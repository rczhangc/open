package org.open.boot.dao.permission.business;

import org.open.boot.dao.permission.entity.MenusDO;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单信息实体类BO
 *
 * @author barnak
 */
public class MenusBO extends MenusDO implements Serializable {
    private static final long serialVersionUID = 1L;

    List<MenusBO> childMenusList;

    public List<MenusBO> getChildMenusList() {
        return childMenusList;
    }

    public void setChildMenusList(List<MenusBO> childMenusList) {
        this.childMenusList = childMenusList;
    }

    @Override
    public String toString() {
        return "MenusBO{" +
                "id=" + super.getId() +
                ", code=" + super.getCode() +
                ", parentId=" + super.getParentId() +
                ", levels=" + super.getLevels() +
                ", named=" + super.getNamed() +
                ", types=" + super.getTypes() +
                ", iconUrl=" + super.getIconUrl() +
                ", linkUrl=" + super.getLinkUrl() +
                ", path=" + super.getPath() +
                ", insertTime=" + super.getInsertTime() +
                ", updateTime=" + super.getUpdateTime() +
                ", isDeleted=" + super.getIsDeleted() +
                "}";
    }
}