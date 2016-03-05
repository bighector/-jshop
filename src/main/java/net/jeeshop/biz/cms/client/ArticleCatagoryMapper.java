package net.jeeshop.biz.cms.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.cms.model.ArticleCatagory;
import net.jeeshop.biz.cms.model.ArticleCatagoryExample;

public interface ArticleCatagoryMapper extends BaseMapper<ArticleCatagory, ArticleCatagoryExample> {
    int countByExample(ArticleCatagoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleCatagory record);

    int insertSelective(ArticleCatagory record);

    List<ArticleCatagory> selectByExample(ArticleCatagoryExample example);

    ArticleCatagory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleCatagory record);

    int updateByPrimaryKey(ArticleCatagory record);
}