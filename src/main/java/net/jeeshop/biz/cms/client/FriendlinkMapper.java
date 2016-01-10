package net.jeeshop.biz.cms.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.cms.model.Friendlink;
import net.jeeshop.biz.cms.model.FriendlinkExample;

public interface FriendlinkMapper extends BaseMapper<Friendlink, FriendlinkExample> {
    int countByExample(FriendlinkExample example);

    int deleteByPrimaryKey(Short linkId);

    int insert(Friendlink record);

    int insertSelective(Friendlink record);

    List<Friendlink> selectByExample(FriendlinkExample example);

    Friendlink selectByPrimaryKey(Short linkId);

    int updateByPrimaryKeySelective(Friendlink record);

    int updateByPrimaryKey(Friendlink record);
}