package org.open.boot.unit;

/**
 * @author barnak
 */
public interface ActExecuteService<T> {

    /**
     * 执行动作单元
     *
     * @param context {@link T}
     * @return {@link ActResult}
     */
    ActResult execute(T context);
}
