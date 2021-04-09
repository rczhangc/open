package org.open.boot.dao.goods.business;

import org.open.boot.dao.goods.entity.GoodsDO;

import java.io.Serializable;
import java.util.List;

/**
 * 商品信息表实体类BO
 *
 * @author barnak
 */
public class GoodsBO extends GoodsDO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品规格列表
     */
    private List<GoodsSkuBO> goodsSkuList;

    /**
     * 商品详情列表
     */
    private List<GoodsSkuDetailBO> goodsSkuDetailList;

    public List<GoodsSkuBO> getGoodsSkuList() {
        return goodsSkuList;
    }

    public void setGoodsSkuList(List<GoodsSkuBO> goodsSkuList) {
        this.goodsSkuList = goodsSkuList;
    }

    public List<GoodsSkuDetailBO> getGoodsSkuDetailList() {
        return goodsSkuDetailList;
    }

    public void setGoodsSkuDetailList(List<GoodsSkuDetailBO> goodsSkuDetailList) {
        this.goodsSkuDetailList = goodsSkuDetailList;
    }

    @Override
    public String toString() {
        return "GoodsBO{" +
                "id=" + super.getId() +
                ", code=" + super.getCode() +
                ", title=" + super.getTitle() +
                ", name=" + super.getNamed() +
                ", describe=" + super.getDescription() +
                ", status=" + super.getStatus() +
                ", imgCoverUrl=" + super.getImgCoverUrlList() +
                ", imgDetailsUrl=" + super.getImgDetailsUrlList() +
                ", price=" + super.getPrice() +
                ", priceOriginal=" + super.getPriceOriginal() +
                ", priceCost=" + super.getPriceCost() +
                ", insertTime=" + super.getInsertTime() +
                ", updateTime=" + super.getUpdateTime() +
                ", isDeleted=" + super.getIsDeleted() +
                "}";
    }
}