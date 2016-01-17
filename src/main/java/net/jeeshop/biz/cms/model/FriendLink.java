package net.jeeshop.biz.cms.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class FriendLink extends BaseModel implements Serializable {
    /** 链接名称 */
    private String linkName;

    /** 友情链接网站的链接地址 */
    private String linkUrl;

    /** 友情链接的logo */
    private String linkLogo;

    /** 顺序 */
    private Integer oridnal;

    private static final long serialVersionUID = 1L;

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

    public Integer getOridnal() {
        return oridnal;
    }

    public void setOridnal(Integer oridnal) {
        this.oridnal = oridnal;
    }
}