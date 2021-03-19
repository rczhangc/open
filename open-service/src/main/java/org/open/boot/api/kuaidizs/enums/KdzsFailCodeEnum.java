package org.open.boot.api.kuaidizs.enums;

/**
 * 快递助手异常码
 *
 * @author barnak
 */
public enum KdzsFailCodeEnum {

    // 异常信息
    SUCCESS(200, "成功"),
    BUSINESS_EXCEPTION(500, "业务异常"),
    DUPLICATE_KEY(601, "主键冲突"),
    ;

    KdzsFailCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final Integer code;
    private final String desc;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
