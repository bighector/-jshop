package net.jeeshop.biz.advert.model;

import java.io.Serializable;
import java.sql.Date;

import net.jeeshop.biz.base.model.BaseModel;

public class Advert extends BaseModel implements Serializable{
	 /** 广告标题*/
    private String title;

    /** code */
    private String code;
    
    /** 备注 */
    private String remark;
    
    /** html */
    private String html;

    /** 状态,n-有效，y-无效 */
    private String status;
    
    /** 开始时间 */
    private Date startdate;
    
    /** 结束时间 */
    private Date enddate;

    /**图片优先级  */
    private String useImagesRandom;

    private static final long serialVersionUID = 1L;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title== null ? null : title.trim();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code==  null ? null : code.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark==  null ? null : remark.trim();
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html==  null ? null : html.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status==  null ? null : status.trim();
	}
	

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getUseImagesRandom() {
		return useImagesRandom;
	}

	public void setUseImagesRandom(String useImagesRandom) {
		this.useImagesRandom = useImagesRandom==  null ? null : useImagesRandom.trim();
	}

}
