package net.jeeshop.web.controller.manage.system;

import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.system.bean.MenuItem;
import net.jeeshop.biz.system.model.SysMenu;
import net.jeeshop.biz.system.model.SysMenuExample;
import net.jeeshop.biz.system.model.SysPrivilege;
import net.jeeshop.biz.system.model.SysPrivilegeExample;
import net.jeeshop.biz.system.service.MenuService;
import net.jeeshop.biz.system.service.PrivilegeService;
import net.jeeshop.web.controller.manage.ManageBaseController;
import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * Created by carlosxiao on 29/12/2015.
 */

@Controller
@RequestMapping("/manage/menu/")
public class SystemMenuController extends ManageBaseController<SysMenu, SysMenuExample> {

    @Autowired
    private MenuService menuService;

    @Autowired
    private PrivilegeService privilegeService;

    @Override
    public BaseService<SysMenu, SysMenuExample> getService() {
        return menuService;
    }

    SystemMenuController() {
        super.page_toList = "manage/system/menu/menuList";
        super.page_toEdit = "manage/system/menu/editMenu";
        super.page_toAdd = "manage/system/menu/editRole";
    }

    @RequestMapping(value = "getMenusByPid" , method = RequestMethod.GET )
    @ResponseBody
    public String getMenusByPid(@RequestParam(required = false , defaultValue = "0") String pid ,
                                @RequestParam(required = false) String id) throws Exception {
        // 加载全部的菜单
        List<MenuItem> menus = menuService.loadMenus(null, Long.parseLong(pid), "#");
        if(StringUtils.isNotBlank(id)) {
            // 加载指定角色的权限
            SysPrivilegeExample privilegeExample = new SysPrivilegeExample();
            SysPrivilegeExample.Criteria criteria = privilegeExample.createCriteria();
            criteria.andRidEqualTo(Long.parseLong(id));
            List<SysPrivilege> rolePs = privilegeService.selectByExample(privilegeExample);
            // 拿角色拥有的菜单和全部的菜单做比对，进行勾选
            for (int i = 0; i < rolePs.size(); i++) {
                SysPrivilege sysPrivilege = rolePs.get(i);
                checkRoleMenu(sysPrivilege , menus);
            }
        }
        return writeMenus(menus);
    }

    /**
     * 角色权限和资源菜单进行对比，使checkbox选中
     * @param p
     * @param menus
     */
    private void checkRoleMenu(SysPrivilege p, List<MenuItem> menus){
        for (int j = 0; j < menus.size(); j++) {
            MenuItem menu = menus.get(j);
            if (p.getMid().equals(menu.getId())) {
                menu.setChecked(true);
                return;
            }else{
                if(menu.getChildren()!=null && menu.getChildren().size()>0) {
                    checkRoleMenu(p, menu.getChildren());
                }
            }
        }
    }

    //输出菜单到页面
    private String writeMenus(List<MenuItem> root) throws IOException {
        JSONArray json = JSONArray.fromObject(root);
        String jsonStr = json.toString();
        try {
            return jsonStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

}
