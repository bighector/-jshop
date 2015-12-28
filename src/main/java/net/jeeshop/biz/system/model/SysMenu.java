package net.jeeshop.biz.system.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class SysMenu extends BaseModel implements Serializable {
    /** 父级ID */
    private Long pid;

    /** URL */
    private String url;

    /** 菜单名称 */
    private String name;

    /** 顺序 */
    private Integer orderNum;

    /** 菜单类型 */
    private String type;

    private static final long serialVersionUID = 1L;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}