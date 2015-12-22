package net.jeeshop.model.system;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class SysUser extends BaseModel implements Serializable {
    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 状态,n-有效，y-无效 */
    private String status;

    /** 角色ID */
    private Long rid;

    /** 昵称 */
    private String nickname;

    /** 电子邮箱 */
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
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