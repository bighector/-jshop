package net.jeeshop.biz.cms.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class Notice extends BaseModel implements Serializable {
    /** t_notice.title */
    private String title;

    /** t_notice.readerCount */
    private Integer readercount;

    /** t_notice.status */
    private String status;

    /** t_notice.order1 */
    private Integer order1;

    /** t_notice.content */
    private String content;

    private static final long serialVersionUID = 1L;
    
    
	public static final String   status_y = "y";//显示
	public static final String   status_n = "n";//不显示

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getReadercount() {
        return readercount;
    }

    public void setReadercount(Integer readercount) {
        this.readercount = readercount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getOrder1() {
        return order1;
    }

    public void setOrder1(Integer order1) {
        this.order1 = order1;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}