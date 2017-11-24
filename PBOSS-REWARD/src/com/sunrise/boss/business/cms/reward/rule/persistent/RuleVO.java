package com.sunrise.boss.business.cms.reward.rule.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.rulelog.persistent.RulelogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class RuleVO implements OperationLog {
	public Class logVOClass() {
		return RulelogVO.class;
	}

    /** identifier field */
    private String ruleid;

    /** nullable persistent field */
    private String rulename;

    /** nullable persistent field */
    private java.util.Date startdate;

    /** nullable persistent field */
    private java.util.Date enddate;

    /** nullable persistent field */
    private String remark;
    
    private String ruletype;

    /** full constructor */
    public RuleVO(java.lang.String ruleid, java.lang.String rulename, java.util.Date startdate, java.util.Date enddate, java.lang.String remark, java.lang.String ruletype) {
        this.ruleid = ruleid;
        this.rulename = rulename;
        this.startdate = startdate;
        this.enddate = enddate;
        this.remark = remark;
        this.ruletype = ruletype;
    }

    /** default constructor */
    public RuleVO() {
    }

    /** minimal constructor */
    public RuleVO(java.lang.String ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.String getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.String ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.String getRulename() {
        return this.rulename;
    }

    public void setRulename(java.lang.String rulename) {
        this.rulename = rulename;
    }

    public java.util.Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(java.util.Date startdate) {
        this.startdate = startdate;
    }

    public java.util.Date getEnddate() {
        return this.enddate;
    }

    public void setEnddate(java.util.Date enddate) {
        this.enddate = enddate;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ruleid", getRuleid())
            .toString();
    }

    public String getRuletype() {
		return ruletype;
	}

	public void setRuletype(String ruletype) {
		this.ruletype = ruletype;
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

}
