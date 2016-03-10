package net.jeeshop.biz.order.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class OrderItem extends BaseModel implements Serializable {
    /** 会员ID */
    private Long memberId;

    /** 商品ID */
    private Long productId;

    /** 单价 */
    private Double price;

    /** 数量 */
    private Integer quantity;

    /** 金额 */
    private Double amount;

    /** 订单ID */
    private Long orderId;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}