package org.open.boot.controller.page.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品规格详情表实体类
 *
 * @author barnak
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="GoodsDetailVO对象", description="商品规格详情表")
public class GoodsDetailVO implements Serializable {

private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品详情ID")
    private Long id;

    @ApiModelProperty(value = "规格编码组合")
    private String skuMakeCode;

    @ApiModelProperty(value = "规格值组合")
    private String skuMakeValue;

    @ApiModelProperty(value = "规格图")
    private String imgUrl;

    @ApiModelProperty(value = "规格实际价格")
    private BigDecimal price;

    @ApiModelProperty(value = "规格原价")
    private BigDecimal priceOriginal;

    @ApiModelProperty(value = "规格成本价")
    private BigDecimal priceCost;

    @ApiModelProperty(value = "总库存（锁定库存+可用库存）")
    private String stockTotal;

    @ApiModelProperty(value = "锁定库存")
    private String stockLock;

    @ApiModelProperty(value = "可用库存")
    private String stockSurplus;

    @ApiModelProperty(value = "规格组合排序")
    private Integer sort;

    @ApiModelProperty(value = "新增时间")
    private Date insertTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "已删除：0否")
    private Long isDeleted;


    public Long getId() {
        return id;
    }

    public GoodsDetailVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getSkuMakeCode() {
        return skuMakeCode;
    }

    public GoodsDetailVO setSkuMakeCode(String skuMakeCode) {
        this.skuMakeCode = skuMakeCode;
        return this;
    }

    public String getSkuMakeValue() {
        return skuMakeValue;
    }

    public GoodsDetailVO setSkuMakeValue(String skuMakeValue) {
        this.skuMakeValue = skuMakeValue;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public GoodsDetailVO setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public GoodsDetailVO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getPriceOriginal() {
        return priceOriginal;
    }

    public GoodsDetailVO setPriceOriginal(BigDecimal priceOriginal) {
        this.priceOriginal = priceOriginal;
        return this;
    }

    public BigDecimal getPriceCost() {
        return priceCost;
    }

    public GoodsDetailVO setPriceCost(BigDecimal priceCost) {
        this.priceCost = priceCost;
        return this;
    }

    public String getStockTotal() {
        return stockTotal;
    }

    public GoodsDetailVO setStockTotal(String stockTotal) {
        this.stockTotal = stockTotal;
        return this;
    }

    public String getStockLock() {
        return stockLock;
    }

    public GoodsDetailVO setStockLock(String stockLock) {
        this.stockLock = stockLock;
        return this;
    }

    public String getStockSurplus() {
        return stockSurplus;
    }

    public GoodsDetailVO setStockSurplus(String stockSurplus) {
        this.stockSurplus = stockSurplus;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public GoodsDetailVO setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public GoodsDetailVO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public GoodsDetailVO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public GoodsDetailVO setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "GoodsDetailVO{" +
            "id=" + id +
            ", skuMakeCode=" + skuMakeCode +
            ", skuMakeValue=" + skuMakeValue +
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