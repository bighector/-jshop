package net.jeeshop.biz.system.model;

import java.io.Serializable;
import java.math.BigDecimal;
import net.jeeshop.biz.base.model.BaseModel;

public class SystemExpress extends BaseModel implements Serializable {
    /** 配送方式编码 */
    private String code;

    /** 配送方式名称 */
    private String name;

    /** 配送费用 */
    private BigDecimal fee;

    /** 显示顺序 */
    private Integer ordinal;

    private static final long serialVersionUID = 1L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }
}