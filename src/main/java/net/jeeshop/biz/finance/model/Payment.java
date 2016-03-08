package net.jeeshop.biz.finance.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class Payment extends BaseModel implements Serializable {
    /** 会员ID */
    private Long memberId;

    /** 相关的订单号 */
    private Long orderId;

    /** 请求号 */
    private String requestNum;

    /** 金额 */
    private Double amount;

    /** 备注 */
    private String remark;

    /** 支付状态 */
    private String paymentStatus;

    /** 退款状态 */
    private String refundStatus;

    /** 已退金额 */
    private Double refundedAmount;

    private static final long serialVersionUID = 1L;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getRequestNum() {
        return requestNum;
    }

    public void setRequestNum(String requestNum) {
        this.requestNum = requestNum == null ? null : requestNum.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus == null ? null : paymentStatus.trim();
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus == null ? null : refundStatus.trim();
    }

    public Double getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(Double refundedAmount) {
        this.refundedAmount = refundedAmount;
    }
}