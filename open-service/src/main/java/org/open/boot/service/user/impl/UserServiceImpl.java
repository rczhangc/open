package org.open.boot.service.user.impl;

import org.open.boot.dao.user.UserManager;
import org.open.boot.dao.user.entity.UserDO;
import org.open.boot.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 服务实现类
 *
 * @author barnak
 */
@Service
class UserServiceImpl implements UserService {

    @Resource
    private UserManager userManager;

    @Override
    public void updateBatchById(List<UserDO> asList) {
        userManager.updateBatchById(asList);
    }

    @Override
    public UserDO getById(long l) {
        return userManager.getById(l);
    }

    @Override
    public int updateById(UserDO user) {
        boolean b = userManager.updateById(user);
        return b ? 1 : 0;
    }
}