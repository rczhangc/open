package org.open.boot.unit;

import org.apache.commons.collections4.CollectionUtils;
import org.open.boot.util.SpringContextUtil;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 动作执行方法
 *
 * @author barnak
 */
public abstract class AbstractActExecuteService<T extends ActContext> implements ActExecuteService<T> {

    /**
     * 动作单元列表
     */
    private final List<ActUnit<T>> unitList = new ArrayList<>();

    public AbstractActExecuteService() {
        List<Class<? extends ActUnit<T>>> unitClassList = new ArrayList<>();
        initActUnitClass(unitClassList);
        if (CollectionUtils.isEmpty(unitClassList)) {
            return;
        }
        try {
            for (Class<? extends ActUnit<T>> clazz : unitClassList) {
                unitList.add(clazz.newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException("动作单元初始化失败", e);
        }
    }

    /**
     * 执行动作单元
     *
     * @param context {@link T}
     * @return {@link ActResult}
     */
    @Override
    public ActResult execute(T context) {
        if (CollectionUtils.isEmpty(unitList)) {
            throw new RuntimeException("无动作的执行单元");
        }
        try {
            for (ActUnit<T> unit: unitList) {
                if (unit instanceof OperateUnit) {
                    ((OperateUnit<T>) unit).doCheck(context);
                }
                unit.doUnit(context);
            }
        } catch (Exception e) {
            return new ActResult();
        }
        return new ActResult();
    }

    /**
     * 初始化动作单元类
     *
     * @param unitClassList {@link List<Class>}
     */
    protected abstract void initActUnitClass(List<Class<? extends ActUnit<T>>> unitClassList);
}
