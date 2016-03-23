package net.jeeshop.biz.product.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.product.model.Category;
import net.jeeshop.biz.product.model.CategoryExample;

public interface CategoryMapper extends BaseMapper<Category, CategoryExample> 
{
    int countByExample(CategoryExample example);

    int inValidated(Long id); 
    
    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}