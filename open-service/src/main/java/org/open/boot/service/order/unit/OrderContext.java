package org.open.boot.service.order.unit;

import org.open.boot.dao.user.entity.UserDO;
import org.open.boot.unit.ActContext;

/**
 * 订单上下文操作参数
 *
 * @author barnak
 */
public class OrderContext extends ActContext {

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户信息
     */
    private UserDO user;


    private UserDO updateUser;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserDO getUser() {
        return user;
    }

    public void setUser(UserDO user) {
        this.user = user;
    }

    public UserDO getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(UserDO updateUser) {
        this.updateUser = updateUser;
    }
}
