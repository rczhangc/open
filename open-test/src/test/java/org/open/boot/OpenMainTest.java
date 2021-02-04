package org.open.boot;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.open.boot.api.user.UserApi;
import org.open.boot.api.user.dto.UserDTO;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author barnak
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OpenMainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class OpenMainTest {

    @Resource
    private UserApi userApi;

    @Before
    public void initDate() {

    }

    @After
    public void printAfter() {

    }

    @Test
    public void getUserInfo() {
        UserDTO byUserId = userApi.getByUserId(1L);
    }
}
