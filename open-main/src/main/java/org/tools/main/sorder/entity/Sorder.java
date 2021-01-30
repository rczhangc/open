package org.tools.main.sorder.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 订单信息表实体类
 *
 * @author barnak
 */
@TableName("sorder")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="Sorder对象", description="订单信息表")
public class Sorder implements Serializable {

private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "order_id", type = IdType.AUTO)
    private Long orderId;

    @ApiModelProperty(value = "订单编号")
    @TableField("order_code")
    private String orderCode;

    @ApiModelProperty(value = "商家ID")
    @TableField("seller_id")
    private Long sellerId;

    @ApiModelProperty(value = "商家账户")
    @TableField("seller_account")
    private String sellerAccount;

    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty(value = "用户账户")
    @TableField("user_account")
    private String userAccount;

    @ApiModelProperty(value = "团购ID")
    @TableField("team_buy_id")
    private Long teamBuyId;

    @ApiModelProperty(value = "跟团号")
    @TableField("team_follow_code")
    private Integer teamFollowCode;

    @ApiModelProperty(value = "购买件数")
    @TableField("buy_num")
    private Integer buyNum;

    @ApiModelProperty(value = "实际发货数量")
    @TableField("send_num")
    private Integer sendNum;

    @ApiModelProperty(value = "商品销售价格")
    @TableField("goods_price")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "运费")
    @TableField("express_fee")
    private BigDecimal expressFee;

    @ApiModelProperty(value = "实际折扣总金额")
    @TableField("discount_fee")
    private BigDecimal discountFee;

    @ApiModelProperty(value = "实际销售总金额（应支付金额）")
    @TableField("total_fee")
    private BigDecimal totalFee;

    @ApiModelProperty(value = "实际支付总金额")
    @TableField("total_pay")
    private BigDecimal totalPay;

    @TableField("address_id")
    private Integer addressId;

    @ApiModelProperty(value = "地址")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "商家备注")
    @TableField("seller_note")
    private String sellerNote;

    @ApiModelProperty(value = "订单状态，0=>待付款，10=>待发货，20=>待收货   40=>已完成，50=>已取消，60=>售后中，70=>交易关闭 ")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "评价状态：0-待评价  10-已评价  ")
    @TableField("praise_status")
    private Integer praiseStatus;

    @ApiModelProperty(value = "支付状态 0=>待支付 1=>已支付 2. 部分退款  3=> 已退款 ")
    @TableField("pay_status")
    private Integer payStatus;

    @ApiModelProperty(value = "售后状态 0=>未开始，10=>申请中 , 20=>等待买家寄出商品，30=>等待商家验收商品，40=>售后完成")
    @TableField("after_status")
    private Integer afterStatus;

    @ApiModelProperty(value = "是否关闭售后,0=>否,1=>是")
    @TableField("is_close_return")
    private Integer isCloseReturn;

    @ApiModelProperty(value = "支付渠道 1=>微信支付 2=>支付宝支付")
    @TableField("pay_channel")
    private Integer payChannel;

    @ApiModelProperty(value = "下单渠道 1 购物车 2 再次下单 ")
    @TableField("order_channel")
    private Integer orderChannel;

    @ApiModelProperty(value = "支付时间")
    @TableField("pay_time")
    private Date payTime;

    @ApiModelProperty(value = "发货时间")
    @TableField("send_time")
    private Date sendTime;

    @ApiModelProperty(value = "收货时间")
    @TableField("receive_time")
    private Date receiveTime;

    @ApiModelProperty(value = "取消时间")
    @TableField("cancel_time")
    private Date cancelTime;

    @ApiModelProperty(value = "联系人")
    @TableField("contact_name")
    private String contactName;

    @ApiModelProperty(value = "联系方式")
    @TableField("contact_phone")
    private String contactPhone;

    @ApiModelProperty(value = "邮政编码")
    @TableField("zip_code")
    private String zipCode;

    @ApiModelProperty(value = "详细收货地址")
    @TableField("express_address")
    private String expressAddress;

    @ApiModelProperty(value = "详情摘要，用于展示")
    @TableField("detail")
    private String detail;

    @ApiModelProperty(value = "创建时间")
    @TableField("input_time")
    private Date inputTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除")
    @TableField("is_del")
    private Integer isDel;

    @ApiModelProperty(value = "关闭售后时间")
    @TableField("close_return_time")
    private Date closeReturnTime;


    public Long getOrderId() {
        return orderId;
    }

    public Sorder setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public Sorder setOrderCode(String orderCode) {
        this.orderCode = orderCode;
        return this;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public Sorder setSellerId(Long sellerId) {
        this.sellerId = sellerId;
        return this;
    }

    public String getSellerAccount() {
        return sellerAccount;
    }

    public Sorder setSellerAccount(String sellerAccount) {
        this.sellerAccount = sellerAccount;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Sorder setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public Sorder setUserAccount(String userAccount) {
        this.userAccount = userAccount;
        return this;
    }

    public Long getTeamBuyId() {
        return teamBuyId;
    }

    public Sorder setTeamBuyId(Long teamBuyId) {
        this.teamBuyId = teamBuyId;
        return this;
    }

    public Integer getTeamFollowCode() {
        return teamFollowCode;
    }

    public Sorder setTeamFollowCode(Integer teamFollowCode) {
        this.teamFollowCode = teamFollowCode;
        return this;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public Sorder setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
        return this;
    }

    public Integer getSendNum() {
        return sendNum;
    }

    public Sorder setSendNum(Integer sendNum) {
        this.sendNum = sendNum;
        return this;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public Sorder setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
        return this;
    }

    public BigDecimal getExpressFee() {
        return expressFee;
    }

    public Sorder setExpressFee(BigDecimal expressFee) {
        this.expressFee = expressFee;
        return this;
    }

    public BigDecimal getDiscountFee() {
        return discountFee;
    }

    public Sorder setDiscountFee(BigDecimal discountFee) {
        this.discountFee = discountFee;
        return this;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public Sorder setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
        return this;
    }

    public BigDecimal getTotalPay() {
        return totalPay;
    }

    public Sorder setTotalPay(BigDecimal totalPay) {
        this.totalPay = totalPay;
        return this;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public Sorder setAddressId(Integer addressId) {
        this.addressId = addressId;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Sorder setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Sorder setNote(String note) {
        this.note = note;
        return this;
    }

    public String getSellerNote() {
        return sellerNote;
    }

    public Sorder setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Sorder setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getPraiseStatus() {
        return praiseStatus;
    }

    public Sorder setPraiseStatus(Integer praiseStatus) {
        this.praiseStatus = praiseStatus;
        return this;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public Sorder setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
        return this;
    }

    public Integer getAfterStatus() {
        return afterStatus;
    }

    public Sorder setAfterStatus(Integer afterStatus) {
        this.afterStatus = afterStatus;
        return this;
    }

    public Integer getIsCloseReturn() {
        return isCloseReturn;
    }

    public Sorder setIsCloseReturn(Integer isCloseReturn) {
        this.isCloseReturn = isCloseReturn;
        return this;
    }

    public Integer getPayChannel() {
        return payChannel;
    }

    public Sorder setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
        return this;
    }

    public Integer getOrderChannel() {
        return orderChannel;
    }

    public Sorder setOrderChannel(Integer orderChannel) {
        this.orderChannel = orderChannel;
        return this;
    }

    public Date getPayTime() {
        return payTime;
    }

    public Sorder setPayTime(Date payTime) {
        this.payTime = payTime;
        return this;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public Sorder setSendTime(Date sendTime) {
        this.sendTime = sendTime;
        return this;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public Sorder setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
        return this;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public Sorder setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
        return this;
    }

    public String getContactName() {
        return contactName;
    }

    public Sorder setContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public Sorder setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Sorder setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getExpressAddress() {
        return expressAddress;
    }

    public Sorder setExpressAddress(String expressAddress) {
        this.expressAddress = expressAddress;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public Sorder setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public Sorder setInputTime(Date inputTime) {
        this.inputTime = inputTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Sorder setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public Sorder setIsDel(Integer isDel) {
        this.isDel = isDel;
        return this;
    }

    public Date getCloseReturnTime() {
        return closeReturnTime;
    }

    public Sorder setCloseReturnTime(Date closeReturnTime) {
        this.closeReturnTime = closeReturnTime;
        return this;
    }

    @Override
    public String toString() {
        return "Sorder{" +
            "orderId=" + orderId +
            ", orderCode=" + orderCode +
            ", sellerId=" + sellerId +
            ", sellerAccount=" + sellerAccount +
            ", userId=" + userId +
            ", userAccount=" + userAccount +
            ", teamBuyId=" + teamBuyId +
            ", teamFollowCode=" + teamFollowCode +
            ", buyNum=" + buyNum +
            ", sendNum=" + sendNum +
            ", goodsPrice=" + goodsPrice +
            ", expressFee=" + expressFee +
            ", discountFee=" + discountFee +
            ", totalFee=" + totalFee +
            ", totalPay=" + totalPay +
            ", addressId=" + addressId +
            ", address=" + address +
            ", note=" + note +
            ", sellerNote=" + sellerNote +
            ", status=" + status +
            ", praiseStatus=" + praiseStatus +
            ", payStatus=" + payStatus +
            ", afterStatus=" + afterStatus +
            ", isCloseReturn=" + isCloseReturn +
            ", payChannel=" + payChannel +
            ", orderChannel=" + orderChannel +
            ", payTime=" + payTime +
            ", sendTime=" + sendTime +
            ", receiveTime=" + receiveTime +
            ", cancelTime=" + cancelTime +
            ", contactName=" + contactName +
            ", contactPhone=" + contactPhone +
            ", zipCode=" + zipCode +
            ", expressAddress=" + expressAddress +
            ", detail=" + detail +
            ", inputTime=" + inputTime +
            ", updateTime=" + updateTime +
            ", isDel=" + isDel +
            ", closeReturnTime=" + closeReturnTime +
            "}";
    }
}