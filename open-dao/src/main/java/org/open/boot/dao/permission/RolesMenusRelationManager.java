package org.open.boot.dao.permission;

import org.open.boot.dao.permission.business.MenusBO;
import org.open.boot.dao.permission.entity.RolesMenusRelationDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 角色菜单关联表服务类
 *
 * @author barnak
 */
public interface RolesMenusRelationManager extends IService<RolesMenusRelationDO> {

    /**
     * 保存超级管理员资源
     *
     * @param menusCode
     * @return
     */
    RolesMenusRelationDO saveAdminRelation(String menusCode);

    /**
     * 删除超级管理员资源
     *
     * @param menusCode
     * @return
     */
    void removeRelation(String menusCode);

    /**
     * 保存
     *
     * @param menusCodeList
     */
    void saveRelation(List<String> menusCodeList, String rolesCode);
}
