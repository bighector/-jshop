package net.jeeshop.biz.system.client;

import java.util.List;

import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.system.model.KeyValue;
import net.jeeshop.biz.system.model.KeyValueExample;

public interface KeyValueMapper extends BaseMapper<KeyValue, KeyValueExample> {
    int countByExample(KeyValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(KeyValue record);

    int insertSelective(KeyValue record);

    List<KeyValue> selectByExample(KeyValueExample example);

    KeyValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(KeyValue record);

    int updateByPrimaryKey(KeyValue record);
}