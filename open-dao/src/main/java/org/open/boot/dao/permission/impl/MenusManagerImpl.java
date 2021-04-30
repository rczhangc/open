package org.open.boot.dao.permission.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.open.boot.dao.permission.MenusManager;
import org.open.boot.dao.permission.RolesMenusRelationManager;
import org.open.boot.dao.permission.business.MenusBO;
import org.open.boot.dao.permission.entity.MenusDO;
import org.open.boot.dao.permission.entity.RolesMenusRelationDO;
import org.open.boot.util.CheckUtil;
import org.open.boot.util.CodeUtil;
import org.open.boot.util.CopyUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 菜单信息服务实现类
 *
 * @author barnak
 */
@Repository
class MenusManagerImpl extends ServiceImpl<MenusMapper, MenusDO> implements MenusManager {

    @Resource
    private RolesMenusRelationManager rolesMenusRelationManager;

    @Override
    public MenusBO saveMenus(MenusBO menus) {
        checkMenus(menus);
        menus.setId(null);
        menus.setCode(CodeUtil.getMenusCode());
        this.save(menus);
        // 每个资源都添加给超级管理员
        rolesMenusRelationManager.saveAdminRelation(menus.getCode());
        return menus;
    }

    @Override
    public List<String> getMenusCodeList(List<MenusBO> menusCodeList) {
        if (CollectionUtils.isEmpty(menusCodeList)) {
            return Collections.emptyList();
        }
        Set<String> set = new HashSet<>();
        for (MenusBO menus : menusCodeList) {
            setIdList(set, menus);
        }
        return new ArrayList<>(set);
    }

    private void setIdList(Set<String> set, MenusBO parent) {
        set.add(parent.getCode());
        if (CollectionUtils.isEmpty(parent.getChildMenusList())) {
            return;
        }
        for (MenusBO menus : parent.getChildMenusList()) {
            setIdList(set, menus);
        }
    }

    @Override
    public List<MenusBO> getAllMenusList() {
        List<MenusDO> list = list();
        if (Objects.isNull(list)) {
            return Collections.emptyList();
        }
        List<MenusBO> copyList = CopyUtil.copy(list, MenusBO.class);
        return copyList.stream().filter(m -> m.getParentId().equals(0L))
                .peek(m -> m.setChildMenusList(getChildList(m, copyList)))
                .collect(Collectors.toList());
    }

    private List<MenusBO> getChildList(MenusBO parent, List<MenusBO> allList) {
        return allList.stream().filter(m -> m.getParentId().equals(parent.getId()))
                .peek(m -> m.setChildMenusList(getChildList(m, allList)))
                .collect(Collectors.toList());
    }

    /**
     * 校验菜单信息
     *
     * @param menus {@link MenusBO}
     */
    private void checkMenus(MenusDO menus) {
        CheckUtil.checkLength(menus.getNamed(), 32, "菜单名称");
        if (Objects.nonNull(menus.getParentId()) && !Objects.equals(menus.getParentId(), 0L)) {
            // 上级资源ID存在且不为0
            MenusDO parent = getById(menus.getParentId());
            if (null == parent) {
                throw new RuntimeException("上级资源不存在");
            }
            menus.setLevels(parent.getLevels() + 1);
            menus.setPath(menus.getPath()+"_"+parent.getId());
        }
        if (Objects.nonNull(menus.getIconUrl())) {
            CheckUtil.checkLength(menus.getIconUrl(), 128, "菜单图标");
        }
        if (Objects.equals(menus.getTypes(), 1) ) {
            // 1为页面菜单，校验链接
            CheckUtil.checkLength(menus.getLinkUrl(), 128, "菜单链接");
        }
    }
}
