package net.jeeshop.biz.keyvalue.service;

import java.util.List;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.keyvalue.client.KeyValueObjectMapper;
import net.jeeshop.biz.keyvalue.model.KeyValueObject;
import net.jeeshop.biz.keyvalue.model.KeyValueObjectExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author ysqin
* Email: 442800318@qq.com
*/
@Service
public class KeyValueObjectService extends BaseService<KeyValueObject, KeyValueObjectExample> {

	 @Autowired
	 private KeyValueObjectMapper keyValueObjectMapper;

	@Override
	protected BaseMapper<KeyValueObject, KeyValueObjectExample> getMapper() {
		// TODO Auto-generated method stub
		return keyValueObjectMapper;
	}

	  public PageBean<KeyValueObject> selectPageBean(final KeyValueObjectExample params, PageQueryBean pageQueryBean) {
	        return executePageQuery(new PageQueryExecutor<KeyValueObject>() {
	            @Override
	            public List<KeyValueObject> executeQuery() {
	                return keyValueObjectMapper.selectByExample(params);
	            }
	        }, pageQueryBean);
	    }

}
