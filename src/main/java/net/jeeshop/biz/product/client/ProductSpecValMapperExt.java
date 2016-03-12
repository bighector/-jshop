package net.jeeshop.biz.product.client;

import java.util.List;

import net.jeeshop.biz.product.model.ProductSpec;
import net.jeeshop.biz.product.model.ProductSpecVal;

public interface ProductSpecValMapperExt  extends ProductSpecValMapper {
   public int insertSpecValues(List<ProductSpecVal> specVals);
   
   public int insertValuesByProductSpec(ProductSpec productSpec);
   
   public int deleteBySpecId(Long spec_id);
   
   public List<ProductSpecVal> selectBySpecId(Long spec_id);
}