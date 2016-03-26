package net.jeeshop.biz.product.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.product.model.ProductSpecValueLink;
import net.jeeshop.biz.product.model.ProductSpecValueLinkExample;

public interface ProductSpecValueLinkMapper extends BaseMapper<ProductSpecValueLink, ProductSpecValueLinkExample> {
    int countByExample(ProductSpecValueLinkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductSpecValueLink record);

    int insertSelective(ProductSpecValueLink record);

    List<ProductSpecValueLink> selectByExample(ProductSpecValueLinkExample example);

    ProductSpecValueLink selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductSpecValueLink record);

    int updateByPrimaryKey(ProductSpecValueLink record);
}