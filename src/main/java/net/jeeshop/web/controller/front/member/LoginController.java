package net.jeeshop.web.controller.front.member;

import net.jeeshop.biz.member.model.Member;
import net.jeeshop.biz.member.service.MemberService;
import net.jeeshop.core.FrontContainer;
import net.jeeshop.web.bean.ResultBean;
import net.jeeshop.web.controller.front.FrontBaseController;
import net.jeeshop.web.util.LoginUserHolder;
import net.jeeshop.web.util.RequestHolder;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dylan
 * @date 2016-04-04 19-46
 */
@Controller
@RequestMapping("/member")
public class LoginController extends FrontBaseController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/login")
    public String login() {
        if (LoginUserHolder.getLoginMember() != null) {
            return "redirect:home";
        }
        return "member/login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(Member member, ModelMap model) {
        String errorMsg = "帐号或密码错误!";
        if (StringUtils.isBlank(member.getUsername())
                || StringUtils.isBlank(member.getPassword())) {
            model.addAttribute("errorMsg", "请输入帐号密码");
            return "member/login";
        }

        //用户验证
        String username = member.getUsername();
        String password = member.getPassword();
        Member acc = memberService.selectByUsernamePassword(username, password);
        if (acc == null) {
            model.addAttribute("errorMsg", errorMsg);
            return "member/login";
        } else if (acc.getIsFreeze() == true) {
            if (acc.getFreezeStartTime() == null && acc.getFreezeEndTime() == null) {
                model.addAttribute("errorMsg", "此账号已永久冻结!有疑问请联系站点管理员!");
            } else {
                model.addAttribute("errorMsg", "此账号已暂时冻结!有疑问请联系站点管理员!");
            }
            return "member/login";
        } else if (acc.getIsEmailActive() == false) {
            //邮箱未激活
            errorMsg = "此账号的邮箱尚未激活，请立即去激活邮箱！";
            model.addAttribute("errorMsg", errorMsg);
            return "member/login";
        }
        RequestHolder.getSession().setAttribute(FrontContainer.MEMBER_INFO, acc);
        //记录登录日志
        memberService.logLogin(acc);
        return "redirect:home";
    }

    @RequestMapping("/forgetPassword")
    public String forgetPassword() {
        return "member/login";
    }

    @RequestMapping("/logout")
    public String logout() {
        RequestHolder.getSession().invalidate();
        return "redirect:/index";
    }

    @RequestMapping("/register")
    public String register() {
        return "member/register";
    }

    @RequestMapping("/doRegister")
    public String doRegister(Member e, ModelMap model) {
        String errorMsg = null;
        //检查入参
        if (StringUtils.isBlank(e.getEmail())) {
            errorMsg = "邮箱不能为空!";
        } else if (StringUtils.isBlank(e.getUsername())) {
            errorMsg = "用户名不能为空!";
        } else if (StringUtils.isBlank(e.getNickName())) {
            errorMsg = "昵称不能为空!";
        } else if (StringUtils.isBlank(e.getPassword())) {
            errorMsg = "密码不能为空!";
        }

        if (errorMsg != null) {
            model.addAttribute("errorMsg", errorMsg);
            return "member/register";
        }
        e.setUsername(e.getUsername().trim());
        e.setNickName(e.getNickName().trim());
        e.setPassword(e.getPassword().trim());
        e.setEmail(e.getEmail().trim());
        // 用户注册
        ResultBean resultBean = memberService.register(e);
        if (!resultBean.isSuccess()) {
            model.addAttribute("errorMsg", resultBean.getMsg());
            return "member/register";
        }

        return "redirect:regSuccess";
    }

    @RequestMapping("regSuccess")
    public String regSuccess() {
        return "member/regSuccess";
    }

    @RequestMapping("uniqueEmail")
    @ResponseBody
    public String uniqueEmail(String email) {
        if(memberService.selectByEmail(email) != null) {
            return "邮箱已经被注册!";
        }
        return "";
    }

    @RequestMapping("uniqueNickname")
    @ResponseBody
    public String uniqueNickname(String nickName) {
        if(memberService.selectByNickname(nickName) != null) {
            return "昵称已经被使用!";
        }
        return "";
    }

    @RequestMapping("uniqueUsername")
    @ResponseBody
    public String uniqueUsername(String username) {
        if(memberService.selectByUsername(username) != null) {
            return "用户名已经被使用!";
        }
        return "";
    }
}
