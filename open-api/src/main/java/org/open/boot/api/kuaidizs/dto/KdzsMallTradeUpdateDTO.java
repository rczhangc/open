package org.open.boot.api.kuaidizs.dto;

import java.util.Date;

/**
 * 订单助手：订单更新信息
 *
 * @author barnak
 */
public class KdzsMallTradeUpdateDTO {

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
}
