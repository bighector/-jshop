package net.jeeshop.biz.system.model;

import java.io.Serializable;
import java.util.Date;
import net.jeeshop.biz.base.model.BaseModel;
import net.jeeshop.biz.system.enums.LogType;

public class SystemLog extends BaseModel implements Serializable {
    /** 标题 */
    private String title;

    /** 日志内容 */
    private String content;

    /** 日志类型 */
    private LogType logType;

    /** 日志用户 */
    private String account;

    /** sys_system_log.login_ip */
    private String loginIp;

    /** 登录区域 */
    private String loginArea;

    /** 日志记录时间 */
    private Date logTime;

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

    public LogType getLogType() {
        return logType;
    }

    public void setLogType(LogType logType) {
        this.logType = logType;
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

    public String getLoginArea() {
        return loginArea;
    }

    public void setLoginArea(String loginArea) {
        this.loginArea = loginArea == null ? null : loginArea.trim();
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }
}