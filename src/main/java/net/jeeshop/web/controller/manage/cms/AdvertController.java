package net.jeeshop.web.controller.manage.cms;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.cms.model.Advert;
import net.jeeshop.biz.cms.model.AdvertExample;
import net.jeeshop.biz.cms.service.AdvertService;
import net.jeeshop.web.controller.manage.ManageBaseController;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manage/cms/advert/")
public class AdvertController extends ManageBaseController<Advert, AdvertExample>{
	  private static final String page_toList = "/manage/cms/advertList";
	    private static final String page_toAdd = "/manage/cms/advertEdit";
	    private static final String page_toEdit = "/manage/cms/advertEdit";

	
	 @Autowired
	    private AdvertService advertService;
	 
	 @Override
	 public BaseService<Advert, AdvertExample> getService() {
		 return advertService;
	 }
	 
	 public AdvertController() {
		 super.page_toEdit = page_toEdit;
		 super.page_toList = page_toList;
		 super.page_toAdd = page_toAdd;
	 }
	 
//	  @RequestMapping("loadData")
//	    @ResponseBody
//	    public PageBean<Advert> loadData(AdvertExample queryParams, PageQueryBean pageQueryBean) {
//		  System.out.println("--------loadData-----");
//	        PageBean pager =advertService.selectPageList(queryParams, pageQueryBean);
//	        return pager;
//	    }
	 
	  
	  @SuppressWarnings("unchecked")
		@RequestMapping("loadData")
	    @ResponseBody
	    public PageBean<Advert> loadData(Advert advert, PageQueryBean pageQueryBean) {
		  AdvertExample advertExample=new AdvertExample();
		  AdvertExample.Criteria criteria = advertExample.createCriteria();
	        if (StringUtils.isNotBlank(advert.getTitle())) {
	            criteria.andTitleLike( advert.getTitle());
	        }
	        if (StringUtils.isNotBlank(advert.getCode())) {
	            criteria.andCodeLike(advert.getCode());
	        }
	        advertExample.setOrderByClause("id");
//			@SuppressWarnings("rawtypes")
			PageBean pager = advertService.selectPageList(advertExample, pageQueryBean);
	        return pager;
	    }
}
