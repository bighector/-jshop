package net.jeeshop.biz.order.model;

import java.io.Serializable;
import java.util.Date;
import net.jeeshop.biz.base.model.BaseModel;

public class Order extends BaseModel implements Serializable {
    /** ä¼šå‘˜ID */
    private Long memberId;

    /** è®¢å�•ç¼–å�· */
    private String orderNum;

    /** è®¢å�•æ€»é‡‘é¢� */
    private Double amount;

    /** å•†å“�é‡‘é¢� */
    private Double productAmount;

    /** é…�é€�è´¹ç”¨ */
    private Double shipAmount;

    /** æ”¯ä»˜æ‰‹ç»­è´¹ */
    private Double payFee;

    /** æ ‡é¢˜ */
    private String title;

    /** æ€»é‡�é‡� */
    private Double weight;

    /** æ•°é‡� */
    private Integer quantity;

    /** è®¢å�•çŠ¶æ€� */
    private String orderStatus;

    /** æ˜¯å�¦å·²ç»�æ”¯ä»˜ */
    private String isPaid;

    /** æ”¯ä»˜æµ�æ°´å�· */
    private String paymentNum;

    /** æ”¯ä»˜æ—¶é—´ */
    private Date paymentTime;

    /** ä¼šå‘˜å¤‡æ³¨ */
    private String memberRemark;

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Double productAmount) {
        this.productAmount = productAmount;
    }

    public Double getShipAmount() {
        return shipAmount;
    }

    public void setShipAmount(Double shipAmount) {
        this.shipAmount = shipAmount;
    }

    public Double getPayFee() {
        return payFee;
    }

    public void setPayFee(Double payFee) {
        this.payFee = payFee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid == null ? null : isPaid.trim();
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

    public String getMemberRemark() {
        return memberRemark;
    }

    public void setMemberRemark(String memberRemark) {
        this.memberRemark = memberRemark == null ? null : memberRemark.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}