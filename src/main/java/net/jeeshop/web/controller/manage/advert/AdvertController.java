package net.jeeshop.web.controller.manage.advert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.jeeshop.biz.advert.model.Advert;
import net.jeeshop.biz.advert.model.AdvertExample;
import net.jeeshop.biz.advert.service.AdvertService;
import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.system.bean.SysUserBean;
import net.jeeshop.biz.system.model.SysRoleExample;
import net.jeeshop.biz.system.model.SysUser;
import net.jeeshop.biz.system.model.SysUserExample;
import net.jeeshop.biz.system.service.UserService;
import net.jeeshop.web.controller.manage.ManageBaseController;
import net.jeeshop.web.util.LoginUserHolder;

@Controller
@RequestMapping("/manage/advert")
public class AdvertController extends ManageBaseController<Advert, AdvertExample>{
	  private static final String page_toList = "/manage/advert/advertList";
	    private static final String page_toAdd = "/manage/advert/advertEdit";
	    private static final String page_toEdit = "/manage/advert/advertEdit";
	    private static final String page_home = "/manage/advert/home";
	    private static final String page_initManageIndex = page_home;

	
	 @Autowired
	    private AdvertService advertService;
	 
	 @Override
	 public BaseService<Advert, AdvertExample> getService() {
		 // TODO Auto-generated method stub
		 return advertService;
	 }
	 
	 public AdvertController() {
		 super.page_toEdit = page_toEdit;
		 super.page_toList = page_toList;
		 super.page_toAdd = page_toAdd;
	 }
	 
	  @RequestMapping("loadData")
	    @ResponseBody
	    public PageBean<Advert> loadData(AdvertExample queryParams, PageQueryBean pageQueryBean) {
		  System.out.println("--------loadData-----");
	        PageBean pager =advertService.selectPageList(queryParams, pageQueryBean);
	        return pager;
	    }
	 
}
