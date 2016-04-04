package net.jeeshop.web.controller.front.cms;

import net.jeeshop.biz.cms.model.Article;
import net.jeeshop.biz.cms.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文章管理
 * @author Dylan.Ding
 * @date 2016-04-04 17-36
 */
@Controller("frontArticleController")
@RequestMapping("cms/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @RequestMapping({"index","index.html"})
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("articleCode", "index");
        return "cms/article";
    }

    @RequestMapping({"{articleCode}","{articleCode}.html"})
    public String articlePage(ModelMap modelMap, @PathVariable("articleCode")String articleCode) {
        Article article = articleService.selectByCode(articleCode);
        if(article == null) {
            return "redirect:index";
        }
        modelMap.put("article", article);
        return "cms/article";
    }

}
