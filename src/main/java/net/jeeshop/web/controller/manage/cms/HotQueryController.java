package net.jeeshop.web.controller.manage.cms;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.cms.model.FriendLink;
import net.jeeshop.biz.cms.model.FriendLinkExample;
import net.jeeshop.biz.cms.model.HotQuery;
import net.jeeshop.biz.cms.model.HotQueryExample;
import net.jeeshop.biz.cms.service.HotQueryService;
import net.jeeshop.web.controller.manage.ManageBaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 友情链接
 * @author yue
 * 2016年3月5日 上午10:44:12
 */
@Controller
@RequestMapping("/manage/cms/hotQuery/")
public class HotQueryController extends ManageBaseController<HotQuery, HotQueryExample> {

    @Autowired
    private HotQueryService hotQueryService;
    private static final String page_toList = "/manage/cms/hotqueryList";
    private static final String page_toEdit = "/manage/cms/hotqueryEdit";
    private static final String page_toAdd = "/manage/cms/hotqueryEdit";

    private HotQueryController() {
        super.page_toList = page_toList;
        super.page_toEdit = page_toEdit;
        super.page_toAdd = page_toAdd;
    }
    @Override
    public BaseService<HotQuery, HotQueryExample> getService() {
        return hotQueryService;
    }
    
    @RequestMapping("loadData")
	@ResponseBody
	public PageBean<HotQuery> loadData(HotQuery hotQuery,PageQueryBean pageQueryBean) {
    	HotQueryExample hotQueryExample = new HotQueryExample();
    	PageBean<HotQuery> pager =  hotQueryService.selectPageList(hotQueryExample, pageQueryBean);
		return pager;
	}
    
}


