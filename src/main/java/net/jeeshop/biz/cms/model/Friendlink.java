package net.jeeshop.biz.cms.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class Friendlink extends BaseModel implements Serializable {
    /** 友情链接编号（自增id） */
    private Short linkId;

    /** 友情链接的名称，img的alt的内容 */
    private String linkName;

    /** 友情链接网站的链接地址 */
    private String linkUrl;

    /** 友情链接的logo */
    private String linkLogo;

    /** 在页面的显示顺序 */
    private Byte showOrder;

    private static final long serialVersionUID = 1L;

    public Short getLinkId() {
        return linkId;
    }

    public void setLinkId(Short linkId) {
        this.linkId = linkId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    public String getLinkLogo() {
        return linkLogo;
    }

    public void setLinkLogo(String linkLogo) {
        this.linkLogo = linkLogo == null ? null : linkLogo.trim();
    }

    public Byte getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Byte showOrder) {
        this.showOrder = showOrder;
    }
}