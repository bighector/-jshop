package net.jeeshop.biz.system.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class SystemSetting extends BaseModel implements Serializable {
    /** 系统代号 */
    private String systemCode;

    /** 系统名称 */
    private String name;

    /** 门户页面 */
    private String www;

    /** logo */
    private String logo;

    /** 标题 */
    private String title;

    /** 描述 */
    private String description;

    /** 关键字 */
    private String keywords;

    /** 图标 */
    private String shortcuticon;

    /** 地址 */
    private String address;

    /** 联系电话 */
    private String tel;

    /** 联系邮箱 */
    private String email;

    /** 备案号 */
    private String icp;

    /** 是否开放 */
    private String isOpen;

    /** 关站信息 */
    private String closeMsg;

    /** QQ */
    private String qq;

    /** 图片根路径 */
    private String imageRootPath;

    /** 后台地址 */
    private String manageHttp;

    /** 默认产品图片 */
    private String defaultProductImg;

    /** 样式 */
    private String style;

    /** 版本号 */
    private String version;

    /** 后台左侧菜单叶子节点的图标 */
    private String manageLeftTreeLeafIcon;

    /** 站长统计代码 */
    private String statisticsCode;

    /** 是否开放响应式 */
    private String openResponsive;

    /** qq 联系信息 */
    private String qqHelpHtml;

    /** 图片 */
    private String images;

    private static final long serialVersionUID = 1L;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode == null ? null : systemCode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www == null ? null : www.trim();
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

    public String getShortcuticon() {
        return shortcuticon;
    }

    public void setShortcuticon(String shortcuticon) {
        this.shortcuticon = shortcuticon == null ? null : shortcuticon.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
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

    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen == null ? null : isOpen.trim();
    }

    public String getCloseMsg() {
        return closeMsg;
    }

    public void setCloseMsg(String closeMsg) {
        this.closeMsg = closeMsg == null ? null : closeMsg.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getImageRootPath() {
        return imageRootPath;
    }

    public void setImageRootPath(String imageRootPath) {
        this.imageRootPath = imageRootPath == null ? null : imageRootPath.trim();
    }

    public String getManageHttp() {
        return manageHttp;
    }

    public void setManageHttp(String manageHttp) {
        this.manageHttp = manageHttp == null ? null : manageHttp.trim();
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

    public String getManageLeftTreeLeafIcon() {
        return manageLeftTreeLeafIcon;
    }

    public void setManageLeftTreeLeafIcon(String manageLeftTreeLeafIcon) {
        this.manageLeftTreeLeafIcon = manageLeftTreeLeafIcon == null ? null : manageLeftTreeLeafIcon.trim();
    }

    public String getStatisticsCode() {
        return statisticsCode;
    }

    public void setStatisticsCode(String statisticsCode) {
        this.statisticsCode = statisticsCode == null ? null : statisticsCode.trim();
    }

    public String getOpenResponsive() {
        return openResponsive;
    }

    public void setOpenResponsive(String openResponsive) {
        this.openResponsive = openResponsive == null ? null : openResponsive.trim();
    }

    public String getQqHelpHtml() {
        return qqHelpHtml;
    }

    public void setQqHelpHtml(String qqHelpHtml) {
        this.qqHelpHtml = qqHelpHtml == null ? null : qqHelpHtml.trim();
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }
}