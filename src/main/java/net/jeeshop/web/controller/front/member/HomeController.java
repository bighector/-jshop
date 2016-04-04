package net.jeeshop.web.controller.front.member;

import net.jeeshop.biz.member.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dylan
 * @date 16/3/2 21:59
 * Email: dinguangx@163.com
 */
@Controller
@RequestMapping("/member")
public class HomeController {
    @RequestMapping("/home")
    public String home() {
        return "account/home";
    }
}
