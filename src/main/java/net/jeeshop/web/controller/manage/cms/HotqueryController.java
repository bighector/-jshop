/**
 * 
 */
package net.jeeshop.web.controller.manage.cms;


import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.cms.model.Hotquery;
import net.jeeshop.biz.cms.model.HotqueryExample;
import net.jeeshop.biz.cms.service.HotqueryService;
import net.jeeshop.web.controller.manage.ManageBaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 热门查询管理
 * @author yue
 * 2016年1月1日
 */
@Controller
@RequestMapping("/manage/cms/hotQuery/")
public class HotqueryController extends ManageBaseController<Hotquery, HotqueryExample>{
	@Autowired
	private HotqueryService hotqueryService;
	
	private static final String page_toList = "/manage/cms/hotqueryList";
	private static final String page_toEdit = "/manage/cms/hotqueryEdit";
	private static final String page_toAdd = "/manage/cms/hotqueryEdit";
	private HotqueryController() {
		super.page_toList = page_toList;
		super.page_toAdd = page_toAdd;
		super.page_toEdit = page_toEdit;
	}
	/* 
	 * @return 
	 */
	@Override
	public BaseService<Hotquery, HotqueryExample> getService() {
		return hotqueryService;
	}
	
	@RequestMapping("loadData")
	@ResponseBody
	public PageBean<Hotquery> loadData(HotqueryExample example,PageQueryBean pageQueryBean){
		PageBean<Hotquery> hotqueryList = hotqueryService.selectPageList(example, pageQueryBean);
		return hotqueryList;
    }

}
