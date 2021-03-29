package org.open.boot.service.order.unit;

import org.open.boot.dao.user.UserManager;
import org.open.boot.dao.user.entity.UserDO;
import org.open.boot.unit.CheckUnit;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author barnak
 */
@Component
public class OrderCheckUnit extends CheckUnit<OrderContext> {

    public OrderCheckUnit() {
        System.out.println("OrderCheckUnit 进行初始化");
    }

    @Resource
    private UserManager userManager;

    @Override
    public void doUnit(OrderContext context) {
        if ( Objects.isNull(context.getUserId()) ) {
            throw new RuntimeException("用户ID不能为空");
        }
        UserDO userDO = userManager.selectByUserIds(context.getUserId());
        context.setUser(userDO);
    }
}
