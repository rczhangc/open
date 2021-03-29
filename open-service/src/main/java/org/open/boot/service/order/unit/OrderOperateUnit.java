package org.open.boot.service.order.unit;

import org.open.boot.dao.user.entity.UserDO;
import org.open.boot.unit.OperateUnit;
import org.springframework.stereotype.Component;

/**
 * @author barnak
 */
@Component
public class OrderOperateUnit extends OperateUnit<OrderContext> {

    public OrderOperateUnit() {
        System.out.println("OrderOperateUnit 进行初始化");
    }

    @Override
    public void doUnit(OrderContext context) {
        UserDO user = context.getUser();


        UserDO update = new UserDO();
        update.setId(user.getId());
        update.setName("动作单元修改");

        context.setUpdateUser(user);
    }
}
