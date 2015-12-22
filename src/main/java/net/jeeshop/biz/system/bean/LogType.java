package net.jeeshop.biz.system.bean;

/**
 * @author dinguangx@163.com
 * @date 2015-12-22 23:23
 */
public enum LogType {
    login(1), logout(2);
    private int value;
    LogType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
