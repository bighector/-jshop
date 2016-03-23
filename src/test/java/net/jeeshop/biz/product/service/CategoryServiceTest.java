package net.jeeshop.biz.product.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.product.client.CategoryMapper;
import net.jeeshop.biz.product.model.Category;
import net.jeeshop.biz.product.model.CategoryExample;
import net.jeeshop.biz.product.model.CategoryExample.Criteria;

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
public class CategoryServiceTest extends BaseService<Category,CategoryExample>
{
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	protected BaseMapper<Category, CategoryExample> getMapper() {
		// TODO Auto-generated method stub
		return categoryMapper;
	}
	
	public void update()
	{
		Category test = new Category();
		System.out.println(super.selectPageList(new CategoryExample(), new PageQueryBean()));
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
		
		 categoryMapper.inValidated(6L);
		
	}
	
	public void loadByParentId()
	{
        List<Category> categories = categoryMapper.selectByExample(null);
		
		//把结果放到Iterchange 里面，方便接下来的分类
		HashMap<Long,Category> Iterchange = new HashMap<Long,Category>();
		for(Category c: categories)
		{
			   Iterchange.put(c.getId(), c);
		}
		
		
		List<Category> root = new ArrayList<Category>();
		Category parent;
		
		
		//分类  
		for(Category c: Iterchange.values())
		{
			if(c.getPid()==0)  {  root.add(c);  }
			else               {  
				                  parent = Iterchange.get(c.getPid());
			                      if(parent!=null) { parent.addChild(c); }
							   }              	
		}
		
		
		
	}
	
	@Test
	public void Test()
	{
	    Category c = super.selectById(3L);
	    
	    System.out.println(selectCategory(c));
	}
	
	public List<Category> selectByName(String name)
	{
		CategoryExample Example = new CategoryExample();
		Example.createCriteria().andCateNameEqualTo(name);
		
		System.out.println(Example.getOredCriteria());
		
		 List<Category> cates = getMapper().selectByExample(Example);
		 
		 for(Category c : cates)
		 {
			 c =  selectCategory(c);
			 System.out.println(c);
		 }
		 
		 return cates;
		
	}
	

	private Category selectCategory(Category  c)
	{
		Category parent=null;
		switch(c.getLevel())
		{
			case 1: parent = c; break; 
			
			default:parent = super.selectById(c.getPid());
					if(parent!= null)  {   
						                 parent.addChild(c);
						                 parent = selectCategory(parent);
									   }
					else               { parent = c; }
		}
		
		return parent;
	}
	
	public  Collection<Category> loadCateByParent(Long Pid)
	{
		if(Pid==null)
		    Pid=0L;
		
		CategoryExample query = new CategoryExample();
		Criteria  condition= query.createCriteria();
		condition.andIsValidEqualTo("1");
		condition.andPidEqualTo(Pid);
		
		
		return getMapper().selectByExample(query);
	}
	
		
	
}
