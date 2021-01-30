package org.tools.main.propagation.supports;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tools.main.user.entity.User;
import org.tools.main.user.mapper.UserMapper;

import javax.annotation.Resource;

/**
 * @author barnak
 */
@Service
public class SupportsServiceB {

    @Resource
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void nonTry() {
        User user = new User();
        user.setId(2L);
        user.setName("JackB");
        int i = userMapper.updateById(user);
        if (i == 1) {
            throw new RuntimeException("更新失败");
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void insideTry() {
        try {
            User user = new User();
            user.setId(2L);
            user.setName("JackB");
            int i = userMapper.updateById(user);
            if (i == 1) {
                throw new RuntimeException("更新失败");
            }
        } catch (RuntimeException e) {
            System.out.println("内部进行异常捕获");
        }
    }

}
