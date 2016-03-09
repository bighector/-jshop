package net.jeeshop.biz.order.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class MemberFavorite extends BaseModel implements Serializable {
    /** ä¼šå‘˜ID */
    private Long memberId;

    /** å•†å“�ID */
    private Long productId;

    /** æ˜¯å�¦æœ‰æ•ˆ ï¼Œ1-æ˜¯0-å�¦ */
    private String isValid;

    private static final long serialVersionUID = 1L;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid == null ? null : isValid.trim();
    }
}