package net.jeeshop.web.action.manage.commentType;import net.jeeshop.core.KeyValueHelper;import net.jeeshop.core.ManageContainer;import net.jeeshop.core.exception.NotThisMethod;import net.jeeshop.services.manage.comment.bean.Comment;import net.jeeshop.services.manage.commentType.CommentTypeService;import net.jeeshop.services.manage.commentType.bean.CommentType;import net.jeeshop.web.action.BaseController;import org.apache.commons.lang.StringUtils;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.ModelAttribute;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.servlet.mvc.support.RedirectAttributes;import javax.servlet.http.HttpServletRequest;/** * 评论方式 * @author huangf * @author dylan * */@Controller@RequestMapping("/manage/commentType/")public class CommentTypeAction extends BaseController<CommentType> {	private static final long serialVersionUID = 1L;	private static final Logger logger = LoggerFactory.getLogger(CommentTypeAction.class);	@Autowired	private CommentTypeService commentTypeService;	private static final String page_toList = "/manage/commentType/commentTypeList";	private static final String page_toEdit = "/manage/commentType/commentTypeEdit";	private static final String page_toAdd = "/manage/commentType/commentTypeEdit";	private CommentTypeAction() {		super.page_toList = page_toList;		super.page_toAdd = page_toAdd;		super.page_toEdit = page_toEdit;	}	@Override	public CommentTypeService getService() {		return commentTypeService;	}	public void setCommentTypeService(CommentTypeService commentTypeService) {		this.commentTypeService = commentTypeService;	}	@Override	public String insert(HttpServletRequest request, CommentType e, RedirectAttributes flushAttrs) throws Exception {		comm(e);		return super.insert(request, e, flushAttrs);	}		@Override	public String update(HttpServletRequest request, CommentType e, RedirectAttributes flushAttrs) throws Exception {		comm(e);		return super.update(request, e, flushAttrs);	}		//根据code获取名称	private void comm(CommentType e) {		logger.error("comm..code="+e.getCode());		String name = KeyValueHelper.get("commentType_code_"+e.getCode());		if(StringUtils.isBlank(name)){			throw new NullPointerException("未配置"+e.getCode()+"的评论插件的键值对！");		}				e.setName(name);	}		@Override	public String deletes(HttpServletRequest request, Long[] ids, @ModelAttribute("e") CommentType e, RedirectAttributes flushAttrs) throws Exception {		throw new NotThisMethod(ManageContainer.not_this_method);	}		/**	 * 设置指定的评论未系统默认评论插件	 * @return	 * @throws Exception 	 */	@RequestMapping(value = "updateDefaultCommentType",method = RequestMethod.POST)	public String updateDefaultCommentType(HttpServletRequest request, CommentType e) throws Exception{		if(e.getId() == null){			throw new NullPointerException("非法请求！");		}				CommentType comm = new CommentType();		comm.setId(e.getId());		comm.setStatus(Comment.comment_status_y);		commentTypeService.update(comm);				return selectList(request, e);//		return "updateDefaultCommentType";	}}