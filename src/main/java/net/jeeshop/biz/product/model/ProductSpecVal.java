package net.jeeshop.biz.product.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class ProductSpecVal extends BaseModel implements Serializable {
    /** 规格值id */
    private Long spValueId;

    /** 规格值名称 */
    private String spValueName;

    /** 所属规格id */
    private Integer spId;

    /** 分类id */
    private Integer gcId;

    /** 排序 */
    private Boolean spValueSort;

    private static final long serialVersionUID = 1L;

    public Long getSpValueId() {
        return spValueId;
    }

    public void setSpValueId(Long spValueId) {
        this.spValueId = spValueId;
    }

    public String getSpValueName() {
        return spValueName;
    }

    public void setSpValueName(String spValueName) {
        this.spValueName = spValueName == null ? null : spValueName.trim();
    }

    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public Integer getGcId() {
        return gcId;
    }

    public void setGcId(Integer gcId) {
        this.gcId = gcId;
    }

    public Boolean getSpValueSort() {
        return spValueSort;
    }

    public void setSpValueSort(Boolean spValueSort) {
        this.spValueSort = spValueSort;
    }
}