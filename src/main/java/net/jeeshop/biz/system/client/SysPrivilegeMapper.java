package net.jeeshop.biz.system.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.system.model.SysPrivilege;
import net.jeeshop.biz.system.model.SysPrivilegeExample;

public interface SysPrivilegeMapper extends BaseMapper<SysPrivilege, SysPrivilegeExample> {
    int countByExample(SysPrivilegeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysPrivilege record);

    int insertSelective(SysPrivilege record);

    void insertPrivileges(List<SysPrivilege> privileges);

    List<SysPrivilege> selectByExample(SysPrivilegeExample example);

    SysPrivilege selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysPrivilege record);

    int updateByPrimaryKey(SysPrivilege record);

    /***
     * 删除指定角色的权限
     * @param id
     */
    void deleteByRid(Long id);
}