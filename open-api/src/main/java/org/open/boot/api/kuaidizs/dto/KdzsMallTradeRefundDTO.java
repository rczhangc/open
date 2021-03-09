package org.open.boot.api.kuaidizs.dto;

import java.util.List;

/**
 * 订单助手：订单退款对象
 *
 * @author barnak
 */
public class KdzsMallTradeRefundDTO {

    /**
     * 订单id，全局唯一（必须）
     */
    private String tid;

    /**
     * 子订单id，全局唯一
     */
    private List< String > oids;

    /**
     * 退款状态（必须）
     */
    private String refundStatus;
}
