package org.open.boot.dao.goods.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import org.open.boot.dao.goods.business.GoodsSkuValueBO;


/**
 * 商品规格信息表实体类
 *
 * @author barnak
 */
@TableName("goods_sku")
public class GoodsSkuDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 规格ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 规格编码
     */
    @TableField("code")
    private String code;

    /**
     * 规格名称
     */
    @TableField("name")
    private String name;

    /**
     * 规格值
     */
    @TableField("valueList")
    private List<GoodsSkuValueBO> valueList;

    /**
     * 规格描述
     */
    @TableField("describe")
    private String describe;

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

    public GoodsSkuDO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public GoodsSkuDO setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodsSkuDO setName(String name) {
        this.name = name;
        return this;
    }

    public List<GoodsSkuValueBO> getValueList() {
        return valueList;
    }

    public GoodsSkuDO setValueList(List<GoodsSkuValueBO> valueList) {
        this.valueList = valueList;
        return this;
    }

    public String getDescribe() {
        return describe;
    }

    public GoodsSkuDO setDescribe(String describe) {
        this.describe = describe;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public GoodsSkuDO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public GoodsSkuDO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public GoodsSkuDO setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "GoodsSkuDO{" +
            "id=" + id +
            ", code=" + code +
            ", name=" + name +
            ", value=" + valueList +
            ", describe=" + describe +
            ", insertTime=" + insertTime +
            ", updateTime=" + updateTime +
            ", isDeleted=" + isDeleted +
            "}";
    }
}