package org.open.boot.api.kuaidizs.enums;

/**
 * 快递助手订单状态枚举
 *
 * @author barnak
 */
public enum KdzsOrderStatusEnum {

    // 订单状态
    ORDER_NO_PAY("订单未付款"),
    ORDER_CANCELLED("订单取消"),
    ORDER_PAID("买家已付款即等待卖家发货"),
    ORDER_SHIPPED("卖家已发货"),
    ORDER_COMPLETED("订单完成"),
    ORDER_CLOSE("订单关闭"),
    ;

    public String getCode() {
        return this.name();
    }

    KdzsOrderStatusEnum(String desc) {
        this.desc = desc;
    }

    private final String desc;

    public String getDesc() {
        return desc;
    }
}
