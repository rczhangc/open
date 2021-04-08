package org.open.boot.controller.goods.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 商品信息表实体类
 *
 * @author barnak
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="GoodsVO对象", description="商品信息表")
public class GoodsVO implements Serializable {

private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品ID")
    private Long id;

    @ApiModelProperty(value = "商品编码")
    private String code;

    @ApiModelProperty(value = "商品标题")
    private String title;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "商品描述")
    private String describe;

    @ApiModelProperty(value = "商品状态：10下架 20上架")
    private Integer status;

    @ApiModelProperty(value = "商品封面图")
    private String imgCoverUrl;

    @ApiModelProperty(value = "商品详情图")
    private String imgDetailsUrl;

    @ApiModelProperty(value = "商品实际价格")
    private BigDecimal price;

    @ApiModelProperty(value = "商品原价")
    private BigDecimal priceOriginal;

    @ApiModelProperty(value = "商品成本价")
    private BigDecimal priceCost;

    @ApiModelProperty(value = "新增时间")
    private Date insertTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "已删除：0否")
    private Long isDeleted;


    public Long getId() {
        return id;
    }

    public GoodsVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public GoodsVO setCode(String code) {
        this.code = code;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public GoodsVO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodsVO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescribe() {
        return describe;
    }

    public GoodsVO setDescribe(String describe) {
        this.describe = describe;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public GoodsVO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getImgCoverUrl() {
        return imgCoverUrl;
    }

    public GoodsVO setImgCoverUrl(String imgCoverUrl) {
        this.imgCoverUrl = imgCoverUrl;
        return this;
    }

    public String getImgDetailsUrl() {
        return imgDetailsUrl;
    }

    public GoodsVO setImgDetailsUrl(String imgDetailsUrl) {
        this.imgDetailsUrl = imgDetailsUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public GoodsVO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getPriceOriginal() {
        return priceOriginal;
    }

    public GoodsVO setPriceOriginal(BigDecimal priceOriginal) {
        this.priceOriginal = priceOriginal;
        return this;
    }

    public BigDecimal getPriceCost() {
        return priceCost;
    }

    public GoodsVO setPriceCost(BigDecimal priceCost) {
        this.priceCost = priceCost;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public GoodsVO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public GoodsVO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public GoodsVO setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "GoodsVO{" +
            "id=" + id +
            ", code=" + code +
            ", title=" + title +
            ", name=" + name +
            ", describe=" + describe +
            ", status=" + status +
            ", imgCoverUrl=" + imgCoverUrl +
            ", imgDetailsUrl=" + imgDetailsUrl +
            ", price=" + price +
            ", priceOriginal=" + priceOriginal +
            ", priceCost=" + priceCost +
            ", insertTime=" + insertTime +
            ", updateTime=" + updateTime +
            ", isDeleted=" + isDeleted +
            "}";
    }
}