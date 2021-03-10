package org.open.boot.api.kuaidizs.impl;

import com.alibaba.fastjson.TypeReference;
import org.open.boot.api.kuaidizs.KdzsWaybillApi;
import org.open.boot.api.kuaidizs.dto.*;
import org.open.boot.api.kuaidizs.enums.KdzsMethodEnum;
import org.open.boot.api.kuaidizs.util.KdzsUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 快递助手：电子面单实现
 *
 * @author barnak
 */
@Service
class KdzsWaybillApiImpl implements KdzsWaybillApi {

    @Override
    public KdzsResponseDTO<KdzsTemplateListDTO> getTemplateList() {
        return KdzsUtils.doRequest(new KdzsObjectDTO(), KdzsMethodEnum.WAYBILL_GET_TEMPLATE_LIST, new TypeReference<KdzsTemplateListDTO>(){});
    }

    @Override
    public KdzsResponseDTO<List<KdzsOpenGetYdNoDataDTO>> getBatch(KdzsMallTradeTidListDTO request) {
        return KdzsUtils.doRequest(request, KdzsMethodEnum.WAYBILL_GET_BATCH, new TypeReference<List<KdzsOpenGetYdNoDataDTO>>(){});
    }
}
