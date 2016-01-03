package net.jeeshop.web.controller.manage.system;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
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
import net.jeeshop.biz.system.model.SystemExpress;
import net.jeeshop.biz.system.model.SystemExpressExample;
import net.jeeshop.biz.system.service.SystemExpressService;
import net.jeeshop.web.controller.manage.ManageBaseController;

/**
 * @project: jshop 
 * @Description: 后台系统管理配送方式Controller
 * @author: Leolion
 * @date: 2015-12-30 23:05:12 
 * @version: 
 */
@Controller
@RequestMapping("/manage/express")
public class SystemExpressController extends  ManageBaseController<SystemExpress, SystemExpressExample>{
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	@Autowired
	SystemExpressService systemExpressService;
	
    @Override
    public BaseService<SystemExpress, SystemExpressExample> getService() {
        return systemExpressService;
    }
    
    public SystemExpressController() {
        super.page_toList = "manage/system/express/expressList";
        super.page_toEdit = "manage/system/express/editExpress";
        super.page_toAdd = "manage/system/express/editExpress";
    }

    @RequestMapping("loadData")
    @ResponseBody
    public PageBean<SystemExpress> loadData(SystemExpress queryParams, PageQueryBean pageQueryBean) {
        SystemExpressExample example = new SystemExpressExample();
        SystemExpressExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(queryParams.getCode())) {
            criteria.andCodeEqualTo(queryParams.getCode());
        }
        example.setOrderByClause("id desc");
        PageBean<SystemExpress> pager = systemExpressService.selectPageList(example, pageQueryBean);
        return pager;
    }
    
    /**
     * 添加配送方式
     */
    @Override
    @RequestMapping("insert")
    public String insert(@ModelAttribute("e") SystemExpress systemExpress, RedirectAttributes flushAttrs){
        return super.insert(systemExpress, flushAttrs);
    }
    
    /**
     * 修改配送方式
     */
    @Override
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("e") SystemExpress systemExpress, RedirectAttributes flushAttrs) {
        return super.update(systemExpress, flushAttrs);
    }
    /**
     * ajax验证输入的字符的唯一性
     *
     * @return
     * @throws java.io.IOException
     */
    @RequestMapping("unique")
    @ResponseBody
    public String unique(@ModelAttribute("e") SystemExpress e, HttpServletResponse response) throws IOException {
        logger.debug("验证输入的字符的唯一性:" + e);
        response.setCharacterEncoding("utf-8");
        if (StringUtils.isNotBlank(e.getCode())) {//验证快递编码是否存在
            logger.debug("验证快递编码是否存在:" + e.getCode());
            SystemExpress systemExpress = systemExpressService.selectByCode(e.getCode());

            if (systemExpress == null) {
                //数据库中不存在此编码
                return "{\"ok\":\"该快递编码可以使用!\"}";
            } else {
                if (e.getId() != null && e.getId().equals(systemExpress.getId())) {
                    //update操作
                    return "{\"ok\":\"该快递编码可以使用!\"}";
                } else {
                    //insert操作
                    return "{\"error\":\"该快递编码已经存在!\"}";
                }
            }
        }
        return null;
    }
    
    /**
     * 删除配送方式
     */
    @Override
    @RequestMapping(value = "deletes", method = RequestMethod.POST)
    public String deletes(Long[] ids, RedirectAttributes flushAttrs) {
    	return super.deletes(ids, flushAttrs);
    }
}
