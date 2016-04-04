package net.jeeshop.biz.cms.service;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.cms.bean.ArticleBean;
import net.jeeshop.biz.cms.client.ArticleMapper;
import net.jeeshop.biz.cms.client.ArticleMapperExt;
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
    @Autowired
    private ArticleMapperExt articleMapperExt;

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
    public PageBean<ArticleBean> selectPageBeanList(final ArticleBean article, PageQueryBean pageQueryBean){
        if (StringUtils.isNotBlank(article.getTitle())){
            article.setTitle("%"+article.getTitle().trim()+"%");
        }
        if (StringUtils.isNotBlank(article.getCode())){
            article.setCode("%"+article.getCode().trim()+"%");
        }
        if (article.getCategoryId() != null && article.getCategoryId() != 0L){
            article.setCategoryId(article.getCategoryId());
        }
        PageBean<ArticleBean> pagerModel = super.executePageQuery(new PageQueryExecutor<ArticleBean>() {
            @Override
            public List<ArticleBean> executeQuery() {
                return articleMapperExt.selectArticleBeanList(article);
            }
        }, pageQueryBean);
        return pagerModel;
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
        return catalogs.size() > 0 ? catalogs.get(0) : null;
    }
}
