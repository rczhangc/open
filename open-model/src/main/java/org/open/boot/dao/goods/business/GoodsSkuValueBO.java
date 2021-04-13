package org.open.boot.dao.goods.business;

import org.open.boot.dao.goods.entity.GoodsSkuValueDO;

/**
 * 商品规格值对象
 *
 * @author barnak
 */
public class GoodsSkuValueBO extends GoodsSkuValueDO {

    /**
     * 规格名称
     */
    private String skuNamed;

    public String getSkuNamed() {
        return skuNamed;
    }

    public void setSkuNamed(String skuNamed) {
        this.skuNamed = skuNamed;
    }

    @Override
    public String toString() {
        return "GoodsSkuValueBO{}";
    }
}
