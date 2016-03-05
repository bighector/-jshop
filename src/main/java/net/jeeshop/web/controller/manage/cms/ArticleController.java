package net.jeeshop.web.controller.manage.cms;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.cms.bean.ArticleCatagoryBean;
import net.jeeshop.biz.cms.model.Article;
import net.jeeshop.biz.cms.model.ArticleExample;
import net.jeeshop.biz.cms.service.ArticleCatagoryService;
import net.jeeshop.biz.cms.service.ArticleService;
import net.jeeshop.core.util.PinYinUtil;
import net.jeeshop.web.controller.manage.ManageBaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * Created by pingge on 2016/1/15.
 */
@Controller
@RequestMapping("/manage/article/")
public class ArticleController extends ManageBaseController<Article, ArticleExample>{

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleCatagoryService articleCatalogService;

    private static final String page_toList = "/manage/cms/articleList";
    private static final String page_toAdd = "/manage/cms/articleEdit";
    private static final String page_toEdit = "/manage/cms/articleEdit";

    public ArticleController(){
        super.page_toList = page_toList;
        super.page_toAdd = page_toAdd;
        super.page_toEdit = page_toEdit;
    }
    @Override
    public BaseService<Article, ArticleExample> getService() {
        return articleService;
    }

    @Override
    @RequestMapping("selectList")
    public String selectList(ModelMap modelMap) {
        //modelMap.addAttribute("catalog",(List<ArticleCatalog>)articleCatalogService.selectByExample(new ArticleCatalogExample()));
        return super.selectList(modelMap);
    }

    @RequestMapping("loadData")
    @ResponseBody
    public PageBean<Article> loadData(Article article, PageQueryBean pageQueryBean){
        return articleService.selectPageList(article,pageQueryBean );
    }

    @Override
    protected void beforeToAdd(Article e, ModelMap modelMap) {
        modelMap.addAttribute("catalogs",(List<ArticleCatagoryBean>)articleCatalogService.loadRoot());
        super.beforeToAdd(e, modelMap);
    }

    @Override
    protected void beforeToEdit(Article e, ModelMap modelMap) {
        modelMap.addAttribute("catalogs",(List<ArticleCatagoryBean>)articleCatalogService.loadRoot());
        super.beforeToEdit(e, modelMap);
    }

    @Override
    protected void beforeToList(ModelMap modelMap) {
        modelMap.addAttribute("catalogs",(List<ArticleCatagoryBean>)articleCatalogService.loadRoot());
        super.beforeToList(modelMap);
    }

    @Override
    public String toEdit(@ModelAttribute("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("catalogs",(List<ArticleCatagoryBean>)articleCatalogService.loadRoot());
        return super.toEdit(id, modelMap);
    }

    /**
     * 唯一性检查
     *
     * @return
     * @throws java.io.IOException
     */
    @RequestMapping(value = "uniqueCode", method = RequestMethod.POST)
    @ResponseBody
    public String uniqueCode(Article e) throws IOException {
        logger.error("unique code = " + e.getCode());
        if (StringUtils.isNotBlank(e.getCode())) {
            Article article = articleService.selectByCode(e.getCode());

            if (article == null) {
                //数据库中部存在此编码
                return "{\"ok\":\"编码可以使用!\"}";
            } else {
                if (e.getId() != null && e.getId().compareTo(article.getId()) == 0) {
                    //update操作，又是根据自己的编码来查询的，所以当然可以使用啦
                    return "{\"ok\":\"编码可以使用!\"}";
                } else {
                    //当前为insert操作，但是编码已经存在，则只可能是别的记录的编码
                    return "{\"error\":\"编码已经存在!\"}";
                }
            }
        } else {
            return "{\"error\":\"编码不能为空!\"}";
        }
    }

    /**
     * 根据类别名称自动获取拼音-ajax
     *
     * @return
     * @throws java.io.IOException
     */
    @RequestMapping(value = "autoCode", method = RequestMethod.POST)
    @ResponseBody
    public String autoCode(Article e) throws IOException {
        if (StringUtils.isBlank(e.getTitle())) {
            return null;
        }

        final String pinyin = PinYinUtil.getPingYin(e.getTitle());
        logger.debug("pinyin=" + pinyin);
        String _pinyin = pinyin;
        for (int i = 1; true; i++) {
            Article c = articleService.selectByCode(_pinyin);
            if (c == null) {
                return _pinyin;
//				break;
            } else {
                _pinyin = pinyin + i;
            }
        }
    }
}
