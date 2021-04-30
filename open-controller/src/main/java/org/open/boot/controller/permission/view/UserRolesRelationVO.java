package org.open.boot.controller.permission.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 用户角色关联表实体类
 *
 * @author barnak
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="UserRolesRelationVO对象", description="用户角色关联表")
public class UserRolesRelationVO implements Serializable {

private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户角色关联ID")
    private Long id;

    @ApiModelProperty(value = "用户编码")
    private String userCode;

    @ApiModelProperty(value = "角色编码")
    private String rolesCode;

    @ApiModelProperty(value = "新增时间")
    private Date insertTime;

    @ApiModelProperty(value = "已删除：0否")
    private Long isDeleted;


    public Long getId() {
        return id;
    }

    public UserRolesRelationVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserCode() {
        return userCode;
    }

    public UserRolesRelationVO setUserCode(String userCode) {
        this.userCode = userCode;
        return this;
    }

    public String getRolesCode() {
        return rolesCode;
    }

    public UserRolesRelationVO setRolesCode(String rolesCode) {
        this.rolesCode = rolesCode;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public UserRolesRelationVO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public UserRolesRelationVO setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "UserRolesRelationVO{" +
            "id=" + id +
            ", userCode=" + userCode +
            ", rolesCode=" + rolesCode +
            ", insertTime=" + insertTime +
            ", isDeleted=" + isDeleted +
            "}";
    }
}