package org.open.boot.dao.goods;

import cn.hutool.core.util.IdUtil;
import org.junit.Test;
import org.open.boot.BaseUnitTest;
import org.open.boot.dao.goods.entity.GoodsSkuValueDO;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author barnak
 */
public class GoodsSkuValueManagerTest extends BaseUnitTest {

    @Resource
    private GoodsSkuValueManager goodsSkuValueManager;

    @Test
    public void testSave() {
        GoodsSkuValueDO skuValue1 = new GoodsSkuValueDO();
        skuValue1.setCode(IdUtil.simpleUUID());
        skuValue1.setGoodsCode("9b1ed87c5c7a49b29be8bd4bc6a5a4fc");
        skuValue1.setGoodsSkuCode("183200d710fb484f94b7ea7a79fb16a0");
        skuValue1.setValue("红色");

        GoodsSkuValueDO skuValue2 = new GoodsSkuValueDO();
        skuValue2.setCode(IdUtil.simpleUUID());
        skuValue2.setGoodsCode("9b1ed87c5c7a49b29be8bd4bc6a5a4fc");
        skuValue2.setGoodsSkuCode("183200d710fb484f94b7ea7a79fb16a0");
        skuValue2.setValue("红色");

        goodsSkuValueManager.save(skuValue1);
        goodsSkuValueManager.save(skuValue2);
    }

    @Test
    public void testSelect() {
        List<GoodsSkuValueDO> goodsSkuValueDOS = goodsSkuValueManager.listByIds(Arrays.asList(1L, 2L));
    }

}