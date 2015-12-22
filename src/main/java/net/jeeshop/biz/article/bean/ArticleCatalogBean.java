package net.jeeshop.biz.article.bean;

import net.jeeshop.core.util.BeanUtilsExt;
import net.jeeshop.model.cms.ArticleCatalog;

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
