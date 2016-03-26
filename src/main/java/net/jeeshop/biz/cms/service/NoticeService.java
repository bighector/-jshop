package net.jeeshop.biz.cms.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.cms.client.NoticeMapper;
import net.jeeshop.biz.cms.client.NoticeMapperExt;
import net.jeeshop.biz.cms.model.Notice;
import net.jeeshop.biz.cms.model.NoticeExample;
import net.jeeshop.biz.system.model.SysUser;
import net.jeeshop.web.util.LoginUserHolder;
import net.sf.ehcache.search.expression.And;

/**
 *  
 *  公告相关的service
 * @author zuowen
 *
 */
@Service
public class NoticeService extends BaseService<Notice, NoticeExample> {

	@Autowired
	NoticeMapper noticeMapper;
	
	@Autowired
	NoticeMapperExt noticeMapperExt;
	
	@Override
	protected BaseMapper<Notice, NoticeExample> getMapper() {
		  return  noticeMapper;
	}
	
	@Transactional
	public void updateStatus(Long[] ids, String statusY) {
	      if(ids==null ||ids.length==0){
	    	  return ;
	      }
	      SysUser sysUser = LoginUserHolder.getLoginUser();
	      Date nowDate=Calendar.getInstance().getTime();
	      List<Notice> noticeList=noticeMapperExt.selectNoticeByIds(ids);
	      if(noticeList==null||noticeList.isEmpty()){
	    	  return ;
	      }
	     List<Notice> updateNoticeList=new ArrayList<Notice>(noticeList.size());
	      for(Notice notice:noticeList){
	    	   if(notice.getIsValid()){
	    		   continue;
	    	   }
	    	   notice.setUpdateAccount(sysUser.getUsername());
	    	   notice.setUpdateTime(nowDate);
	    	   notice.setIsValid(true);
	    	   updateNoticeList.add(notice);
	    	   
	      }
	      if(updateNoticeList!=null &&!updateNoticeList.isEmpty()){
	    	  noticeMapperExt.updateNoticeByNoticeList(updateNoticeList);
	      }
	     
	      
	      
	}

}
