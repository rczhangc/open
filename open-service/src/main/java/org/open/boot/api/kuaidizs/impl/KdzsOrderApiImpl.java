package org.open.boot.api.kuaidizs.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.open.boot.api.kuaidizs.KdzsOrderApi;
import org.open.boot.api.kuaidizs.constants.KdzsConstants;
import org.open.boot.api.kuaidizs.dto.*;
import org.open.boot.api.kuaidizs.util.KdzsUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 快递助手：订单接口实现
 *
 * @author barnak
 */
@Service
public class KdzsOrderApiImpl implements KdzsOrderApi {

    @Override
    public KdzsResponseDTO create(KdzsMallTradeDTO request) {
        KdzsRequestDTO kdzsReqDTO = KdzsUtils.buildRequest(JSON.toJSONString(request), KdzsConstants.Order.METHOD_CREATE);
        String responseStr = HttpUtil.post(KdzsConstants.MethodUrl.COMMON_URL, JSON.toJSONString(kdzsReqDTO));
        return JSON.parseObject(responseStr, KdzsResponseDTO.class);
    }

    @Override
    public KdzsResponseDTO batchCreate(List<KdzsMallTradeDTO> requestList) {
        KdzsUtils.buildRequest(JSON.toJSONString(requestList), KdzsConstants.Order.METHOD_BATCH_CREATE);
        String responseStr = HttpUtil.post(KdzsConstants.MethodUrl.COMMON_URL, JSON.toJSONString(requestList));
        return JSON.parseObject(responseStr, KdzsResponseDTO.class);
    }

    @Override
    public KdzsResponseDTO update(KdzsMallTradeUpdateDTO request) {
        return null;
    }

    @Override
    public KdzsResponseDTO send(KdzsMallTradeSendDTO request) {
        return null;
    }

    @Override
    public KdzsResponseDTO refund(KdzsMallTradeRefundDTO request) {
        return null;
    }

    @Override
    public KdzsResponseDTO batchDelete(KdzsMallTradeTidListDTO request) {
        return null;
    }
}
