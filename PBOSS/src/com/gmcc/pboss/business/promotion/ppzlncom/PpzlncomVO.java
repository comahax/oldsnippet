package com.gmcc.pboss.business.promotion.ppzlncom;

import com.gmcc.pboss.business.promotion.ppzlncomlog.PpzlncomlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PpzlncomVO extends BaseVO implements BusinessLog, Serializable {

	/** identifier field */
	private String comcategory;

	/** identifier field */
	private Long pid;

	/** full constructor */
	public PpzlncomVO(java.lang.String comcategory, java.lang.Long pid) {
		this.comcategory = comcategory;
		this.pid = pid;
	}

	/** default constructor */
	public PpzlncomVO() {
	}

	public java.lang.String getComcategory() {
		return this.comcategory;
	}

	public void setComcategory(java.lang.String comcategory) {
		this.comcategory = comcategory;
	}

	public java.lang.Long getPid() {
		return this.pid;
	}

	public void setPid(java.lang.Long pid) {
		this.pid = pid;
	}

	public String toString() {
		return new ToStringBuilder(this)
				.append("comcategory", getComcategory())
				.append("pid", getPid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof PpzlncomVO))
			return false;
		PpzlncomVO castOther = (PpzlncomVO) other;
		return new EqualsBuilder().append(this.getComcategory(),
				castOther.getComcategory()).append(this.getPid(),
				castOther.getPid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getComcategory()).append(getPid())
				.toHashCode();
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return PpzlncomlogVO.class;
	}

}
