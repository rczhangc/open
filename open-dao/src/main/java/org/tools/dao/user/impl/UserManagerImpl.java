package org.tools.dao.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;
import org.tools.dao.user.UserManager;
import org.tools.dao.user.entity.UserDO;

/**
 * 服务实现类
 *
 * @author barnak
 */
@Repository
class UserManagerImpl extends ServiceImpl<UserMapper, UserDO> implements UserManager {

}
