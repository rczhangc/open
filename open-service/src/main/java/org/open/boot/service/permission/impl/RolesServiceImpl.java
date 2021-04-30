package org.open.boot.service.permission.impl;

import org.open.boot.dao.permission.RolesManager;
import org.open.boot.service.permission.RolesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色信息表服务实现类
 *
 * @author barnak
 */
@Service
class RolesServiceImpl implements RolesService {

    @Resource
    private RolesManager rolesManager;

}