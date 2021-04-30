package org.open.boot.dao.permission.business;

import org.open.boot.dao.permission.entity.RolesDO;

import java.io.Serializable;
import java.util.List;

/**
 * 角色信息表实体类BO
 *
 * @author barnak
 */
public class RolesBO extends RolesDO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单列表
     */
    List<MenusBO> menusCodeList;

    public List<MenusBO> getMenusCodeList() {
        return menusCodeList;
    }

    public void setMenusCodeList(List<MenusBO> menusCodeList) {
        this.menusCodeList = menusCodeList;
    }

    @Override
    public String toString() {
        return "RolesBO{" +
                "id=" + super.getId() +
                ", code=" + super.getCode() +
                ", named=" + super.getNamed() +
                ", description=" + super.getDescription() +
                ", insertTime=" + super.getInsertTime() +
                ", updateTime=" + super.getUpdateTime() +
                ", isDeleted=" + super.getIsDeleted() +
                "}";
    }
}