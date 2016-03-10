package net.jeeshop.biz.order.model;

import java.io.Serializable;
import java.util.Date;
import net.jeeshop.biz.base.model.BaseModel;

public class Order extends BaseModel implements Serializable {
    /** 会员ID */
    private Long memberId;

    /** 订单编号 */
    private String orderNum;

    /** 订单总金额 */
    private Double amount;

    /** 商品金额 */
    private Double productAmount;

    /** 配送费用 */
    private Double shipAmount;

    /** 支付手续费 */
    private Double payFee;

    /** 标题 */
    private String title;

    /** 总重量 */
    private Double weight;

    /** 数量 */
    private Integer quantity;

    /** 订单状态 */
    private String orderStatus;

    /** 是否已经支付 */
    private String isPaid;

    /** 支付流水号 */
    private String paymentNum;

    /** 支付时间 */
    private Date paymentTime;

    /** 会员备注 */
    private String memberRemark;

    /** 备注 */
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