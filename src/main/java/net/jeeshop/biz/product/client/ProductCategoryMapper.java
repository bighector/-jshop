package net.jeeshop.biz.product.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.product.model.ProductCategory;
import net.jeeshop.biz.product.model.ProductCategoryExample;

public interface ProductCategoryMapper extends BaseMapper<ProductCategory, ProductCategoryExample> {
    int countByExample(ProductCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    List<ProductCategory> selectByExample(ProductCategoryExample example);

    ProductCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);
}