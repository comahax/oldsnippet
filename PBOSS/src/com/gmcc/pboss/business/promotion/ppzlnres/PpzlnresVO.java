package com.gmcc.pboss.business.promotion.ppzlnres;

import com.gmcc.pboss.business.promotion.ppzlnreslog.PpzlnreslogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PpzlnresVO extends BaseVO implements BusinessLog, Serializable {

	/** identifier field */
	private Long pid;

	/** identifier field */
	private String resid;

	/** full constructor */
	public PpzlnresVO(java.lang.Long pid, java.lang.String resid) {
		this.pid = pid;
		this.resid = resid;
	}

	/** default constructor */
	public PpzlnresVO() {
	}

	public java.lang.Long getPid() {
		return this.pid;
	}

	public void setPid(java.lang.Long pid) {
		this.pid = pid;
	}

	public java.lang.String getResid() {
		return this.resid;
	}

	public void setResid(java.lang.String resid) {
		this.resid = resid;
	}

	public String toString() {
		return new ToStringBuilder(this).append("pid", getPid()).append(
				"resid", getResid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof PpzlnresVO))
			return false;
		PpzlnresVO castOther = (PpzlnresVO) other;
		return new EqualsBuilder().append(this.getPid(), castOther.getPid())
				.append(this.getResid(), castOther.getResid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getPid()).append(getResid())
				.toHashCode();
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return PpzlnreslogVO.class;
	}
}
