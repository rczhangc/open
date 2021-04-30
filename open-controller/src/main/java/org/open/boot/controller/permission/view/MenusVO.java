package org.open.boot.controller.permission.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 菜单信息实体类
 *
 * @author barnak
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="MenusVO对象", description="菜单信息")
public class MenusVO implements Serializable {

private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜单ID")
    private Long id;

    @ApiModelProperty(value = "菜单编码")
    private String code;

    @ApiModelProperty(value = "菜单父节点ID")
    private Long parentId;

    @ApiModelProperty(value = "菜单层次：0顶级")
    private Integer levels;

    @ApiModelProperty(value = "菜单名称")
    private String named;

    @ApiModelProperty(value = "节点类型：1页面 2按钮")
    private Integer types;

    @ApiModelProperty(value = "图标地址")
    private String iconUrl;

    @ApiModelProperty(value = "页面地址，非页面可以为空")
    private String linkUrl;

    @ApiModelProperty(value = "树ID的路径")
    private String path;

    @ApiModelProperty(value = "新增时间")
    private Date insertTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "已删除：0否")
    private Long isDeleted;


    public Long getId() {
        return id;
    }

    public MenusVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public MenusVO setCode(String code) {
        this.code = code;
        return this;
    }

    public Long getParentId() {
        return parentId;
    }

    public MenusVO setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getLevels() {
        return levels;
    }

    public MenusVO setLevels(Integer levels) {
        this.levels = levels;
        return this;
    }

    public String getNamed() {
        return named;
    }

    public MenusVO setNamed(String named) {
        this.named = named;
        return this;
    }

    public Integer getTypes() {
        return types;
    }

    public MenusVO setTypes(Integer types) {
        this.types = types;
        return this;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public MenusVO setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public MenusVO setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
        return this;
    }

    public String getPath() {
        return path;
    }

    public MenusVO setPath(String path) {
        this.path = path;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public MenusVO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public MenusVO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public MenusVO setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "MenusVO{" +
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