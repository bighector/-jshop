package net.jeeshop.web.controller.manage.cms;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.cms.model.FriendLink;
import net.jeeshop.biz.cms.model.FriendLinkExample;
import net.jeeshop.biz.cms.service.FriendLinkService;
import net.jeeshop.web.controller.manage.ManageBaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 友情链接
 * @author yue
 * 2016年3月5日 上午10:44:12
 */
@Controller
@RequestMapping("/manage/cms/friendLink/")
public class FriendLinkController extends ManageBaseController<FriendLink, FriendLinkExample> {

    @Autowired
    private FriendLinkService friendsLinkService;
    private static final String page_toList = "/manage/cms/friendLinkList";
    private static final String page_toEdit = "/manage/cms/friendLinkEdit";
    private static final String page_toAdd = "/manage/cms/friendLinkEdit";

    private FriendLinkController() {
        super.page_toList = page_toList;
        super.page_toEdit = page_toEdit;
        super.page_toAdd = page_toAdd;
    }
    @Override
    public BaseService<FriendLink, FriendLinkExample> getService() {
        return friendsLinkService;
    }
    
    @RequestMapping("loadData")
	@ResponseBody
	public PageBean<FriendLink> loadData(FriendLink friendLink,PageQueryBean pageQueryBean) {
    	FriendLinkExample friendLinkExample = new FriendLinkExample();
    	PageBean<FriendLink> pager =  friendsLinkService.selectPageList(friendLinkExample, pageQueryBean);
		return pager;
	}
}


