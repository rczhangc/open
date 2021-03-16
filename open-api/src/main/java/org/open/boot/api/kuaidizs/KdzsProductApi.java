package org.open.boot.api.kuaidizs;

import org.open.boot.api.kuaidizs.dto.KdzsMallItemIdListDTO;
import org.open.boot.api.kuaidizs.dto.KdzsMallItemListDTO;
import org.open.boot.api.kuaidizs.dto.KdzsResponseDTO;

/**
 * 快递助手：商品模块
 *
 * @author barnak
 */
public interface KdzsProductApi {

    /**
     * 同步商品列表（一次同步不可超过500条）[暂不开放]
     *
     * @param request {@link KdzsMallItemListDTO}
     * @return {@link KdzsResponseDTO}
     */
    KdzsResponseDTO<Object> list(KdzsMallItemListDTO request);

    /**
     * 上传(更新)商品（一次同步不可超过300条）
     *
     * @param request {@link KdzsMallItemListDTO}
     * @return {@link KdzsResponseDTO}
     */
    KdzsResponseDTO<Object> saveItemList(KdzsMallItemListDTO request);

    /**
     * 商品删除
     *
     * @param request {@link KdzsMallItemIdListDTO}
     * @return {@link KdzsResponseDTO}
     */
    KdzsResponseDTO<Object> deleteItemList(KdzsMallItemIdListDTO request);
}
