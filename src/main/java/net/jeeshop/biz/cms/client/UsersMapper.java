package net.jeeshop.biz.cms.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.cms.model.Users;
import net.jeeshop.biz.cms.model.UsersExample;

public interface UsersMapper extends BaseMapper<Users, UsersExample> {
    int countByExample(UsersExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}