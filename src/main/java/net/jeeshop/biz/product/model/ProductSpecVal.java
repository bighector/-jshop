package net.jeeshop.biz.product.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

import net.jeeshop.biz.base.model.BaseModel;

public class ProductSpecVal extends BaseModel implements Serializable {
    /** 规格值 */
    private String specVal;

    /** 所属规格id */
    private Long specId;

    /** 排序 */
    private Integer ordinal;

    private static final long serialVersionUID = 1L;

    public String getSpecVal() {
        return specVal;
    }

    public void setSpecVal(String specVal) {
        this.specVal = specVal == null ? null : specVal.trim();
    }
    
    @JsonIgnore
    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }
    
    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

	@Override
	public String toString() {
		return "ProductSpecVal [specVal=" + specVal + ", specId=" + specId
				+ ", ordinal=" + ordinal + "]";
	}
    
    
}