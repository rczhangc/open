package org.tools.main.user.service;

import org.junit.Assert;
import org.junit.Test;
import org.tools.main.OpenMainApplicationTests;
import org.tools.main.user.entity.User;
import org.tools.main.user.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author barnak
 */
public class IUserServiceTest extends OpenMainApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
}