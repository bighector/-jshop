package net.jeeshop.biz.order.model;

import java.io.Serializable;
import java.util.Date;
import net.jeeshop.biz.base.model.BaseModel;

public class OrderPay extends BaseModel implements Serializable {
    /** ä¼šå‘˜ID */
    private Long memberId;

    /** è®¢å�•ç¼–å�· */
    private String orderNum;

    /** è®¢å�•ID */
    private Long orderId;

    /** æ”¯ä»˜è¯·æ±‚å�· */
    private String requestNum;

    /** è®¢å�•æ€»é‡‘é¢� */
    private Double amount;

    /** æ”¯ä»˜çŠ¶æ€� */
    private String payStatus;

    /** æ”¯ä»˜æ–¹å¼�(æ”¯ä»˜å®�ï¼Œç§¯åˆ†ç­‰) */
    private String paymentType;

    /** æ”¯ä»˜æµ�æ°´å�· */
    private String paymentNum;

    /** æ”¯ä»˜æ—¶é—´ */
    private Date paymentTime;

    /** æ ‡é¢˜ */
    private String title;

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

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public String getPaymentNum() {
        return paymentNum;
    }

    public void setPaymentNum(String paymentNum) {
        this.paymentNum = paymentNum == null ? null : paymentNum.trim();
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}