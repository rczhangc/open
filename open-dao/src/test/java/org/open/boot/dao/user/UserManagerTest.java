package org.open.boot.dao.user;

import org.junit.Test;
import org.open.boot.BaseUnitTest;
import org.open.boot.dao.user.entity.UserDO;

import javax.annotation.Resource;

/**
 * @author barnak
 */
public class UserManagerTest extends BaseUnitTest {

    @Resource
    private UserManager userManager;

    @Test
    public void test() {
        UserDO byId = userManager.getById(null);
    }

    @Test
<<<<<<< HEAD
    public void testUser() {
        UserDO byUserId = userManager.getByUserId("1");

    }
=======
    public void test2() {
        UserDO userDO = userManager.selectByUserIds(1L);
    }

>>>>>>> 6c93c63cc08ab6b62be4be8fdcd03bdda9328020
}