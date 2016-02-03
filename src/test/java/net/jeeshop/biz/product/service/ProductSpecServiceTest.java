package net.jeeshop.biz.product.service;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.product.client.ProductSpecMapper;
import net.jeeshop.biz.product.client.ProductSpecValMapperExt;
import net.jeeshop.biz.product.model.ProductSpec;
import net.jeeshop.biz.product.model.ProductSpecExample;
import net.jeeshop.biz.product.model.ProductSpecVal;

/**
 * @author: pj_zhong
 * @email: pj_zhong@163.com
 * @date Jan 19, 2016
 * @since: V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
@Service
public class ProductSpecServiceTest extends BaseService<ProductSpec,ProductSpecExample>
{
	@Autowired
	private ProductSpecMapper productspec;
	
	@Autowired
	private ProductSpecValMapperExt productspecvalext;
	
	@Override
	protected BaseMapper<ProductSpec,ProductSpecExample> getMapper()
	{
		return productspec;
	}
	
	@Override
	public long insert(ProductSpec spec)
	{
		int inserts=0;
		
		/*插入规格*/
		inserts+=getMapper().insert(spec);
		
		//将前台的数据装换成 List<ProdcutSpecVal>
		if(spec.getVaList()==null || spec.getVaList().size() <= 0)
		{
			spec.setVaList( getValsList(spec.getId(),spec.getSpecVals(),spec.getSpecOrders()) );
		}
		
		spec.setCreateTime(new Date());
		spec.setUpdateTime(spec.getCreateTime());
 
		/*插入规格值*/
		inserts+=InsertSpecValues(spec);
		
		return inserts;
	}
	
	@Override
	public int update(ProductSpec spec)
	{
		int updates=0;
		
		//将前台的数据装换成 List<ProdcutSpecVal>
		if(spec.getVaList()==null || spec.getVaList().size() <= 0)
		{
			spec.setVaList( getValsList(spec.getId(),spec.getSpecVals(),spec.getSpecOrders()) );
		}
		
		/*更新 规格*/
		updates+=getMapper().updateByPrimaryKey(spec);
		
		/*删除旧规格值*/
		productspecvalext.deleteBySpecId(spec.getId());
		
		/*插入新的规格值*/
		updates+=InsertSpecValues(spec);	
		
		return updates;
	}
	
	@Override
	public int deleteById(long id)
	{
		int deletes=0;
		
		/*删除规格*/
		deletes+=getMapper().deleteByPrimaryKey(id);
		
		/*删除规格值*/
		deletes+=productspecvalext.deleteBySpecId(id);
		
		return deletes;
	}
	
	@Override
	public ProductSpec selectById(long id)
	{
		ProductSpec spec = getMapper().selectByPrimaryKey(id);
		spec.setVaList(productspecvalext.selectBySpecId(id));
		return spec;
	}
	
	public PageBean<ProductSpec> selectPageList(final ProductSpecExample example, PageQueryBean pageQueryBean)
	{
		return executePageQuery(new PageQueryExecutor<ProductSpec>() 
		{
            @Override
            public List<ProductSpec> executeQuery() 
            {
            	List<ProductSpec> specs = getMapper().selectByExample(example);
            	
            	for(ProductSpec e : specs)
            	{
            		e.setVaList(productspecvalext.selectBySpecId(e.getId()));
            	}
            	
            	return specs;
            }
        }, pageQueryBean);
	}
	
	public List<ProductSpecVal> getValsList(long specId,String[] spec_val,Integer[] ordinal)
	{
		if(specId > 0 && spec_val!= null && spec_val.length > 0 )
		{
		   List<ProductSpecVal> vals = new ArrayList<ProductSpecVal>();
		   
		   for(int i=0;i<spec_val.length;i++)
		   {
			   if(spec_val[i].equals("") || ordinal[i]==0) continue;
			   ProductSpecVal e = new ProductSpecVal();
			   e.setSpecId(specId);
			   e.setSpecVal(spec_val[i]);
			   e.setOrdinal(ordinal[i]);
			   vals.add(e);
		   }
		   
		   return vals;
		}
		
		return null;
	}
	
	@org.junit.Test
	public void Test()
	{
		ProductSpecExample sel = new ProductSpecExample();
		
		ProductSpecExample.Criteria test = sel.createCriteria();
		
		test.andSpecificationLike("%C%");
		test.andCatagoryNameLike("%%");
		
		
		
		System.out.println(getMapper().selectByExample(sel));
	}
	
	/**
	 * 插入规格值，并返回插入的数目，如果没有则返回0
	 * @param spec
	 * @return
	 */
	private int InsertSpecValues(ProductSpec spec)
	{
		 if( spec.getVaList() != null && spec.getVaList().size() > 0 )
		 { 
			return  productspecvalext.insertSpecValues(spec.getVaList());
		 }
		 
		 return 0;
	}
}
