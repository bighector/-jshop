package net.jeeshop.biz.cms.service;

import com.google.common.collect.Lists;
import net.jeeshop.biz.cms.bean.ArticleCatalogBean;
import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.cms.client.ArticleCatalogMapper;
import net.jeeshop.biz.cms.model.ArticleCatalog;
import net.jeeshop.biz.cms.model.ArticleCatalogExample;
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
public class ArticleCatalogService extends BaseService<ArticleCatalog, ArticleCatalogExample> {

    @Resource
    ArticleCatalogMapper articleCatalogMapper;

    @Override
    protected BaseMapper getMapper() {
        return articleCatalogMapper;
    }

    /**
     * 分页查询数据
     *
     * @param articleCatalog
     * @return
     */
    public PageBean<ArticleCatalog> selectPageList(ArticleCatalog articleCatalog, PageQueryBean pageQueryBean) {
        ArticleCatalogExample example = getExampleWithOrder();
        ArticleCatalogExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(articleCatalog.getName())) {
            criteria.andNameEqualTo(StringUtils.trimToEmpty(articleCatalog.getName()));
        }
        PageBean<ArticleCatalog> pagerModel = super.selectPageList(example, pageQueryBean);
        return pagerModel;
    }

    /**
     * 获取一级目录分类
     *
     * @return
     */
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
        for (ArticleCatalog catalog : articleCatalogs) {
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
     *
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
