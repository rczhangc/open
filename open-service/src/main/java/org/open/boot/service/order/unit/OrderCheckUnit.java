package org.open.boot.service.order.unit;

import org.open.boot.dao.user.entity.UserDO;
import org.open.boot.unit.CheckUnit;

import java.util.Objects;

/**
 * @author barnak
 */
public class OrderCheckUnit extends CheckUnit<OrderContext> {

    @Override
    public void doUnit(OrderContext context) {
        if ( Objects.isNull(context.getUserId()) ) {
            throw new RuntimeException("用户ID不能为空");
        }
        UserDO userDO = OrderContextUtil.userManager.selectByUserIds(context.getUserId());
        context.setUser(userDO);
    }
}
