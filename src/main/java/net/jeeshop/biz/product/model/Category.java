package net.jeeshop.biz.product.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.jeeshop.biz.base.model.BaseModel;

public class Category extends BaseModel implements Serializable
{
    /** 父级ID */
    private Long pid;

    /** 层级 */
    private Integer level;

    /** 分类编号 */
    private String cateCode;

    /** 分类名称 */
    private String cateName;

    /** 页面展示标题 */
    private String pageTitle;

    /** SEO关键字 */
    private String keywords;

    /** 描述信息 */
    private String description;

    /** 0:不可用 1:可用 */
    private String isValid;
    
    private List<Category> children;
    
    private String state = "closed";
    
    
    
    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void addChild(Category child)
    {
    	if(children==null)
    	{
    		children = new ArrayList<Category>();
    	}
    	
    	children.add(child);
    }
    

    private static final long serialVersionUID = 1L;

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

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle == null ? null : pageTitle.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid == null ? null : isValid.trim();
    }
    
	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Category [pid=" + pid + ", level=" + level + ", cateCode="
				+ cateCode + ", cateName=" + cateName + ", pageTitle="
				+ pageTitle + ", keywords=" + keywords + ", description="
				+ description + ", isValid=" + isValid + "]";
	}

	
}