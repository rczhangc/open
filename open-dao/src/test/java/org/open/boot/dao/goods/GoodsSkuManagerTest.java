package org.open.boot.dao.goods;

import cn.hutool.core.util.IdUtil;
import org.junit.Test;
import org.open.boot.BaseUnitTest;
import org.open.boot.dao.goods.business.GoodsSkuValueBO;
import org.open.boot.dao.goods.entity.GoodsSkuDO;

import javax.annotation.Resource;

import java.util.Arrays;

/**
 * @author barnak
 */
public class GoodsSkuManagerTest extends BaseUnitTest {

    @Resource
    private GoodsSkuManager goodsSkuManager;

    @Test
    public void testSave() {

        GoodsSkuDO goodsSkuDO = new GoodsSkuDO();
        goodsSkuDO.setGoodsCode("9b1ed87c5c7a49b29be8bd4bc6a5a4fc");
        goodsSkuDO.setCode(IdUtil.simpleUUID());
        goodsSkuDO.setDescription("测试规格描述");
        goodsSkuDO.setNamed("颜色");

        goodsSkuManager.save(goodsSkuDO);
    }

    @Test
    public void testSelect() {
        GoodsSkuDO byId = goodsSkuManager.getById(1L);
    }

}