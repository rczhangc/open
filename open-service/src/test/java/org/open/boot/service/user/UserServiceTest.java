package org.open.boot.service.user;

import org.junit.Test;
import org.open.boot.BaseUnitTest;
import org.open.boot.dao.user.entity.UserDO;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author barnak
 */
public class UserServiceTest extends BaseUnitTest {

    @Resource
    private UserService userService;

    @Test
    public void test() {
        UserDO byId = userService.getById(1L);
    }

}