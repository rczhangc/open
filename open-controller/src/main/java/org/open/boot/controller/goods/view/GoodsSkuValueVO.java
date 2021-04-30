package org.open.boot.controller.goods.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品规格值信息表实体类
 *
 * @author barnak
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="GoodsSkuValueVO对象", description="商品规格值信息表")
public class GoodsSkuValueVO implements Serializable {

private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "规格ID")
    private Long id;

    @ApiModelProperty(value = "商品编码")
    private String goodsCode;

    @ApiModelProperty(value = "规格编码")
    private String goodsSkuCode;

    @ApiModelProperty(value = "规格值编码")
    private String code;

    @ApiModelProperty(value = "规格值")
    private String value;

    @ApiModelProperty(value = "新增时间")
    private Date insertTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "已删除：0否")
    private Long isDeleted;


    public Long getId() {
        return id;
    }

    public GoodsSkuValueVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public GoodsSkuValueVO setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
        return this;
    }

    public String getGoodsSkuCode() {
        return goodsSkuCode;
    }

    public GoodsSkuValueVO setGoodsSkuCode(String goodsSkuCode) {
        this.goodsSkuCode = goodsSkuCode;
        return this;
    }

    public String getCode() {
        return code;
    }

    public GoodsSkuValueVO setCode(String code) {
        this.code = code;
        return this;
    }

    public String getValue() {
        return value;
    }

    public GoodsSkuValueVO setValue(String value) {
        this.value = value;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public GoodsSkuValueVO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public GoodsSkuValueVO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public GoodsSkuValueVO setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "GoodsSkuValueVO{" +
            "id=" + id +
            ", goodsCode=" + goodsCode +
            ", goodsSkuCode=" + goodsSkuCode +
            ", code=" + code +
            ", value=" + value +
            ", insertTime=" + insertTime +
            ", updateTime=" + updateTime +
            ", isDeleted=" + isDeleted +
            "}";
    }
}