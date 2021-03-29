package org.open.boot.unit;

/**
 * 动作单元
 *
 * @author barnak
 */
public interface ActUnit<T extends ActContext> {

    /**
     * 执行动作
     *
     * @param context {@link T} T 是 {@link ActContext}的实现
     */
    void doUnit(T context);
}
