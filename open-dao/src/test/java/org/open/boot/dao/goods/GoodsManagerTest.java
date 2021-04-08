package org.open.boot.dao.goods;

import org.junit.Test;
import org.open.boot.BaseUnitTest;
import org.open.boot.dao.goods.business.*;
import org.open.boot.dao.goods.entity.GoodsSkuDetailDO;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author barnak
 */
public class GoodsManagerTest extends BaseUnitTest {

    @Resource
    private GoodsManager goodsManager;

    @Test
    public void testSave() {
        GoodsBO goodsBO = new GoodsBO();

        goodsBO.setName("测试商品");
        goodsBO.setTitle("测试商品标题");
        goodsBO.setDescribe("测i是商品描述");
        goodsBO.setImgCoverUrl("http://127.0.1.1");
        goodsBO.setImgDetailsUrl("www.baidu.com");
        goodsBO.setPrice(BigDecimal.ZERO);
        goodsBO.setPriceCost(BigDecimal.ZERO);
        goodsBO.setPriceOriginal(BigDecimal.ZERO);
        goodsBO.setStatus(10);

        List<GoodsSkuBO> goodsSkuBOList = new ArrayList<>();
        GoodsSkuBO goodsSkuBO = new GoodsSkuBO();
        goodsSkuBO.setName("测试规格");
        goodsSkuBO.setCode("dfasdf");
        goodsSkuBO.setDescribe("规格描述");
        goodsSkuBO.setValueList(Collections.singletonList(new GoodsSkuValueBO()));

        goodsBO.setGoodsSkuList(goodsSkuBOList);

        GoodsSkuDetailBO goodsSkuDetailDO = new GoodsSkuDetailBO();
        goodsSkuDetailDO.setImgUrl("http:15445");
        goodsSkuDetailDO.setPrice(BigDecimal.ZERO);
        goodsSkuDetailDO.setPriceCost(BigDecimal.ZERO);
        goodsSkuDetailDO.setPriceOriginal(BigDecimal.ZERO);
        goodsSkuDetailDO.setSkuMakeValueList(Collections.singletonList(new GoodsDetailSkuValueBO()));
        goodsSkuDetailDO.setSkuMakeCode("sdfasdfa");
        goodsSkuDetailDO.setStockLock("0");
        goodsSkuDetailDO.setStockSurplus("0");
        goodsSkuDetailDO.setSort(0);
        goodsSkuDetailDO.setStockTotal("0");
        goodsSkuDetailDO.setSkuMakeValueList(Collections.singletonList(new GoodsDetailSkuValueBO()));
        goodsBO.setGoodsSkuDetailList(Collections.singletonList(goodsSkuDetailDO));

        GoodsBO save = goodsManager.save(goodsBO);
    }
}