package org.open.boot.service.order.unit;

import org.open.boot.dao.user.UserManager;
import org.open.boot.unit.DatabaseUnit;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author barnak
 */
@Component
public class OrderDatabaseUnit extends DatabaseUnit<OrderContext> {

    public OrderDatabaseUnit(UserManager userManager) {
        System.out.println("OrderDatabaseUnit 进行初始化");
    }

    @Resource
    private UserManager userManager;

    @Override
    public void doUnit(OrderContext context) {
        userManager.updateById(context.getUpdateUser());
    }
}
