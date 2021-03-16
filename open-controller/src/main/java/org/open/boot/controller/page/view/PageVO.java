package org.open.boot.controller.page.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 页面信息表（页面定义）实体类
 *
 * @author barnak
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="PageVO对象", description="页面信息表（页面定义）")
public class PageVO implements Serializable {

private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "页面标题")
    private String pageTitle;

    @ApiModelProperty(value = "页面编码（区分页面）")
    private String pageCode;

    @ApiModelProperty(value = "是否展示  0 不展示 1 展示")
    private Boolean isShow;

    @ApiModelProperty(value = "审核状态 0 待审核 10 审核通过 20 审核不通过")
    private Integer authStatus;

    @ApiModelProperty(value = "是否为默认配置  0 否 1 是")
    private Boolean isDefault;

    @ApiModelProperty(value = "权重值")
    private Integer weightValue;

    @ApiModelProperty(value = "扩展字段（建议JSON扩展）")
    private String extend;

    @ApiModelProperty(value = "新增时间")
    private Date inputTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "创建人ID")
    private Long creatorId;

    @ApiModelProperty(value = "修改人ID")
    private Long reviserId;

    @ApiModelProperty(value = "是否删除  0 否 1 是")
    private Boolean isDel;


    public Long getId() {
        return id;
    }

    public PageVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public PageVO setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
        return this;
    }

    public String getPageCode() {
        return pageCode;
    }

    public PageVO setPageCode(String pageCode) {
        this.pageCode = pageCode;
        return this;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public PageVO setIsShow(Boolean isShow) {
        this.isShow = isShow;
        return this;
    }

    public Integer getAuthStatus() {
        return authStatus;
    }

    public PageVO setAuthStatus(Integer authStatus) {
        this.authStatus = authStatus;
        return this;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public PageVO setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
        return this;
    }

    public Integer getWeightValue() {
        return weightValue;
    }

    public PageVO setWeightValue(Integer weightValue) {
        this.weightValue = weightValue;
        return this;
    }

    public String getExtend() {
        return extend;
    }

    public PageVO setExtend(String extend) {
        this.extend = extend;
        return this;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public PageVO setInputTime(Date inputTime) {
        this.inputTime = inputTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public PageVO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public PageVO setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
        return this;
    }

    public Long getReviserId() {
        return reviserId;
    }

    public PageVO setReviserId(Long reviserId) {
        this.reviserId = reviserId;
        return this;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public PageVO setIsDel(Boolean isDel) {
        this.isDel = isDel;
        return this;
    }

    @Override
    public String toString() {
        return "PageVO{" +
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