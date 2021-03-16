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
    private List<KdzsMallSkuPropDTO> saleProps;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getSkuUrl() {
        return skuUrl;
    }

    public void setSkuUrl(String skuUrl) {
        this.skuUrl = skuUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getOuterSkuId() {
        return outerSkuId;
    }

    public void setOuterSkuId(String outerSkuId) {
        this.outerSkuId = outerSkuId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(String discountFee) {
        this.discountFee = discountFee;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public List<KdzsMallSkuPropDTO> getSaleProps() {
        return saleProps;
    }

    public void setSaleProps(List<KdzsMallSkuPropDTO> saleProps) {
        this.saleProps = saleProps;
    }
}
