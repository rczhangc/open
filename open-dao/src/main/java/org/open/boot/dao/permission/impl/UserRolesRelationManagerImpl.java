package org.open.boot.dao.permission.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.open.boot.dao.permission.UserRolesRelationManager;
import org.open.boot.dao.permission.entity.UserRolesRelationDO;
import org.springframework.stereotype.Repository;

/**
 * 用户角色关联表服务实现类
 *
 * @author barnak
 */
@Repository
class UserRolesRelationManagerImpl extends ServiceImpl<UserRolesRelationMapper, UserRolesRelationDO> implements UserRolesRelationManager {

}
