package org.open.boot.service.permission.impl;

import org.open.boot.dao.permission.RolesMenusRelationManager;
import org.open.boot.service.permission.RolesMenusRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色菜单关联表服务实现类
 *
 * @author barnak
 */
@Service
class RolesMenusRelationServiceImpl implements RolesMenusRelationService {

    @Resource
    private RolesMenusRelationManager rolesMenusRelationManager;

}