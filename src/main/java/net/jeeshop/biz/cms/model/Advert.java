package net.jeeshop.biz.cms.model;

import java.io.Serializable;
import java.util.Date;
import net.jeeshop.biz.base.model.BaseModel;

public class Advert extends BaseModel implements Serializable {
    /** 标题 */
    private String title;

    /** 代码 */
    private String code;

    /** 备注 */
    private String remark;

    /** HTML页面信息 */
    private String html;

    /** 开始时间 */
    private Date startDate;

    /** 结束时间 */
    private Date endDate;

    /** 广告状态 */
    private String status;

    /** 是否使用随机图片 */
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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