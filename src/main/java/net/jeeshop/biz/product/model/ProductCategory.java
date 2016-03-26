package net.jeeshop.biz.product.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class ProductCategory extends BaseModel implements Serializable {
    /** 分类编码 */
    private String cateCode;

    /** 分类名称 */
    private String cateName;

    /** 父级ID */
    private Long pid;

    /** 层级 */
    private Integer level;

    /** 描述信息 */
    private String description;

    /** SEO关键字 */
    private String keyworks;

    /** 页面展示标题 */
    private String pageTitle;

    /** 是否有效,1-是0-否 */
    private String isValid;

    private static final long serialVersionUID = 1L;

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode == null ? null : cateCode.trim();
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName == null ? null : cateName.trim();
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getKeyworks() {
        return keyworks;
    }

    public void setKeyworks(String keyworks) {
        this.keyworks = keyworks == null ? null : keyworks.trim();
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle == null ? null : pageTitle.trim();
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid == null ? null : isValid.trim();
    }
}