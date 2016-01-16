package net.jeeshop.biz.cms.service;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.cms.client.ArticleMapper;
import net.jeeshop.biz.cms.model.Article;
import net.jeeshop.biz.cms.model.ArticleExample;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pingge on 2016/1/15.
 */
@Service
public class ArticleService extends BaseService<Article, ArticleExample> {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    protected BaseMapper<Article, ArticleExample> getMapper() {
        return articleMapper;
    }
    /**
     * 分页查询数据
     *
     * @param article
     * @return
     */
    public PageBean<Article> selectPageList(Article article, PageQueryBean pageQueryBean){
        ArticleExample example = getExampleWithOrder();
        ArticleExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(article.getTitle())){
            criteria.andTitleLike("%"+article.getTitle()+"%");
        }
        if (StringUtils.isNotBlank(article.getCode())){
            criteria.andCodeLike("%"+article.getCode()+"%");
        }
        if (article.getCatalogId() != null && article.getCatalogId() != 0L){
            criteria.andCatalogIdEqualTo(article.getCatalogId());
        }
        PageBean<Article> pagerModel = super.selectPageList(example, pageQueryBean);
        return pagerModel;
    }
    private ArticleExample getExampleWithOrder() {
        ArticleExample example = new ArticleExample();
        example.setOrderByClause("ordinal asc");
        return example;
    }

    /**
     * 根据code检索
     *
     * @param code
     * @return
     */
    public Article selectByCode(String code) {
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(StringUtils.trimToEmpty(code));

        List<Article> catalogs = articleMapper.selectByExample(example);
        return catalogs.size() > 1 ? catalogs.get(0) : null;
    }
}
