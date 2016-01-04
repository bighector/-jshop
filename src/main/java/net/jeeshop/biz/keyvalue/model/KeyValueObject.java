package net.jeeshop.biz.keyvalue.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class KeyValueObject extends BaseModel implements Serializable {
    /** t_key_value.keyTemp */
    private String keytemp;

    /** t_key_value.valueTemp */
    private String valuetemp;

    private static final long serialVersionUID = 1L;

    public String getKeytemp() {
        return keytemp;
    }

    public void setKeytemp(String keytemp) {
        this.keytemp = keytemp == null ? null : keytemp.trim();
    }

    public String getValuetemp() {
        return valuetemp;
    }

    public void setValuetemp(String valuetemp) {
        this.valuetemp = valuetemp == null ? null : valuetemp.trim();
    }
}