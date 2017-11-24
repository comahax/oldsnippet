package com.gmcc.pboss.business.promotion.rule;

import com.gmcc.pboss.business.promotion.rulelog.RulelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RuleVO extends BaseVO implements BusinessLog, Serializable {

    /** identifier field */
    private Long ruleid;

    /** persistent field */
    private String rulename;

    /** persistent field */
    private String pri;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public RuleVO(java.lang.String rulename, java.lang.String pri, java.lang.String memo) {
        this.rulename = rulename;
        this.pri = pri;
        this.memo = memo;
    }

    /** default constructor */
    public RuleVO() {
    }

    /** minimal constructor */
    public RuleVO(java.lang.String rulename, java.lang.String pri) {
        this.rulename = rulename;
        this.pri = pri;
    }

    public java.lang.Long getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.Long ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.String getRulename() {
        return this.rulename;
    }

    public void setRulename(java.lang.String rulename) {
        this.rulename = rulename;
    }

    public java.lang.String getPri() {
        return this.pri;
    }

    public void setPri(java.lang.String pri) {
        this.pri = pri;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ruleid", getRuleid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RuleVO) ) return false;
        RuleVO castOther = (RuleVO) other;
        return new EqualsBuilder()
            .append(this.getRuleid(), castOther.getRuleid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRuleid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return RulelogVO.class;
	}

}
