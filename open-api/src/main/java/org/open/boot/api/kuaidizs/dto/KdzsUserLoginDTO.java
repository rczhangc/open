package org.open.boot.api.kuaidizs.dto;

/**
 * 快递助手：店铺登录
 *
 * @author barnak
 */
public class KdzsUserLoginDTO {

    /**
     * 校验该店铺是否有效（必须）
     */
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "KdzsUserLoginDTO{" +
                "token='" + token + '\'' +
                '}';
    }
}
