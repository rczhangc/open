package org.open.boot.api.kuaidizs.dto;

import java.util.Date;

/**
 * 订单助手：订单更新信息
 *
 * @author barnak
 */
public class KdzsMallTradeUpdateDTO extends KdzsObjectDTO {

    /**
     * 订单id，全局唯一（必须）
     */
    private String tid;

    /**
     * 收件人姓名
     */
    private String receiverName;

    /**
     * 收件人省份
     */
    private String receiverProvince;

    /**
     * 收件人市
     */
    private String receiverCity;

    /**
     * 收件人区/县
     */
    private String receiverCounty;

    /**
     * 收件人街道
     */
    private String receiverTown;

    /**
     * 收件人详细地址
     */
    private String receiverAddress;

    /**
     * 收件人手机号，手机号固话不可同时为空
     */
    private String receiverPhone;

    /**
     * 收件人固话，手机号固话不可同时为空
     */
    private String receiverMobile;

    /**
     * 收件邮编
     */
    private String receiverZip;

    /**
     * 交易修改时间(用户对订单的任何修改都会更新此字段)。格式:yyyy-MM-dd HH:mm:ss。（必须）
     */
    private Date modified;

    /**
     * 卖家备注旗帜 红、黄、绿、蓝、紫 、灰分别对应 1、2、3、4、5、0
     */
    private Long sellerFlag;

    /**
     * 卖家备注
     */
    private String sellerMemo;

    /**
     * 交易状态
     */
    private String status;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverCounty() {
        return receiverCounty;
    }

    public void setReceiverCounty(String receiverCounty) {
        this.receiverCounty = receiverCounty;
    }

    public String getReceiverTown() {
        return receiverTown;
    }

    public void setReceiverTown(String receiverTown) {
        this.receiverTown = receiverTown;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverZip() {
        return receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Long getSellerFlag() {
        return sellerFlag;
    }

    public void setSellerFlag(Long sellerFlag) {
        this.sellerFlag = sellerFlag;
    }

    public String getSellerMemo() {
        return sellerMemo;
    }

    public void setSellerMemo(String sellerMemo) {
        this.sellerMemo = sellerMemo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "KdzsMallTradeUpdateDTO{" +
                "tid='" + tid + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverProvince='" + receiverProvince + '\'' +
                ", receiverCity='" + receiverCity + '\'' +
                ", receiverCounty='" + receiverCounty + '\'' +
                ", receiverTown='" + receiverTown + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", receiverMobile='" + receiverMobile + '\'' +
                ", receiverZip='" + receiverZip + '\'' +
                ", modified=" + modified +
                ", sellerFlag=" + sellerFlag +
                ", sellerMemo='" + sellerMemo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
