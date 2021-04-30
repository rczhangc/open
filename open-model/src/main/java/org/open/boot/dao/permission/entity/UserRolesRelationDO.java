package org.open.boot.dao.permission.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;


/**
 * 用户角色关联表实体类
 *
 * @author barnak
 */
@TableName("user_roles_relation")
public class UserRolesRelationDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户角色关联ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户编码
     */
    @TableField("user_code")
    private String userCode;

    /**
     * 角色编码
     */
    @TableField("roles_code")
    private String rolesCode;

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

    public UserRolesRelationDO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserCode() {
        return userCode;
    }

    public UserRolesRelationDO setUserCode(String userCode) {
        this.userCode = userCode;
        return this;
    }

    public String getRolesCode() {
        return rolesCode;
    }

    public UserRolesRelationDO setRolesCode(String rolesCode) {
        this.rolesCode = rolesCode;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public UserRolesRelationDO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public UserRolesRelationDO setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "UserRolesRelationDO{" +
            "id=" + id +
            ", userCode=" + userCode +
            ", rolesCode=" + rolesCode +
            ", insertTime=" + insertTime +
            ", isDeleted=" + isDeleted +
            "}";
    }
}