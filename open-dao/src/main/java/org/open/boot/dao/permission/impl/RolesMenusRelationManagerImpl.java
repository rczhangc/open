package org.open.boot.dao.permission.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.open.boot.dao.permission.RolesManager;
import org.open.boot.dao.permission.RolesMenusRelationManager;
import org.open.boot.dao.permission.business.MenusBO;
import org.open.boot.dao.permission.entity.RolesDO;
import org.open.boot.dao.permission.entity.RolesMenusRelationDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 角色菜单关联表服务实现类
 *
 * @author barnak
 */
@Repository
class RolesMenusRelationManagerImpl extends ServiceImpl<RolesMenusRelationMapper, RolesMenusRelationDO> implements RolesMenusRelationManager {

    @Resource
    private RolesManager rolesManager;

    @Override
    public RolesMenusRelationDO saveAdminRelation(String menusCode) {
        RolesDO adminRoles = rolesManager.getAdminRoles();
        RolesMenusRelationDO relation = new RolesMenusRelationDO();
        relation.setRolesCode(adminRoles.getCode());
        relation.setMenusCode(menusCode);
        save(relation);
        return relation;
    }

    @Override
    public void removeRelation(String menusCode) {
        RolesMenusRelationDO query = new RolesMenusRelationDO();
        query.setIsDeleted(0L);
        query.setMenusCode(menusCode);
        RolesMenusRelationDO update = new RolesMenusRelationDO();
        update.setIsDeleted(System.currentTimeMillis());
        update(update,new UpdateWrapper<>(query));
    }

    @Override
    public void saveRelation(List<String> menusCodeList, String rolesCode) {
        if (CollectionUtils.isEmpty(menusCodeList)) {
            return;
        }
        List<RolesMenusRelationDO> relationList = new ArrayList<>();
        for (String menusCode : menusCodeList) {
            RolesMenusRelationDO relation = new RolesMenusRelationDO();
            relation.setRolesCode(rolesCode);
            relation.setMenusCode(menusCode);
            relationList.add(relation);
        }
        saveBatch(relationList);
    }


}
