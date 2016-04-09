package net.jeeshop.biz.system.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class SysArea extends BaseModel implements Serializable {
    /** çˆ¶çº§ID */
    private Long parentId;

    /** åŒºåŸŸå��ç§° */
    private String areaName;

    private static final long serialVersionUID = 1L;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }
}