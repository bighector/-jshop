package net.jeeshop.biz.system.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class SysPrivilege extends BaseModel implements Serializable {
    /** 角色ID */
    private Long roleId;

    /** 资源ID */
    private Long resourceId;

    private static final long serialVersionUID = 1L;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}