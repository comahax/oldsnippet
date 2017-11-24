package com.gmcc.pboss.business.promotion.ppzlnrule;

import com.gmcc.pboss.business.promotion.ppzlnrulelog.PpzlnrulelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PpzlnruleVO extends BaseVO implements BusinessLog, Serializable {

	/** identifier field */
	private Long pid;

	/** identifier field */
	private Long ruleid;

	/** full constructor */
	public PpzlnruleVO(java.lang.Long pid, java.lang.Long ruleid) {
		this.pid = pid;
		this.ruleid = ruleid;
	}

	/** default constructor */
	public PpzlnruleVO() {
	}

	public java.lang.Long getPid() {
		return this.pid;
	}

	public void setPid(java.lang.Long pid) {
		this.pid = pid;
	}

	public java.lang.Long getRuleid() {
		return this.ruleid;
	}

	public void setRuleid(java.lang.Long ruleid) {
		this.ruleid = ruleid;
	}

	public String toString() {
		return new ToStringBuilder(this).append("pid", getPid()).append(
				"ruleid", getRuleid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof PpzlnruleVO))
			return false;
		PpzlnruleVO castOther = (PpzlnruleVO) other;
		return new EqualsBuilder().append(this.getPid(), castOther.getPid())
				.append(this.getRuleid(), castOther.getRuleid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getPid()).append(getRuleid())
				.toHashCode();
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return PpzlnrulelogVO.class;
	}

}
