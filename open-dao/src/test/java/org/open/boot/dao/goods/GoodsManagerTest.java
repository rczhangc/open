package org.open.boot.dao.goods;

import org.junit.Test;
import org.open.boot.BaseUnitTest;
import org.open.boot.dao.goods.entity.GoodsDO;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author barnak
 */
public class GoodsManagerTest extends BaseUnitTest {

    @Resource
    private GoodsManager goodsManager;

    @Test
    public void testSave() {
    }

    @Test
    public void testGoodsSave() {
        GoodsDO goods = new GoodsDO();

        goods.setNamed("测试商品");
        goods.setTitle("测试商品标题");
        goods.setDescription("测i是商品描述");
        goods.setImgCoverUrlList(Arrays.asList("https://image.fengmaijie.com/s/2021022010/33d798fba3ca6f95735c1c7a98c16c56.jpg","https://image.fengmaijie.com/s/2021022010/33d798fba3ca6f95735c1c7a98c16c56.jpg"));
        goods.setImgDetailsUrlList(Arrays.asList("https://image.fengmaijie.com/s/2021022010/33d798fba3ca6f95735c1c7a98c16c56.jpg","https://image.fengmaijie.com/s/2021022010/33d798fba3ca6f95735c1c7a98c16c56.jpg"));
        goods.setPrice(BigDecimal.ZERO);
        goods.setPriceCost(BigDecimal.ZERO);
        goods.setPriceOriginal(BigDecimal.ZERO);
        goods.setStatus(10);
        goods.setInsertTime(new Date());
        goods.setUpdateTime(new Date());
        goods.setIsDeleted(0L);

        goodsManager.saveGoodsInfo(goods);
    }

    @Test
    public void testGoodsSelect() {
        GoodsDO byId = goodsManager.getById(1L);
    }
}