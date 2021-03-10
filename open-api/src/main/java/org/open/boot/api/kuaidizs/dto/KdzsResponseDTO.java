package org.open.boot.api.kuaidizs.dto;

import java.util.Objects;

/**
 * 快递助手：请求返回对象
 *
 * @author barnak
 */
public class KdzsResponseDTO<T> {

    /**
     * 成功CODE值
     */
    private static final Integer SUCCESS_CODE = 200;

    /**
     * 成功：200，异常时返回result:非200（必须）
     */
    private Integer code;

    /**
     * 异常时返回信息
     */
    private String result;

    /**
     * 异常时错误信息
     */
    private String message;

    /**
     * 成功时返回的数据
     */
    private T data;

    /**
     * 是否成功
     *
     * @return true是 false否
     */
    public boolean isSuccess() {
        return Objects.equals(code, SUCCESS_CODE);
    }

    /**
     * 是否失败
     *
     * @return true是 false否
     */
    public boolean isFail() {
        return !isSuccess();
    }

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "KdzsResponseDTO{" +
                "code=" + code +
                ", result='" + result + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
