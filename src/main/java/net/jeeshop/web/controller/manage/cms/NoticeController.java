package net.jeeshop.web.controller.manage.cms;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.cms.model.Notice;
import net.jeeshop.biz.cms.model.NoticeExample;
import net.jeeshop.biz.cms.service.NoticeService;
import net.jeeshop.biz.system.model.SysUser;
import net.jeeshop.web.controller.manage.ManageBaseController;
import net.jeeshop.web.util.LoginUserHolder;

/**
 * 通知管理 controller
 * @author zuowen
 *
 */

@Controller
@RequestMapping("/manage/cms/notice/")
public class NoticeController extends ManageBaseController<Notice, NoticeExample> {
	@Autowired
	private NoticeService noticeService;
	
	private static final String page_toList = "/manage/cms/noticeList";
	private static final String page_toAdd = "/manage/cms/noticeEdit";
	private static final String page_toEdit = "/manage/cms/noticeEdit";
	
	  
	public NoticeController() {
		super.page_toList = page_toList;
		super.page_toAdd = page_toAdd;
		super.page_toEdit = page_toEdit;
	}
	
	@Override
	public BaseService<Notice, NoticeExample> getService() {
		
		return noticeService;
	}
	
	@RequestMapping("loadData")
	@ResponseBody
	public PageBean<Notice> loadData(Notice notice, PageQueryBean queryBean) {
		NoticeExample noticeExample = new NoticeExample();
		NoticeExample.Criteria criteria = noticeExample.createCriteria();
		if (StringUtils.isNotBlank(notice.getTitle())) {
			criteria.andTitleLike("%"+notice.getTitle()+"%");
		}
		if (StringUtils.isNotBlank(notice.getIsValid())) {
			criteria.andIsValidEqualTo(notice.getIsValid());
		}
		noticeExample.setOrderByClause("id desc");
		PageBean<Notice> pager = noticeService.selectPageList(noticeExample, queryBean);
		return pager;
	}
	
	 /**
	 * 删除公告
	 */
	@Override
	@RequestMapping(value = "deletes", method = RequestMethod.POST)
	public String deletes(Long[] ids, RedirectAttributes flushAttrs) {
		return super.deletes(ids, flushAttrs);
	}
	
	/**
	 * 添加公告
	 */
	@Override
	@RequestMapping("insert")
	public String insert(@ModelAttribute("e") Notice notice, RedirectAttributes flushAttrs) {
		return save0(notice, flushAttrs);
	}
	
    /**
     * 修改公告信息
     */
    @Override
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("e")  Notice notice, RedirectAttributes flushAttrs) {
        return save0(notice, flushAttrs);
    }

	private String save0(Notice notice, RedirectAttributes flushAttrs) {
		SysUser sysUser = LoginUserHolder.getLoginUser();

		if (sysUser == null) {
			flushAttrs.addFlashAttribute("errorMsg", "该用户没有登陆，请先登录");
			return "redirect:/manage/user/login";
		}
		Date nowTime = Calendar.getInstance().getTime();
		String loginUserName = sysUser.getUsername();

		if (notice.getId() == null) {
			// 添加
			notice.setCreateAccount(loginUserName);
			notice.setCreateTime(nowTime);
			notice.setUpdateAccount(loginUserName);
			notice.setUpdateTime(nowTime);
			notice.setIsValid(Notice.status_n);
			super.insert(notice, flushAttrs);

		} else {
			// 修改
			notice.setUpdateAccount(loginUserName);
			notice.setUpdateTime(nowTime);
			super.update(notice, flushAttrs);
		}
		return "redirect:selectList";
	}
	
	@RequestMapping(value = "updateStatusY", method = RequestMethod.POST)
	public String updateStatusY(Long[] ids, RedirectAttributes flushAttrs) {
		noticeService.updateStatus(ids, Notice.status_y);
		addMessage(flushAttrs, "操作成功!");
		return "redirect:selectList";

	}
	
	/**
	 * 显示指定的公告
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "up")
	public String up(Long id,  RedirectAttributes flushAttrs) throws Exception {
		return updateDownOrUp0(id, Notice.status_y, flushAttrs);
	}

	

	/**
	 * 不显示指定的文章
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "down")
	public String down(Long id, RedirectAttributes flushAttrs) throws Exception {
		return updateDownOrUp0(id,Notice.status_n, flushAttrs);
	}
    
    private String updateDownOrUp0(Long id, String statusY, RedirectAttributes flushAttrs) {
	    if(id==null){
	    	throw new NullPointerException("参数不能为空！");
	    }
	    noticeService.updateStatus(new Long[]{id}, statusY);
	    addMessage(flushAttrs, "更新成功!");
		return "redirect:toEdit?id="+id;
	}
	
	@RequestMapping(value = "updateStatusN", method = RequestMethod.POST)
	public String updateStatusN(Long[] ids, RedirectAttributes flushAttrs) {
		noticeService.updateStatus(ids, Notice.status_n);
		addMessage(flushAttrs, "操作成功!");
		return "redirect:selectList";
	}


	

}
