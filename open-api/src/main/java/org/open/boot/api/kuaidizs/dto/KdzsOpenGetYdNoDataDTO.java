package org.open.boot.api.kuaidizs.dto;

/**
 * 快递助手：运单号数据
 *
 * @author barnak
 */
public class KdzsOpenGetYdNoDataDTO {

    /**
     * 订单号（必须）
     */
    private String tid;

    /**
     * 快递单号
     */
    private String waybillNo;

    /**
     * 失败原因
     */
    private String message;

    /**
     * 是否成功（必须）
     */
    private Boolean success;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "KdzsOpenGetYdNoDataDTO{" +
                "tid='" + tid + '\'' +
                ", waybillNo='" + waybillNo + '\'' +
                ", message='" + message + '\'' +
                ", success=" + success +
                '}';
    }
}
