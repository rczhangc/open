package org.open.boot.propagation;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author barnak
 */
@Service
public class PropagationService {

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void insideTry(Runnable runnableA, Runnable runnableB) {
        runnableA.run();
        runnableB.run();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void outsideTry(Runnable runnableA, Runnable runnableB) {
        runnableA.run();
        try {
            runnableB.run();
        } catch (Exception e) {
            System.out.println("【runnableB】方法执行失败");
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void run(Runnable runnable) {
        runnable.run();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void tryCatch(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            System.out.println("内部执行方法异常捕获");
        }
    }
}
