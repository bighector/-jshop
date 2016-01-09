package net.jeeshop.biz.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.product.client.ProductBrandMapper;
import net.jeeshop.biz.product.model.ProductBrand;
import net.jeeshop.biz.product.model.ProductBrandExample;

/**
 *	产品品牌管理Service
 *
 * @author Leolione
 * @email leolione@outlook.com
 * @since V1.0
 */
@Service
public class ProductBrandService extends BaseService<ProductBrand, ProductBrandExample>{
	
	@Autowired
	private ProductBrandMapper productBrandMapper;
	
	@Override
	protected BaseMapper<ProductBrand, ProductBrandExample> getMapper() {
		return productBrandMapper;
	}

}
