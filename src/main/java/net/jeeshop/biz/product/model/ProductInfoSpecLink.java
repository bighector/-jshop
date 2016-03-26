package net.jeeshop.biz.product.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class ProductInfoSpecLink extends BaseModel implements Serializable {
    /** 规格ID */
    private Long specGroupId;

    /** 商品信息ID */
    private Long productInfoId;

    private static final long serialVersionUID = 1L;

    public Long getSpecGroupId() {
        return specGroupId;
    }

    public void setSpecGroupId(Long specGroupId) {
        this.specGroupId = specGroupId;
    }

    public Long getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(Long productInfoId) {
        this.productInfoId = productInfoId;
    }
}