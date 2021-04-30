package org.open.boot.dao.permission.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;


/**
 * 角色菜单关联表实体类
 *
 * @author barnak
 */
@TableName("roles_menus_relation")
public class RolesMenusRelationDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色菜单关联ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色编码
     */
    @TableField("roles_code")
    private String rolesCode;

    /**
     * 菜单编码
     */
    @TableField("menus_code")
    private String menusCode;

    /**
     * 新增时间
     */
    @TableField("insert_time")
    private Date insertTime;

    /**
     * 已删除：0否
     */
    @TableField("is_deleted")
    private Long isDeleted;


    public Long getId() {
        return id;
    }

    public RolesMenusRelationDO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRolesCode() {
        return rolesCode;
    }

    public RolesMenusRelationDO setRolesCode(String rolesCode) {
        this.rolesCode = rolesCode;
        return this;
    }

    public String getMenusCode() {
        return menusCode;
    }

    public RolesMenusRelationDO setMenusCode(String menusCode) {
        this.menusCode = menusCode;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public RolesMenusRelationDO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public RolesMenusRelationDO setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "RolesMenusRelationDO{" +
            "id=" + id +
            ", rolesCode=" + rolesCode +
            ", menusCode=" + menusCode +
            ", insertTime=" + insertTime +
            ", isDeleted=" + isDeleted +
            "}";
    }
}