package net.jeeshop.biz.keyvalue.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.keyvalue.model.KeyValueObject;
import net.jeeshop.biz.keyvalue.model.KeyValueObjectExample;

public interface KeyValueObjectMapper extends BaseMapper<KeyValueObject, KeyValueObjectExample> {
    int countByExample(KeyValueObjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(KeyValueObject record);

    int insertSelective(KeyValueObject record);

    List<KeyValueObject> selectByExample(KeyValueObjectExample example);

    KeyValueObject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(KeyValueObject record);

    int updateByPrimaryKey(KeyValueObject record);
}