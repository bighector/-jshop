package net.jeeshop.biz.order.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class OrderPayItem extends BaseModel implements Serializable {
    /** æ”¯ä»˜æ–¹å¼�(æ”¯ä»˜å®�ï¼Œç§¯åˆ†ç­‰) */
    private String paymentType;

    /** é‡‘é¢� */
    private Double amount;

    /** æ”¯ä»˜æ˜Žç»†ä¿¡æ�¯ */
    private String detailMsg;

    /** æ”¯ä»˜ID */
    private Long orderPayId;

    private static final long serialVersionUID = 1L;

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

    public String getDetailMsg() {
        return detailMsg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg == null ? null : detailMsg.trim();
    }

    public Long getOrderPayId() {
        return orderPayId;
    }

    public void setOrderPayId(Long orderPayId) {
        this.orderPayId = orderPayId;
    }
}