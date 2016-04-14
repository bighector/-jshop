package net.jeeshop.web.controller.manage.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.product.model.ProductAttr;
import net.jeeshop.biz.product.model.ProductAttrExample;
import net.jeeshop.biz.product.service.ProductAttrService;
import net.jeeshop.web.controller.manage.ManageBaseController;

/**
 *	商品属性管理Controller
 *
 * @author Sun
 * @email java_henan@163.com
 * @since V1.0
 */
@Controller
@RequestMapping("manage/product/attr")
public class ProductAttrController extends ManageBaseController<ProductAttr, ProductAttrExample>{
	
	@Autowired
	ProductAttrService productAttrService;
	
	@Override
	public BaseService<ProductAttr, ProductAttrExample> getService() {
		return productAttrService;
	}
	
	public ProductAttrController() {
        super.page_toList = "manage/product/attr/productAttrList";
        super.page_toEdit = "manage/product/attr/editProductAttr";
        super.page_toAdd = "manage/product/attr/editProductAttr";
	}
	
	@RequestMapping("loadData")
    @ResponseBody
    public PageBean<ProductAttr> loadData(ProductAttr queryParams, PageQueryBean pageQueryBean) 
    {
		ProductAttrExample example = new ProductAttrExample();
        example.setOrderByClause("ordinal asc");
        PageBean<ProductAttr> pager = productAttrService.selectPageList(example, pageQueryBean);
        return pager;
    }
	
	/**
	 * 添加商品属性
	 */
    @Override
    @RequestMapping("insert")
    public String insert(@ModelAttribute("e") ProductAttr productAttr, RedirectAttributes flushAttrs){
        return super.insert(productAttr, flushAttrs);
    }
    
    
    /**
     * 修改商品属性
     */
    @Override
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("e") ProductAttr productAttr, RedirectAttributes flushAttrs) {
        return super.update(productAttr, flushAttrs);
    }
    
    /**
     * 删除商品属性
     */
    @Override
    @RequestMapping(value = "deletes", method = RequestMethod.POST)
    public String deletes(Long[] ids, RedirectAttributes flushAttrs) {
    	return super.deletes(ids, flushAttrs);
    }

}
