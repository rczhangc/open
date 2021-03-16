package org.open.boot.api.kuaidizs.dto;

/**
 * 快递助手：商品规格
 *
 * @author barnak
 */
public class KdzsMallSkuDTO {

    /**
     * 规格id（必须）
     */
    private String skuId;

    /**
     * 商品id（必须）
     */
    private String itemId;

    /**
     * 规格单价
     */
    private String skuPrice;

    /**
     * 商品名称（必须）
     */
    private String itemTitle;

    /**
     * 规格名称（必须）
     */
    private String skuName;

    /**
     * 状态（必须）
     */
    private Integer status;

    /**
     * 创建时间（必须）
     */
    private String created;

    /**
     * 规格商家编码
     */
    private String skuOuterId;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(String skuPrice) {
        this.skuPrice = skuPrice;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getSkuOuterId() {
        return skuOuterId;
    }

    public void setSkuOuterId(String skuOuterId) {
        this.skuOuterId = skuOuterId;
    }

    @Override
    public String toString() {
        return "KdzsMallSkuDTO{" +
                "skuId='" + skuId + '\'' +
                ", itemId='" + itemId + '\'' +
                ", skuPrice='" + skuPrice + '\'' +
                ", itemTitle='" + itemTitle + '\'' +
                ", skuName='" + skuName + '\'' +
                ", status=" + status +
                ", created='" + created + '\'' +
                ", skuOuterId='" + skuOuterId + '\'' +
                '}';
    }
}
