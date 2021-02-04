package org.tools.service.user;

import org.junit.Test;
import org.tools.BaseUnitTest;
import org.tools.dao.user.entity.UserDO;

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