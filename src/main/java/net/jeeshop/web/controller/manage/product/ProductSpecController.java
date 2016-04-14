package net.jeeshop.web.controller.manage.product;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.product.model.ProductSpec;
import net.jeeshop.biz.product.model.ProductSpecExample;
import net.jeeshop.biz.product.service.ProductSpecService;
import net.jeeshop.web.controller.manage.ManageBaseController;


/**
 * @author: pj_zhong
 * @email: pj_zhong@163.com
 * @date 2016-1-23
 * @since: V1.0
 */
@Controller
@RequestMapping("/manage/product/spec")
public class ProductSpecController extends ManageBaseController<ProductSpec, ProductSpecExample> 
{
	private static String page_toList = "manage/product/spec/specList";
	private static String page_toAdd  = "manage/product/spec/specAddOrUpdate";
	private static String page_toEdit = page_toAdd;
	
	@Autowired
	private ProductSpecService specServier;
	
	@Override
	public BaseService<ProductSpec, ProductSpecExample> getService() {
		return specServier;
	}
	
	public ProductSpecController()
	{
	    super.page_toAdd  = page_toAdd;
	    super.page_toEdit = page_toEdit;
	    super.page_toList = page_toList;
	}
	
	@RequestMapping("loadData")
	@ResponseBody
	public PageBean<ProductSpec> loadData(ProductSpec spec, PageQueryBean pageQueryBean)
	{
		ProductSpecExample example=new ProductSpecExample();
		
		//规格名称查询
		if(spec.getSpecName()!=null && !spec.getSpecName().equals(""))
		{
			ProductSpecExample.Criteria sel = example.createCriteria();
			sel.andSpecNameLike("%" +spec.getSpecName() + "%");
		}

		return getService().selectPageList(example, pageQueryBean);
	}
}
