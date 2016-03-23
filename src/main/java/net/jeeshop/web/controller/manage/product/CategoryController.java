package net.jeeshop.web.controller.manage.product;

import java.util.Collection;

import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.product.model.Category;
import net.jeeshop.biz.product.model.CategoryExample;
import net.jeeshop.biz.product.service.CategoryService;
import net.jeeshop.web.controller.manage.ManageBaseController;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: pj_zhong
 * @email: pj_zhong@163.com
 * @date Mar 17, 2016
 */
@Controller
@RequestMapping("/manage/category")
public class CategoryController extends ManageBaseController<Category,CategoryExample>
{
	@Autowired
	private CategoryService service;
	
	private static String page_toList = "manage/product/category/categoryList";
	private static String page_toAdd  = null;
	private static String page_toEdit = null;
	
	public CategoryController()
	{
		super.page_toAdd  = CategoryController.page_toAdd;
		super.page_toEdit = CategoryController.page_toEdit;
		super.page_toList = CategoryController.page_toList;
	}

	@Override
	public BaseService<Category, CategoryExample> getService()
	{
		return service;
	}
	
	@Override
	public void beforeToList(ModelMap modelMap) 
	{
	     modelMap.put("categories", service.loadCateByParent(0L));
	}
	
	
	@RequestMapping("loadByPid")
    @ResponseBody
	public String loadByPid(@RequestParam(required = false, defaultValue = "0")String pid)
	{
		Long parent=Long.parseLong(pid);
		
	   return writer(service.loadCateByParent(parent));
	}
	
	
    @RequestMapping("loadAll")
    @ResponseBody
    public String loadAllCate()
    {
    	return writer(service.loadAll());
    }
    
    
    
    /**
     * JSON数据输出
     * @param obj
     * @param req 
     * @return
     */
    private String writer(Collection<Category> list) 
    {
        JSONArray json = JSONArray.fromObject(list);
        String jsonStr = json.toString();
        try {
            return jsonStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

}
