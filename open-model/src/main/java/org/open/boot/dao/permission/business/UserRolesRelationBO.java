package org.open.boot.dao.permission.business;

import org.open.boot.dao.permission.entity.UserRolesRelationDO;

import java.io.Serializable;

/**
 * 用户角色关联表实体类BO
 *
 * @author barnak
 */
public class UserRolesRelationBO extends UserRolesRelationDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "UserRolesRelationBO{" +
                "id=" + super.getId() +
                ", userCode=" + super.getUserCode() +
                ", rolesCode=" + super.getRolesCode() +
                ", insertTime=" + super.getInsertTime() +
                ", isDeleted=" + super.getIsDeleted() +
                "}";
    }
}