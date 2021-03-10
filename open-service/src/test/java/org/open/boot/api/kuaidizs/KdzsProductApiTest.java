package org.open.boot.api.kuaidizs;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.github.jsonzou.jmockdata.JMockData;
import org.junit.Test;
import org.open.boot.BaseUnitTest;
import org.open.boot.api.kuaidizs.dto.*;

import javax.annotation.Resource;

import java.util.*;


/**
 * @author barnak
 */
public class KdzsProductApiTest extends BaseUnitTest {

    @Resource
    private KdzsProductApi kdzsProductApi;

    @Test
    public void list() {
        KdzsMallItemListDTO request = new KdzsMallItemListDTO();
        List<KdzsMallItemDTO> mallItems = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            KdzsMallItemDTO mallItem = createMallItemUtil();
            mallItems.add(mallItem);
        }
        request.setItemList(mallItems);

        KdzsResponseDTO<Object> response = kdzsProductApi.list(request);
        System.out.println(JSON.toJSONString(response));
    }

    @Test
    public void saveItemList() {
        KdzsMallItemDTO mallItem = JMockData.mock(KdzsMallItemDTO.class);
        mallItem.setItemId("102");
        mallItem.setTitle("修改商品title");
        mallItem.setStatus("ONSALE");
        mallItem.setPicUrl("测试图片地址https://");
        List<KdzsMallSkuDTO> skus = new ArrayList<>();
        KdzsMallSkuDTO sku = new KdzsMallSkuDTO();
        sku.setItemId("102");
        sku.setSkuId("20216224-skuid");
        sku.setItemTitle("修改商品sku");
        sku.setSkuName("修改sku");
        sku.setStatus(1);
        skus.add(sku);
        mallItem.setSkus(skus);
        KdzsMallItemListDTO request = new KdzsMallItemListDTO();
        request.setItemList(Arrays.asList(mallItem));

        KdzsResponseDTO<Object> response = kdzsProductApi.saveItemList(request);
        System.out.println(JSON.toJSONString(response));
    }

    @Test
    public void deleteItemList() {
        KdzsMallItemIdListDTO request = new KdzsMallItemIdListDTO();
        List<String> list = new ArrayList<>();
        list.add("102");
        request.setItemIdList(list);

        KdzsResponseDTO<Object> response = kdzsProductApi.deleteItemList(request);
        System.out.println(JSON.toJSONString(response));
    }

    public KdzsMallItemDTO createMallItemUtil() {
        KdzsMallItemDTO mallItem = JMockData.mock(KdzsMallItemDTO.class);
        mallItem.setStatus("1");
        mallItem.setPicUrl("测试测试");
        KdzsMallSkuDTO mallSku = JMockData.mock(KdzsMallSkuDTO.class);
        mallSku.setCreated(DateUtil.formatDate(new Date()));
        mallSku.setStatus(1);
        List<KdzsMallSkuDTO> mallSkus = new ArrayList<>();
        mallSkus.add(mallSku);
        mallItem.setSkus(mallSkus);
        return mallItem;
    }

}