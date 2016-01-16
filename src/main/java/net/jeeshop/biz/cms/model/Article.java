package net.jeeshop.biz.cms.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class Article extends BaseModel implements Serializable {
    /** 标题 */
    private String title;

    /** 副标题 */
    private String secondTitle;

    /** 标题简称 */
    private String code;

    /** 阅读次数 */
    private Integer readerCount;

    /** 文章是否显示到门户。y:显示；n：不显示；默认是n */
    private String status;

    /** 文章目录ID,一个目录下面有多个文章，跟字典似的 */
    private Long catalogId;

    /** 排序 */
    private Integer order1;

    /** 通知：notice；帮助：help */
    private String type;

    /** 内容 */
    private String content;

    private static final long serialVersionUID = 1L;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSecondTitle() {
        return secondTitle;
    }

    public void setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle == null ? null : secondTitle.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public Integer getOrder1() {
        return order1;
    }

    public void setOrder1(Integer order1) {
        this.order1 = order1;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}