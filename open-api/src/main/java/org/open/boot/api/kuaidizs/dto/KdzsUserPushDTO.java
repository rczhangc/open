package org.open.boot.api.kuaidizs.dto;

/**
 * 快递助手：店铺信息推送
 *
 * @author barnak
 */
public class KdzsUserPushDTO {

    /**
     * 店铺名称（必须）
     */
    private String shopName;

    /**
     * 校验该店铺是否有效（必须）
     */
    private String token;

    /**
     * 店铺ID（必须）
     */
    private Long mallUserId;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getMallUserId() {
        return mallUserId;
    }

    public void setMallUserId(Long mallUserId) {
        this.mallUserId = mallUserId;
    }

    @Override
    public String toString() {
        return "KdzsUserPushDTO{" +
                "shopName='" + shopName + '\'' +
                ", token='" + token + '\'' +
                ", mallUserId=" + mallUserId +
                '}';
    }
}
