package net.jeeshop.web.util;

import net.jeeshop.biz.system.bean.MenuItem;
import net.jeeshop.core.FrontContainer;
import net.jeeshop.core.ManageContainer;
import net.jeeshop.core.exception.JShopException;
import net.jeeshop.core.system.bean.User;
import net.jeeshop.model.system.SysUser;
import net.jeeshop.services.front.account.bean.Account;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * Created by dylan on 15-2-11.
 */
public class LoginUserHolder {
    public static SysUser getLoginUser(){
        HttpSession session = RequestHolder.getSession();
        return session == null ? null : (SysUser)session.getAttribute(ManageContainer.manage_session_user_info);
    }

    public static void setLoginUser(SysUser user){
        HttpSession session = RequestHolder.getSession();
        if(session == null) {
            throw new JShopException("当前session不存在.");
        }
        session.setAttribute(ManageContainer.manage_session_user_info, user);
    }

    public static void setLoginUserMenus(Collection<MenuItem> menuItems){
        HttpSession session = RequestHolder.getSession();
        if(session == null) {
            throw new JShopException("当前session不存在.");
        }
        session.setAttribute("userMenus", menuItems);
    }

    /**
     * 清除后台登录session信息
     */
    public static void invalidateManageSession() {

        HttpSession session = RequestHolder.getSession();
        if (session != null) {
            session.setAttribute(ManageContainer.manage_session_user_info, null);
            session.setAttribute(ManageContainer.resource_menus, null);
            session.setAttribute(ManageContainer.user_resource_menus_button, null);
            session.invalidate();
        }
    }

    public static Account getLoginAccount(){
        HttpSession session = RequestHolder.getSession();
        return session == null ? null : (Account)session.getAttribute(FrontContainer.USER_INFO);
    }
}
