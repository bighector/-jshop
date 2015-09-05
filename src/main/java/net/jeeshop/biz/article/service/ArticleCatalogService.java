package net.jeeshop.biz.article.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import net.jeeshop.biz.article.bean.ArticleCatalogBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.client.ArticleCatalogMapper;
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
    public int deleteById(long id) {
        return articleCatalogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deletes(Long[] ids) {
        int cnt = 0;
        for(Long id : ids) {
            int i = deleteById(id);
            cnt += i;
        }
        return cnt;
    }

    @Override
    public int update(ArticleCatalog articleCatalog) {
        return articleCatalogMapper.updateByPrimaryKeySelective(articleCatalog);
    }

    @Override
    public ArticleCatalog selectById(long id) {
        return articleCatalogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PagerModel selectPageList(ArticleCatalog articleCatalog) {
        ArticleCatalogExample example = getExampleWithOrder();
        ArticleCatalogExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(articleCatalog.getName())) {
            criteria.andNameEqualTo(StringUtils.trimToEmpty(articleCatalog.getName()));
        }
        PageHelper.startPage(1, 10);
        List<ArticleCatalog> catalogs = articleCatalogMapper.selectByExample(example);
        PagerModel pagerModel = new PagerModel();
        pagerModel.setList(catalogs);
        pagerModel.setTotal(((Page)catalogs).getTotal());
        return pagerModel;
    }

    @Override
    public List<ArticleCatalog> selectList(ArticleCatalog articleCatalog) {
        return null;
    }

    public List<ArticleCatalogBean> loadRoot() {
        ArticleCatalogExample example = getExampleWithOrder();
        ArticleCatalogExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(0L);

        List<ArticleCatalog> rootCatalogs = articleCatalogMapper.selectByExample(example);
        List<ArticleCatalogBean> result = convertList(rootCatalogs);
        for (ArticleCatalogBean catalogBean : result) {
            loadChildrenRecursive(catalogBean);
        }
        return result;
    }

    private ArticleCatalogExample getExampleWithOrder() {
        ArticleCatalogExample example = new ArticleCatalogExample();
        example.setOrderByClause("ordinal asc");
        return example;
    }

    private List<ArticleCatalogBean> convertList(List<ArticleCatalog> articleCatalogs) {
        List<ArticleCatalogBean> result = Lists.newArrayList();
        for(ArticleCatalog catalog : articleCatalogs) {
            result.add(new ArticleCatalogBean(catalog));
        }
        return result;
    }
    /**
     * 加载指定节点下的全部子节点
     *
     * @param item
     */
    private void loadChildrenRecursive(ArticleCatalogBean item) {
        ArticleCatalogExample example = getExampleWithOrder();
        ArticleCatalogExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(item.getId());
        item.setChildren(convertList(articleCatalogMapper.selectByExample(example)));
        if (item.getChildren() != null && item.getChildren().size() > 0) {
            for (ArticleCatalogBean bean : item.getChildren()) {
                loadChildrenRecursive(bean);
            }
        }
    }

    /**
     * 根据code检索
     * @param code
     * @return
     */
    public ArticleCatalog selectByCode(String code) {
        ArticleCatalogExample example = new ArticleCatalogExample();
        ArticleCatalogExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(StringUtils.trimToEmpty(code));

        List<ArticleCatalog> catalogs = articleCatalogMapper.selectByExample(example);
        return catalogs.size() > 1 ? catalogs.get(0) : null;
    }
}
