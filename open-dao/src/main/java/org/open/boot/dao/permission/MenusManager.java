package org.open.boot.dao.permission;

import org.open.boot.dao.permission.business.MenusBO;
import org.open.boot.dao.permission.entity.MenusDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 菜单信息服务类
 *
 * @author barnak
 */
public interface MenusManager extends IService<MenusDO> {

    /**
     * 保存菜单信息
     *
     * @param menus {@link MenusBO}
     * @return {@link MenusBO}
     */
    MenusBO saveMenus(MenusBO menus);

    /**
     * 校验获取菜单Code
     *
     * @param menusCodeList
     * @return
     */
    List<String> getMenusCodeList(List<MenusBO> menusCodeList);

    /**
     * 获取全部菜单列表
     *
     * @return
     */
    List<MenusBO> getAllMenusList();
}
