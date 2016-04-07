package net.jeeshop.web.controller.front.member;

import com.google.common.collect.Lists;
import net.jeeshop.biz.member.model.Member;
import net.jeeshop.biz.member.service.MemberService;
import net.jeeshop.web.util.LoginUserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dylan
 * @date 16/3/2 21:59
 * Email: dinguangx@163.com
 */
@Controller
@RequestMapping("/member")
public class HomeController {
    @Autowired
    MemberService memberService;
    @RequestMapping("/home")
    public String home(ModelMap modelMap) {
        Member currentMember = LoginUserHolder.getLoginMember();
        if(currentMember == null){
            return "redirect:login";
        }
        Member member = memberService.selectById(currentMember.getId());
        modelMap.addAttribute("e", member);
        modelMap.addAttribute("provinces", Lists.newArrayList());
        modelMap.addAttribute("cities", Lists.newArrayList());
        return "member/home";
    }

    /**
     * 更新个人信息
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    public String updateInfo(ModelMap modelMap) {
        return "redirect:home";
    }

    @RequestMapping("changeEmail")
    public String changeEmail(ModelMap modelMap) {
        return "member/changeEmail";
    }

    @RequestMapping("/changePwd")
    public String changePwd(ModelMap modelMap) {
        return "member/changePwd";
    }

    @RequestMapping("orders")
    public String orders(ModelMap modelMap) {
        return "member/orders";
    }

    @RequestMapping("address")
    public String address(ModelMap modelMap) {
        return "member/address";
    }
}
