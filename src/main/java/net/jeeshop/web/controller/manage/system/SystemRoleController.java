package net.jeeshop.web.controller.manage.system;

import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.system.bean.SysUserBean;
import net.jeeshop.biz.system.model.SysRole;
import net.jeeshop.biz.system.model.SysRoleExample;
import net.jeeshop.biz.system.service.RoleService;
import net.jeeshop.biz.system.service.SystemLogService;
import net.jeeshop.web.controller.manage.ManageBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by carlosxiao on 28/12/2015.
 */

@Controller
@RequestMapping("/manage/role/")
public class SystemRoleController extends ManageBaseController<SysRole, SysRoleExample> {

    @Autowired
    private RoleService roleService;

    @Override
    public BaseService<SysRole, SysRoleExample> getService() {
        return roleService;
    }

    SystemRoleController() {
        super.page_toList = "manage/system/role/roleList";
        super.page_toEdit = null;
        super.page_toAdd = null;
    }

    @Override
    public void beforeToList(ModelMap modelMap) {
        modelMap.addAttribute("roleList", roleService.selectByExample(new SysRoleExample()));
    }

    @RequestMapping("loadData")
    @ResponseBody
    public PageBean<SysUserBean> loadData(SysRoleExample queryParams, PageQueryBean pageQueryBean) {
        PageBean pager = roleService.selectPageList(queryParams, pageQueryBean);
        return pager;
    }
}
