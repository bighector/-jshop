package net.jeeshop.biz.system.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class SystemSetting extends BaseModel implements Serializable {
    /** 系统代号 */
    private String systemCode;

    /** 应用名称 */
    private String appName;

    /** 门户页面 */
    private String website;

    /** LOGO */
    private String logo;

    /** 标题 */
    private String title;

    /** 描述信息 */
    private String description;

    /** 关键字 */
    private String keywords;

    /** 图标 */
    private String shortcutIcon;

    /** 联系地址 */
    private String address;

    /** 联系电话 */
    private String telphone;

    /** 邮箱 */
    private String email;

    /** 备案号 */
    private String icp;

    /** 是否开放,1-是0-否 */
    private Boolean isOpen;

    /** 网站关闭提示语 */
    private String closeMsg;

    /** 图片根路径 */
    private String imageRootPath;

    /** 默认产品图片 */
    private String defaultProductImg;

    /** 样式 */
    private String style;

    /** 系统版本号 */
    private String version;

    /** 统计代码 */
    private String statisticsCode;

    /** 是否开放响应式,1-是0-否 */
    private String isResponsive;

    /** 图片集 */
    private String images;

    private static final long serialVersionUID = 1L;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode == null ? null : systemCode.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getShortcutIcon() {
        return shortcutIcon;
    }

    public void setShortcutIcon(String shortcutIcon) {
        this.shortcutIcon = shortcutIcon == null ? null : shortcutIcon.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIcp() {
        return icp;
    }

    public void setIcp(String icp) {
        this.icp = icp == null ? null : icp.trim();
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public String getCloseMsg() {
        return closeMsg;
    }

    public void setCloseMsg(String closeMsg) {
        this.closeMsg = closeMsg == null ? null : closeMsg.trim();
    }

    public String getImageRootPath() {
        return imageRootPath;
    }

    public void setImageRootPath(String imageRootPath) {
        this.imageRootPath = imageRootPath == null ? null : imageRootPath.trim();
    }

    public String getDefaultProductImg() {
        return defaultProductImg;
    }

    public void setDefaultProductImg(String defaultProductImg) {
        this.defaultProductImg = defaultProductImg == null ? null : defaultProductImg.trim();
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getStatisticsCode() {
        return statisticsCode;
    }

    public void setStatisticsCode(String statisticsCode) {
        this.statisticsCode = statisticsCode == null ? null : statisticsCode.trim();
    }

    public String getIsResponsive() {
        return isResponsive;
    }

    public void setIsResponsive(String isResponsive) {
        this.isResponsive = isResponsive == null ? null : isResponsive.trim();
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }
}