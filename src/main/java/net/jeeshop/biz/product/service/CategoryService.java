package net.jeeshop.biz.product.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.product.client.CategoryMapper;
import net.jeeshop.biz.product.model.Category;
import net.jeeshop.biz.product.model.CategoryExample;
import net.jeeshop.biz.product.model.CategoryExample.Criteria;

/**
 * @author: pj_zhong
 * @email: pj_zhong@163.com
 * @date 2016-3-15
 */
@Service
public class CategoryService extends BaseService<Category,CategoryExample>
{
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	protected BaseMapper<Category, CategoryExample> getMapper() {
		// TODO Auto-generated method stub
		return categoryMapper;
	}
	
	
	/*public List<Category> selectByName(String name)
	{
		CategoryExample Example = new CategoryExample();
		Example.createCriteria().andCateNameEqualTo(name);
		
		 List<Category> cates = getMapper().selectByExample(Example);
		 List<Category> result = new ArrayList<Category>();
		 
		 for(Category c : cates)
		 {
			result.add(selectCategory(c));
		 }
		 
		 return result;
		
	}*/
	
	
	/**
	 * 查询 特定商品分类的所有父分类或子分类。
	 * @param id
	 * @return 返回 该分类的最高级父类(并且包含它)或者自身
	 */
	@Override
	public Category selectById(long id)
	{
		Category result = super.selectById(id);
		
		return selectCategory(result);
	}
	
	/**
	 * 查询 特定商品分类的所有父分类或子分类。
	 * @param c
	 * @return 返回 该分类的最高级父类(并且包含它)或者自身
	 */
	private Category selectCategory(Category  c)
	{
		Category result=null;
		switch(c.getLevel())
		{
			case 1: result = c; break; 
			
			case 2: result = super.selectById(c.getPid()); //获取一层分类
					if(result != null)   result.addChild(c);
					else                 result = c;
			        break;
			        
			case 3: result=  super.selectById(c.getPid()); //获取第二层分类
			 		if(result != null)
			 		{
					  result.addChild(c);
					  result=selectCategory(result);    //递归获取第一层分类
			 		}
			 		else {   result = c; }
					break;
		}
		
		return result;
	}
	
	
	@Override
	 public int deleteById(long id)
	 {
		int row=0;
		Collection<Category> children = loadCateByParent(id);
		
		if(children!=null && !children.isEmpty())
		{
			for(Category c : children)
				row+=deleteById(c.getId());
		}
				
		return row + categoryMapper.inValidated(id);
	 }
	
	
	/**
	 * 根据父类ID查询分类 ,0查询顶级分类
	 * @param Pid 
	 * @return
	 */
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
	
	
	/**
	 * 加载所有分类(1-3级)
	 * @return
	 */
	public Collection<Category> loadAll()
	{	
		CategoryExample query = new CategoryExample();
		query.createCriteria().andIsValidEqualTo("1");
		List<Category> categories = getMapper().selectByExample(query);
		
		//把结果放到Iterchange中转站，方便接下来的分类
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
			if(c.getPid()==0)  {  root.add(c); }
			else               {  parent = Iterchange.get(c.getPid());
			                      if(parent!=null) { parent.addChild(c); }
							   }              	
		}
		return root;
		
	}
	
}
