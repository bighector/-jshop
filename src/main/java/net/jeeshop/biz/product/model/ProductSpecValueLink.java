package net.jeeshop.biz.product.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class ProductSpecValueLink extends BaseModel implements Serializable {
    /** 规格ID */
    private Long specGroupId;

    /** 商品信息关联规格ID */
    private Long productInfoSpecLinkId;

    /** 商品信息ID */
    private Long productInfoId;

    /** 商品ID */
    private Long productId;

    /** 规格名称 */
    private String specName;

    /** 规格值 */
    private String specValue;

    private static final long serialVersionUID = 1L;

    public Long getSpecGroupId() {
        return specGroupId;
    }

    public void setSpecGroupId(Long specGroupId) {
        this.specGroupId = specGroupId;
    }

    public Long getProductInfoSpecLinkId() {
        return productInfoSpecLinkId;
    }

    public void setProductInfoSpecLinkId(Long productInfoSpecLinkId) {
        this.productInfoSpecLinkId = productInfoSpecLinkId;
    }

    public Long getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(Long productInfoId) {
        this.productInfoId = productInfoId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    public String getSpecValue() {
        return specValue;
    }

    public void setSpecValue(String specValue) {
        this.specValue = specValue == null ? null : specValue.trim();
    }
}