package net.jeeshop.biz.product.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.product.model.ProductSpecVal;
import net.jeeshop.biz.product.model.ProductSpecValExample;

public interface ProductSpecValMapper extends BaseMapper<ProductSpecVal, ProductSpecValExample> {
    int countByExample(ProductSpecValExample example);

    int deleteByPrimaryKey(Long spValueId);

    int insert(ProductSpecVal record);

    int insertSelective(ProductSpecVal record);

    List<ProductSpecVal> selectByExample(ProductSpecValExample example);

    ProductSpecVal selectByPrimaryKey(Long spValueId);

    int updateByPrimaryKeySelective(ProductSpecVal record);

    int updateByPrimaryKey(ProductSpecVal record);
}