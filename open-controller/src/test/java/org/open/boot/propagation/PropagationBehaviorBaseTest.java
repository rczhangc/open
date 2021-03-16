package org.open.boot.propagation;

import com.alibaba.fastjson.JSON;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.open.boot.OpenMainApplication;
import org.open.boot.dao.user.entity.UserDO;
import org.open.boot.propagation.mandatory.MandatoryService;
import org.open.boot.propagation.required.RequiredService;
import org.open.boot.service.user.UserService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author barnak
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OpenMainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class PropagationBehaviorBaseTest {

    @Resource
    protected UserService userService;
    @Resource
    protected MandatoryService mandatoryService;
    @Resource
    protected RequiredService requiredService;
    @Resource
    protected PropagationService propagationService;

    protected UserDO beforeUser1;

    protected UserDO beforeUser2;

    protected UserDO afterUser1;

    protected UserDO afterUser2;

    @Before
    public void initDate() {
        System.out.println("初始化用户信息开始");
        UserDO user1 = new UserDO();
        user1.setId(1L);
        user1.setName("Jone");

        UserDO user2 = new UserDO();
        user2.setId(2L);
        user2.setName("Jack");
        userService.updateBatchById(Arrays.asList(user1,user2));
        saveUserInfo(true);
        System.out.println("初始化用户信息完毕");
    }

    @After
    public void printAfter() {
        saveUserInfo(false);
        System.out.println("before user1："+ JSON.toJSONString(beforeUser1));
        System.out.println("after user1："+ JSON.toJSONString(afterUser1));
        System.out.println("before user2："+ JSON.toJSONString(beforeUser2));
        System.out.println("after user2："+ JSON.toJSONString(afterUser2));
    }

    public void saveUserInfo(boolean isBefore) {
        UserDO user1 = userService.getById(1L);
        UserDO user2 = userService.getById(2L);
        if (isBefore) {
            beforeUser1 = user1;
            beforeUser2 = user2;
            return;
        }
        afterUser1 = user1;
        afterUser2 = user2;
    }

    public void updateA() {
        UserDO user = new UserDO();
        user.setId(1L);
        user.setName("JoneA");
        userService.updateById(user);
    }

    public void updateB() {
        UserDO user = new UserDO();
        user.setId(2L);
        user.setName("JackB");
        int i = userService.updateById(user);
        if (i == 1) {
            throw new RuntimeException("更新失败");
        }
    }

    public void updateC() {

    }
}
