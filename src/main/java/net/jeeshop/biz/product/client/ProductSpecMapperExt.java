package net.jeeshop.biz.product.client;

import net.jeeshop.biz.product.model.ProductSpec;

 
/**
 * @author: pj_zhong
 * @email: pj_zhong@163.com
 * @date Jan 19, 2016
 * @since: V1.0
 */
public interface ProductSpecMapperExt
{
	/**
	 * MySql自增长的ID会自动赋值到  record
	 * @param record
	 * @return
	 */
	 int insertAndReturnId(ProductSpec record);
}
