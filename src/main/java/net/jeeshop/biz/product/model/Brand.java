package net.jeeshop.biz.product.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class Brand extends BaseModel implements Serializable {
    /** 品牌名称 */
    private String brandName;

    /** 品牌LOGO */
    private String logo;

    /** 官方网站 */
    private String officeSite;

    /** 描述信息 */
    private String description;

    /** 排序 */
    private Long ordinal;

    private static final long serialVersionUID = 1L;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getOfficeSite() {
        return officeSite;
    }

    public void setOfficeSite(String officeSite) {
        this.officeSite = officeSite == null ? null : officeSite.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Long ordinal) {
        this.ordinal = ordinal;
    }
}