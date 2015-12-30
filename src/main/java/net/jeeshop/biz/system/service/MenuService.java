package net.jeeshop.biz.system.service;

import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.system.bean.MenuItem;
import net.jeeshop.biz.system.bean.MenuType;
import net.jeeshop.biz.system.client.SysMenuMapperExt;
import net.jeeshop.biz.system.model.SysMenu;
import net.jeeshop.biz.system.model.SysMenuExample;
import net.jeeshop.biz.system.model.SysUser;
import net.jeeshop.core.util.EnumUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    //加载根节点
    public List<MenuItem> loadMenus(SysUser u, long pid, String url) {
        SysMenuExample menuExample = new SysMenuExample();
        SysMenuExample.Criteria criteria = menuExample.createCriteria();
        if (u != null && u.getRid() != null) {
            criteria.andPidEqualTo(u.getRid());
        }
        //父级菜单
        criteria.andPidEqualTo(pid);
        List<SysMenu> menus = sysMenuMapperExt.selectByExample(menuExample);

        // 创建菜单集合
        List<MenuItem> menuItems = new ArrayList<MenuItem>();
        // 循环添加菜单到菜单集合
		for (Iterator<SysMenu> it = menus.iterator(); it.hasNext();) {
			SysMenu sysMenu = it.next();
            MenuItem menuItem = new MenuItem(sysMenu.getName(), null);
            menuItem.setId(sysMenu.getId());
            menuItem.setPid(sysMenu.getPid());
            menuItem.setMenuType(MenuType.valueOf(sysMenu.getType()));
            if (url != null) {
                menuItem.setUrl(url);
            } else {
                menuItem.setUrl(sysMenu.getUrl());
            }
            menuItems.add(menuItem);
        }
        // 加载子菜单，注意 只加载type为模块级或页面级的
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem menuItem = menuItems.get(i);
            if (StringUtils.isEmpty(menuItem.getType().toString()) || menuItem.getType().equals(MenuType.button)) {
                continue;
            }
            SysMenu sysMenu = new SysMenu();
            sysMenu.setPid(menuItem.getId());
            loadChildrenByPid(menuItem, sysMenu, url, u);
        }

        return menuItems;
    }


    /**
     * 根据父ID加载子节点
     * @param item
     * @param menu
     * @param url
     * @param user
     */
    private void loadChildrenByPid(MenuItem item, SysMenu menu, String url, SysUser user) {
        Map<String, String> param = new HashMap<String, String>();
        if (user != null && user.getRid() != null) {
            param.put("rid", String.valueOf(user.getRid()));
        }
        param.put("pid", String.valueOf(menu.getPid()));
        // 加载菜单节点
        List<SysMenu> data = sysMenuMapperExt.selectByCondition(param);
        if (data == null || data.size() == 0) {
            return;
        }
        if (item.getChildren() == null) {
            item.setChildren(new ArrayList<MenuItem>());
        }
        // 创建菜单节点
        for (int i = 0; i < data.size(); i++) {
            SysMenu entryMenu = data.get(i);
            MenuItem addItem = new MenuItem(entryMenu.getName(), null);
            addItem.setId(entryMenu.getId());
            addItem.setPid(entryMenu.getPid());
            addItem.setMenuType(MenuType.valueOf(entryMenu.getType()));
            if (url != null) {
                addItem.setUrl(url);
            } else {
                addItem.setUrl(entryMenu.getUrl());
            }
            item.getChildren().add(addItem);
        }
        // 根据菜单节点进行递归加载
        for (int i = 0; i < item.getChildren().size(); i++) {
            SysMenu itemMenu = new SysMenu();
            itemMenu.setPid(item.getChildren().get(i).getId());
            loadChildrenByPid(item.getChildren().get(i), itemMenu, url, user);
        }
    }
}
