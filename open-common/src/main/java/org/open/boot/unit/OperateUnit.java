package org.open.boot.unit;

/**
 * 操作单元
 * 用来执行具体操作
 *
 * @author barnak
 */
public abstract class OperateUnit<T extends ActContext> implements ActUnit<T> {

    /**
     * 校验方法，在 doUnit 方法前执行
     */
    public void doCheck(T context) {}
}
