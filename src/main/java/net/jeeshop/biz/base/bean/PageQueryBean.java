package net.jeeshop.biz.base.bean;

/**
 * @author dinguangx@163.com
 * @date 2015-12-21 23:37
 */
public class PageQueryBean {
    public static final int UNLIMIT_LENGTH = -1;
    public static final int DEFAULT_LENGTH = 20;
    private int start = 0;
    private int length = DEFAULT_LENGTH;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}
