package net.jeeshop.biz.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.product.client.BrandMapper;
import net.jeeshop.biz.product.model.Brand;
import net.jeeshop.biz.product.model.BrandExample;

/**
 *	产品品牌管理Service
 *
 * @author Leolione
 * @email leolione@outlook.com
 * @since V1.0
 */
@Service
public class BrandService extends BaseService<Brand, BrandExample>{
	
	@Autowired
	private BrandMapper brandMapper;
	
	@Override
	protected BaseMapper<Brand, BrandExample> getMapper() {
		return brandMapper;
	}

}
