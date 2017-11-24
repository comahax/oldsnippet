package com.sunrise.boss.business.cms.reward.ruleexp.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RuleexpVO implements Serializable {

    /** identifier field */
    private String cityid;

    /** identifier field */
    private String ruleid;

    /** identifier field */
    private Integer rulemodeid;

    /** nullable persistent field */
    private Byte state;

    /** persistent field */
    private Long taskid;

    /** nullable persistent field */
    private String ruleitemexp;

    /** nullable persistent field */
    private String remark;

    /** full constructor */
    public RuleexpVO(java.lang.String cityid, java.lang.String ruleid, java.lang.Integer rulemodeid, java.lang.Byte state, java.lang.Long taskid, java.lang.String ruleitemexp, java.lang.String remark) {
        this.cityid = cityid;
        this.ruleid = ruleid;
        this.rulemodeid = rulemodeid;
        this.state = state;
        this.taskid = taskid;
        this.ruleitemexp = ruleitemexp;
        this.remark = remark;
    }

    /** default constructor */
    public RuleexpVO() {
    }

    /** minimal constructor */
    public RuleexpVO(java.lang.String cityid, java.lang.String ruleid, java.lang.Integer rulemodeid, java.lang.Long taskid) {
        this.cityid = cityid;
        this.ruleid = ruleid;
        this.rulemodeid = rulemodeid;
        this.taskid = taskid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.String ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.Integer getRulemodeid() {
        return this.rulemodeid;
    }

    public void setRulemodeid(java.lang.Integer rulemodeid) {
        this.rulemodeid = rulemodeid;
    }

    public java.lang.Byte getState() {
        return this.state;
    }

    public void setState(java.lang.Byte state) {
        this.state = state;
    }

    public java.lang.Long getTaskid() {
        return this.taskid;
    }

    public void setTaskid(java.lang.Long taskid) {
        this.taskid = taskid;
    }

    public java.lang.String getRuleitemexp() {
        return this.ruleitemexp;
    }

    public void setRuleitemexp(java.lang.String ruleitemexp) {
        this.ruleitemexp = ruleitemexp;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("ruleid", getRuleid())
            .append("rulemodeid", getRulemodeid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RuleexpVO) ) return false;
        RuleexpVO castOther = (RuleexpVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getRuleid(), castOther.getRuleid())
            .append(this.getRulemodeid(), castOther.getRulemodeid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getRuleid())
            .append(getRulemodeid())
            .toHashCode();
    }

}
