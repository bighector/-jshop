package net.jeeshop.biz.system.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;
import net.jeeshop.biz.system.enums.ResourceType;

public class SysResource extends BaseModel implements Serializable {
    /** 资源名称 */
    private String resourceName;

    /** 资源类型 */
    private ResourceType resourceType;

    /** 资源值 */
    private String resourceValue;

    /** 顺序 */
    private Integer ordinal;

    /** 是否有效,1-是0-否 */
    private Boolean isValid;

    /** 父级ID */
    private Long parentId;

    private static final long serialVersionUID = 1L;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceValue() {
        return resourceValue;
    }

    public void setResourceValue(String resourceValue) {
        this.resourceValue = resourceValue == null ? null : resourceValue.trim();
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}