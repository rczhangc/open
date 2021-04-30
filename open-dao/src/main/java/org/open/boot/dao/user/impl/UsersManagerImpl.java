package org.open.boot.dao.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.open.boot.dao.user.UsersManager;
import org.open.boot.dao.user.entity.UsersDO;
import org.springframework.stereotype.Repository;

/**
 * 用户信息表服务实现类
 *
 * @author barnak
 */
@Repository
class UsersManagerImpl extends ServiceImpl<UsersMapper, UsersDO> implements UsersManager {

}
