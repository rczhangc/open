package org.open.boot.propagation.supports;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.open.boot.dao.user.entity.UserDO;
import org.open.boot.service.user.UserService;

import javax.annotation.Resource;

/**
 * @author barnak
 */
@Service
public class SupportsServiceA {

    @Resource
    private UserService userService;
    @Resource
    private SupportsServiceB methodB;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
    public void nonTry() {
        UserDO user = new UserDO();
        user.setId(1L);
        user.setName("JoneA");
        userService.updateById(user);
        methodB.nonTry();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
    public void insideTry() {
        UserDO user = new UserDO();
        user.setId(1L);
        user.setName("JoneA");
        userService.updateById(user);
        methodB.insideTry();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
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
