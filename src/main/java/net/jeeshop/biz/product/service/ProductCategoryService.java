package net.jeeshop.biz.product.service;

import com.google.common.collect.Lists;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.product.bean.ProductCategoryBean;
import net.jeeshop.biz.product.client.ProductCategoryMapper;
import net.jeeshop.biz.product.model.ProductCategory;
import net.jeeshop.biz.product.model.ProductCategoryExample;
import net.jeeshop.biz.product.model.ProductCategoryExample.Criteria;
import net.jeeshop.core.exception.JShopException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: pj_zhong
 * @email: pj_zhong@163.com
 * @date 2016-3-15
 */
@Service
public class ProductCategoryService extends BaseService<ProductCategory, ProductCategoryExample> {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    protected BaseMapper<ProductCategory, ProductCategoryExample> getMapper() {
        return productCategoryMapper;
    }


    @Override
    public long insert(ProductCategory entity) {
        if (entity.getParentId() == null) {
            entity.setParentId(0L);
            entity.setLevel(1);
        }
        if (entity.getParentId().compareTo(0l) != 0) {
            ProductCategory parent = selectById(entity.getParentId());
            if(parent == null) {
                throw new JShopException("父级分类不存在!");
            }
            entity.setLevel(parent.getLevel() + 1);
        }
        return super.insert(entity);
    }

    /**
     * 根据categoryCode检索
     *
     * @param categoryCode
     * @return
     */
    public ProductCategory selectByCategoryCode(String categoryCode) {
        ProductCategoryExample example = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryCodeEqualTo(categoryCode);
        criteria.andIsValidEqualTo(true);
        return super.selectUniqueByExample(example);
    }


    @Override
    public int deleteById(long id) {
        int row = 0;
        List<ProductCategory> children = loadCategoryByParent(id);
        for (ProductCategory c : children) {
            row += deleteById(c.getId());
        }
        ProductCategory productCategory = this.selectById(id);
        if (productCategory != null) {
            ProductCategory record = new ProductCategory();
            record.setId(productCategory.getId());
            record.setIsValid(false);
            row += productCategoryMapper.updateByPrimaryKeySelective(record);
        }
        return row;
    }


    /**
     * 根据父类ID查询分类 ,0查询顶级分类
     *
     * @param pid
     * @return
     */
    public List<ProductCategory> loadCategoryByParent(long pid) {
        ProductCategoryExample query = new ProductCategoryExample();
        Criteria condition = query.createCriteria();
        condition.andIsValidEqualTo(true);
        condition.andParentIdEqualTo(pid);
        return getMapper().selectByExample(query);
    }


    /**
     * 加载所有分类(1-3级)
     *
     * @return
     */
    public List<ProductCategory> loadAll() {
        ProductCategoryExample query = new ProductCategoryExample();
        query.createCriteria().andIsValidEqualTo(true);
        List<ProductCategory> categories = getMapper().selectByExample(query);

        HashMap<Long, ProductCategory> categoryMap = new HashMap<Long, ProductCategory>();
        for (ProductCategory c : categories) {
            categoryMap.put(c.getId(), c);
        }

        List<ProductCategory> root = new ArrayList<ProductCategory>();
        ProductCategory parent;

        //分类
        for (ProductCategory c : categoryMap.values()) {
            if (c.getParentId() == 0) {
                root.add(c);
            } else {
                parent = categoryMap.get(c.getParentId());
//			                      if(parent!=null) { parent.addChild(c); }
            }
        }
        return root;

    }

    /**
     * 获取一级目录分类
     *
     * @return
     */
    public List<ProductCategoryBean> loadRoot() {
        ProductCategoryExample example = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andIsValidEqualTo(true);
        criteria.andParentIdEqualTo(0L);

        List<ProductCategory> rootCatalogs = productCategoryMapper.selectByExample(example);
        List<ProductCategoryBean> result = convertList(rootCatalogs);
        for (ProductCategoryBean category : result) {
            loadChildrenRecursive(category);
        }
        return result;
    }

    private List<ProductCategoryBean> convertList(List<ProductCategory> categories) {
        List<ProductCategoryBean> result = Lists.newArrayList();
        for (ProductCategory catalog : categories) {
            result.add(new ProductCategoryBean(catalog));
        }
        return result;
    }

    /**
     * 加载指定节点下的全部子节点
     *
     * @param item
     */
    private void loadChildrenRecursive(ProductCategoryBean item) {
        ProductCategoryExample example = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andIsValidEqualTo(true);
        criteria.andParentIdEqualTo(item.getId());
        item.setChildren(convertList(productCategoryMapper.selectByExample(example)));
        if (item.getChildren() != null && item.getChildren().size() > 0) {
            for (ProductCategoryBean bean : item.getChildren()) {
                loadChildrenRecursive(bean);
            }
        }
    }
}
