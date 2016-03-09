package net.jeeshop.biz.order.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class ShoppingCart extends BaseModel implements Serializable {
    /** å•†å“�ID */
    private Long productId;

    /** ä¼šå‘˜ID */
    private Long memberId;

    /** æ•°é‡� */
    private Integer quantity;

    /** å•†å“�å��ç§° */
    private String productName;

    /** æ˜¯å�¦æœ‰æ•ˆ ï¼Œ1-æ˜¯0-å�¦ */
    private String isValid;

    private static final long serialVersionUID = 1L;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid == null ? null : isValid.trim();
    }
}