package org.open.boot.controller.system.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统全局配置实体类
 *
 * @author barnak
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="SysGlobalConfigVO对象", description="系统全局配置")
public class SysGlobalConfigVO implements Serializable {

private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "配置CODE值")
    private String code;

    @ApiModelProperty(value = "分组标识")
    private String grouping;

    @ApiModelProperty(value = "配置值")
    private String jsonValue;

    @ApiModelProperty(value = "新增时间")
    private Date insertTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "已删除：0否，1是")
    private Boolean isDeleted;


    public String getCode() {
        return code;
    }

    public SysGlobalConfigVO setCode(String code) {
        this.code = code;
        return this;
    }

    public String getGrouping() {
        return grouping;
    }

    public SysGlobalConfigVO setGrouping(String grouping) {
        this.grouping = grouping;
        return this;
    }

    public String getJsonValue() {
        return jsonValue;
    }

    public SysGlobalConfigVO setJsonValue(String jsonValue) {
        this.jsonValue = jsonValue;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public SysGlobalConfigVO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public SysGlobalConfigVO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public SysGlobalConfigVO setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "SysGlobalConfigVO{" +
            "code=" + code +
            ", grouping=" + grouping +
            ", jsonValue=" + jsonValue +
            ", insertTime=" + insertTime +
            ", updateTime=" + updateTime +
            ", isDeleted=" + isDeleted +
            "}";
    }
}