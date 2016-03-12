package net.jeeshop.biz.product.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class ProductSpec extends BaseModel implements Serializable {
    /** 规格名称 */
    private String specName;

    /** 顺序 */
    private Integer ordinal;

    /** 值类型，int-整型，string-字符型,color-颜色型,img-图片型 */
    private String valueType;

    /** 商品分类ID */
    private Long categoryId;

    /** 是否有效,1-是0-否 */
    private String isValid;

    /** 人性化名称(规格重名时用这个区分) */
    private String friendlyName;

    private static final long serialVersionUID = 1L;

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType == null ? null : valueType.trim();
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid == null ? null : isValid.trim();
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName == null ? null : friendlyName.trim();
    }
}