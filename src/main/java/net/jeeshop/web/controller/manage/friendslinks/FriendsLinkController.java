package net.jeeshop.web.controller.manage.friendslinks;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.cms.model.Friendlink;
import net.jeeshop.biz.cms.model.FriendlinkExample;
import net.jeeshop.biz.cms.service.FriendsLinkService;
import net.jeeshop.web.controller.manage.ManageBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by machenike on 2016/1/6.
 */
@Controller
@RequestMapping("/manage/friendslink")
public class FriendsLinkController extends ManageBaseController<Friendlink, FriendlinkExample> {

    @Autowired
    private FriendsLinkService friendsLinkService;
    private static final String page_toList = "/manage/navigation/navigationList";
    private static final String page_toEdit = "/manage/navigation/navigationEdit";

    private FriendsLinkController() {
        super.page_toList = page_toList;
        super.page_toEdit = page_toEdit;
    }
}


}
