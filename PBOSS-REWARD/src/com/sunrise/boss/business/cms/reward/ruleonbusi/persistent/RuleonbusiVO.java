package com.sunrise.boss.business.cms.reward.ruleonbusi.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RuleonbusiVO implements Serializable {

    /** identifier field */
    private String opnid;

    /** identifier field */
    private String ruleid;

    /** full constructor */
    public RuleonbusiVO(java.lang.String opnid, java.lang.String ruleid) {
        this.opnid = opnid;
        this.ruleid = ruleid;
    }

    /** default constructor */
    public RuleonbusiVO() {
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.String ruleid) {
        this.ruleid = ruleid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("opnid", getOpnid())
            .append("ruleid", getRuleid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RuleonbusiVO) ) return false;
        RuleonbusiVO castOther = (RuleonbusiVO) other;
        return new EqualsBuilder()
            .append(this.getOpnid(), castOther.getOpnid())
            .append(this.getRuleid(), castOther.getRuleid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOpnid())
            .append(getRuleid())
            .toHashCode();
    }

}
