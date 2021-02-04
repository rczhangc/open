package org.open.boot.api.user.impl;

import org.open.boot.api.user.UserApi;
import org.open.boot.api.user.dto.UserDTO;
import org.open.boot.dao.user.entity.UserDO;
import org.open.boot.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author barnak
 */
@Service
class UserApiImpl implements UserApi {

    @Resource
    private UserService userService;

    @Override
    public UserDTO getByUserId(long userId) {
        UserDO byId = userService.getById(userId);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(byId.getId());
        userDTO.setAge(byId.getAge());
        userDTO.setEmail(byId.getEmail());
        userDTO.setName(byId.getName());
        return userDTO;
    }
}
