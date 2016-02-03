package net.jeeshop.web.controller.manage;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.jeeshop.biz.base.model.BaseModel;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.system.model.SysUser;
import net.jeeshop.web.controller.BaseController;
import net.jeeshop.web.util.LoginUserHolder;
import net.jeeshop.web.util.RequestHolder;
import net.sf.json.JSONArray;

import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 后台业务操作基类
 *
 * @author dinguangx@163.com
 * @date 2015-12-21 23:17
 */
@Controller
public abstract class ManageBaseController<Model extends BaseModel, Example> extends BaseController {

    protected String page_toList = null;
    protected String page_toEdit = null;
    protected String page_toAdd = null;
    
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
   
    @ModelAttribute
    public void loadServlet(HttpServletRequest request, HttpServletResponse response){
    	this.request = request;
    	this.response = response;
    	this.session = request.getSession();
    }

    public abstract BaseService<Model, Example> getService();

    /**
     * 公共的分页方法
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("selectList")
    public String selectList(ModelMap modelMap)
    {
        beforeToList(modelMap);
        return page_toList;
    }

    protected void beforeToList(ModelMap modelMap) {

    }

    /**
     * 初始化编辑页面
     *
     * @param id
     * @param modelMap
     * @return
     * @throws Exception
     */
    @RequestMapping("toEdit")
    public String toEdit(@ModelAttribute("id") Long id, ModelMap modelMap) 
    {
        Model e = getService().selectById(id);
//		if(e==null || StringUtils.isBlank(e.getId())){
//			throw new NullPointerException("");
//		}
        beforeToEdit(e, modelMap);
        if(modelMap.get("e") == null) {
            modelMap.addAttribute("e", e);
        }
        return page_toEdit;
    }

    protected void beforeToEdit(Model e, ModelMap modelMap) {

    }

    /**
     * 初始化新增页面
     *
     * @param e
     * @param modelMap
     * @return
     * @throws Exception
     */
    @RequestMapping("toAdd")
    public String toAdd(@ModelAttribute("e") Model e, ModelMap modelMap) {
        beforeToAdd(e, modelMap);
        return page_toAdd;
    }

    protected void beforeToAdd(Model e, ModelMap modelMap) {

    }

    /**
     * 公共的批量删除数据的方法，子类可以通过重写此方法实现个性化的需求。
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "deletes", method = RequestMethod.POST)
    public String deletes(Long[] ids, RedirectAttributes flushAttrs)
    {
        getService().deletes(ids);
        addMessage(flushAttrs, "操作成功！");
        return "redirect:selectList";
    }

    /**
     * 公共的更新数据的方法，子类可以通过重写此方法实现个性化的需求。
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("e") Model e, RedirectAttributes flushAttrs) 
    {
    	SysUser user = LoginUserHolder.getLoginUser(); 
    	e.setUpdateAccount(user.getUsername());
        e.setUpdateTime(new Date());
    	getService().update(e);
        addMessage(flushAttrs, "更新操作成功！");
        return "redirect:selectList";
    }

    /**
     * 公共的插入数据方法，子类可以通过重写此方法实现个性化的需求。
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(@ModelAttribute("e") Model e, RedirectAttributes flushAttrs) {
    	SysUser user = LoginUserHolder.getLoginUser();
		e.setCreateAccount(user.getUsername());//创建用户
		e.setCreateTime(new Date());
    	getService().insert(e);
        addMessage(flushAttrs, "插入操作成功！");
        return "redirect:selectList";
    }

    /**
     * 返回到查询页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("back")
    public String back(ModelMap model) {
        return selectList(model);
    }
    
    /**
     * JSON数据输出
     * @param obj
     * @param req 
     * @return
     */
    public void writeToJson(Object obj)
    {
    	try{
    		JSONArray ja = JSONArray.fromObject(obj);
    		PrintWriter write = response.getWriter();
    		write.print( ja.toString());
    		write.flush();
    		write.close();
    	}catch(Exception e){
    		logger.error("输出JSON格式数据异常", e);
    	}
    }

}
