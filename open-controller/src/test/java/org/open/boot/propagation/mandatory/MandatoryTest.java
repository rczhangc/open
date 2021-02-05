package org.open.boot.propagation.mandatory;

import org.junit.Test;
import org.open.boot.dao.user.entity.UserDO;
import org.open.boot.propagation.PropagationBehaviorBaseTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author barnak
 */
public class MandatoryTest extends PropagationBehaviorBaseTest {

    /**
     * 不开启事务直接执行
     * 抛出异常 No existing transaction found for transaction marked with propagation 'mandatory'
     */
    @Test
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void test(){
    }

    /**
     * 由 REQUIRED 级别调用，内部进行异常 try catch
     * A方法不回滚，B方法不回滚
     */
    @Test
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void testInsideTry() {
        UserDO user = new UserDO();
        user.setId(1L);
        user.setName("JoneA");
        userService.updateById(user);
        mandatoryService.insideTry();
    }

    /**
     * 由 REQUIRED 级别调用，外部进行异常 try catch
     * A方法不回滚，B方法不回滚
     */
    @Test
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void testOutsideTry() {
        UserDO user = new UserDO();
        user.setId(1L);
        user.setName("JoneA");
        userService.updateById(user);
        try {
            mandatoryService.nonTry();
        } catch (Exception e) {
            System.out.println("B方法更新失败");
        }
    }
}
