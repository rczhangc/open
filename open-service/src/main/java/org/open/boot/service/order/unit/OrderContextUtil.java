package org.open.boot.service.order.unit;

import org.open.boot.dao.user.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author barnak
 */
@Component
public class OrderContextUtil {

    public static UserManager userManager;

    @Autowired
    public void setUserManager(UserManager userManager) {
        OrderContextUtil.userManager = userManager;
    }
}
