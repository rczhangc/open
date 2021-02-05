package org.open.boot.propagation.required;

import org.junit.Test;
import org.open.boot.dao.user.entity.UserDO;
import org.open.boot.propagation.PropagationBehaviorBaseTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author barnak
 */
public class RequiredTest extends PropagationBehaviorBaseTest {



    /**
     * 不开启事务直接调用， 内部进行异常 try catch
     * A方法不回滚，B方法不回滚
     */
    @Test
    public void testNoneInsideTry(){
        UserDO user = new UserDO();
        user.setId(1L);
        user.setName("JoneA");
        userService.updateById(user);
        requiredService.insideTry();
    }

    /**
     * 不开启事务直接调用，外部进行异常 try catch
     * A方法不回滚，B方法回滚
     */
    @Test
    public void testNoneOutsideTry(){
        UserDO user = new UserDO();
        user.setId(1L);
        user.setName("JoneA");
        userService.updateById(user);
        try {
            requiredService.nonTry();
        } catch (Exception e) {
            System.out.println("B方法更新失败");
        }
    }

    /**
     * 由 REQUIRED 级别调用，内部进行异常 try catch
     * A方法不回滚，B方法不回滚
     */
    @Test
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void testInsideTry() {
        Runnable methodA = this::updateA;
        Runnable methodB = () -> propagationService.run(this::updateB);
        propagationService.insideTry(methodA, methodB);
    }

    /**
     * 由 REQUIRED 级别调用，外部进行异常 try catch
     * A方法回滚，B方法回滚，并抛出异常 Transaction rolled back because it has been marked as rollback-only
     */
    @Test
    public void testOutsideTry1() {
        Runnable methodA = this::updateA;
        Runnable methodB = () -> propagationService.run(this::updateB);
        propagationService.outsideTry(methodA, methodB);
    }
}
