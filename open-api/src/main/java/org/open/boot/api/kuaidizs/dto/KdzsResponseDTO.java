package org.open.boot.api.kuaidizs.dto;

/**
 * 快递助手：请求返回对象
 *
 * @author barnak
 */
public class KdzsResponseDTO {

    /**
     * 成功：200，异常时返回result:非200（必须）
     */
    private Integer code;

    /**
     * 异常时错误信息
     */
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
