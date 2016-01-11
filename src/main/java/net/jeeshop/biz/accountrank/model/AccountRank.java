package net.jeeshop.biz.accountrank.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class AccountRank extends BaseModel implements Serializable {
    /** t_accountrank.code */
    private String code;

    /** t_accountrank.name */
    private String name;

    /** t_accountrank.minScore */
    private Integer minscore;

    /** t_accountrank.maxScore */
    private Integer maxscore;

    /** t_accountrank.remark */
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

    public Integer getMinscore() {
        return minscore;
    }

    public void setMinscore(Integer minscore) {
        this.minscore = minscore;
    }

    public Integer getMaxscore() {
        return maxscore;
    }

    public void setMaxscore(Integer maxscore) {
        this.maxscore = maxscore;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}