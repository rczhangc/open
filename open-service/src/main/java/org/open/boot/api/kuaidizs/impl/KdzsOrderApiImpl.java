package org.open.boot.api.kuaidizs.impl;

import org.open.boot.api.kuaidizs.KdzsOrderApi;
import org.open.boot.api.kuaidizs.dto.*;
import org.open.boot.api.kuaidizs.enums.KdzsMethodEnum;
import org.open.boot.api.kuaidizs.util.KdzsUtils;
import org.springframework.stereotype.Service;

/**
 * 快递助手：订单接口实现
 *
 * @author barnak
 */
@Service
class KdzsOrderApiImpl implements KdzsOrderApi {

    @Override
    public KdzsResponseDTO<Object> create(KdzsMallTradeDTO request) {
        return KdzsUtils.doRequest(request, KdzsMethodEnum.ORDER_CREATE);
    }

    @Override
    public KdzsResponseDTO<Object> batchCreate(KdzsMallTradeListDTO request) {
        return KdzsUtils.doRequest(request, KdzsMethodEnum.ORDER_BATCH_CREATE);
    }

    @Override
    public KdzsResponseDTO<Object> update(KdzsMallTradeUpdateDTO request) {
        return KdzsUtils.doRequest(request, KdzsMethodEnum.ORDER_UPDATE);
    }

    @Override
    public KdzsResponseDTO<Object> send(KdzsMallTradeSendDTO request) {
        return KdzsUtils.doRequest(request, KdzsMethodEnum.ORDER_SEND);
    }

    @Override
    public KdzsResponseDTO<Object> refund(KdzsMallTradeRefundDTO request) {
        return KdzsUtils.doRequest(request, KdzsMethodEnum.ORDER_REFUND);
    }

    @Override
    public KdzsResponseDTO<Object> batchDelete(KdzsMallTradeTidListDTO request) {
        return KdzsUtils.doRequest(request, KdzsMethodEnum.ORDER_BATCH_DELETED);
    }
}
