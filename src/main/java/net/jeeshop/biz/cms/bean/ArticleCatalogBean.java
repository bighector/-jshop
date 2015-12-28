package net.jeeshop.biz.cms.bean;

import net.jeeshop.biz.cms.model.ArticleCatalog;
import net.jeeshop.core.util.BeanUtilsExt;

import java.util.List;

/**
* Created by dylan on 15-9-5.
*/
public class ArticleCatalogBean extends ArticleCatalog {
    public ArticleCatalogBean() {
    }

    public ArticleCatalogBean(ArticleCatalog catalog) {
        convertFrom(catalog);
    }

    private List<ArticleCatalogBean> children;

    public List<ArticleCatalogBean> getChildren() {
        return children;
    }

    public void setChildren(List<ArticleCatalogBean> children) {
        this.children = children;
    }

    public void convertFrom(ArticleCatalog catalog) {
        BeanUtilsExt.copyProperties(this, catalog);
    }
}
