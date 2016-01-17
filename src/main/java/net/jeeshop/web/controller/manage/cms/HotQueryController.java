/**
 * 
 */
package net.jeeshop.web.controller.manage.cms;


import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.cms.model.HotQuery;
import net.jeeshop.biz.cms.model.HotQueryExample;
import net.jeeshop.biz.cms.service.HotQueryService;
import net.jeeshop.biz.system.model.SysUser;
import net.jeeshop.web.controller.manage.ManageBaseController;

import net.jeeshop.web.util.LoginUserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

/**
 * 热门查询管理
 * @author yue
 * 2016年1月1日
 */
@Controller
@RequestMapping("/manage/cms/hotQuery/")
public class HotQueryController extends ManageBaseController<HotQuery, HotQueryExample>{
	@Autowired
	private HotQueryService hotqueryService;
	
	private static final String page_toList = "/manage/cms/hotQueryList";
	private static final String page_toEdit = "/manage/cms/hotQueryEdit";
	private static final String page_toAdd = "/manage/cms/hotQueryEdit";
	private HotQueryController() {
		super.page_toList = page_toList;
		super.page_toAdd = page_toAdd;
		super.page_toEdit = page_toEdit;
	}
	/* 
	 * @return 
	 */
	@Override
	public BaseService<HotQuery, HotQueryExample> getService() {
		return hotqueryService;
	}
	
	@RequestMapping("loadData")
	@ResponseBody
	public PageBean<HotQuery> loadData(HotQueryExample example,PageQueryBean pageQueryBean){
		PageBean<HotQuery> hotqueryList = hotqueryService.selectPageList(example, pageQueryBean);
		return hotqueryList;
    }

	/* 新增方法
	 * @param e
	 * @param flushAttrs
	 * @return 
	 */
	@Override
	public String insert(HotQuery e, RedirectAttributes flushAttrs) {
		SysUser user = LoginUserHolder.getLoginUser();
		e.setCreateAccount(user.getUsername());//创建用户
		e.setCreateTime(new Date());
		return super.insert(e, flushAttrs);
	}
	
	/* 更新方法
	 * @param e
	 * @param flushAttrs
	 * @return 
	 */
	@Override
	public String update(HotQuery e, RedirectAttributes flushAttrs) {
		SysUser user = LoginUserHolder.getLoginUser();
		e.setUpdateAccount(user.getUsername());//创建用户
		e.setUpdateTime(new Date());
		return super.update(e, flushAttrs);
	}

}
