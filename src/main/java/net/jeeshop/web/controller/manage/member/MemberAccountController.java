package net.jeeshop.web.controller.manage.member;

import javax.servlet.http.HttpServletRequest;

import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.member.model.Member;
import net.jeeshop.biz.member.model.MemberExample;
import net.jeeshop.biz.member.service.MemberService;
import net.jeeshop.web.controller.manage.ManageBaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ysqin Email: 442800318@qq.com
 */
@Controller
@RequestMapping("/manage/account")
public class MemberAccountController extends
		ManageBaseController<Member, MemberExample> {

	private static final String page_toList = "/manage/member/memberList";
	private static final String page_toAdd = "/manage/member/memberEdit";
	private static final String page_toEdit = "/manage/member/memberEdit";
	private static final String page_toRegister = "/manage/member/memberRegister";

	@Autowired
	private MemberService accountService;

	@Override
	public BaseService<Member, MemberExample> getService() {
		return accountService;
	}

	@RequestMapping("selectList")
	public String selectList(ModelMap modelMap) {
		beforeToList(modelMap);
		return page_toList;
	}
	
	@RequestMapping("register")
	public String memberRegister(ModelMap modelMap,HttpServletRequest request) {
		
		return page_toRegister;
	}

}
