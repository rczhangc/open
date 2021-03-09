package org.open.boot.api.kuaidizs.dto;

import java.util.List;

/**
 * 快递助手：订单
 *
 * @author barnak
 */
public class KdzsMallOrderDTO {

    /**
     * 子订单Id，全局唯一（必须）
     */
    private String orderId;

    /**
     * 商品图片绝对路径（必须）
     */
    private String picPath;

    /**
     * 商品规格图片绝对路径
     */
    private String skuUrl;

    /**
     * 订单状态值（必须）
     */
    private String status;

    /**
     * 商品标题（必须）
     */
    private String title;

    /**
     * 商家编码（必须）
     */
    private String outerId;

    /**
     * 商品ID（必须）
     */
    private String itemId;

    /**
     * 规格ID（必须）
     */
    private String skuId;

    /**
     * 规格商家编码（必须）
     */
    private String outerSkuId;

    /**
     * 购买数量（必须）
     */
    private Integer number;

    /**
     * 单价（必须）
     */
    private String price;

    /**
     * 应付金额（必须）
     */
    private String totalFee;

    /**
     * 优惠金额
     */
    private String discountFee;

    /**
     * 子订单实付金额（必须）
     */
    private String payment;

    /**
     * 商品属性（必须）
     */
    private List<KdzsMallPropDTO> saleProps;


}
