package net.jeeshop.client.system;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.model.system.SysPrivilege;
import net.jeeshop.model.system.SysPrivilegeExample;

public interface SysPrivilegeMapper extends BaseMapper<SysPrivilege, SysPrivilegeExample> {
    int countByExample(SysPrivilegeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysPrivilege record);

    int insertSelective(SysPrivilege record);

    List<SysPrivilege> selectByExample(SysPrivilegeExample example);

    SysPrivilege selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysPrivilege record);

    int updateByPrimaryKey(SysPrivilege record);
}