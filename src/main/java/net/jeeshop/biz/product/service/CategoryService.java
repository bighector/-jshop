package net.jeeshop.biz.product.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.product.client.ProductCategoryMapper;
import net.jeeshop.biz.product.model.ProductCategory;
import net.jeeshop.biz.product.model.ProductCategoryExample;
import net.jeeshop.biz.product.model.ProductCategoryExample.Criteria;

/**
 * @author: pj_zhong
 * @email: pj_zhong@163.com
 * @date 2016-3-15
 */
@Service
public class CategoryService extends BaseService<ProductCategory,ProductCategoryExample>
{
	@Autowired
	private ProductCategoryMapper categoryMapper;

	@Override
	protected BaseMapper<ProductCategory, ProductCategoryExample> getMapper() {
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
	public ProductCategory selectById(long id)
	{
		ProductCategory result = super.selectById(id);
		
		return selectCategory(result);
	}
	
	/**
	 * 查询 特定商品分类的所有父分类或子分类。
	 * @param c
	 * @return 返回 该分类的最高级父类(并且包含它)或者自身
	 */
	private ProductCategory selectCategory(ProductCategory c)
	{
		ProductCategory parent=null;
		switch(c.getLevel())
		{
			case 1: parent = c; break; 
		
			default:parent = super.selectById(c.getPid());
					if(parent!= null)  {   
//					                     parent.addChild(c);
					                     parent = selectCategory(parent);
					                   } 
				    else               { parent = c; }
		}
		
		return parent;
	}
	
	
	@Override
	 public int deleteById(long id)
	 {
		int row=0;
		Collection<ProductCategory> children = loadCateByParent(id);
		
		if(children!=null && !children.isEmpty())
		{
			for(ProductCategory c : children)
				row+=deleteById(c.getId());
		}
				
		return row + categoryMapper.inValidated(id);
	 }
	
	
	/**
	 * 根据父类ID查询分类 ,0查询顶级分类
	 * @param Pid 
	 * @return
	 */
	public  Collection<ProductCategory> loadCateByParent(Long Pid)
	{
		if(Pid==null)
		    Pid=0L;
		
		ProductCategoryExample query = new ProductCategoryExample();
		Criteria  condition= query.createCriteria();
		condition.andIsValidEqualTo("1");
		condition.andPidEqualTo(Pid);
		
		
		return getMapper().selectByExample(query);
	}
	
	
	/**
	 * 加载所有分类(1-3级)
	 * @return
	 */
	public Collection<ProductCategory> loadAll()
	{	
		ProductCategoryExample query = new ProductCategoryExample();
		query.createCriteria().andIsValidEqualTo("1");
		List<ProductCategory> categories = getMapper().selectByExample(query);
		
		//把结果放到Iterchange中转站，方便接下来的分类
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
			if(c.getPid()==0)  {  root.add(c); }
			else               {  parent = Iterchange.get(c.getPid());
//			                      if(parent!=null) { parent.addChild(c); }
							   }              	
		}
		return root;
		
	}
	
}
