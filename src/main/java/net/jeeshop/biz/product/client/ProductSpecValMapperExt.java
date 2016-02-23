package net.jeeshop.biz.product.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.product.model.ProductSpecVal;
import net.jeeshop.biz.product.model.ProductSpecValExample;

public interface ProductSpecValMapperExt 
{
   public int insertSpecValues(List<ProductSpecVal> specVals);
   
   public int deleteBySpecId(Long spec_id);
   
   public List<ProductSpecVal> selectBySpecId(Long spec_id);
}