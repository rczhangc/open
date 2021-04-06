package org.open.boot.service.order.unit;

import org.open.boot.unit.DatabaseUnit;

/**
 * @author barnak
 */
public class OrderDatabaseUnit extends DatabaseUnit<OrderContext> {

    @Override
    public void doUnit(OrderContext context) {
        boolean b = OrderContextUtil.userManager.updateById(context.getUpdateUser());
    }
}
