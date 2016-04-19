package net.jeeshop.biz.product.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.product.client.ProductCategoryMapper;
import net.jeeshop.biz.product.model.ProductCategory;
import net.jeeshop.biz.product.model.ProductCategoryExample;
import net.jeeshop.biz.product.model.ProductCategoryExample.Criteria;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: pj_zhong
 * @email: pj_zhong@163.com
 * @date Mar 15, 2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
@Service
public class CategoryServiceTest extends BaseService<ProductCategory,ProductCategoryExample>
{
	@Autowired
	private ProductCategoryMapper categoryMapper;

	@Override
	protected BaseMapper<ProductCategory, ProductCategoryExample> getMapper() {
		// TODO Auto-generated method stub
		return categoryMapper;
	}
	
	public void update()
	{
		ProductCategory test = new ProductCategory();
		System.out.println(super.selectPageList(new ProductCategoryExample(), new PageQueryBean()));
	}
	

	public  void  loadCateByParent()
	{
		/*CategoryExample query = null;
		Long Pid=0L;
	
		
			query = new CategoryExample();
			query.createCriteria().andPidEqualTo(Pid);
			for(Category c : getMapper().selectByExample(query))
			{
				System.out.println(c);
			}*/
		
//		 categoryMapper.inValidated(6L);
		
	}
	
	public void loadByParentId()
	{
        List<ProductCategory> categories = categoryMapper.selectByExample(null);
		
		//把结果放到Iterchange 里面，方便接下来的分类
		HashMap<Long,ProductCategory> Iterchange = new HashMap<Long,ProductCategory>();
		for(ProductCategory c: categories)
		{
			   Iterchange.put(c.getId(), c);
		}
		
		
		List<ProductCategory> root = new ArrayList<ProductCategory>();
		ProductCategory parent;
		
		
		//分类  
		for(ProductCategory c: Iterchange.values())
		{
			if(c.getParentId()==0)  {  root.add(c);  }
			else               {  
				                  parent = Iterchange.get(c.getParentId());
			                      if(parent!=null) {
//									  parent.addChild(c);
}
							   }              	
		}
		
		
		
	}
	
	@Test
	public void Test()
	{
	    ProductCategory c = super.selectById(3L);
	    
	    System.out.println(selectCategory(c));
	}
	
	public List<ProductCategory> selectByName(String name)
	{
		ProductCategoryExample Example = new ProductCategoryExample();
		Example.createCriteria().andCategoryNameEqualTo(name);
		
		System.out.println(Example.getOredCriteria());
		
		 List<ProductCategory> cates = getMapper().selectByExample(Example);
		 
		 for(ProductCategory c : cates)
		 {
			 c =  selectCategory(c);
			 System.out.println(c);
		 }
		 
		 return cates;
		
	}
	

	private ProductCategory selectCategory(ProductCategory c)
	{
		ProductCategory parent=null;
		switch(c.getLevel())
		{
			case 1: parent = c; break; 
			
			default:parent = super.selectById(c.getParentId());
					if(parent!= null)  {   
//						                 parent.addChild(c);
						                 parent = selectCategory(parent);
									   }
					else               { parent = c; }
		}
		
		return parent;
	}
	
	public  Collection<ProductCategory> loadCateByParent(Long Pid)
	{
		if(Pid==null)
		    Pid=0L;
		
		ProductCategoryExample query = new ProductCategoryExample();
		Criteria  condition= query.createCriteria();
		condition.andIsValidEqualTo(true);
		condition.andParentIdEqualTo(Pid);
		
		
		return getMapper().selectByExample(query);
	}
	
		
	
}
