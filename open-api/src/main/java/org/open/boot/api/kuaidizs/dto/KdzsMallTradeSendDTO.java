package org.open.boot.api.kuaidizs.dto;

import java.util.List;

/**
 * 订单助手：订单发货对象
 *
 * @author barnak
 */
public class KdzsMallTradeSendDTO {

    /**
     * 订单id，全局唯一（必须）
     */
    private String tid;

    /**
     * 子订单id，全局唯一
     */
    private List< String > oids;

    /**
     * 快递公司code，详见快递公司对应表（必须）
     */
    private String companyCode;

    /**
     * 运单号（必须）
     */
    private String waybillNo;

    /**
     * 是否拆单，拆单则oids为必传（必须）
     */
    private String split;


}
