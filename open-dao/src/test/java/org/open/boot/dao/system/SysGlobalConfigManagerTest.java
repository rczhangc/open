package org.open.boot.dao.system;

import org.junit.Test;
import org.open.boot.BaseUnitTest;
import org.open.boot.dao.system.enums.SysGlobalConfigCodeEnum;
import org.open.boot.dao.user.UserManager;

import javax.annotation.Resource;
/**
 *
 * @author barnak
 */
public class SysGlobalConfigManagerTest extends BaseUnitTest {

    @Resource
    private UserManager userManager;
    @Resource
    private SysGlobalConfigManager sysGlobalConfigManager;

    @Test
    public void test() {
//        UserDO userDO = userManager.selectByUserIds(1L);
//        SysGlobalConfigDO config = new SysGlobalConfigDO();
//        config.setConfigCode("SYS_USER_INFO2");
//        config.setJsonValue(10);
//
//        boolean save = sysGlobalConfigManager.save(config);
    }

    @Test
    public void test2() {
//        SysGlobalConfigDO<UserDO> sys_user_info = sysGlobalConfigManager.getById("SYS_USER_INFO");
//        SysGlobalConfigDO<Integer> sys_user_info2 = sysGlobalConfigManager.getById("SYS_USER_INFO2");
        String s = SysGlobalConfigCodeEnum.USER_INFO.toString();
    }
}