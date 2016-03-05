package net.jeeshop.biz.cms.bean;

import java.util.List;

import net.jeeshop.biz.cms.model.ArticleCatagory;
import net.jeeshop.core.util.BeanUtilsExt;

/**
* Created by dylan on 15-9-5.
*/
public class ArticleCatagoryBean extends ArticleCatagory {
	private static final long serialVersionUID = 1600799011967259967L;

	public ArticleCatagoryBean() {
    }

    public ArticleCatagoryBean(ArticleCatagory catalog) {
        convertFrom(catalog);
    }

    private List<ArticleCatagoryBean> children;

    public List<ArticleCatagoryBean> getChildren() {
        return children;
    }

    public void setChildren(List<ArticleCatagoryBean> children) {
        this.children = children;
    }

    public void convertFrom(ArticleCatagory catalog) {
        BeanUtilsExt.copyProperties(this, catalog);
    }
}
