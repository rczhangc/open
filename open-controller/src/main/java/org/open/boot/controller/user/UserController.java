package org.open.boot.controller.user;

import org.open.boot.service.user.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 前端控制器
 *
 * @author barnak
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

}
