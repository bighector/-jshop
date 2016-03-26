package net.jeeshop.biz.product.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class ProductAttrLink extends BaseModel implements Serializable {
    /** 属性名称 */
    private String attrName;

    /** 属性值 */
    private String attrValue;

    /** 商品属性ID */
    private Long productAttrId;

    /** 商品信息ID */
    private Long productInfoId;

    private static final long serialVersionUID = 1L;

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue == null ? null : attrValue.trim();
    }

    public Long getProductAttrId() {
        return productAttrId;
    }

    public void setProductAttrId(Long productAttrId) {
        this.productAttrId = productAttrId;
    }

    public Long getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(Long productInfoId) {
        this.productInfoId = productInfoId;
    }
}