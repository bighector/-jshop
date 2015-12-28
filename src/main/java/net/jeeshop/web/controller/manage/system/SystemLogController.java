package net.jeeshop.web.controller.manage.system;import net.jeeshop.biz.base.bean.PageBean;import net.jeeshop.biz.base.bean.PageQueryBean;import net.jeeshop.biz.system.model.SystemLog;import net.jeeshop.biz.system.model.SystemLogExample;import net.jeeshop.biz.system.service.SystemLogService;import net.jeeshop.web.controller.manage.ManageBaseController;import org.apache.commons.lang.StringUtils;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.ResponseBody;/** * 系统日志管理 * * @author dylan */@Controller@RequestMapping("/manage/systemlog/")public class SystemLogController extends ManageBaseController<SystemLog, SystemLogExample> {    private static final long serialVersionUID = 1L;    @Autowired    private SystemLogService systemLogService;    public SystemLogController() {        super.page_toList = null;        super.page_toEdit = null;        super.page_toAdd = null;    }    @Override    public SystemLogService getService() {        return systemLogService;    }    @RequestMapping("loadData")    @ResponseBody    public PageBean<SystemLog> loadData(SystemLog queryParams, PageQueryBean pageQueryBean) {        SystemLogExample example = new SystemLogExample();        SystemLogExample.Criteria criteria = example.createCriteria();        if (StringUtils.isNotBlank(queryParams.getAccount())) {            criteria.andAccountEqualTo(queryParams.getAccount());        }        if (StringUtils.isNotBlank(queryParams.getDiffAreaLogin())) {            criteria.andDiffAreaLoginEqualTo(queryParams.getDiffAreaLogin());        }        example.setOrderByClause("login_time desc");        PageBean<SystemLog> pager = systemLogService.selectPageList(example, pageQueryBean);        return pager;    }}