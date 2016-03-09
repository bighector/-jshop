package net.jeeshop.biz.order.model;

import java.io.Serializable;
import java.util.Date;
import net.jeeshop.biz.base.model.BaseModel;

public class RefundPayment extends BaseModel implements Serializable {
    /** ä¼šå‘˜ID */
    private Long memberId;

    /** è®¢å�•ç¼–å�· */
    private String orderNum;

    /** è®¢å�•ID */
    private Long orderId;

    /** é€€å�•ID */
    private Long refundOrderId;

    /** é€€æ¬¾è¯·æ±‚å�· */
    private String requestNum;

    /** åŽŸæ”¯ä»˜é‡‘é¢� */
    private Double payAmount;

    /** è®¢å�•æ€»é‡‘é¢� */
    private Double amount;

    /** é€€æ¬¾çŠ¶æ€� */
    private String refundStatus;

    /** æ”¯ä»˜æµ�æ°´å�· */
    private String paymentNum;

    /** é€€æ¬¾æµ�æ°´å�· */
    private String refundNum;

    /** é€€æ¬¾å®Œæˆ�æ—¶é—´ */
    private Date refundTime;

    /** å¤‡æ³¨ */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getRefundOrderId() {
        return refundOrderId;
    }

    public void setRefundOrderId(Long refundOrderId) {
        this.refundOrderId = refundOrderId;
    }

    public String getRequestNum() {
        return requestNum;
    }

    public void setRequestNum(String requestNum) {
        this.requestNum = requestNum == null ? null : requestNum.trim();
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
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

    public String getPaymentNum() {
        return paymentNum;
    }

    public void setPaymentNum(String paymentNum) {
        this.paymentNum = paymentNum == null ? null : paymentNum.trim();
    }

    public String getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(String refundNum) {
        this.refundNum = refundNum == null ? null : refundNum.trim();
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}