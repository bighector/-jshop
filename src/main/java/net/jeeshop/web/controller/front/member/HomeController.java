package net.jeeshop.web.controller.front.member;

import com.google.common.collect.Lists;
import net.jeeshop.biz.member.model.Member;
import net.jeeshop.biz.member.service.MemberService;
import net.jeeshop.biz.system.bean.AreaItem;
import net.jeeshop.biz.system.service.AreaService;
import net.jeeshop.web.util.LoginUserHolder;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @Autowired
    AreaService areaService;

    @RequestMapping("/home")
    public String home(ModelMap modelMap) {
        Member currentMember = LoginUserHolder.getLoginMember();
        if(currentMember == null){
            return "redirect:login";
        }
        Member member = memberService.selectById(currentMember.getId());
        modelMap.addAttribute("e", member);

        long provinceId = 0;
        List<AreaItem> provinces = areaService.loadAreasByPid(0l, false);
        modelMap.addAttribute("provinces", provinces);
        if(StringUtils.isNotBlank(member.getProvince())) {
            for(AreaItem item: provinces) {
                if(item.getAreaCode().equals(member.getProvince())) {
                    provinceId = item.getId();
                    break;
                }
            }
            modelMap.addAttribute("cities", areaService.loadAreasByPid(Long.valueOf(provinceId), false));
        } else {
            modelMap.addAttribute("cities", new ArrayList<Area>());
        }
        return "member/home";
    }

    /**
     * 更新个人信息
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    public String updateInfo(Member member, ModelMap modelMap) {
        Member currentMember = LoginUserHolder.getLoginMember();
        if(currentMember == null){
            return "redirect:login";
        }
        member.setId(currentMember.getId());
        memberService.update(member);
        //TODO 更新session中存储的登录用户信息
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
