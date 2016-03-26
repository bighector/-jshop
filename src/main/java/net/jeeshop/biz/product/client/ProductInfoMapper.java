package net.jeeshop.biz.product.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.product.model.ProductInfo;
import net.jeeshop.biz.product.model.ProductInfoExample;

public interface ProductInfoMapper extends BaseMapper<ProductInfo, ProductInfoExample> {
    int countByExample(ProductInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    List<ProductInfo> selectByExample(ProductInfoExample example);

    ProductInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);
}