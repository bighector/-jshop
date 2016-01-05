package net.jeeshop.biz.system.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class SysRole extends BaseModel implements Serializable {
    /** 角色名称 */
    private String roleName;

    /** 角色描述 */
    private String roleDesc;

    /** 角色权限 */
    private String roleDbPrivilege;

    /** 状态，y-有效,n-无效 */
    private String status;

    private String privileges;

    private static final long serialVersionUID = 1L;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    public String getRoleDbPrivilege() {
        return roleDbPrivilege;
    }

    public void setRoleDbPrivilege(String roleDbPrivilege) {
        this.roleDbPrivilege = roleDbPrivilege == null ? null : roleDbPrivilege.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }
}