package net.jeeshop.client.system;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.model.system.SystemSetting;
import net.jeeshop.model.system.SystemSettingExample;

public interface SystemSettingMapper extends BaseMapper<SystemSetting, SystemSettingExample> {
    int countByExample(SystemSettingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemSetting record);

    int insertSelective(SystemSetting record);

    List<SystemSetting> selectByExampleWithBLOBs(SystemSettingExample example);

    List<SystemSetting> selectByExample(SystemSettingExample example);

    SystemSetting selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemSetting record);

    int updateByPrimaryKeyWithBLOBs(SystemSetting record);

    int updateByPrimaryKey(SystemSetting record);
}