package org.open.boot.dao.goods.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * 商品信息表实体类
 *
 * @author barnak
 */
@TableName("goods")
public class GoodsDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品编码
     */
    @TableField("code")
    private String code;

    /**
     * 商品标题
     */
    @NotBlank
    @TableField("title")
    private String title;

    /**
     * 商品名称
     */
    @NotNull
    @TableField("name")
    private String name;

    /**
     * 商品描述
     */
    @NotBlank
    @TableField("describe")
    private String describe;

    /**
     * 商品状态：10下架 20上架
     */
    @NotNull
    @TableField("status")
    private Integer status;

    /**
     * 商品封面图
     */
    @NotNull
    @TableField("img_cover_url")
    private String imgCoverUrl;

    /**
     * 商品详情图
     */
    @NotNull
    @TableField("img_details_url")
    private String imgDetailsUrl;

    /**
     * 商品实际价格
     */
    @NotNull
    @TableField("price")
    private BigDecimal price;

    /**
     * 商品原价
     */
    @NotNull
    @TableField("price_original")
    private BigDecimal priceOriginal;

    /**
     * 商品成本价
     */
    @NotNull
    @TableField("price_cost")
    private BigDecimal priceCost;

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

    public GoodsDO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public GoodsDO setCode(String code) {
        this.code = code;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public GoodsDO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodsDO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescribe() {
        return describe;
    }

    public GoodsDO setDescribe(String describe) {
        this.describe = describe;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public GoodsDO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getImgCoverUrl() {
        return imgCoverUrl;
    }

    public GoodsDO setImgCoverUrl(String imgCoverUrl) {
        this.imgCoverUrl = imgCoverUrl;
        return this;
    }

    public String getImgDetailsUrl() {
        return imgDetailsUrl;
    }

    public GoodsDO setImgDetailsUrl(String imgDetailsUrl) {
        this.imgDetailsUrl = imgDetailsUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public GoodsDO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getPriceOriginal() {
        return priceOriginal;
    }

    public GoodsDO setPriceOriginal(BigDecimal priceOriginal) {
        this.priceOriginal = priceOriginal;
        return this;
    }

    public BigDecimal getPriceCost() {
        return priceCost;
    }

    public GoodsDO setPriceCost(BigDecimal priceCost) {
        this.priceCost = priceCost;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public GoodsDO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public GoodsDO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public GoodsDO setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "GoodsDO{" +
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