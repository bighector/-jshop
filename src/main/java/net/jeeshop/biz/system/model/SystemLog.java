package net.jeeshop.biz.system.model;

import java.io.Serializable;
import java.util.Date;
import net.jeeshop.biz.base.model.BaseModel;

public class SystemLog extends BaseModel implements Serializable {
    /** 标题 */
    private String title;

    /** 内容 */
    private String content;

    /** 类型 */
    private Integer type;

    /** 日志用户 */
    private String account;

    /** 登录IP */
    private String loginIp;

    /** 登录时间 */
    private Date loginTime;

    /** 登录区域 */
    private String loginArea;

    /** 是否异地登录 */
    private String diffAreaLogin;

    private static final long serialVersionUID = 1L;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginArea() {
        return loginArea;
    }

    public void setLoginArea(String loginArea) {
        this.loginArea = loginArea == null ? null : loginArea.trim();
    }

    public String getDiffAreaLogin() {
        return diffAreaLogin;
    }

    public void setDiffAreaLogin(String diffAreaLogin) {
        this.diffAreaLogin = diffAreaLogin == null ? null : diffAreaLogin.trim();
    }
}