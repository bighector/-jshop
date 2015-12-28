package net.jeeshop.biz.system.service;

import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.system.client.SysRoleMapper;
import net.jeeshop.biz.system.model.SysRole;
import net.jeeshop.biz.system.model.SysRoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dinguangx@163.com
 * @date 2015-12-19 00:14
 */
@Service
public class RoleService extends BaseService<SysRole, SysRoleExample> {
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    protected BaseMapper<SysRole, SysRoleExample> getMapper() {
        return sysRoleMapper;
    }
}
