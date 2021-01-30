package org.tools.main.user.service.impl;

import org.tools.main.user.entity.User;
import org.tools.main.user.mapper.UserMapper;
import org.tools.main.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 *
 * @author barnak
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
