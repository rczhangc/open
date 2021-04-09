package org.open.boot.dao.goods.business;

import org.open.boot.dao.goods.entity.GoodsSkuDO;

import java.io.Serializable;
import java.util.List;

/**
 * 商品规格信息表实体类BO
 *
 * @author barnak
 */
public class GoodsSkuBO extends GoodsSkuDO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 规格值列表
     */
    private List<GoodsSkuValueBO> goodsSkuValueList;

    public List<GoodsSkuValueBO> getGoodsSkuValueList() {
        return goodsSkuValueList;
    }

    public void setGoodsSkuValueList(List<GoodsSkuValueBO> goodsSkuValueList) {
        this.goodsSkuValueList = goodsSkuValueList;
    }

    @Override
    public String toString() {
        return "GoodsSkuBO{" +
                "id=" + super.getId() +
                ", code=" + super.getCode() +
                ", name=" + super.getNamed() +
                ", describe=" + super.getDescription() +
                ", insertTime=" + super.getInsertTime() +
                ", updateTime=" + super.getUpdateTime() +
                ", isDeleted=" + super.getIsDeleted() +
                "}";
    }
}