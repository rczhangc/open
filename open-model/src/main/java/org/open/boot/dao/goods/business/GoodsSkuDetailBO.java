package org.open.boot.dao.goods.business;

import org.open.boot.dao.goods.entity.GoodsSkuDetailDO;

import java.io.Serializable;

/**
 * 商品规格详情表实体类BO
 *
 * @author barnak
 */
public class GoodsSkuDetailBO extends GoodsSkuDetailDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "GoodsDetailBO{" +
                "id=" + super.getId() +
                ", skuMakeCode=" + super.getSkuMakeCode() +
                ", skuMakeValue=" + super.getSkuMakeValueList() +
                ", imgUrl=" + super.getImgUrl() +
                ", price=" + super.getPrice() +
                ", priceOriginal=" + super.getPriceOriginal() +
                ", priceCost=" + super.getPriceCost() +
                ", stockTotal=" + super.getStockTotal() +
                ", stockLock=" + super.getStockLock() +
                ", stockSurplus=" + super.getStockSurplus() +
                ", sort=" + super.getSort() +
                ", insertTime=" + super.getInsertTime() +
                ", updateTime=" + super.getUpdateTime() +
                ", isDeleted=" + super.getIsDeleted() +
                "}";
    }
}