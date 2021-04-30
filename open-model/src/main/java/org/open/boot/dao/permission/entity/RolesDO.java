package org.open.boot.dao.permission.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;


/**
 * 角色信息表实体类
 *
 * @author barnak
 */
@TableName("roles")
public class RolesDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色编码
     */
    @TableField("code")
    private String code;

    /**
     * 角色名称
     */
    @TableField("named")
    private String named;

    /**
     * 角色描述
     */
    @TableField("description")
    private String description;

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

    public RolesDO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public RolesDO setCode(String code) {
        this.code = code;
        return this;
    }

    public String getNamed() {
        return named;
    }

    public RolesDO setNamed(String named) {
        this.named = named;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RolesDO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public RolesDO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public RolesDO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public RolesDO setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "RolesDO{" +
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