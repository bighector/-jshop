package net.jeeshop.biz.cms.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class Advert extends BaseModel implements Serializable {
    /** t_advert.title */
    private String title;

    /** t_advert.code */
    private String code;

    /** t_advert.remark */
    private String remark;

    /** t_advert.html */
    private String html;

    /** t_advert.start_date */
    private String startDate;

    /** t_advert.end_date */
    private String endDate;

    /** t_advert.status */
    private String status;

    /** t_advert.use_Images_Random */
    private String useImagesRandom;

    private static final long serialVersionUID = 1L;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html == null ? null : html.trim();
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getUseImagesRandom() {
        return useImagesRandom;
    }

    public void setUseImagesRandom(String useImagesRandom) {
        this.useImagesRandom = useImagesRandom == null ? null : useImagesRandom.trim();
    }
}