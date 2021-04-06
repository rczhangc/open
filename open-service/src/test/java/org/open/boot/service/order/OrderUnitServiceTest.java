package org.open.boot.service.order;

import org.junit.Test;
import org.open.boot.BaseUnitTest;
import org.open.boot.service.order.unit.OrderContext;

import javax.annotation.Resource;

/**
 * @author barnak
 */
public class OrderUnitServiceTest extends BaseUnitTest {

    @Resource
    private OrderUnitService orderUnitService;

    @Test
    public void testExecute() {
        OrderContext orderContext = new OrderContext();
        orderContext.setUserId(1L);
        orderUnitService.execute(orderContext);
    }

}