package org.tools.service.user.impl;

import org.springframework.stereotype.Service;
import org.tools.dao.user.UserManager;
import org.tools.dao.user.entity.UserDO;
import org.tools.service.user.UserService;

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
    public int updateById(UserDO user) {
        boolean b = userManager.updateById(user);
        return b ? 1 : 0;
    }

    @Override
    public int updateBatchById(List<UserDO> userDOList) {
        boolean b = userManager.updateBatchById(userDOList);
        return b ? 1 : 0;
    }

    @Override
    public UserDO getById(Long userId) {
        return userManager.getById(userId);
    }
}