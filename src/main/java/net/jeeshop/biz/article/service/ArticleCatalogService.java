package net.jeeshop.biz.article.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.client.ArticleCatalogMapper;
import net.jeeshop.core.Services;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.model.ArticleCatalog;
import net.jeeshop.model.ArticleCatalogExample;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dylan
 * @date 15/8/18 21:19
 * Email: dinguangx@163.com
 */
@Service
public class ArticleCatalogService implements BaseService<ArticleCatalog> {

    @Resource
    ArticleCatalogMapper articleCatalogMapper;


    @Override
    public long insert(ArticleCatalog articleCatalog) {
        return articleCatalogMapper.insert(articleCatalog);
    }

    @Override
    public int delete(ArticleCatalog articleCatalog) {
        return articleCatalogMapper.deleteByPrimaryKey(articleCatalog.getId());
    }

    @Override
    public int deletes(Integer[] ids) {
        int cnt = 0;
        for(Integer id : ids) {
            int i = articleCatalogMapper.deleteByPrimaryKey(id);
            cnt += i;
        }
        return cnt;
    }

    @Override
    public int update(ArticleCatalog articleCatalog) {
        return articleCatalogMapper.updateByPrimaryKeySelective(articleCatalog);
    }

    @Override
    public ArticleCatalog selectOne(ArticleCatalog articleCatalog) {
        return null;
    }

    @Override
    public ArticleCatalog selectById(Integer id) {
        return articleCatalogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PagerModel selectPageList(ArticleCatalog articleCatalog) {
        ArticleCatalogExample example = new ArticleCatalogExample();
        ArticleCatalogExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(articleCatalog.getName())) {
            criteria.andNameEqualTo(StringUtils.trimToEmpty(articleCatalog.getName()));
        }
        PageHelper.startPage(1, 10);
        List<ArticleCatalog> catalogs = articleCatalogMapper.selectByExample(example);
        PagerModel pagerModel = new PagerModel();
        pagerModel.setList(catalogs);
        pagerModel.setTotal(((Page)catalogs).getTotal());
        return null;
    }

    @Override
    public List<ArticleCatalog> selectList(ArticleCatalog articleCatalog) {
        return null;
    }
}
