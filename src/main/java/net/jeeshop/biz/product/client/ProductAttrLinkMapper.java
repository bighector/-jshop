package net.jeeshop.biz.product.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.product.model.ProductAttrLink;
import net.jeeshop.biz.product.model.ProductAttrLinkExample;

public interface ProductAttrLinkMapper extends BaseMapper<ProductAttrLink, ProductAttrLinkExample> {
    int countByExample(ProductAttrLinkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductAttrLink record);

    int insertSelective(ProductAttrLink record);

    List<ProductAttrLink> selectByExample(ProductAttrLinkExample example);

    ProductAttrLink selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductAttrLink record);

    int updateByPrimaryKey(ProductAttrLink record);
}