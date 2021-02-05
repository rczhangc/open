package org.open.boot.propagation;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author barnak
 */
public interface PropagationExecute {

    /**
     * 执行方法
     */
    @Transactional(rollbackFor = Exception.class)
    void start();
}
