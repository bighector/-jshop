package net.jeeshop.biz.system.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class KeyValue extends BaseModel implements Serializable {
    /** 类别 */
    private String catalog;

    /** 键 */
    private String kValue;

    /** 值 */
    private String vValue;

    /** 顺序 */
    private Integer ordinal;

    /** 是否有效,1-是0-否 */
    private Boolean isValid;

    private static final long serialVersionUID = 1L;

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog == null ? null : catalog.trim();
    }

    public String getkValue() {
        return kValue;
    }

    public void setkValue(String kValue) {
        this.kValue = kValue == null ? null : kValue.trim();
    }

    public String getvValue() {
        return vValue;
    }

    public void setvValue(String vValue) {
        this.vValue = vValue == null ? null : vValue.trim();
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
}