package org.open.boot.api.kuaidizs;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.open.boot.BaseUnitTest;
import org.open.boot.api.kuaidizs.KdzsWaybillApi;
import org.open.boot.api.kuaidizs.dto.KdzsMallTradeTidListDTO;
import org.open.boot.api.kuaidizs.dto.KdzsOpenGetYdNoDataDTO;
import org.open.boot.api.kuaidizs.dto.KdzsResponseDTO;
import org.open.boot.api.kuaidizs.dto.KdzsTemplateListDTO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author barnak
 */
public class KdzsWaybillApiTest extends BaseUnitTest {

    @Resource
    private KdzsWaybillApi kdzsWaybillApi;

    @Test
    public void getTemplateList() {
        KdzsResponseDTO<KdzsTemplateListDTO> response = kdzsWaybillApi.getTemplateList();
        System.out.println(JSON.toJSONString(response));
    }

    @Test
    public void getBatch() {
        KdzsMallTradeTidListDTO request = new KdzsMallTradeTidListDTO();
        List<String> tidList = new ArrayList<>();
        tidList.add("0123123123");
        tidList.add("2123123123");
        request.setTidList(tidList);
        request.setModeListShowId("4081");

        KdzsResponseDTO<List<KdzsOpenGetYdNoDataDTO>> response = kdzsWaybillApi.getBatch(request);
        System.out.println(JSON.toJSONString(response));
    }
}
