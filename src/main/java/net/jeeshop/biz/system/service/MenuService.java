package net.jeeshop.biz.system.service;

import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.system.bean.MenuItem;
import net.jeeshop.biz.system.bean.MenuType;
import net.jeeshop.biz.system.client.SysMenuMapperExt;
import net.jeeshop.core.util.EnumUtils;
import net.jeeshop.model.system.SysMenu;
import net.jeeshop.model.system.SysMenuExample;
import net.jeeshop.model.system.SysUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author dinguangx@163.com
 * @date 2015-12-21 23:13
 */
@Service
public class MenuService extends BaseService<SysMenu, SysMenuExample> {
    @Autowired
    private SysMenuMapperExt sysMenuMapperExt;

    @Override
    protected BaseMapper<SysMenu, SysMenuExample> getMapper() {
        return sysMenuMapperExt;
    }

    /**
     * 加载用户可用菜单项
     *
     * @param u
     * @return
     */
    public Collection<MenuItem> loadMenus(SysUser u) {
//		param.put("pid", pid);//菜单父ID
        List<SysMenu> menus = sysMenuMapperExt.selectByRoleId(u.getRid());
        //创建菜单集合
        LinkedHashMap<Long, MenuItem> root = new LinkedHashMap<Long, MenuItem>();
        //循环添加菜单到菜单集合
        for (SysMenu menu : menus) {
            MenuItem item = new MenuItem(menu.getName(), null);
            item.setId(menu.getId());
            item.setPid(menu.getPid());
            item.setMenuType(EnumUtils.parseEnum(MenuType.class, menu.getName()));
            item.setUrl(StringUtils.trimToEmpty(menu.getUrl()));
            if (item.isRootMenu()) {
                root.put(item.getId(), item);
            }
        }
        for (SysMenu menu : menus) {
            MenuItem item = new MenuItem(menu.getName(), null);
            item.setId(menu.getId());
            item.setPid(menu.getPid());
            item.setMenuType(EnumUtils.parseEnum(MenuType.class, menu.getName()));
            item.setUrl(StringUtils.trimToEmpty(menu.getUrl()));
            if (!item.isRootMenu() && !item.isButton()) {
                MenuItem parentItem = root.get(item.getPid());
                if (parentItem != null) {
                    parentItem.addClild(item);
                } else {
                    logger.warn("菜单项{}({})没有对应的父级菜单", item.getName(), item.getId());
                }
            }
        }
        return root.values();
    }
}
