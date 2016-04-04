/**
 * 
 */
package net.jeeshop.web.controller.manage.cms;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.cms.model.NotifyTemplate;
import net.jeeshop.biz.cms.model.NotifyTemplateExample;
import net.jeeshop.biz.cms.service.NotifyTemplateService;
import net.jeeshop.web.controller.manage.ManageBaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 通知模板管理
 * @author yue
 * 2016年1月11日 下午10:32:53
 */
@Controller
@RequestMapping("/manage/cms/notifyTemplate/")
public class NotifyTemplateController extends ManageBaseController<NotifyTemplate, NotifyTemplateExample>{
	@Autowired
	private NotifyTemplateService notifyTemplateService;
	
	private static final String page_toList = "/manage/cms/notifyTemplateList";
	private static final String page_toEdit = "/manage/cms/notifyTemplateEdit";
	private static final String page_toAdd = "/manage/cms/notifyTemplateEdit";
	private NotifyTemplateController() {
		super.page_toList = page_toList;
		super.page_toAdd = page_toAdd;
		super.page_toEdit = page_toEdit;
	}
	/* 
	 * @return 
	 */
	@Override
	public BaseService<NotifyTemplate, NotifyTemplateExample> getService() {
		return notifyTemplateService;
	}
	
	@RequestMapping("loadData")
	@ResponseBody
	public PageBean<NotifyTemplate> loadData(NotifyTemplateExample example,PageQueryBean pageQueryBean){
		PageBean<NotifyTemplate> notifyTemplateList = notifyTemplateService.selectPageList(example, pageQueryBean);
		return notifyTemplateList;
    }
	
	/* 新增方法
	 * @param e
	 * @param flushAttrs
	 * @return 
	 */
	@Override
	public String insert(NotifyTemplate e, RedirectAttributes flushAttrs) {
		e.setValidStatus("1");//默认有效
		return super.insert(e, flushAttrs);
	}
	
	@RequestMapping(value="selectTemplateByKey",method=RequestMethod.POST)
	public  void  selectTemplateByKey(@RequestParam("tplKey")String tplKey,NotifyTemplateExample example){
		example.createCriteria().andTplTypeEqualTo(tplKey);
		List<NotifyTemplate> list = notifyTemplateService.selectByExample(example);
		//FIXME
//		writeToJson(list);
	}

	

}
