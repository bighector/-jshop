package net.jeeshop.biz.product.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.product.model.ProductAttr;
import net.jeeshop.biz.product.model.ProductAttrExample;

public interface ProductAttrMapper extends BaseMapper<ProductAttr, ProductAttrExample> {
    int countByExample(ProductAttrExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductAttr record);

    int insertSelective(ProductAttr record);

    List<ProductAttr> selectByExample(ProductAttrExample example);

    ProductAttr selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductAttr record);

    int updateByPrimaryKey(ProductAttr record);
}