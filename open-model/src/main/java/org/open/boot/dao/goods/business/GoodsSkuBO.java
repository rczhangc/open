package org.open.boot.dao.goods.business;

import org.open.boot.dao.goods.entity.GoodsSkuDO;

import java.io.Serializable;

/**
 * 商品规格信息表实体类BO
 *
 * @author barnak
 */
public class GoodsSkuBO extends GoodsSkuDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "GoodsSkuBO{" +
                "id=" + super.getId() +
                ", code=" + super.getCode() +
                ", name=" + super.getName() +
                ", value=" + super.getValueList() +
                ", describe=" + super.getDescribe() +
                ", insertTime=" + super.getInsertTime() +
                ", updateTime=" + super.getUpdateTime() +
                ", isDeleted=" + super.getIsDeleted() +
                "}";
    }
}