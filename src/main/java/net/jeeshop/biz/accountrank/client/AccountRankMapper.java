package net.jeeshop.biz.accountrank.client;

import java.util.List;
import net.jeeshop.biz.accountrank.model.AccountRank;
import net.jeeshop.biz.accountrank.model.AccountRankExample;
import net.jeeshop.biz.base.client.BaseMapper;

public interface AccountRankMapper extends BaseMapper<AccountRank, AccountRankExample> {
    int countByExample(AccountRankExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AccountRank record);

    int insertSelective(AccountRank record);

    List<AccountRank> selectByExample(AccountRankExample example);

    AccountRank selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountRank record);

    int updateByPrimaryKey(AccountRank record);
}