package net.jeeshop.biz.cms.bean;

import java.util.List;

import net.jeeshop.biz.cms.model.ArticleCategory;
import net.jeeshop.core.util.BeanUtilsExt;

/**
* Created by dylan on 15-9-5.
*/
public class ArticleCatageryBean extends ArticleCategory {
	private static final long serialVersionUID = 1600799011967259967L;

	public ArticleCatageryBean() {
    }

    public ArticleCatageryBean(ArticleCategory catalog) {
        convertFrom(catalog);
    }

    private List<ArticleCatageryBean> children;

    public List<ArticleCatageryBean> getChildren() {
        return children;
    }

    public void setChildren(List<ArticleCatageryBean> children) {
        this.children = children;
    }

    public void convertFrom(ArticleCategory catalog) {
        BeanUtilsExt.copyProperties(this, catalog);
    }
}
