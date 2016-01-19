package net.jeeshop.biz.product.service;

import org.junit.Test;
import org.junit.runner.RunWith;
 
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.jeeshop.biz.product.client.ProductSpecMapper;
import net.jeeshop.biz.product.client.ProductSpecMapperExt;
import net.jeeshop.biz.product.client.ProductSpecValMapper;
import net.jeeshop.biz.product.model.ProductSpec;

/**
 * @author: pj_zhong
 * @email: pj_zhong@163.com
 * @date Jan 19, 2016
 * @since: V1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class ProductSepcTest 
{
	private static final Logger logger = LoggerFactory.getLogger(ProductSepcTest.class);
	
	@Autowired
	ProductSpecMapper productspec;
	
	@Autowired
	ProductSpecMapperExt productspecext;
	
	@Autowired
	ProductSpecValMapper productspecval;
	
	@Test
	public void Test() throws Exception
	{
		ProductSpec produt = new ProductSpec();
		produt.setSpName("Test5");
		produt.setSpSort(1);
		produt.setClassId(1);
		produt.setClassName("pjz");
		produt.setIsDel(0);
		
		productspecext.insertAndReturnId(produt);
		
		logger.info(produt.toString());
	}
}
