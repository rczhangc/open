package org.open.boot.propagation.notsupported;

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
public class NotSupportedServiceB {

    @Resource
    private UserService userService;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NOT_SUPPORTED)
    public void nonTry() {
        UserDO user = new UserDO();
        user.setId(2L);
        user.setName("JackB");
        int i = userService.updateById(user);
        if (i == 1) {
            throw new RuntimeException("更新失败");
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NOT_SUPPORTED)
    public void insideTry() {
        try {
            UserDO user = new UserDO();
            user.setId(2L);
            user.setName("JackB");
            int i = userService.updateById(user);
            if (i == 1) {
                throw new RuntimeException("更新失败");
            }
        } catch (RuntimeException e) {
            System.out.println("内部进行异常捕获");
        }
    }

}
