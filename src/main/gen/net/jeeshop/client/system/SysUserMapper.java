package net.jeeshop.client.system;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.model.system.SysUser;
import net.jeeshop.model.system.SysUserExample;

public interface SysUserMapper extends BaseMapper<SysUser, SysUserExample> {
    int countByExample(SysUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}