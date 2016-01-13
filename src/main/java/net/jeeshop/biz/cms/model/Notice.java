package net.jeeshop.biz.cms.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class Notice extends BaseModel implements Serializable {
    /** t_notice.title */
    private String title;

    /** t_notice.reader_count */
    private Integer readerCount;

    /** t_notice.status */
    private String status;

    /** t_notice.ordinal */
    private Integer ordinal;

    /** t_notice.content */
    private String content;
    
    
    public static final String   status_y = "y";//显示
	public static final String   status_n = "n";//不显示
    
  
    

    private static final long serialVersionUID = 1L;
    
    


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getReaderCount() {
        return readerCount;
    }

    public void setReaderCount(Integer readerCount) {
        this.readerCount = readerCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}