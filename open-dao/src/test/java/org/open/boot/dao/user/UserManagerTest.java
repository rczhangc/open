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
        UserDO byId = userManager.getById(1L);
    }

    @Test
    public void test2() {
        UserDO userDO = userManager.selectByUserIds(1L);
    }

}