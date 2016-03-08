package net.jeeshop.biz.finance.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class PaymentRefundItem extends BaseModel implements Serializable {
    /** 退款ID */
    private Long paymentRefundId;

    /** 原支付信息ID */
    private Long paymentId;

    /** 原支付明细ID */
    private Long paymentItemId;

    /** 支付方式代码 */
    private String paymentType;

    /** 金额 */
    private Double amount;

    /** 退款状态 */
    private String refundStatus;

    /** 会员ID */
    private Long memberId;

    /** 备注 */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getPaymentRefundId() {
        return paymentRefundId;
    }

    public void setPaymentRefundId(Long paymentRefundId) {
        this.paymentRefundId = paymentRefundId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getPaymentItemId() {
        return paymentItemId;
    }

    public void setPaymentItemId(Long paymentItemId) {
        this.paymentItemId = paymentItemId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus == null ? null : refundStatus.trim();
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}