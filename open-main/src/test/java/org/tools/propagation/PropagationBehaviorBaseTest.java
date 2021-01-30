package org.tools.propagation;

import com.alibaba.fastjson.JSON;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.tools.main.OpenMainApplication;
import org.tools.main.user.entity.User;
import org.tools.main.user.service.IUserService;

import java.util.Arrays;

/**
 * @author barnak
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OpenMainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class PropagationBehaviorBaseTest {

    @Autowired
    private IUserService userService;

    protected User beforeUser1;

    protected User beforeUser2;

    protected User afterUser1;

    protected User afterUser2;

    @Before
    public void initDate() {
        System.out.println("初始化用户信息开始");
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Jone");

        User user2 = new User();
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
        User user1 = userService.getById(1L);
        User user2 = userService.getById(2L);
        if (isBefore) {
            beforeUser1 = user1;
            beforeUser2 = user2;
            return;
        }
        afterUser1 = user1;
        afterUser2 = user2;
    }
}
