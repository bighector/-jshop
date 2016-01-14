package net.jeeshop.biz.system.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.system.model.SystemExpress;
import net.jeeshop.biz.system.model.SystemExpressExample;

public interface SystemExpressMapper extends BaseMapper<SystemExpress, SystemExpressExample> {
    int countByExample(SystemExpressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemExpress record);

    int insertSelective(SystemExpress record);

    List<SystemExpress> selectByExample(SystemExpressExample example);

    SystemExpress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemExpress record);

    int updateByPrimaryKey(SystemExpress record);
}