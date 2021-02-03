package org.tools.dao.user.impl;

import org.tools.dao.user.impl.UserMapper;
import org.tools.dao.user.UserManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.tools.dao.user.entity.UserDO;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 *
 * @author barnak
 */
@Service
class UserManagerImpl extends ServiceImpl<UserMapper, UserDO> implements UserManager {

}
