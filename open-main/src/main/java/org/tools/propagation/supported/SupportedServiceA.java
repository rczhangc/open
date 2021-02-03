package org.tools.propagation.supported;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tools.dao.user.entity.UserDO;
import org.tools.service.user.UserService;

import javax.annotation.Resource;

/**
 * @author barnak
 */
@Service
public class SupportedServiceA {

    @Resource
    private UserService userService;
    @Resource
    private SupportedServiceB methodB;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void nonTry() {
        UserDO user = new UserDO();
        user.setId(1L);
        user.setName("JoneA");
        userService.updateById(user);
        methodB.nonTry();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void insideTry() {
        UserDO user = new UserDO();
        user.setId(1L);
        user.setName("JoneA");
        userService.updateById(user);
        methodB.insideTry();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void outsideTry() {
        UserDO user = new UserDO();
        user.setId(1L);
        user.setName("JoneA");
        userService.updateById(user);
        try {
            methodB.nonTry();
        } catch (Exception e) {
            System.out.println("B方法更新失败");
        }
    }
}
