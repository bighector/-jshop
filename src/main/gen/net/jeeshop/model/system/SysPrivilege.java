package net.jeeshop.model.system;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class SysPrivilege extends BaseModel implements Serializable {
    /** 角色id */
    private Long rid;

    /** 菜单ID */
    private Long mid;

    private static final long serialVersionUID = 1L;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }
}