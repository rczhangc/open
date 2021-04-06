package org.open.boot.service.order.impl;

import org.open.boot.service.order.OrderUnitService;
import org.open.boot.service.order.unit.OrderCheckUnit;
import org.open.boot.service.order.unit.OrderContext;
import org.open.boot.service.order.unit.OrderDatabaseUnit;
import org.open.boot.service.order.unit.OrderOperateUnit;
import org.open.boot.unit.AbstractActExecuteService;
import org.open.boot.unit.ActUnit;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author barnak
 */
@Service
public class OrderUnitServiceImpl extends AbstractActExecuteService<OrderContext> implements OrderUnitService {

    @Override
    protected void initActUnitClass(List<Class<? extends ActUnit<OrderContext>>> unitClassList) {
        unitClassList.add(OrderCheckUnit.class);
        unitClassList.add(OrderOperateUnit.class);
        unitClassList.add(OrderDatabaseUnit.class);
    }
}
