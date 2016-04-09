package net.jeeshop.biz.system.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class SysUser extends BaseModel implements Serializable {
    /** è§’è‰²ID */
    private Long roleId;

    /** ç™»å½•å�� */
    private String username;

    /** ç™»å½•å¯†ç � */
    private String password;

    /** æ˜¯å�¦æœ‰æ•ˆ,1-æ˜¯0-å�¦ */
    private Boolean isValid;

    /** æ˜µç§° */
    private String nickname;

    /** ç”µå­�é‚®ç®± */
    private String email;

    private static final long serialVersionUID = 1L;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

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

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
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