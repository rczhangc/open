package org.open.boot.service.user.impl;

import org.open.boot.dao.user.UsersManager;
import org.open.boot.service.user.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户信息表服务实现类
 *
 * @author barnak
 */
@Service
class UsersServiceImpl implements UsersService {

    @Resource
    private UsersManager usersManager;

}