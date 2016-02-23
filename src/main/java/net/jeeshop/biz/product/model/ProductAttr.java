package net.jeeshop.biz.product.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class ProductAttr extends BaseModel implements Serializable {
    /** 属性名称 */
    private String attrName;

    /** 排序 */
    private Integer ordinal;

    /** 是否必须,1-是0-否 */
    private String isMandated;

    /** 值类型，input-手工输入, list-列表选择 */
    private String valueType;

    /** 可选值列表，以逗号分隔; 当value_type为list时使用 */
    private String optionsList;

    /** 商品分类ID */
    private Long categoryId;

    private static final long serialVersionUID = 1L;

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public String getIsMandated() {
        return isMandated;
    }

    public void setIsMandated(String isMandated) {
        this.isMandated = isMandated == null ? null : isMandated.trim();
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType == null ? null : valueType.trim();
    }

    public String getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(String optionsList) {
        this.optionsList = optionsList == null ? null : optionsList.trim();
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}