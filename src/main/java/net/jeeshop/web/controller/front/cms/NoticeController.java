package net.jeeshop.web.controller.front.cms;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dylan.Ding
 * @date 2016-04-04 17-57
 */
@RequestMapping("cms/notice")
public class NoticeController {

    @RequestMapping({"index", "index.html"})
    public String index() {
        return "cms/notice";
    }
}
