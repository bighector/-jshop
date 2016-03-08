package net.jeeshop.biz.finance.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class PaymentType extends BaseModel implements Serializable {
    /** 支付方式代码 */
    private String paymentType;

    /** 支付方式名称 */
    private String typeName;

    /** 是否可用,1-是0-否 */
    private String isValid;

    /** 备注 */
    private String remark;

    private static final long serialVersionUID = 1L;

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid == null ? null : isValid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}