package com.sunrise.boss.business.cms.reward.ruleitemrl.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RuleitemrlVO implements Serializable {

    /** identifier field */
    private Short groupid;

    /** identifier field */
    private String ruleid;

    /** nullable persistent field */
    private Short rltype;

    /** nullable persistent field */
    private String ruleitemid;

    /** nullable persistent field */
    private Short isleader;

    /** full constructor */
    public RuleitemrlVO(java.lang.Short groupid, java.lang.String ruleid, java.lang.Short rltype, java.lang.String ruleitemid, java.lang.Short isleader) {
        this.groupid = groupid;
        this.ruleid = ruleid;
        this.rltype = rltype;
        this.ruleitemid = ruleitemid;
        this.isleader = isleader;
    }

    /** default constructor */
    public RuleitemrlVO() {
    }

    /** minimal constructor */
    public RuleitemrlVO(java.lang.Short groupid, java.lang.String ruleid) {
        this.groupid = groupid;
        this.ruleid = ruleid;
    }

    public java.lang.Short getGroupid() {
        return this.groupid;
    }

    public void setGroupid(java.lang.Short groupid) {
        this.groupid = groupid;
    }

    public java.lang.String getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.String ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.Short getRltype() {
        return this.rltype;
    }

    public void setRltype(java.lang.Short rltype) {
        this.rltype = rltype;
    }

    public java.lang.String getRuleitemid() {
        return this.ruleitemid;
    }

    public void setRuleitemid(java.lang.String ruleitemid) {
        this.ruleitemid = ruleitemid;
    }

    public java.lang.Short getIsleader() {
        return this.isleader;
    }

    public void setIsleader(java.lang.Short isleader) {
        this.isleader = isleader;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("groupid", getGroupid())
            .append("ruleid", getRuleid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RuleitemrlVO) ) return false;
        RuleitemrlVO castOther = (RuleitemrlVO) other;
        return new EqualsBuilder()
            .append(this.getGroupid(), castOther.getGroupid())
            .append(this.getRuleid(), castOther.getRuleid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getGroupid())
            .append(getRuleid())
            .toHashCode();
    }

}
