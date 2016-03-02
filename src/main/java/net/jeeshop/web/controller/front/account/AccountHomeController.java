package net.jeeshop.web.controller.front.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dylan
 * @date 16/3/2 21:59
 * Email: dinguangx@163.com
 */
@Controller
@RequestMapping("/account")
public class AccountHomeController {
    @RequestMapping("/home")
    public String home() {
        return "account/home";
    }

    @RequestMapping("/login")
    public String login() {
        return "redirect:home";
    }
}
