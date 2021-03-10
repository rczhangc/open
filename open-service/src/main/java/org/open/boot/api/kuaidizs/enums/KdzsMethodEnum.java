package org.open.boot.api.kuaidizs.enums;

import cn.hutool.http.Method;

/**
 * 快递助手方法枚举
 *
 * @author barnak
 */
public enum KdzsMethodEnum {

    // 订单方法枚举
    ORDER_CREATE("创建订单", "trade.create", Method.POST),
    ORDER_BATCH_CREATE("批量同步订单", "trade.batchCreate", Method.POST),
    ORDER_UPDATE("修改订单信息", "trade.update", Method.POST),
    ORDER_SEND("订单发货", "trade.send", Method.POST),
    ORDER_REFUND("订单退款", "trade.refund", Method.POST),
    ORDER_BATCH_DELETED("订单删除", "trade.batchDelete", Method.POST),

    // 商品模块方法枚举
    PRODUCT_LIST("同步商品列表", "product.list", Method.POST),
    PRODUCT_SAVE_ITEM_LIST("上传(更新)商品", "product.saveItemList", Method.POST),
    PRODUCT_DELETE_ITEM_LIST("商品删除", "product.deleteItemList", Method.POST),

    // 电子面单方法枚举
    WAYBILL_GET_TEMPLATE_LIST("获取模版列表", "waybill.getTemplateList", Method.POST),
    WAYBILL_GET_BATCH("预申请单号", "waybill.getBatch", Method.POST),
    ;

    KdzsMethodEnum(String name, String value, Method method) {
        this.name = name;
        this.value = value;
        this.httpMethod = method;
    }

    private final String name;
    private final String value;
    private final Method httpMethod;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public Method getHttpMethod() {
        return httpMethod;
    }
}
