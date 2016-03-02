package net.jeeshop.web.controller.manage.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.member.model.Member;
import net.jeeshop.biz.member.model.MemberExample;
import net.jeeshop.biz.member.service.MemberService;
import net.jeeshop.web.controller.manage.ManageBaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonObject;

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
	
	@RequestMapping("checkUsername")
	public String checkUsername(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		JsonObject retJson = new JsonObject();
		String userName = request.getParameter("userName");
		if(StringUtils.isEmpty(userName)){
			retJson.addProperty("code", "2");
			retJson.addProperty("msg", "请输入用户名");
		}else{
			MemberExample example = new MemberExample();
			example.setUserName(userName);
			List<Member> memberList = accountService.selectByExample(example);
			
			if(memberList!=null && memberList.size()==1){
				retJson.addProperty("code", "0");
				retJson.addProperty("msg", "可用");
			}else{
				retJson.addProperty("code", "1");
				retJson.addProperty("msg", "不可用");
			}
		}
		try {
			response.getWriter().write(retJson.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
