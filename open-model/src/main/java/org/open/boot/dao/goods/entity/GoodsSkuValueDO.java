package org.open.boot.dao.goods.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;


/**
 * 商品规格值信息表实体类
 *
 * @author barnak
 */
@TableName("goods_sku_value")
public class GoodsSkuValueDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 规格ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品编码
     */
    @TableField("goods_code")
    private String goodsCode;

    /**
     * 规格编码
     */
    @TableField("goods_sku_code")
    private String goodsSkuCode;

    /**
     * 规格值编码
     */
    @TableField("code")
    private String code;

    /**
     * 规格值
     */
    @TableField("value")
    private String value;

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

    public GoodsSkuValueDO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public GoodsSkuValueDO setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
        return this;
    }

    public String getGoodsSkuCode() {
        return goodsSkuCode;
    }

    public GoodsSkuValueDO setGoodsSkuCode(String goodsSkuCode) {
        this.goodsSkuCode = goodsSkuCode;
        return this;
    }

    public String getCode() {
        return code;
    }

    public GoodsSkuValueDO setCode(String code) {
        this.code = code;
        return this;
    }

    public String getValue() {
        return value;
    }

    public GoodsSkuValueDO setValue(String value) {
        this.value = value;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public GoodsSkuValueDO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public GoodsSkuValueDO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public GoodsSkuValueDO setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "GoodsSkuValueDO{" +
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