package net.jeeshop.biz.accountrank.service;

import java.util.List;

import net.jeeshop.biz.accountrank.client.AccountRankMapper;
import net.jeeshop.biz.accountrank.model.AccountRank;
import net.jeeshop.biz.accountrank.model.AccountRankExample;
import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountRankService extends BaseService<AccountRank, AccountRankExample>{

	@Autowired
	private AccountRankMapper accountRankMapper;

	@Override
	protected BaseMapper<AccountRank, AccountRankExample> getMapper() {
		return accountRankMapper;
	}

	public PageBean<AccountRank> selectPageBean(final AccountRankExample params,
			PageQueryBean pageQueryBean) {
		return executePageQuery(new PageQueryExecutor<AccountRank>() {
			@Override
			public List<AccountRank> executeQuery() {
				return accountRankMapper.selectByExample(params);
			}
		}, pageQueryBean);
	}

}
