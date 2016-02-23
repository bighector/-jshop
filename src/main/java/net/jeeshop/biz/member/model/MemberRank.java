package net.jeeshop.biz.member.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class MemberRank extends BaseModel implements Serializable {
    /** 代码 */
    private String code;

    /** 等级名称 */
    private String name;

    /** 积分上限 */
    private Integer minScore;

    /** 积分下限 */
    private Integer maxScore;

    /** 备注 */
    private String remark;

    private static final long serialVersionUID = 1L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}