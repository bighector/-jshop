package net.jeeshop.biz.cms.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.cms.model.Hotquery;
import net.jeeshop.biz.cms.model.HotqueryExample;

public interface HotqueryMapper extends BaseMapper<Hotquery, HotqueryExample> {
    int countByExample(HotqueryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Hotquery record);

    int insertSelective(Hotquery record);

    List<Hotquery> selectByExample(HotqueryExample example);

    Hotquery selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Hotquery record);

    int updateByPrimaryKey(Hotquery record);
}