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
import net.jeeshop.biz.product.model.ProductBrand;
import net.jeeshop.biz.product.model.ProductBrandExample;
import net.jeeshop.biz.product.service.ProductBrandService;
import net.jeeshop.web.controller.manage.ManageBaseController;

/**
 *	商品品牌管理Controller
 *
 * @author Leolione
 * @email leolione@outlook.com
 * @since V1.0
 */
@Controller
@RequestMapping("/manage/brand")
public class ProductBrandController extends  ManageBaseController<ProductBrand, ProductBrandExample>{
	
	@Autowired
	ProductBrandService productBrandService;
	
	@Override
	public BaseService<ProductBrand, ProductBrandExample> getService() {
		return productBrandService;
	}
	
	public ProductBrandController() {
        super.page_toList = "manage/product/brand/brandList";
        super.page_toEdit = "manage/product/brand/editBrand";
        super.page_toAdd = "manage/product/brand/editBrand";
	}
	
	@RequestMapping("loadData")
    @ResponseBody
    public PageBean<ProductBrand> loadData(ProductBrand queryParams, PageQueryBean pageQueryBean) {
		ProductBrandExample example = new ProductBrandExample();
        example.setOrderByClause("ordinal desc");
        PageBean<ProductBrand> pager = productBrandService.selectPageList(example, pageQueryBean);
        return pager;
    }
	
	/**
	 * 添加商品品牌
	 */
    @Override
    @RequestMapping("insert")
    public String insert(@ModelAttribute("e") ProductBrand productBrand, RedirectAttributes flushAttrs){
        return super.insert(productBrand, flushAttrs);
    }
    
    
    /**
     * 修改商品品牌
     */
    @Override
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("e") ProductBrand productBrand, RedirectAttributes flushAttrs) {
        return super.update(productBrand, flushAttrs);
    }
    
    /**
     * 删除商品品牌
     */
    @Override
    @RequestMapping(value = "deletes", method = RequestMethod.POST)
    public String deletes(Long[] ids, RedirectAttributes flushAttrs) {
    	return super.deletes(ids, flushAttrs);
    }

}
