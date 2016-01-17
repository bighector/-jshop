package net.jeeshop.web.controller.manage.cms;

import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.cms.model.FriendLink;
import net.jeeshop.biz.cms.model.FriendLinkExample;
import net.jeeshop.biz.cms.service.FriendLinkService;
import net.jeeshop.web.controller.manage.ManageBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by machenike on 2016/1/6.
 */
@Controller
@RequestMapping("/manage/navigation")
public class FriendLinkController extends ManageBaseController<FriendLink, FriendLinkExample> {

    @Autowired
    private FriendLinkService friendsLinkService;
    private static final String page_toList = "/manage/cms/friendLinkList";
    private static final String page_toEdit = "/manage/navigation/friendLinkEdit";

    private FriendLinkController() {
        super.page_toList = page_toList;
        super.page_toEdit = page_toEdit;
    }
    @Override
    public BaseService<FriendLink, FriendLinkExample> getService() {
        return friendsLinkService;
    }
    @Override
    @RequestMapping("selectList")
    public String selectList(ModelMap modelMap) {
        return page_toList;
    }

}


