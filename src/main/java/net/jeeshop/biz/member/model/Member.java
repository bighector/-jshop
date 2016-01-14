package net.jeeshop.biz.member.model;

import java.io.Serializable;
import java.util.Date;
import net.jeeshop.biz.base.model.BaseModel;

public class Member extends BaseModel implements Serializable {
    /** 登录名 */
    private String username;

    /** 昵称 */
    private String nickname;

    /** 密码 */
    private String password;

    /** 省份 */
    private String province;

    /** 城市 */
    private String city;

    /** 联系地址 */
    private String address;

    /** 邮政编码 */
    private String postCode;

    /** 证件类型 */
    private String cardType;

    /** 证件号 */
    private String cardNo;

    /** 手机号 */
    private String mobile;

    /** 电子邮箱 */
    private String email;

    /** 邮箱是否已经激活,y-是，n-否 */
    private String isEmailActive;

    /** 是否冻结,y-是,n-否 */
    private String freeze;

    /** 最后登录时间 */
    private Date lastLoginTime;

    /** 最后登录IP */
    private String lastLoginIp;

    /** 最后登录区域 */
    private String lastLoginArea;

    /** 是否异地登录,y-是,n-否 */
    private String diffAreaLogin;

    /** 注册时间 */
    private Date registTime;

    /** 冻结开始时间 */
    private Date freezeStartTime;

    /** 冻结结束时间 */
    private Date freezeEndTime;

    /** 性别，1-男2-女0-未知 */
    private String gender;

    /** 真实姓名 */
    private String realName;

    /** 出生日期 */
    private Date birthday;

    /** 用户等级 */
    private Long memberRank;

    private static final long serialVersionUID = 1L;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIsEmailActive() {
        return isEmailActive;
    }

    public void setIsEmailActive(String isEmailActive) {
        this.isEmailActive = isEmailActive == null ? null : isEmailActive.trim();
    }

    public String getFreeze() {
        return freeze;
    }

    public void setFreeze(String freeze) {
        this.freeze = freeze == null ? null : freeze.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public String getLastLoginArea() {
        return lastLoginArea;
    }

    public void setLastLoginArea(String lastLoginArea) {
        this.lastLoginArea = lastLoginArea == null ? null : lastLoginArea.trim();
    }

    public String getDiffAreaLogin() {
        return diffAreaLogin;
    }

    public void setDiffAreaLogin(String diffAreaLogin) {
        this.diffAreaLogin = diffAreaLogin == null ? null : diffAreaLogin.trim();
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public Date getFreezeStartTime() {
        return freezeStartTime;
    }

    public void setFreezeStartTime(Date freezeStartTime) {
        this.freezeStartTime = freezeStartTime;
    }

    public Date getFreezeEndTime() {
        return freezeEndTime;
    }

    public void setFreezeEndTime(Date freezeEndTime) {
        this.freezeEndTime = freezeEndTime;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getMemberRank() {
        return memberRank;
    }

    public void setMemberRank(Long memberRank) {
        this.memberRank = memberRank;
    }
}