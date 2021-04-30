package org.open.boot.dao.user.business;

import org.open.boot.dao.user.entity.UsersDO;

import java.io.Serializable;

/**
 * 用户信息表实体类BO
 *
 * @author barnak
 */
public class UsersBO extends UsersDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "UsersBO{" +
                "id=" + super.getId() +
                ", loginNamed=" + super.getLoginNamed() +
                ", loginPassword=" + super.getLoginPassword() +
                ", nickNamed=" + super.getNickNamed() +
                ", profileUrl=" + super.getProfileUrl() +
                ", insertTime=" + super.getInsertTime() +
                ", updateTime=" + super.getUpdateTime() +
                ", isDeleted=" + super.getIsDeleted() +
                "}";
    }
}