package org.open.boot.dao.page.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;


/**
 * 页面信息表（页面定义）实体类
 *
 * @author barnak
 */
@TableName("page")
public class PageDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 页面标题
     */
    @TableField("page_title")
    private String pageTitle;

    /**
     * 页面编码（区分页面）
     */
    @TableField("page_code")
    private String pageCode;

    /**
     * 是否展示  0 不展示 1 展示
     */
    @TableField("is_show")
    private Boolean isShow;

    /**
     * 审核状态 0 待审核 10 审核通过 20 审核不通过
     */
    @TableField("auth_status")
    private Integer authStatus;

    /**
     * 是否为默认配置  0 否 1 是
     */
    @TableField("is_default")
    private Boolean isDefault;

    /**
     * 权重值
     */
    @TableField("weight_value")
    private Integer weightValue;

    /**
     * 扩展字段（建议JSON扩展）
     */
    @TableField("extend")
    private String extend;

    /**
     * 新增时间
     */
    @TableField("input_time")
    private Date inputTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 创建人ID
     */
    @TableField("creator_id")
    private Long creatorId;

    /**
     * 修改人ID
     */
    @TableField("reviser_id")
    private Long reviserId;

    /**
     * 是否删除  0 否 1 是
     */
    @TableField("is_del")
    private Boolean isDel;


    public Long getId() {
        return id;
    }

    public PageDO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public PageDO setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
        return this;
    }

    public String getPageCode() {
        return pageCode;
    }

    public PageDO setPageCode(String pageCode) {
        this.pageCode = pageCode;
        return this;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public PageDO setIsShow(Boolean isShow) {
        this.isShow = isShow;
        return this;
    }

    public Integer getAuthStatus() {
        return authStatus;
    }

    public PageDO setAuthStatus(Integer authStatus) {
        this.authStatus = authStatus;
        return this;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public PageDO setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
        return this;
    }

    public Integer getWeightValue() {
        return weightValue;
    }

    public PageDO setWeightValue(Integer weightValue) {
        this.weightValue = weightValue;
        return this;
    }

    public String getExtend() {
        return extend;
    }

    public PageDO setExtend(String extend) {
        this.extend = extend;
        return this;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public PageDO setInputTime(Date inputTime) {
        this.inputTime = inputTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public PageDO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public PageDO setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
        return this;
    }

    public Long getReviserId() {
        return reviserId;
    }

    public PageDO setReviserId(Long reviserId) {
        this.reviserId = reviserId;
        return this;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public PageDO setIsDel(Boolean isDel) {
        this.isDel = isDel;
        return this;
    }

    @Override
    public String toString() {
        return "PageDO{" +
            "id=" + id +
            ", pageTitle=" + pageTitle +
            ", pageCode=" + pageCode +
            ", isShow=" + isShow +
            ", authStatus=" + authStatus +
            ", isDefault=" + isDefault +
            ", weightValue=" + weightValue +
            ", extend=" + extend +
            ", inputTime=" + inputTime +
            ", updateTime=" + updateTime +
            ", creatorId=" + creatorId +
            ", reviserId=" + reviserId +
            ", isDel=" + isDel +
            "}";
    }
}