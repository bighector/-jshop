package net.jeeshop.biz.system.client;

import net.jeeshop.client.system.SysMenuMapper;
import net.jeeshop.model.system.SysMenu;

import java.util.List;

/**
 * @author dinguangx@163.com
 * @date 2015-12-22 22:57
 */
public interface SysMenuMapperExt extends SysMenuMapper{
    public List<SysMenu> selectByRoleId(long rid);
}
