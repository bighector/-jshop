package net.jeeshop.biz.cms.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.cms.model.ArticleCatalog;
import net.jeeshop.biz.cms.model.ArticleCatalogExample;

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