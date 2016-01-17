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
import net.jeeshop.biz.product.model.Brand;
import net.jeeshop.biz.product.model.BrandExample;
import net.jeeshop.biz.product.service.BrandService;
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
public class BrandController extends  ManageBaseController<Brand, BrandExample>{
	
	@Autowired
	BrandService brandService;
	
	@Override
	public BaseService<Brand, BrandExample> getService() {
		return brandService;
	}
	
	public BrandController() {
        super.page_toList = "manage/product/brand/brandList";
        super.page_toEdit = "manage/product/brand/editBrand";
        super.page_toAdd = "manage/product/brand/editBrand";
	}
	
	@RequestMapping("loadData")
    @ResponseBody
    public PageBean<Brand> loadData(Brand queryParams, PageQueryBean pageQueryBean) {
		BrandExample example = new BrandExample();
        example.setOrderByClause("ordinal asc");
        PageBean<Brand> pager = brandService.selectPageList(example, pageQueryBean);
        return pager;
    }
	
}
