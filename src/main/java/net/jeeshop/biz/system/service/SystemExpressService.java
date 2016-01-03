package net.jeeshop.biz.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.system.client.SystemExpressMapper;
import net.jeeshop.biz.system.model.SystemExpress;
import net.jeeshop.biz.system.model.SystemExpressExample;

/**
 * @project: jshop 
 * @Description: 后台系统管理配送方式Service
 * @author: Leolion
 * @date: 2015-12-30 23:10:10 
 * @version: 
 */
@Service
public class SystemExpressService extends BaseService<SystemExpress, SystemExpressExample> {
	
	@Autowired
	private SystemExpressMapper systemExpressMapper;
	
	@Override
	protected BaseMapper<SystemExpress, SystemExpressExample> getMapper() {
		return systemExpressMapper;
	}
	
    /**
     * 根据code查找配送方式
     * @param expressCode
     * @return
     */
    public SystemExpress selectByCode(String expressCode) {
    	SystemExpressExample example = new SystemExpressExample();
    	SystemExpressExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(expressCode);
        return selectUniqueByExample(example);
    }
    
}
