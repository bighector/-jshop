package net.jeeshop.web.controller.front;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String index(ModelMap model) {
        model.addAttribute("categoryList", Lists.newArrayList());//商品分类
        model.addAttribute("friendLinkList", Lists.newArrayList());//友情链接
        model.addAttribute("noticeList", Lists.newArrayList());//公告列表
        model.addAttribute("helpList", Lists.newArrayList());//帮助文章，分类及文章列表嵌套结构
        model.addAttribute("hotProductList", Lists.newArrayList());//左侧，热卖推荐商品
        model.addAttribute("indexImages", Lists.newArrayList());//首页轮播图片
        model.addAttribute("hotProducts", Lists.newArrayList());//中间，热门商品
        model.addAttribute("saleProducts", Lists.newArrayList());//中间，特价商品
        model.addAttribute("newProducts", Lists.newArrayList());//中间，最新商品
        model.addAttribute("hotQueryList", Lists.newArrayList());//上方，热门检索列表
        model.addAttribute("shoppingCart", null);//购物车
        return "index";
    }
}
