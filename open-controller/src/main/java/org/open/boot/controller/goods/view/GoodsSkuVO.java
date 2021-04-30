package org.open.boot.controller.goods.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品规格信息表实体类
 *
 * @author barnak
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="GoodsSkuVO对象", description="商品规格信息表")
public class GoodsSkuVO implements Serializable {

private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "规格ID")
    private Long id;

    @ApiModelProperty(value = "规格编码")
    private String code;

    @ApiModelProperty(value = "规格名称")
    private String name;

    @ApiModelProperty(value = "规格值")
    private String value;

    @ApiModelProperty(value = "规格描述")
    private String describe;

    @ApiModelProperty(value = "新增时间")
    private Date insertTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "已删除：0否")
    private Long isDeleted;


    public Long getId() {
        return id;
    }

    public GoodsSkuVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public GoodsSkuVO setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodsSkuVO setName(String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public GoodsSkuVO setValue(String value) {
        this.value = value;
        return this;
    }

    public String getDescribe() {
        return describe;
    }

    public GoodsSkuVO setDescribe(String describe) {
        this.describe = describe;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public GoodsSkuVO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public GoodsSkuVO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public GoodsSkuVO setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "GoodsSkuVO{" +
            "id=" + id +
            ", code=" + code +
            ", name=" + name +
            ", value=" + value +
            ", describe=" + describe +
            ", insertTime=" + insertTime +
            ", updateTime=" + updateTime +
            ", isDeleted=" + isDeleted +
            "}";
    }
}