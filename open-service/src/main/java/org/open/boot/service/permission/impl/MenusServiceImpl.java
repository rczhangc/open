package org.open.boot.service.permission.impl;

import org.open.boot.dao.permission.MenusManager;
import org.open.boot.service.permission.MenusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 菜单信息服务实现类
 *
 * @author barnak
 */
@Service
class MenusServiceImpl implements MenusService {

    @Resource
    private MenusManager menusManager;

}