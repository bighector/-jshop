package net.jeeshop.product.controller;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.product.model.ProductCategory;
import net.jeeshop.biz.product.model.ProductCategoryExample;
import net.jeeshop.biz.product.service.CategoryService;
import net.jeeshop.web.controller.manage.ManageBaseController;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: pj_zhong
 * @email: pj_zhong@163.com
 * @date Mar 20, 2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class ProductCategoryControllerTest extends ManageBaseController<ProductCategory,ProductCategoryExample>
{
	@Autowired
	private CategoryService service;
	
	private static String page_toList = null;
	private static String page_toAdd  = null;
	private static String page_toEdit = null;
	
	@org.junit.Test
	public void Test()
	{
		ProductCategoryControllerTest test= new ProductCategoryControllerTest();
		
		PageQueryBean bean = new PageQueryBean();
		
		System.out.println(test.loadDate(null, bean));
		
		
		
	
	}
	
	public ProductCategoryControllerTest()
	{
		super.page_toAdd  = this.page_toAdd;
		super.page_toEdit = this.page_toEdit;
		super.page_toList = this.page_toList;
	}

	@Override
	public BaseService<ProductCategory, ProductCategoryExample> getService() {
		// TODO Auto-generated method stub
		return service;
	}
	
	public  PageBean<ProductCategory> loadDate(ProductCategory cate, PageQueryBean pageQueryBean)
	{

		return getService().selectPageList(new ProductCategoryExample(), pageQueryBean);
	}
	

}
