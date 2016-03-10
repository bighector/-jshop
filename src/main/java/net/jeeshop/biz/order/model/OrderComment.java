package net.jeeshop.biz.order.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class OrderComment extends BaseModel implements Serializable {
    /** 订单ID */
    private Long orderId;

    /** 会员ID */
    private Long memberId;

    /** 评论内容 */
    private String content;

    /** 标题 */
    private String title;

    /** 订单评级 */
    private Integer star;

    /** 是否已回复，1-是0-否 */
    private String isReply;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getIsReply() {
        return isReply;
    }

    public void setIsReply(String isReply) {
        this.isReply = isReply == null ? null : isReply.trim();
    }
}