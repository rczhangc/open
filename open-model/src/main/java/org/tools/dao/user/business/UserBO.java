package org.tools.dao.user.business;

import org.tools.dao.user.entity.UserDO;

import java.io.Serializable;

/**
 * 实体类BO
 *
 * @author barnak
 */
public class UserBO extends UserDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "UserBO{" +
                "id=" + super.getId() +
                ", name=" + super.getName() +
                ", age=" + super.getAge() +
                ", email=" + super.getEmail() +
                "}";
    }
}