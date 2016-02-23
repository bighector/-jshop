package net.jeeshop.biz.system.client;


import net.jeeshop.biz.system.model.SysMenu;

import java.util.List;
import java.util.Map;

/**
 * @author dinguangx@163.com
 * @date 2015-12-22 22:57
 */
public interface SysMenuMapperExt extends SysMenuMapper
{
    public List<SysMenu> selectByRoleId(long rid);

    /**
     * 根据条件查询菜单资源
     * @param params
     * @return
     */
    public List<SysMenu> selectByCondition(Map<String , String> params);
}
