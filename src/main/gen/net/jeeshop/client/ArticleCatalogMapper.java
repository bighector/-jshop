package net.jeeshop.client;

import java.util.List;
import net.jeeshop.model.ArticleCatalog;
import net.jeeshop.model.ArticleCatalogExample;

public interface ArticleCatalogMapper {
    int countByExample(ArticleCatalogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleCatalog record);

    int insertSelective(ArticleCatalog record);

    List<ArticleCatalog> selectByExample(ArticleCatalogExample example);

    ArticleCatalog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleCatalog record);

    int updateByPrimaryKey(ArticleCatalog record);
}