package org.open.boot.dao.permission.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.open.boot.dao.permission.MenusManager;
import org.open.boot.dao.permission.RolesManager;
import org.open.boot.dao.permission.RolesMenusRelationManager;
import org.open.boot.dao.permission.business.RolesBO;
import org.open.boot.dao.permission.entity.RolesDO;
import org.open.boot.util.CheckUtil;
import org.open.boot.util.CodeUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 角色信息表服务实现类
 *
 * @author barnak
 */
@Repository
class RolesManagerImpl extends ServiceImpl<RolesMapper, RolesDO> implements RolesManager {

    private static final String ADMIN_CODE = "SUPER_ADMIN";

    @Resource
    private RolesMenusRelationManager rolesMenusRelationManager;
    @Resource
    private MenusManager menusManager;

    @Override
    public RolesDO getAdminRoles() {
        RolesDO query = new RolesDO();
        query.setCode(ADMIN_CODE);
        query.setIsDeleted(0L);
        RolesDO one = getOne(new QueryWrapper<>(query));
        if (Objects.isNull(one)) {
            RolesDO insert = new RolesDO();
            insert.setCode(ADMIN_CODE);
            insert.setDescription("超级管理员角色");
            insert.setNamed("超级管理员");
            save(insert);
            return insert;
        }
        return one;
    }

    @Override
    public RolesBO saveRoles(RolesBO roles) {
        checkRoles(roles);
        roles.setCode(CodeUtil.getRolesCode());
        List<String> menusCodeList =  menusManager.getMenusCodeList(roles.getMenusCodeList());
        rolesMenusRelationManager.saveRelation(menusCodeList, roles.getCode());
        return roles;
    }

    private void checkRoles(RolesDO roles) {
        CheckUtil.checkLength(roles.getNamed(), 32, "角色名称");
        if (Objects.nonNull(roles.getDescription())) {
            CheckUtil.checkLength(roles.getDescription(), 128, "角色描述");
        }
        RolesDO query = new RolesDO();
        query.setIsDeleted(0L);
        query.setNamed(roles.getNamed());
        int count = count(new QueryWrapper<>(query));
        CheckUtil.checkIf(count >= 1, "角色名称已存在");
    }
}
