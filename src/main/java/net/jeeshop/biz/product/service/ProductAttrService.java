package net.jeeshop.biz.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.product.client.ProductAttrMapper;
import net.jeeshop.biz.product.model.ProductAttr;
import net.jeeshop.biz.product.model.ProductAttrExample;

@Service
public class ProductAttrService extends BaseService<ProductAttr, ProductAttrExample> {

	@Autowired
	private ProductAttrMapper productAttrMapper;
	
	@Override
	protected BaseMapper<ProductAttr, ProductAttrExample> getMapper() {
		return productAttrMapper;
	}

}
