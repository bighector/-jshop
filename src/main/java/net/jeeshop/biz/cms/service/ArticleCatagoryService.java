package net.jeeshop.biz.cms.service;

import com.google.common.collect.Lists;
import net.jeeshop.biz.cms.bean.ArticleCatagoryBean;
import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.cms.client.ArticleCatagoryMapper;
import net.jeeshop.biz.cms.model.ArticleCatagory;
import net.jeeshop.biz.cms.model.ArticleCatagoryExample;
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
public class ArticleCatagoryService extends BaseService<ArticleCatagory, ArticleCatagoryExample> {

    @Resource
    ArticleCatagoryMapper articleCatagoryMapper;

    @Override
    protected BaseMapper getMapper() {
        return articleCatagoryMapper;
    }

    /**
     * 分页查询数据
     *
     * @param articleCatalog
     * @return
     */
    public PageBean<ArticleCatagory> selectPageList(ArticleCatagory articleCatalog, PageQueryBean pageQueryBean) {
        ArticleCatagoryExample example = getExampleWithOrder();
        ArticleCatagoryExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(articleCatalog.getCategoryName())) {
            criteria.andCategoryNameEqualTo(StringUtils.trimToEmpty(articleCatalog.getCategoryName()));
        }
        PageBean<ArticleCatagory> pagerModel = super.selectPageList(example, pageQueryBean);
        return pagerModel;
    }

    /**
     * 获取一级目录分类
     *
     * @return
     */
    public List<ArticleCatagoryBean> loadRoot() {
        ArticleCatagoryExample example = getExampleWithOrder();
        ArticleCatagoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(0L);

        List<ArticleCatagory> rootCatalogs = articleCatagoryMapper.selectByExample(example);
        List<ArticleCatagoryBean> result = convertList(rootCatalogs);
        for (ArticleCatagoryBean catalogBean : result) {
            loadChildrenRecursive(catalogBean);
        }
        return result;
    }

    private ArticleCatagoryExample getExampleWithOrder() {
        ArticleCatagoryExample example = new ArticleCatagoryExample();
        example.setOrderByClause("ordinal asc");
        return example;
    }

    private List<ArticleCatagoryBean> convertList(List<ArticleCatagory> articleCatalogs) {
        List<ArticleCatagoryBean> result = Lists.newArrayList();
        for (ArticleCatagory catalog : articleCatalogs) {
            result.add(new ArticleCatagoryBean(catalog));
        }
        return result;
    }

    /**
     * 加载指定节点下的全部子节点
     *
     * @param item
     */
    private void loadChildrenRecursive(ArticleCatagoryBean item) {
        ArticleCatagoryExample example = getExampleWithOrder();
        ArticleCatagoryExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(item.getId());
        item.setChildren(convertList(articleCatagoryMapper.selectByExample(example)));
        if (item.getChildren() != null && item.getChildren().size() > 0) {
            for (ArticleCatagoryBean bean : item.getChildren()) {
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
    public ArticleCatagory selectByCode(String code) {
        ArticleCatagoryExample example = new ArticleCatagoryExample();
        ArticleCatagoryExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryCodeEqualTo(StringUtils.trimToEmpty(code));

        List<ArticleCatagory> catalogs = articleCatagoryMapper.selectByExample(example);
        return catalogs.size() > 1 ? catalogs.get(0) : null;
    }

    /**
     * 刷新文章分类的缓存
     */
    public void refreshCache() {
        //TODO
    }
}
