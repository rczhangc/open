package org.open.boot.dao.permission.business;

import org.open.boot.dao.permission.entity.RolesMenusRelationDO;

import java.io.Serializable;

/**
 * 角色菜单关联表实体类BO
 *
 * @author barnak
 */
public class RolesMenusRelationBO extends RolesMenusRelationDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "RolesMenusRelationBO{" +
                "id=" + super.getId() +
                ", rolesCode=" + super.getRolesCode() +
                ", menusCode=" + super.getMenusCode() +
                ", insertTime=" + super.getInsertTime() +
                ", isDeleted=" + super.getIsDeleted() +
                "}";
    }
}