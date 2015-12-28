package net.jeeshop.biz.system.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.system.model.SysMenu;
import net.jeeshop.biz.system.model.SysMenuExample;

public interface SysMenuMapper extends BaseMapper<SysMenu, SysMenuExample> {
    int countByExample(SysMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuExample example);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}