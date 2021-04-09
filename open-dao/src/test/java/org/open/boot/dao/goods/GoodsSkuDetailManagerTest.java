package org.open.boot.dao.goods;

import org.junit.Test;
import org.open.boot.BaseUnitTest;
import org.open.boot.dao.goods.business.GoodsSkuMakeValueBO;
import org.open.boot.dao.goods.entity.GoodsSkuDetailDO;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author barnak
 */
public class GoodsSkuDetailManagerTest extends BaseUnitTest {

    @Resource
    private GoodsSkuDetailManager goodsSkuDetailManager;

    @Test
    public void testSave() {
        GoodsSkuDetailDO sku1 = new GoodsSkuDetailDO();
        sku1.setGoodsCode("9b1ed87c5c7a49b29be8bd4bc6a5a4fc");
        sku1.setImgUrl("https://image.fengmaijie.com/s/2021022010/33d798fba3ca6f95735c1c7a98c16c56.jpg");
        sku1.setPrice(BigDecimal.ZERO);
        sku1.setPriceCost(BigDecimal.ZERO);
        sku1.setPriceOriginal(BigDecimal.ZERO);
        sku1.setSkuMakeValueCode("59ac66300dd847b8b4d655f61d7b35db");

        GoodsSkuMakeValueBO skuValue1 = new GoodsSkuMakeValueBO();
        skuValue1.setSkuCode("183200d710fb484f94b7ea7a79fb16a0");
        skuValue1.setSkuValueCode("59ac66300dd847b8b4d655f61d7b35db");
        skuValue1.setSkuName("颜色");
        skuValue1.setSkuValue("红色");
        sku1.setSkuMakeValueList(Collections.singletonList(skuValue1));
        sku1.setStockLock(1);
        sku1.setStockSurplus(1);
        sku1.setStockTotal(1);

        goodsSkuDetailManager.save(sku1);


        GoodsSkuDetailDO sku2 = new GoodsSkuDetailDO();
        sku2.setGoodsCode("9b1ed87c5c7a49b29be8bd4bc6a5a4fc");
        sku2.setImgUrl("https://image.fengmaijie.com/s/2021022010/33d798fba3ca6f95735c1c7a98c16c56.jpg");
        sku2.setPrice(BigDecimal.ZERO);
        sku2.setPriceCost(BigDecimal.ZERO);
        sku2.setPriceOriginal(BigDecimal.ZERO);
        sku2.setSkuMakeValueCode("beeeec66fcd2423b9f3aa9e5b382f862");

        GoodsSkuMakeValueBO skuValue2 = new GoodsSkuMakeValueBO();
        skuValue2.setSkuCode("183200d710fb484f94b7ea7a79fb16a0");
        skuValue2.setSkuValueCode("beeeec66fcd2423b9f3aa9e5b382f862");
        skuValue2.setSkuName("颜色");
        skuValue2.setSkuValue("黑色");
        sku2.setSkuMakeValueList(Collections.singletonList(skuValue2));
        sku2.setStockLock(1);
        sku2.setStockSurplus(1);
        sku2.setStockTotal(1);
        goodsSkuDetailManager.save(sku2);
    }

    @Test
    public void testSelect() {
        List<GoodsSkuDetailDO> goodsSkuDetailDOS = goodsSkuDetailManager.listByIds(Arrays.asList(1L, 2L));
    }
}