package org.open.boot.api.kuaidizs;

import org.open.boot.api.kuaidizs.dto.KdzsMallTradeTidListDTO;
import org.open.boot.api.kuaidizs.dto.KdzsOpenGetYdNoDataDTO;
import org.open.boot.api.kuaidizs.dto.KdzsResponseDTO;
import org.open.boot.api.kuaidizs.dto.KdzsTemplateListDTO;

import java.util.List;

/**
 * 快递助手：电子面单
 *
 * @author barnak
 */
public interface KdzsWaybillApi {

    /**
     * 获取模版列表
     *
     * @return {@link KdzsResponseDTO<KdzsTemplateListDTO>}
     */
    KdzsResponseDTO<KdzsTemplateListDTO> getTemplateList();

    /**
     * 预申请单号
     *
     * @param request {@link KdzsMallTradeTidListDTO}
     * @return {@link KdzsResponseDTO<List>}
     */
    KdzsResponseDTO<List<KdzsOpenGetYdNoDataDTO>> getBatch(KdzsMallTradeTidListDTO request);
}
