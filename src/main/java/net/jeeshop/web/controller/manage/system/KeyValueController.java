package net.jeeshop.web.controller.manage.system;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.system.model.KeyValue;
import net.jeeshop.biz.system.model.KeyValueExample;
import net.jeeshop.biz.system.service.KeyValueService;
import net.jeeshop.web.controller.manage.ManageBaseController;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/manage/keyvalue")
public class KeyValueController extends ManageBaseController<KeyValue, KeyValueExample>  {
    private static final Logger logger = LoggerFactory
            .getLogger(KeyValueController.class);
    @Autowired
    private KeyValueService keyValueService;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseService getService() {
		return keyValueService;
	}
    
  	private static final String page_toList = "/manage/keyValue/keyValueList";
      private static final String page_toAdd = "/manage/keyValue/keyValueEdit";
      private static final String page_toEdit = "/manage/keyValue/keyValueEdit";
      
    public KeyValueController() {
        super.page_toEdit = page_toEdit;
        super.page_toList = page_toList;
        super.page_toAdd = page_toAdd;
    }
    

	@SuppressWarnings("unchecked")
	@RequestMapping("loadData")
    @ResponseBody
    public PageBean<KeyValue> loadData(KeyValueExample keyValueExample, PageQueryBean pageQueryBean) {
		KeyValueExample.Criteria criteria = keyValueExample.createCriteria();
        if (StringUtils.isNotBlank(keyValueExample.getkValue())) {
            criteria.andKValueLike(keyValueExample.getkValue());
        }
        if (StringUtils.isNotBlank(keyValueExample.getvValue())) {
            criteria.andVValueLike(keyValueExample.getvValue());
        }
        keyValueExample.setOrderByClause("id");
		@SuppressWarnings("rawtypes")
		PageBean pager = keyValueService.selectPageBean(keyValueExample, pageQueryBean);
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

        int isSuccess = keyValueService.deleteById(id);
        logger.info("delete resule : {}", isSuccess);
        return page_toList;
    }

    @RequestMapping("toAdd")
    public String toAdd(KeyValue e, ModelMap model) {
        model.addAttribute("e", e);
        return page_toAdd;
    }


}
