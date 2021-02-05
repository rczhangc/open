package org.open.boot.dao.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.open.boot.dao.user.UserManager;
import org.open.boot.dao.user.entity.UserDO;
import org.springframework.stereotype.Repository;

/**
 * 服务实现类
 *
 * @author barnak
 */
@Repository
class UserManagerImpl extends ServiceImpl<UserMapper, UserDO> implements UserManager {


    @Override
    public UserDO selectByUserIds(Long userId) {
        return baseMapper.selectByUserIds(userId);
    }
}
