package net.jeeshop.biz.order.model;

import java.io.Serializable;
import java.util.Date;
import net.jeeshop.biz.base.model.BaseModel;

public class RefundOrder extends BaseModel implements Serializable {
    /** è®¢å�•ID */
    private Long orderId;

    /** ä¼šå‘˜ID */
    private Long memberId;

    /** é€€å�•åŽŸå›  */
    private String refundReason;

    /** é€€å�•ç±»åž‹ */
    private String refundType;

    /** é€€æ¬¾é‡‘é¢� */
    private Double amount;

    /** é€€å�•çŠ¶æ€� */
    private String refundStatus;

    /** é€€å�•æ ‡é¢˜ */
    private String title;

    /** æ•°é‡� */
    private Integer quantity;

    /** é€€æ¬¾æµ�æ°´å�· */
    private String refundNum;

    /** é€€æ¬¾å®Œæˆ�æ—¶é—´ */
    private Date refundTime;

    private static final long serialVersionUID = 1L;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason == null ? null : refundReason.trim();
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType == null ? null : refundType.trim();
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
}