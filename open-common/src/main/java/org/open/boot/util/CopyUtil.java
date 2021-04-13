package org.open.boot.util;

import cn.hutool.core.bean.BeanUtil;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 对象简单拷贝工具
 * 可在数据量小时使用
 *
 * @author barnak
 * @date 2020/6/11 16:05
 */
public class CopyUtil {

    /**
     * 对象拷贝
     * 将 source 拷贝到 target
     *
     * @param source 原对象
     * @param target 目标对象
     */
    public static void copy(Object source,Object target){
        if (null == source || null == target) {
            throw new RuntimeException("source and target can not be null");
        }
        BeanUtil.copyProperties(source,target);
    }

    /**
     * 对象拷贝
     * 将 source 拷贝为 clz类型的对象
     *
     * @param source 原对象
     * @param clz 目标对象的 class
     * @param <T> -
     * @return 目标对象
     */
    public static <T> T copy(Object source, Class<T> clz){
        if (null == source || null == clz) {
            return null;
        }
        try {
            T target = clz.newInstance();
            BeanUtil.copyProperties(source,target);
            return target;
        } catch (Exception e) {
            throw new RuntimeException("bean copy error:"+e.getMessage());
        }
    }

    /**
     * 数组拷贝
     * 将 sourceList 数组拷贝为 clz 类型的数组
     *
     * @param sourceList 原数组
     * @param clz 目标数组类型 class
     * @param <T> -
     * @return 拷贝好的目标数组
     */
    public static <T> List<T> copy(List<?> sourceList,Class<T> clz){
        if (CollectionUtils.isEmpty(sourceList)){
            return Collections.emptyList();
        }
        List<T> targetList = new ArrayList<>(sourceList.size());
        for (Object source : sourceList) {
            T target = copy(source, clz);
            if (null == target) {
                continue;
            }
            targetList.add(target);
        }
        return targetList;
    }
}
