package net.jeeshop.client.cms;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.model.cms.ArticleCatalog;
import net.jeeshop.model.cms.ArticleCatalogExample;

public interface ArticleCatalogMapper extends BaseMapper<ArticleCatalog, ArticleCatalogExample> {
    int countByExample(ArticleCatalogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleCatalog record);

    int insertSelective(ArticleCatalog record);

    List<ArticleCatalog> selectByExample(ArticleCatalogExample example);

    ArticleCatalog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleCatalog record);

    int updateByPrimaryKey(ArticleCatalog record);
}