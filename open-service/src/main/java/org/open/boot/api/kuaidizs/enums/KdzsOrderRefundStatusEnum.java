package org.open.boot.api.kuaidizs.enums;

/**
 * 快递助手订单退款状态枚举
 *
 * @author barnak
 */
public enum KdzsOrderRefundStatusEnum {

    // 订单退款状态
    REFUND_SUCCESSED("退款成功"),
    REFUND_ING("退款处理中"),
    REFUND_CANCELLED("退款取消"),
    REFUND_REFUSE("退款被拒绝"),
    ;

    public String getCode() {
        return this.name();
    }

    KdzsOrderRefundStatusEnum(String desc) {
        this.desc = desc;
    }

    private final String desc;

    public String getDesc() {
        return desc;
    }
}
