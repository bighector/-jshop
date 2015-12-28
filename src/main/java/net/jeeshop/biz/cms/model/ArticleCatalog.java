package net.jeeshop.biz.cms.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class ArticleCatalog extends BaseModel implements Serializable {
    /** 分类名称 */
    private String name;

    /** 父级ID */
    private Long pid;

    /** 顺序 */
    private Integer ordinal;

    /** 类型 */
    private String type;

    /** 分类编码 */
    private String code;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}