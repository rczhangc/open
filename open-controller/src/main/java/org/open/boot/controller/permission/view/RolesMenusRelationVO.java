package org.open.boot.controller.permission.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 角色菜单关联表实体类
 *
 * @author barnak
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="RolesMenusRelationVO对象", description="角色菜单关联表")
public class RolesMenusRelationVO implements Serializable {

private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色菜单关联ID")
    private Long id;

    @ApiModelProperty(value = "角色编码")
    private String rolesCode;

    @ApiModelProperty(value = "菜单编码")
    private String menusCode;

    @ApiModelProperty(value = "新增时间")
    private Date insertTime;

    @ApiModelProperty(value = "已删除：0否")
    private Long isDeleted;


    public Long getId() {
        return id;
    }

    public RolesMenusRelationVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRolesCode() {
        return rolesCode;
    }

    public RolesMenusRelationVO setRolesCode(String rolesCode) {
        this.rolesCode = rolesCode;
        return this;
    }

    public String getMenusCode() {
        return menusCode;
    }

    public RolesMenusRelationVO setMenusCode(String menusCode) {
        this.menusCode = menusCode;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public RolesMenusRelationVO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public RolesMenusRelationVO setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "RolesMenusRelationVO{" +
            "id=" + id +
            ", rolesCode=" + rolesCode +
            ", menusCode=" + menusCode +
            ", insertTime=" + insertTime +
            ", isDeleted=" + isDeleted +
            "}";
    }
}