package net.jeeshop.biz.product.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.product.model.Product;
import net.jeeshop.biz.product.model.ProductExample;

public interface ProductMapper extends BaseMapper<Product, ProductExample> {
    int countByExample(ProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}