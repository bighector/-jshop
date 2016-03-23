package net.jeeshop.product.controller;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.product.model.Category;
import net.jeeshop.biz.product.model.CategoryExample;
import net.jeeshop.biz.product.model.ProductSpec;
import net.jeeshop.biz.product.model.ProductSpecExample;
import net.jeeshop.biz.product.service.CategoryService;
import net.jeeshop.biz.product.service.ProductSpecService;
import net.jeeshop.web.controller.manage.ManageBaseController;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: pj_zhong
 * @email: pj_zhong@163.com
 * @date Mar 20, 2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class CategoryControllerTest extends ManageBaseController<Category,CategoryExample>
{
	@Autowired
	private CategoryService service;
	
	private static String page_toList = null;
	private static String page_toAdd  = null;
	private static String page_toEdit = null;
	
	@org.junit.Test
	public void Test()
	{
		CategoryControllerTest test= new CategoryControllerTest();
		
		PageQueryBean bean = new PageQueryBean();
		
		System.out.println(test.loadDate(null, bean));
		
		
		
	
	}
	
	public CategoryControllerTest()
	{
		super.page_toAdd  = this.page_toAdd;
		super.page_toEdit = this.page_toEdit;
		super.page_toList = this.page_toList;
	}

	@Override
	public BaseService<Category, CategoryExample> getService() {
		// TODO Auto-generated method stub
		return service;
	}
	
	public  PageBean<Category> loadDate(Category cate, PageQueryBean pageQueryBean)
	{

		return getService().selectPageList(new CategoryExample(), pageQueryBean);
	}
	

}
