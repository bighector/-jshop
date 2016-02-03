package net.jeeshop.web.controller.manage.system;

import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.system.bean.MenuItem;
import net.jeeshop.biz.system.bean.MenuType;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    private static final String PAGE_TOLIST = "/manage/system/menu/menuList";
    private static final String PAGE_TOEDIT = "/manage/system/menu/editMenu";
    private static final String PAGE_ADDORUPDATE = "/manage/system/menu/addOrUpdate";

    SystemMenuController() {
        super.page_toList = PAGE_TOLIST ;
        super.page_toEdit = PAGE_TOEDIT ;
        super.page_toAdd = PAGE_TOEDIT ;
    }

    @RequestMapping(value = "getMenusByPid" , method = RequestMethod.GET )
    @ResponseBody
    public String getMenusByPid(@RequestParam(required = false , defaultValue = "0") String pid ,
                                @RequestParam(required = false) String id) throws Exception 
    {
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

    /**
     * 点击菜单树右侧显示菜单信息
     * @param id
     * @return
     */
    @RequestMapping(value = "showcase" , method = RequestMethod.GET)
    public String showcase(@RequestParam String id , ModelMap model) {
        SysMenu sysMenu = menuService.selectById(Long.parseLong(id));
        model.addAttribute("e", sysMenu);
        return PAGE_ADDORUPDATE;
    }

    @RequestMapping(value = "addOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public String addOrUpdate(HttpServletRequest request) throws Exception
    {
        //选中菜单的信息
        //String updateP = request.getParameter("updateP");
        String id = request.getParameter("id");
        String pid = request.getParameter("pid");
        String name = request.getParameter("name");
        String orderNum = request.getParameter("orderNum");
        String type = request.getParameter("type");

        //要添加的子菜单
        String url = request.getParameter("url");
        String n_name = request.getParameter("n_name");
        String n_url = request.getParameter("n_url");
        String parentOrChild = request.getParameter("parentOrChild");
        String n_orderNum = request.getParameter("n_orderNum");
        String n_type = request.getParameter("n_type");

        SysMenu itemMenu = null;
        if(n_name!=null && !n_name.trim().equals("")){
            itemMenu = new SysMenu();
            //添加子菜单
            if(parentOrChild.equals("0")){//顶级模块
                itemMenu.setPid(0l);
                itemMenu.setType(MenuType.module.toString());
            } else if(parentOrChild.equals("1")){//顶级页面
                itemMenu.setPid(0l);
                itemMenu.setType(MenuType.page.toString());
            } else if(parentOrChild.equals("2")){//子模块
                itemMenu.setPid(Long.parseLong(id));
                itemMenu.setType(MenuType.module.toString());
            } else if(parentOrChild.equals("3")){//子页面
                itemMenu.setPid(Long.parseLong(id));
                itemMenu.setType(MenuType.page.toString());
            } else if(parentOrChild.equals("4")){   //功能
                itemMenu.setPid(Long.parseLong(id));
                itemMenu.setType(MenuType.button.toString());
            } else {
                throw new IllegalAccessException("添加菜单异常。");
            }
            itemMenu.setName(n_name);
            itemMenu.setUrl(n_url);
            itemMenu.setOrderNum(Integer.valueOf(n_orderNum));
            itemMenu.setType(n_type);
        }
        //修改父菜单
        SysMenu m = new SysMenu();
        m.setId(Long.parseLong(id));
        m.setName(name);
        m.setUrl(url);
        m.setPid(Long.parseLong(pid));
        m.setOrderNum(Integer.valueOf(orderNum));
        m.setType(type);

        menuService.addOrUpdate(m, itemMenu);

        return "ok";
    }

}
