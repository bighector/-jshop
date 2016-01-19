package net.jeeshop.biz.product.service;

import org.springframework.beans.factory.annotation.Autowired;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.product.client.ProductSpecMapper;
import net.jeeshop.biz.product.client.ProductSpecMapperExt;
import net.jeeshop.biz.product.client.ProductSpecValMapper;
import net.jeeshop.biz.product.model.ProductSpec;
import net.jeeshop.biz.product.model.ProductSpecExample;
import net.jeeshop.biz.product.model.ProductSpecVal;

/**
 * @author: pj_zhong
 * @email: pj_zhong@163.com
 * @date Jan 19, 2016
 * @since: V1.0
 */
public class ProductSpecService extends BaseService<ProductSpec,ProductSpecExample>
{
	@Autowired
	private ProductSpecMapper productspec;
	
	@Autowired
	private ProductSpecMapperExt productspecext;
	
	@Autowired
	private ProductSpecValMapper productspecval;
	
	@Override
	protected BaseMapper getMapper()
	{
		return productspec;
	}
	
	public void AddProSpec(ProductSpec spec,String[] spec_val)
	{
		productspecext.insertAndReturnId(spec);
		
	}
 
 
		
}
