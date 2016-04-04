package net.jeeshop.biz.product.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.product.model.ProductComment;
import net.jeeshop.biz.product.model.ProductCommentExample;

public interface ProductCommentMapper extends BaseMapper<ProductComment, ProductCommentExample> {
    int countByExample(ProductCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductComment record);

    int insertSelective(ProductComment record);

    List<ProductComment> selectByExample(ProductCommentExample example);

    ProductComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductComment record);

    int updateByPrimaryKey(ProductComment record);
}