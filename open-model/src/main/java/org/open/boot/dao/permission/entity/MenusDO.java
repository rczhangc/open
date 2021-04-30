package org.open.boot.dao.permission.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;


/**
 * 菜单信息实体类
 *
 * @author barnak
 */
@TableName("menus")
public class MenusDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 菜单编码
     */
    @TableField("code")
    private String code;

    /**
     * 菜单父节点ID
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 菜单层次：0顶级
     */
    @TableField("levels")
    private Integer levels;

    /**
     * 菜单名称
     */
    @TableField("named")
    private String named;

    /**
     * 节点类型：1页面 2按钮
     */
    @TableField("types")
    private Integer types;

    /**
     * 图标地址
     */
    @TableField("icon_url")
    private String iconUrl;

    /**
     * 页面地址，非页面可以为空
     */
    @TableField("link_url")
    private String linkUrl;

    /**
     * 树ID的路径
     */
    @TableField("path")
    private String path;

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

    public MenusDO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public MenusDO setCode(String code) {
        this.code = code;
        return this;
    }

    public Long getParentId() {
        return parentId;
    }

    public MenusDO setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getLevels() {
        return levels;
    }

    public MenusDO setLevels(Integer levels) {
        this.levels = levels;
        return this;
    }

    public String getNamed() {
        return named;
    }

    public MenusDO setNamed(String named) {
        this.named = named;
        return this;
    }

    public Integer getTypes() {
        return types;
    }

    public MenusDO setTypes(Integer types) {
        this.types = types;
        return this;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public MenusDO setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public MenusDO setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
        return this;
    }

    public String getPath() {
        return path;
    }

    public MenusDO setPath(String path) {
        this.path = path;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public MenusDO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public MenusDO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public MenusDO setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "MenusDO{" +
            "id=" + id +
            ", code=" + code +
            ", parentId=" + parentId +
            ", levels=" + levels +
            ", named=" + named +
            ", types=" + types +
            ", iconUrl=" + iconUrl +
            ", linkUrl=" + linkUrl +
            ", path=" + path +
            ", insertTime=" + insertTime +
            ", updateTime=" + updateTime +
            ", isDeleted=" + isDeleted +
            "}";
    }
}