package org.open.boot.dao.permission;

import org.open.boot.dao.permission.business.RolesBO;
import org.open.boot.dao.permission.entity.RolesDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 角色信息表服务类
 *
 * @author barnak
 */
public interface RolesManager extends IService<RolesDO> {

    /**
     * 获取管理员角色
     *
     * @return {@link RolesDO}
     */
    RolesDO getAdminRoles();

    /**
     * 保存角色信息
     *
     * @param roles {@link RolesBO}
     * @return {@link RolesBO}
     */
    RolesBO saveRoles(RolesBO roles);
}
