package net.jeeshop.biz.cms.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class Hotquery extends BaseModel implements Serializable {
    /** t_hotquery.key1 */
    private String key1;

    /** t_hotquery.url */
    private String url;

    private static final long serialVersionUID = 1L;

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1 == null ? null : key1.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}