package net.jeeshop.web.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dylan
 * @date 16/3/2 21:55
 * Email: dinguangx@163.com
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }
}
