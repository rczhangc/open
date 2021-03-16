package org.open.boot.api.kuaidizs.dto;

import java.util.List;

/**
 * 快递助手：商品
 *
 * @author barnak
 */
public class KdzsMallItemDTO {

    /**
     * 商品id，全局唯一（必须）
     */
    private String itemId;

    /**
     * 商品名称（必须）
     */
    private String title;

    /**
     * 商家编码
     */
    private String outerId;

    /**
     * 货号
     */
    private String itemNum;

    /**
     * 商品绝对路径
     */
    private String itemUrl;

    /**
     * 商品主图绝对路径(只能使用https格式)（必须）
     */
    private String picUrl;

    /**
     * 商品单价
     */
    private String price;

    /**
     * 商品状态，ONSALE：在售，INVENTORY：仓库中（必须）
     */
    private String status;

    /**
     * 商品规格列表
     */
    private List<KdzsMallSkuDTO> skus;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
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

    public String getItemNum() {
        return itemNum;
    }

    public void setItemNum(String itemNum) {
        this.itemNum = itemNum;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<KdzsMallSkuDTO> getSkus() {
        return skus;
    }

    public void setSkus(List<KdzsMallSkuDTO> skus) {
        this.skus = skus;
    }

    @Override
    public String toString() {
        return "KdzsMallItemDTO{" +
                "itemId='" + itemId + '\'' +
                ", title='" + title + '\'' +
                ", outerId='" + outerId + '\'' +
                ", itemNum='" + itemNum + '\'' +
                ", itemUrl='" + itemUrl + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", price='" + price + '\'' +
                ", status='" + status + '\'' +
                ", skus=" + skus +
                '}';
    }
}
