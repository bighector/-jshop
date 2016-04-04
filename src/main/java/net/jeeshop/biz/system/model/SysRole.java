package net.jeeshop.biz.system.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class SysRole extends BaseModel implements Serializable {
    /** 角色名称 */
    private String roleName;

    /** 角色描述 */
    private String roleDesc;

    /** 是否有效,1-是0-否 */
    private Boolean isValid;

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

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
}