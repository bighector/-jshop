package net.jeeshop.biz.product.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.product.model.ProductSpec;
import net.jeeshop.biz.product.model.ProductSpecExample;

public interface ProductSpecMapper extends BaseMapper<ProductSpec, ProductSpecExample> {
    int countByExample(ProductSpecExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductSpec record);

    int insertSelective(ProductSpec record);

    List<ProductSpec> selectByExample(ProductSpecExample example);

    ProductSpec selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductSpec record);

    int updateByPrimaryKey(ProductSpec record);
}