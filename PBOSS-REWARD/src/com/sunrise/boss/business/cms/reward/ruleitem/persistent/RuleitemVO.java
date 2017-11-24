package com.sunrise.boss.business.cms.reward.ruleitem.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.rulerellog.persistent.RulerellogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class RuleitemVO implements OperationLog {
	public Class logVOClass() {
		return RulerellogVO.class;
	}

    /** identifier field */
    private String ruleitemid;

    /** persistent field */
    private String ruleitemname;

    /** nullable persistent field */
    private String backruleitemid;

    /** nullable persistent field */
    private String contype;

    /** nullable persistent field */
    private Byte specflag;
    
    private String vcityid;
    

    public String getVcityid() {
		return vcityid;
	}

	public void setVcityid(String vcityid) {
		this.vcityid = vcityid;
	}

	/** full constructor */
    public RuleitemVO(java.lang.String ruleitemid, java.lang.String ruleitemname, java.lang.String backruleitemid, java.lang.String contype, java.lang.Byte specflag) {
        this.ruleitemid = ruleitemid;
        this.ruleitemname = ruleitemname;
        this.backruleitemid = backruleitemid;
        this.contype = contype;
        this.specflag = specflag;
    }

    /** default constructor */
    public RuleitemVO() {
    }

    /** minimal constructor */
    public RuleitemVO(java.lang.String ruleitemid, java.lang.String ruleitemname) {
        this.ruleitemid = ruleitemid;
        this.ruleitemname = ruleitemname;
    }

    public java.lang.String getRuleitemid() {
        return this.ruleitemid;
    }

    public void setRuleitemid(java.lang.String ruleitemid) {
        this.ruleitemid = ruleitemid;
    }

    public java.lang.String getRuleitemname() {
        return this.ruleitemname;
    }

    public void setRuleitemname(java.lang.String ruleitemname) {
        this.ruleitemname = ruleitemname;
    }

    public java.lang.String getBackruleitemid() {
        return this.backruleitemid;
    }

    public void setBackruleitemid(java.lang.String backruleitemid) {
        this.backruleitemid = backruleitemid;
    }

    public java.lang.String getContype() {
        return this.contype;
    }

    public void setContype(java.lang.String contype) {
        this.contype = contype;
    }

    public java.lang.Byte getSpecflag() {
        return this.specflag;
    }

    public void setSpecflag(java.lang.Byte specflag) {
        this.specflag = specflag;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ruleitemid", getRuleitemid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RuleitemVO) ) return false;
        RuleitemVO castOther = (RuleitemVO) other;
        return new EqualsBuilder()
            .append(this.getRuleitemid(), castOther.getRuleitemid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRuleitemid())
            .toHashCode();
    }

}
