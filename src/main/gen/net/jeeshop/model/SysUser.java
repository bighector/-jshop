package net.jeeshop.model;

import java.io.Serializable;
import java.util.Date;
import net.jeeshop.biz.base.model.BaseModel;

public class SysUser extends BaseModel implements Serializable {
    /** t_user.username */
    private String username;

    /** t_user.password */
    private String password;

    /** t_user.createtime */
    private Date createtime;

    /** t_user.updatetime */
    private Date updatetime;

    /** t_user.createAccount */
    private String createaccount;

    /** t_user.updateAccount */
    private String updateaccount;

    /** t_user.status */
    private String status;

    /** t_user.rid */
    private String rid;

    /** t_user.nickname */
    private String nickname;

    /** t_user.email */
    private String email;

    private static final long serialVersionUID = 1L;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getCreateaccount() {
        return createaccount;
    }

    public void setCreateaccount(String createaccount) {
        this.createaccount = createaccount == null ? null : createaccount.trim();
    }

    public String getUpdateaccount() {
        return updateaccount;
    }

    public void setUpdateaccount(String updateaccount) {
        this.updateaccount = updateaccount == null ? null : updateaccount.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid == null ? null : rid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}