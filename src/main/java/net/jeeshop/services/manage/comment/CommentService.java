package net.jeeshop.services.manage.comment;import net.jeeshop.core.Services;import net.jeeshop.services.manage.comment.bean.Comment;public interface CommentService extends Services<Comment> {	/**	 * 批量修改评论状态	 * @param ids	 */	void updateStatus(Long[] ids,String status);	/**	 * 查询尚未恢复的评论数	 * @return	 */	int selectNotReplyCount();}