package org.open.boot.service.permission.impl;

import org.open.boot.dao.permission.UserRolesRelationManager;
import org.open.boot.service.permission.UserRolesRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户角色关联表服务实现类
 *
 * @author barnak
 */
@Service
class UserRolesRelationServiceImpl implements UserRolesRelationService {

    @Resource
    private UserRolesRelationManager userRolesRelationManager;

}