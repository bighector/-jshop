package net.jeeshop.web.action.manage.sms;import net.jeeshop.core.ManageContainer;import net.jeeshop.core.sms.SMSWebChinese;import net.jeeshop.services.manage.sms.SmsService;import net.jeeshop.services.manage.sms.bean.Sms;import net.jeeshop.web.action.BaseController;import net.jeeshop.web.util.RequestHolder;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import org.tuckey.web.filters.urlrewrite.utils.StringUtils;/** * 短信管理 * @author jqsl2012@163.com * */@Controller@RequestMapping("sms")public class SmsAction extends BaseController<Sms> {	private static final long serialVersionUID = 1L;	@Autowired	private SmsService smsService;	public SmsService getService() {		return smsService;	}	/**	 * 重发短信	 * @return	 * @throws Exception	 */	@RequestMapping("updateSendSMS")	public String updateSendSMS(Sms e) throws Exception{		if(e.getId() == null){			throw new NullPointerException(ManageContainer.RoleAction_update_error);		}				e = smsService.selectById(e.getId());		if(e==null){			throw new NullPointerException("系统查询不到此短信！");		}				SMSWebChinese.sendSMS(e);				Sms sms = new Sms();		sms.setId(e.getId());		sms.setReturnCode(e.getReturnCode());		smsService.update(e);				return selectList(RequestHolder.getRequest(), e);	}}