package net.jeeshop.web.controller.manage.product;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.product.bean.ProductCategoryBean;
import net.jeeshop.biz.product.model.ProductCategory;
import net.jeeshop.biz.product.model.ProductCategoryExample;
import net.jeeshop.biz.product.service.ProductCategoryService;
import net.jeeshop.web.controller.manage.ManageBaseController;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author: pj_zhong
 * @email: pj_zhong@163.com
 * @date Mar 17, 2016
 */
@Controller
@RequestMapping("/manage/product/category")
public class ProductCategoryController extends ManageBaseController<ProductCategory,ProductCategoryExample>
{
	@Autowired
	private ProductCategoryService service;

	private static final String page_toList = "/manage/product/productCategoryList";
	private static final String page_toAdd = "/manage/product/productCategoryEdit";
	private static final String page_toEdit = "/manage/product/productCategoryEdit";
	
	public ProductCategoryController()
	{
		super.page_toAdd  = page_toAdd;
		super.page_toEdit = page_toEdit;
		super.page_toList = page_toList;
	}

	@Override
	public BaseService<ProductCategory, ProductCategoryExample> getService()
	{
		return service;
	}

	@ModelAttribute("catalogs")
	public List<ProductCategoryBean> getCatalogs() {
		return service.loadRoot();
	}
	/**
	 * 公共的分页方法
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	@RequestMapping("selectList")
	public String selectList(ModelMap modelMap) {
		List<ProductCategoryBean> root = service.loadRoot();
		List<ProductCategoryBean> result = Lists.newArrayList();
		for (ProductCategoryBean cata : root) {
			appendChildren(cata, result);
		}
		modelMap.addAttribute("list", result);
		return page_toList;
	}

	private void appendChildren(ProductCategoryBean catalog, List<ProductCategoryBean> list) {
		if (catalog == null) {
			return;
		}
		list.add(catalog);
		if (catalog.getChildren() != null && catalog.getChildren().size() > 0) {
			for (ProductCategoryBean cata : catalog.getChildren()) {
				appendChildren(cata, list);
			}
		}
	}

	@RequestMapping("loadByPid")
    @ResponseBody
	public String loadByPid(@RequestParam(required = false, defaultValue = "0")String pid)
	{
		Long parent=Long.parseLong(pid);
		
	   return writer(service.loadCategoryByParent(parent));
	}


	/**
	 * 唯一性检查
	 *
	 * @return
	 */
	@RequestMapping(value = "uniqueCode")
	@ResponseBody
	public String uniqueCode(ProductCategory e){
		if (StringUtils.isNotBlank(e.getCategoryCode())) {
			ProductCategory catalog = service.selectByCategoryCode(e.getCategoryCode());
			if (catalog == null) {
				return "{\"ok\":\"编码可以使用!\"}";
			} else {
				if (e.getId() != null && e.getId().compareTo(catalog.getId()) == 0) {
					//更新自己的编码
					return "{\"ok\":\"编码可以使用!\"}";
				} else {
					return "{\"error\":\"编码已经存在!\"}";
				}
			}
		} else {
			return "{\"error\":\"编码不能为空!\"}";
		}
	}
    @RequestMapping("loadAll")
    @ResponseBody
    public String loadAllCategory()
    {
    	return writer(service.loadAll());
    }



    /**
     * JSON数据输出
     * @return
     */
    private String writer(Collection<ProductCategory> list)
    {
		return new Gson().toJson(list);
    }

}
