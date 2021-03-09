package org.open.boot.api.kuaidizs.dto;

import java.util.Date;
import java.util.List;

/**
 * 快递助手：创建订单对象
 *
 * @author barnak
 */
public class KdzsMallTradeDTO {

    /**
     * 订单id，全局唯一（必须）
     */
    private String tid;

    /**
     * 买家留言
     */
    private String buyerMessage;

    /**
     * 销售渠道
     */
    private String salesChannel;

    /**
     * 买家昵称
     */
    private String buyerNick;

    /**
     * 收件人姓名（必须）
     */
    private String receiverName;

    /**
     * 收件人省份（必须）
     */
    private String receiverProvince;

    /**
     * 收件人市（必须）
     */
    private String receiverCity;

    /**
     * 收件人区/县（必须）
     */
    private String receiverCounty;

    /**
     * 收件人街道
     */
    private String receiverTown;

    /**
     * 收件人详细地址（必须）
     */
    private String receiverAddress;

    /**
     * 收件人手机号，手机号固话不可同时为空（必须）
     */
    private String receiverMobile;

    /**
     * 收件人固话，手机号固话不可同时为空
     */
    private String receiverPhone;

    /**
     * 收件邮编
     */
    private String receiverZip;

    /**
     * 是否货到付款,1:是；0：否
     */
    private Integer cod;

    /**
     * 订单类型，一口价、送礼、赠品领取、货到付款
     */
    private String tradeType;

    /**
     * 商品金额,商品价格*数量。精确到2位小数;单位:元。如:200.07，表示:200元7分（必须）
     */
    private String totalFee;

    /**
     * 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分（必须）
     */
    private String payment;

    /**
     * 邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分（必须）
     */
    private String postFee;

    /**
     * 优惠金额 单位:元。如:200.07，表示:200元7分
     */
    private String discountFee;

    /**
     * 交易创建时间。格式:yyyy-MM-dd HH:mm:ss（必须）
     */
    private Date created;

    /**
     * 付款时间。格式:yyyy-MM-dd HH:mm:ss。订单的付款时间即为物流订单的创建时间。（必须）
     */
    private Date payTime;

    /**
     * 交易修改时间(用户对订单的任何修改都会更新此字段)。格式:yyyy-MM-dd HH:mm:ss。（必须）
     */
    private Date modified;

    /**
     * 商品购买数量。取值范围：大于零的整数,对于一个trade对应多个order的时候（一笔主订单，对应多笔子订单），num=0，num是一个跟商品关联的属性（必须）
     */
    private Long totalNum;

    /**
     * 子订单列表（必须）
     */
    private List<KdzsMallOrderDTO> orders;

    /**
     * 卖家备注旗帜 红、黄、绿、蓝、紫 、灰分别对应 1、2、3、4、5、0
     */
    private Long sellerFlag;

    /**
     * 卖家备注
     */
    private String sellerMemo;

    /**
     * 交易状态（必须）
     */
    private String status;

    /**
     * 支付方式
     */
    private String payMethod;

    /**
     * 支付类型
     */
    private String payType;

    /**
     * 发票内容
     */
    private KdzsMallInvoiceDTO mallInvoice;

    /**
     * 退款状态
     */
    private String refundStatus;

    /**
     * 发货运单号
     */
    private String waybillNo;

    /**
     * 发货物流公司code
     */
    private String waybillCode;

    /**
     * 发货时间
     */
    private Date sendTime;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
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

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverZip() {
        return receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPostFee() {
        return postFee;
    }

    public void setPostFee(String postFee) {
        this.postFee = postFee;
    }

    public String getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(String discountFee) {
        this.discountFee = discountFee;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public List<KdzsMallOrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<KdzsMallOrderDTO> orders) {
        this.orders = orders;
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

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public KdzsMallInvoiceDTO getMallInvoice() {
        return mallInvoice;
    }

    public void setMallInvoice(KdzsMallInvoiceDTO mallInvoice) {
        this.mallInvoice = mallInvoice;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    public String getWaybillCode() {
        return waybillCode;
    }

    public void setWaybillCode(String waybillCode) {
        this.waybillCode = waybillCode;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "KdzsMallTradeReqDTO{}";
    }
}
