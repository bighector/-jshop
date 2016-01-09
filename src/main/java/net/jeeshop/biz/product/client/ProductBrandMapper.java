package net.jeeshop.biz.product.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.product.model.ProductBrand;
import net.jeeshop.biz.product.model.ProductBrandExample;

public interface ProductBrandMapper extends BaseMapper<ProductBrand, ProductBrandExample> {
    int countByExample(ProductBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductBrand record);

    int insertSelective(ProductBrand record);

    List<ProductBrand> selectByExample(ProductBrandExample example);

    ProductBrand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductBrand record);

    int updateByPrimaryKey(ProductBrand record);
}