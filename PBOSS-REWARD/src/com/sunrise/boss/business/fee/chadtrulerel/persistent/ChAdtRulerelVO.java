package com.sunrise.boss.business.fee.chadtrulerel.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChAdtRulerelVO implements Serializable {

    /** identifier field */
    private String cityid;

    /** identifier field */
    private String ruleid;

    /** identifier field */
    private String ruleitemid;

    /** identifier field */
    private Long rulemodeid;

    /** nullable persistent field */
    private Short state;

    /** nullable persistent field */
    private Short isdefault;

    /** nullable persistent field */
    private String paramer;

    /** full constructor */
    public ChAdtRulerelVO(java.lang.String cityid, java.lang.String ruleid, java.lang.String ruleitemid, java.lang.Long rulemodeid, java.lang.Short state, java.lang.Short isdefault, java.lang.String paramer) {
        this.cityid = cityid;
        this.ruleid = ruleid;
        this.ruleitemid = ruleitemid;
        this.rulemodeid = rulemodeid;
        this.state = state;
        this.isdefault = isdefault;
        this.paramer = paramer;
    }

    /** default constructor */
    public ChAdtRulerelVO() {
    }

    /** minimal constructor */
    public ChAdtRulerelVO(java.lang.String cityid, java.lang.String ruleid, java.lang.String ruleitemid, java.lang.Long rulemodeid) {
        this.cityid = cityid;
        this.ruleid = ruleid;
        this.ruleitemid = ruleitemid;
        this.rulemodeid = rulemodeid;
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

    public java.lang.String getRuleitemid() {
        return this.ruleitemid;
    }

    public void setRuleitemid(java.lang.String ruleitemid) {
        this.ruleitemid = ruleitemid;
    }

    public java.lang.Long getRulemodeid() {
        return this.rulemodeid;
    }

    public void setRulemodeid(java.lang.Long rulemodeid) {
        this.rulemodeid = rulemodeid;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.lang.Short getIsdefault() {
        return this.isdefault;
    }

    public void setIsdefault(java.lang.Short isdefault) {
        this.isdefault = isdefault;
    }

    public java.lang.String getParamer() {
        return this.paramer;
    }

    public void setParamer(java.lang.String paramer) {
        this.paramer = paramer;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("ruleid", getRuleid())
            .append("ruleitemid", getRuleitemid())
            .append("rulemodeid", getRulemodeid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChAdtRulerelVO) ) return false;
        ChAdtRulerelVO castOther = (ChAdtRulerelVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getRuleid(), castOther.getRuleid())
            .append(this.getRuleitemid(), castOther.getRuleitemid())
            .append(this.getRulemodeid(), castOther.getRulemodeid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getRuleid())
            .append(getRuleitemid())
            .append(getRulemodeid())
            .toHashCode();
    }

}
