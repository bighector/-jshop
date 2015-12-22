package net.jeeshop.biz.system.service;

import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.system.bean.LogType;
import net.jeeshop.client.system.SystemLogMapper;
import net.jeeshop.core.util.AddressUtils;
import net.jeeshop.core.util.Constants;
import net.jeeshop.model.system.SysUser;
import net.jeeshop.model.system.SystemLog;
import net.jeeshop.model.system.SystemLogExample;
import net.jeeshop.web.util.LoginUserHolder;
import net.jeeshop.web.util.RequestHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author dinguangx@163.com
 * @date 2015-12-22 23:14
 */
@Service
public class SystemLogService extends BaseService<SystemLog, SystemLogExample> {
    @Autowired
    private SystemLogMapper systemLogMapper;

    @Override
    protected BaseMapper<SystemLog, SystemLogExample> getMapper() {
        return systemLogMapper;
    }

    /**
     */
    @Transactional
    public void newLog(String title, String content, LogType logType) {
        SysUser currentUser = LoginUserHolder.getLoginUser();

        SystemLog systemlog = new SystemLog();
        systemlog.setTitle(title);
        systemlog.setContent(content);
        systemlog.setAccount(currentUser.getUsername());
        systemlog.setType(logType.getValue());
        systemlog.setLoginTime(new Date());
        systemlog.setDiffAreaLogin(Constants.status_n);
        systemlog.setLoginIp(AddressUtils.getIp(RequestHolder.getRequest()));

        String address = null;
        if (!systemlog.getLoginIp().equals("127.0.0.1") && !systemlog.getLoginIp().equals("localhost")) {
            //获取指定IP的区域位置
            try {
                address = AddressUtils.getAddresses("ip=" + systemlog.getLoginIp(), "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            systemlog.setLoginArea(address);

            //异地登陆的判断方法为：先比较本次登陆和上次登陆的区域位置，如果不一致，说明是异地登陆；如果获取不到区域，则比较IP地址，如果IP地址和上次的不一致，则是异地登陆

//            SystemLog lastestLog = SystemLog.selectFirstOne(currentUser.getUsername());
//            if (lastestLog != null) {
//                if (StringUtils.isNotBlank(address) && StringUtils.isNotBlank(lastestLog.getLoginArea())) {
//                    if (!address.equals(lastestLog.getLoginArea())) {
//                        systemlog.setDiffAreaLogin(Constants.status_y);
//                    }
//                } else if (StringUtils.isNotBlank(systemlog.getLoginIp()) && StringUtils.isNotBlank(lastestLog.getLoginIp())) {
//                    if (!systemlog.getLoginIp().equals(lastestLog.getLoginIp())) {
//                        systemlog.setDiffAreaLogin(Constants.status_y);
//                    }
//                }
//            }
        }

        this.insert(systemlog);
    }
}
