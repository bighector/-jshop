package net.jeeshop.biz.system.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class KeyValue extends BaseModel implements Serializable {
    /** 键值 */
    private String kValue;

    /** 值 */
    private String vValue;

    private static final long serialVersionUID = 1L;

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
}