package org.open.boot.api.kuaidizs.impl;

import org.open.boot.api.kuaidizs.KdzsProductApi;
import org.open.boot.api.kuaidizs.dto.KdzsMallItemIdListDTO;
import org.open.boot.api.kuaidizs.dto.KdzsMallItemListDTO;
import org.open.boot.api.kuaidizs.dto.KdzsResponseDTO;
import org.open.boot.api.kuaidizs.enums.KdzsMethodEnum;
import org.open.boot.api.kuaidizs.util.KdzsUtils;
import org.springframework.stereotype.Service;

/**
 * 快递助手：商品模块实现
 *
 * @author barnak
 */
@Service
class KdzsProductApiImpl implements KdzsProductApi {

    @Override
    public KdzsResponseDTO<Object> list(KdzsMallItemListDTO request) {
        return KdzsUtils.doRequest(request, KdzsMethodEnum.PRODUCT_LIST);
    }

    @Override
    public KdzsResponseDTO<Object> saveItemList(KdzsMallItemListDTO request) {
        return KdzsUtils.doRequest(request, KdzsMethodEnum.PRODUCT_SAVE_ITEM_LIST);
    }

    @Override
    public KdzsResponseDTO<Object> deleteItemList(KdzsMallItemIdListDTO request) {
        return KdzsUtils.doRequest(request, KdzsMethodEnum.PRODUCT_DELETE_ITEM_LIST);
    }
}
