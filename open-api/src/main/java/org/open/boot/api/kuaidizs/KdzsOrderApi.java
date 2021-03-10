package org.open.boot.api.kuaidizs;

import org.open.boot.api.kuaidizs.dto.*;

/**
 * 快递助手：订单接口
 *
 * @author barnak
 */
public interface KdzsOrderApi {

    /**
     * 创建订单
     *
     * @param request {@link KdzsMallOrderDTO}
     * @return {@link KdzsResponseDTO}
     */
    KdzsResponseDTO<Object> create(KdzsMallTradeDTO request);

    /**
     * 批量同步订单（内测中）（一次不可超过300条）
     *
     * @param request {@link KdzsMallTradeListDTO}
     * @return {@link KdzsResponseDTO}
     */
    KdzsResponseDTO<Object> batchCreate(KdzsMallTradeListDTO request);

    /**
     * 修改订单信息
     *
     * @param request {@link KdzsMallTradeUpdateDTO}
     * @return {@link KdzsResponseDTO}
     */
    KdzsResponseDTO<Object> update(KdzsMallTradeUpdateDTO request);

    /**
     * 订单发货
     *
     * @param request {@link KdzsMallTradeSendDTO}
     * @return {@link KdzsResponseDTO}
     */
    KdzsResponseDTO<Object> send(KdzsMallTradeSendDTO request);

    /**
     * 订单退款
     *
     * @param request {@link KdzsMallTradeRefundDTO}
     * @return {@link KdzsResponseDTO}
     */
    KdzsResponseDTO<Object> refund(KdzsMallTradeRefundDTO request);

    /**
     * 订单删除
     *
     * @param request {@link KdzsMallTradeTidListDTO}
     * @return {@link KdzsResponseDTO}
     */
    KdzsResponseDTO<Object> batchDelete(KdzsMallTradeTidListDTO request);
}
