package com.gmcc.pboss.business.resource.numsortrule;

import com.gmcc.pboss.business.resource.numsortrulelog.NumsortrulelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class NumsortruleVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private Long ruleid;

    /** nullable persistent field */
    private Long typeid;

    /** persistent field */
    private String ruleexp;

    /** full constructor */
    public NumsortruleVO(java.lang.Long typeid, java.lang.String ruleexp) {
        this.typeid = typeid;
        this.ruleexp = ruleexp;
    }

    /** default constructor */
    public NumsortruleVO() {
    }

    /** minimal constructor */
    public NumsortruleVO(java.lang.String ruleexp) {
        this.ruleexp = ruleexp;
    }

    public java.lang.Long getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.Long ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.Long getTypeid() {
        return this.typeid;
    }

    public void setTypeid(java.lang.Long typeid) {
        this.typeid = typeid;
    }

    public java.lang.String getRuleexp() {
        return this.ruleexp;
    }

    public void setRuleexp(java.lang.String ruleexp) {
        this.ruleexp = ruleexp;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ruleid", getRuleid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof NumsortruleVO) ) return false;
        NumsortruleVO castOther = (NumsortruleVO) other;
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
		return NumsortrulelogVO.class;
	}

}
