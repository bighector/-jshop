package net.jeeshop.web.controller.manage.system;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.system.bean.SysUserBean;
import net.jeeshop.biz.system.model.SysRole;
import net.jeeshop.biz.system.model.SysRoleExample;
import net.jeeshop.biz.system.model.SysUser;
import net.jeeshop.biz.system.service.RoleService;
import net.jeeshop.core.ManageContainer;
import net.jeeshop.core.exception.NotThisMethod;
import net.jeeshop.core.system.bean.Role;
import net.jeeshop.web.controller.manage.ManageBaseController;
import net.jeeshop.web.util.LoginUserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by carlosxiao on 28/12/2015.
 */

@Controller
@RequestMapping("/manage/role")
public class SystemRoleController extends ManageBaseController<SysRole, SysRoleExample> {

    @Autowired
    private RoleService roleService;

    @Override
    public BaseService<SysRole, SysRoleExample> getService() {
        return roleService;
    }

    SystemRoleController() {
        super.page_toList = "manage/system/role/roleList";
        super.page_toEdit = "manage/system/role/editRole";
        super.page_toAdd = "manage/system/role/editRole";
    }

    @RequestMapping("loadData")
    @ResponseBody
    public PageBean<SysUserBean> loadData(SysRoleExample queryParams, PageQueryBean pageQueryBean) {
        PageBean pager = roleService.selectPageList(queryParams, pageQueryBean);
        return pager;
    }


    /**
     * 添加角色
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(HttpServletRequest request, Role role) throws Exception {
        role.setRole_name(request.getParameter("roleName"));
        role.setId(Long.parseLong(request.getParameter("id")));
        role.setRole_desc(request.getParameter("roleDesc"));
        role.setRole_dbPrivilege(request.getParameter("role_dbPrivilege"));
        role.setPrivileges(request.getParameter("privileges"));
        role.setStatus(request.getParameter("status"));
        if(role.getRole_name()==null || role.getRole_name().trim().equals("")){
            return "0";
        }else{
            //roleService.editRole(role, request.getParameter("insertOrUpdate"));
        }
        return "1";
    }

    @Override
    @RequestMapping(value = "deletes", method = RequestMethod.POST)
    public String deletes(Long [] ids , RedirectAttributes flushAttrs) {
        throw new NotThisMethod(ManageContainer.not_this_method);
    }

    /**
     * 只能是admin才具有编辑其他用户权限的功能
     */
    @Override
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("e") SysRole role, RedirectAttributes flushAttrs) {
        SysUser user = LoginUserHolder.getLoginUser();
        if(!user.getUsername().equals("admin")){
            throw new NullPointerException(ManageContainer.RoleAction_update_error);
        }
        return super.update(role, flushAttrs);
    }
}
