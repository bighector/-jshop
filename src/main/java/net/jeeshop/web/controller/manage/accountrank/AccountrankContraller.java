package net.jeeshop.web.controller.manage.accountrank;

import net.jeeshop.biz.accountrank.model.AccountRank;
import net.jeeshop.biz.accountrank.model.AccountRankExample;
import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.system.model.KeyValue;
import net.jeeshop.biz.system.model.KeyValueExample;
import net.jeeshop.biz.accountrank.service.AccountRankService;
import net.jeeshop.web.controller.manage.ManageBaseController;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @author ysqin
* Email: 442800318@qq.com
*/
@Controller
@RequestMapping("/manage/accountRank")
public class AccountrankContraller extends ManageBaseController<AccountRank, AccountRankExample>  {

    @Autowired
    private AccountRankService accountRankService;

	@Override
	public BaseService<AccountRank, AccountRankExample> getService() {
		return accountRankService;
	}
    
	private static final String page_toList = "/manage/accountRank/accountrankList";
    private static final String page_toAdd = "/manage/accountRank/accountrankEdit";
    private static final String page_toEdit = "/manage/accountRank/accountrankEdit";
    
	public AccountrankContraller() {
		super.page_toEdit = page_toEdit;
		super.page_toList = page_toList;
		super.page_toAdd = page_toAdd;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("loadData")
	@ResponseBody
	public PageBean<AccountRank> loadData(AccountRankExample accountRankExample,
			PageQueryBean pageQueryBean) {
		AccountRankExample.Criteria criteria = accountRankExample.createCriteria();
		if(StringUtils.isNotEmpty(accountRankExample.getName())){
			criteria.andNameLike(accountRankExample.getName());
		}
		@SuppressWarnings("rawtypes")
		PageBean pager = accountRankService.selectPageBean(accountRankExample,
				pageQueryBean);
		return pager;
	}

	/**
	 * 删除
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "deleteByID", method = RequestMethod.GET)
	public String deleteByID(Long id) throws Exception {
		if (id == null) {
			throw new NullPointerException("参数不正确！");
		}

		int isSuccess = accountRankService.deleteById(id);
		logger.info("delete resule : {}", isSuccess);
		return page_toList;
	}

	@RequestMapping("toAdd")
	public String toAdd(AccountRank e, ModelMap model) {
		model.addAttribute("e", e);
		return page_toAdd;
	}

}
