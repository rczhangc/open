package org.open.boot.propagation.required;

import org.junit.Test;
import org.open.boot.api.user.UserApi;
import org.open.boot.api.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.open.boot.propagation.PropagationBehaviorBaseTest;

/**
 * @author barnak
 */
public class RequiredTest extends PropagationBehaviorBaseTest {

    @Autowired
    private RequiredServiceA methodA;
    @Autowired
    private UserApi userApi;

    @Test
    public void testNonTry() {
        methodA.nonTry();
    }

    @Test
    public void testInsideTry() {
        methodA.insideTry();
    }

    @Test
    public void testOutsideTry() {
        methodA.outsideTry();
    }

    @Test
    public void testUserApi() {
        UserDTO byUserId = userApi.getByUserId(1L);
    }

}
