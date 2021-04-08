package org.open.boot.dao.goods.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import org.open.boot.dao.goods.business.GoodsDetailSkuValueBO;


/**
 * 商品规格详情表实体类
 *
 * @author barnak
 */
@TableName("goods_sku_detail")
public class GoodsSkuDetailDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品详情ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 规格编码组合
     */
    @TableField("sku_make_code")
    private String skuMakeCode;

    /**
     * 规格值组合
     */
    @TableField("sku_make_value_list")
    private List<GoodsDetailSkuValueBO> skuMakeValueList;

    /**
     * 规格图
     */
    @TableField("img_url")
    private String imgUrl;

    /**
     * 规格实际价格
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 规格原价
     */
    @TableField("price_original")
    private BigDecimal priceOriginal;

    /**
     * 规格成本价
     */
    @TableField("price_cost")
    private BigDecimal priceCost;

    /**
     * 总库存（锁定库存+可用库存）
     */
    @TableField("stock_total")
    private String stockTotal;

    /**
     * 锁定库存
     */
    @TableField("stock_lock")
    private String stockLock;

    /**
     * 可用库存
     */
    @TableField("stock_surplus")
    private String stockSurplus;

    /**
     * 规格组合排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 新增时间
     */
    @TableField("insert_time")
    private Date insertTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 已删除：0否
     */
    @TableField("is_deleted")
    private Long isDeleted;


    public Long getId() {
        return id;
    }

    public GoodsSkuDetailDO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getSkuMakeCode() {
        return skuMakeCode;
    }

    public GoodsSkuDetailDO setSkuMakeCode(String skuMakeCode) {
        this.skuMakeCode = skuMakeCode;
        return this;
    }

    public List<GoodsDetailSkuValueBO> getSkuMakeValueList() {
        return skuMakeValueList;
    }

    public GoodsSkuDetailDO setSkuMakeValueList(List<GoodsDetailSkuValueBO> skuMakeValueList) {
        this.skuMakeValueList = skuMakeValueList;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public GoodsSkuDetailDO setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public GoodsSkuDetailDO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getPriceOriginal() {
        return priceOriginal;
    }

    public GoodsSkuDetailDO setPriceOriginal(BigDecimal priceOriginal) {
        this.priceOriginal = priceOriginal;
        return this;
    }

    public BigDecimal getPriceCost() {
        return priceCost;
    }

    public GoodsSkuDetailDO setPriceCost(BigDecimal priceCost) {
        this.priceCost = priceCost;
        return this;
    }

    public String getStockTotal() {
        return stockTotal;
    }

    public GoodsSkuDetailDO setStockTotal(String stockTotal) {
        this.stockTotal = stockTotal;
        return this;
    }

    public String getStockLock() {
        return stockLock;
    }

    public GoodsSkuDetailDO setStockLock(String stockLock) {
        this.stockLock = stockLock;
        return this;
    }

    public String getStockSurplus() {
        return stockSurplus;
    }

    public GoodsSkuDetailDO setStockSurplus(String stockSurplus) {
        this.stockSurplus = stockSurplus;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public GoodsSkuDetailDO setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public GoodsSkuDetailDO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public GoodsSkuDetailDO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public GoodsSkuDetailDO setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "GoodsDetailDO{" +
            "id=" + id +
            ", skuMakeCode=" + skuMakeCode +
            ", skuMakeValue=" + skuMakeValueList +
            ", imgUrl=" + imgUrl +
            ", price=" + price +
            ", priceOriginal=" + priceOriginal +
            ", priceCost=" + priceCost +
            ", stockTotal=" + stockTotal +
            ", stockLock=" + stockLock +
            ", stockSurplus=" + stockSurplus +
            ", sort=" + sort +
            ", insertTime=" + insertTime +
            ", updateTime=" + updateTime +
            ", isDeleted=" + isDeleted +
            "}";
    }
}