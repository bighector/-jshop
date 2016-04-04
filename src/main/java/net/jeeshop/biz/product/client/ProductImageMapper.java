package net.jeeshop.biz.product.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.product.model.ProductImage;
import net.jeeshop.biz.product.model.ProductImageExample;

public interface ProductImageMapper extends BaseMapper<ProductImage, ProductImageExample> {
    int countByExample(ProductImageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductImage record);

    int insertSelective(ProductImage record);

    List<ProductImage> selectByExample(ProductImageExample example);

    ProductImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductImage record);

    int updateByPrimaryKey(ProductImage record);
}