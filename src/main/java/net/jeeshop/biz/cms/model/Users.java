package net.jeeshop.biz.cms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import net.jeeshop.biz.base.model.BaseModel;

public class Users extends BaseModel implements Serializable {
    /** 会员编号 */
    private Long userId;

    /** 会员Email */
    private String email;

    /** 用户名 */
    private String userName;

    /** 用户密码 */
    private String password;

    /** 密码提问 */
    private String question;

    /** 密码回答 */
    private String answer;

    /** 性别;0保密;1男;2女 */
    private Boolean sex;

    /** 出生日期 */
    private Date birthday;

    /** 用户现有资金 */
    private BigDecimal userMoney;

    /** 用户冻结资金 */
    private BigDecimal frozenMoney;

    /** 消费积分 */
    private Integer payPoints;

    /** 会员等级积分 */
    private Integer rankPoints;

    /** 收货信息id,关联ecs_user_address */
    private Integer addressId;

    /** 注册时间 */
    private Date regTime;

    /** 最后一次登录时间 */
    private Date lastLogin;

    /** 最后一次修改信息时间 */
    private Date lastTime;

    /** 最后一次登录IP */
    private String lastIp;

    /** 会员登记id，取值ecs_user_rank */
    private Short visitCount;

    /** 会员等级 */
    private Byte userRank;

    /** 是否特殊 */
    private Byte isSpecial;

    /** 该等级的最低积分 */
    private Integer salt;

    /** 推荐人会员id */
    private Integer parentId;

    /** 标识 */
    private Byte flag;

    /** 昵称 */
    private String alias;

    /** msn账号 */
    private String msn;

    /** qq账号 */
    private String qq;

    /** 办公电话 */
    private String officePhone;

    /** 家用电话 */
    private String homePhone;

    /** 移动电话 */
    private String mobilePhone;

    /** 是否生效 */
    private Byte isValidated;

    /** 最大消费 */
    private BigDecimal creditLine;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    public BigDecimal getFrozenMoney() {
        return frozenMoney;
    }

    public void setFrozenMoney(BigDecimal frozenMoney) {
        this.frozenMoney = frozenMoney;
    }

    public Integer getPayPoints() {
        return payPoints;
    }

    public void setPayPoints(Integer payPoints) {
        this.payPoints = payPoints;
    }

    public Integer getRankPoints() {
        return rankPoints;
    }

    public void setRankPoints(Integer rankPoints) {
        this.rankPoints = rankPoints;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp == null ? null : lastIp.trim();
    }

    public Short getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Short visitCount) {
        this.visitCount = visitCount;
    }

    public Byte getUserRank() {
        return userRank;
    }

    public void setUserRank(Byte userRank) {
        this.userRank = userRank;
    }

    public Byte getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(Byte isSpecial) {
        this.isSpecial = isSpecial;
    }

    public Integer getSalt() {
        return salt;
    }

    public void setSalt(Integer salt) {
        this.salt = salt;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn == null ? null : msn.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone == null ? null : officePhone.trim();
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone == null ? null : homePhone.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public Byte getIsValidated() {
        return isValidated;
    }

    public void setIsValidated(Byte isValidated) {
        this.isValidated = isValidated;
    }

    public BigDecimal getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(BigDecimal creditLine) {
        this.creditLine = creditLine;
    }
}