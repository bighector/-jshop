package net.jeeshop.biz.product.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.product.model.ProductInfoSpecLink;
import net.jeeshop.biz.product.model.ProductInfoSpecLinkExample;

public interface ProductInfoSpecLinkMapper extends BaseMapper<ProductInfoSpecLink, ProductInfoSpecLinkExample> {
    int countByExample(ProductInfoSpecLinkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductInfoSpecLink record);

    int insertSelective(ProductInfoSpecLink record);

    List<ProductInfoSpecLink> selectByExample(ProductInfoSpecLinkExample example);

    ProductInfoSpecLink selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductInfoSpecLink record);

    int updateByPrimaryKey(ProductInfoSpecLink record);
}