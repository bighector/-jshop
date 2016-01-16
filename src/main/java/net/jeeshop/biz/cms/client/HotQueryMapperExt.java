/**
 * 
 */
package net.jeeshop.biz.cms.client;

import java.util.List;

import net.jeeshop.biz.cms.model.HotQuery;

/**
 * 
 * @author yue
 * 2016年1月2日 下午4:09:10
 */
public interface HotQueryMapperExt extends HotQueryMapper {
	/**
	 * @param params
	 * @return
	 */
	List<HotQuery> selectByParams(HotQuery params);

	

}
