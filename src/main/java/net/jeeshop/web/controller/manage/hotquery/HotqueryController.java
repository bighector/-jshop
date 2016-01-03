/**
 * 
 */
package net.jeeshop.web.controller.manage.hotquery;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.cms.model.Hotquery;
import net.jeeshop.biz.cms.model.HotqueryExample;
import net.jeeshop.biz.cms.service.HotqueryService;
import net.jeeshop.web.controller.manage.ManageBaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 热门查询管理
 * @author yue
 * 2016年1月1日
 */
@Controller
@RequestMapping("/manage/hotquery/")
public class HotqueryController extends ManageBaseController<Hotquery, HotqueryExample>{
	@Autowired
	private HotqueryService hotqueryService;
	
	private static final String page_toList = "/manage/hotquery/hotqueryList";
	private static final String page_toEdit = "/manage/hotquery/hotqueryEdit";
	private static final String page_toAdd = "/manage/hotquery/hotqueryAdd";
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
	public PageBean<Hotquery> loadData(PageQueryBean pageQueryBean){
		HotqueryExample example = new HotqueryExample();
		PageBean<Hotquery> hotqueryPaper = hotqueryService.selectPageList(example, pageQueryBean);
		return hotqueryPaper;
    }
	

}
