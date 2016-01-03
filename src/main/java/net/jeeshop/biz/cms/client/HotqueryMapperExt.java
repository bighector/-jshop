/**
 * 
 */
package net.jeeshop.biz.cms.client;

import java.util.List;

import net.jeeshop.biz.cms.model.Hotquery;

/**
 * 
 * @author yue
 * 2016年1月2日 下午4:09:10
 */
public interface HotqueryMapperExt extends HotqueryMapper {
	/**
	 * @param params
	 * @return
	 */
	List<Hotquery> selectByParams(Hotquery params);

	

}
