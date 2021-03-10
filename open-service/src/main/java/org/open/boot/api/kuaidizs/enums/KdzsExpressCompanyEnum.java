package org.open.boot.api.kuaidizs.enums;

/**
 * 快递助手快递公司枚举
 *
 * @author barnak
 */
public enum KdzsExpressCompanyEnum {

    // 快递公司
    BESTQJT("百世快运"),
    BEST("百世物流"),
    DBKD("德邦物流"),
    EMS("EMS标准"),
    EYB("EMS快递包裹"),
    FAST("快捷"),
    GTO("国通"),
    HTKY("百世快递"),
    POST("中国邮政"),
    POSTB("中国邮政国内小包"),
    QFKD("全峰快递"),
    SF("顺丰快递"),
    STO("申通快递"),
    SURE("速尔快递"),
    TTKDEX("天天快递"),
    UAPEX("全一快递"),
    UC("优速快递"),
    YTO("圆通快递"),
    YUNDA("韵达快递"),
    ZJS("宅急送"),
    ZTKY("中铁物流"),
    ZTO("中通快递"),
    CNEX("佳吉快运"),
    CN7000001003751("跨越速运"),
    JD("京东快递"),
    ANE56("安能快递"),
    ANEKY("安能快运"),
    OTHERS("其他快递"),
    ;

    public String getCode() {
        return this.name();
    }

    KdzsExpressCompanyEnum(String desc) {
        this.desc = desc;
    }

    private final String desc;

    public String getDesc() {
        return desc;
    }
}
