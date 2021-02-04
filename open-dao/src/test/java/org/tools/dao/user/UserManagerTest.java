package org.tools.dao.user;

import org.junit.Test;
import org.tools.BaseUnitTest;
import org.tools.dao.user.entity.UserDO;

import javax.annotation.Resource;

/**
 * @author barnak
 */
public class UserManagerTest extends BaseUnitTest {

    @Resource
    private UserManager userManager;

    @Test
    public void test() {
        UserDO byId = userManager.getById(1L);
    }

}