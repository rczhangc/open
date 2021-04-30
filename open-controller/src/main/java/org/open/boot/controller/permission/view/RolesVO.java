package org.open.boot.controller.permission.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 角色信息表实体类
 *
 * @author barnak
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="RolesVO对象", description="角色信息表")
public class RolesVO implements Serializable {

private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色ID")
    private Long id;

    @ApiModelProperty(value = "角色编码")
    private String code;

    @ApiModelProperty(value = "角色名称")
    private String named;

    @ApiModelProperty(value = "角色描述")
    private String description;

    @ApiModelProperty(value = "新增时间")
    private Date insertTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "已删除：0否")
    private Long isDeleted;


    public Long getId() {
        return id;
    }

    public RolesVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public RolesVO setCode(String code) {
        this.code = code;
        return this;
    }

    public String getNamed() {
        return named;
    }

    public RolesVO setNamed(String named) {
        this.named = named;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RolesVO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public RolesVO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public RolesVO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public RolesVO setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "RolesVO{" +
            "id=" + id +
            ", code=" + code +
            ", named=" + named +
            ", description=" + description +
            ", insertTime=" + insertTime +
            ", updateTime=" + updateTime +
            ", isDeleted=" + isDeleted +
            "}";
    }
}