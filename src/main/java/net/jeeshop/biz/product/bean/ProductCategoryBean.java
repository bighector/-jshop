package net.jeeshop.biz.product.bean;

import net.jeeshop.biz.product.model.ProductCategory;
import net.jeeshop.core.util.BeanUtilsExt;

import java.util.List;

/**
 * Created by dylan on 15-9-5.
 */
public class ProductCategoryBean extends ProductCategory {
    private static final long serialVersionUID = 1600799011967259967L;

    public ProductCategoryBean() {
    }

    public ProductCategoryBean(ProductCategory catalog) {
        convertFrom(catalog);
    }

    private List<ProductCategoryBean> children;

    public List<ProductCategoryBean> getChildren() {
        return children;
    }

    public void setChildren(List<ProductCategoryBean> children) {
        this.children = children;
    }

    public void convertFrom(ProductCategory catalog) {
        BeanUtilsExt.copyProperties(this, catalog);
    }
}
