package org.tools.main.propagation.required;

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
public class RequiredServiceA {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RequiredServiceB methodB;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void nonTry() {
        User user = new User();
        user.setId(1L);
        user.setName("JoneA");
        userMapper.updateById(user);
        methodB.nonTry();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void insideTry() {
        User user = new User();
        user.setId(1L);
        user.setName("JoneA");
        userMapper.updateById(user);
        methodB.insideTry();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void outsideTry() {
        User user = new User();
        user.setId(1L);
        user.setName("JoneA");
        userMapper.updateById(user);
        try {
            methodB.nonTry();
        } catch (Exception e) {
            System.out.println("B方法更新失败");
        }
    }
}
