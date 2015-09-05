package net.jeeshop.biz.base.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dylan
 * @date 15/8/18 21:54
 * Email: dinguangx@163.com
 */
public class BaseModel implements Serializable {
    private Long id;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
