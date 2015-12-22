package net.jeeshop.client.system;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.model.system.SystemLog;
import net.jeeshop.model.system.SystemLogExample;

public interface SystemLogMapper extends BaseMapper<SystemLog, SystemLogExample> {
    int countByExample(SystemLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemLog record);

    int insertSelective(SystemLog record);

    List<SystemLog> selectByExample(SystemLogExample example);

    SystemLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemLog record);

    int updateByPrimaryKey(SystemLog record);
}