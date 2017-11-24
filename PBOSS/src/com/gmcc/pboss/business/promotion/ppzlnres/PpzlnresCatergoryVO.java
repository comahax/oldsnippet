package com.gmcc.pboss.business.promotion.ppzlnres;

import com.sunrise.jop.infrastructure.db.BaseVO;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PpzlnresCatergoryVO extends BaseVO implements Serializable {

	/** identifier field */
	private String comcategory;

	/** identifier field */
	private String resid;

	/** full constructor */
	public PpzlnresCatergoryVO(java.lang.String comcategory,
			java.lang.String resid) {
		this.comcategory = comcategory;
		this.resid = resid;
	}

	/** default constructor */
	public PpzlnresCatergoryVO() {
	}

	public java.lang.String getComcategory() {
		return this.comcategory;
	}

	public void setComcategory(java.lang.String comcategory) {
		this.comcategory = comcategory;
	}

	public java.lang.String getResid() {
		return this.resid;
	}

	public void setResid(java.lang.String resid) {
		this.resid = resid;
	}

	public String toString() {
		return new ToStringBuilder(this).append("pid", getComcategory())
				.append("resid", getResid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof PpzlnresCatergoryVO))
			return false;
		PpzlnresCatergoryVO castOther = (PpzlnresCatergoryVO) other;
		return new EqualsBuilder().append(this.getComcategory(),
				castOther.getComcategory()).append(this.getResid(),
				castOther.getResid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getComcategory())
				.append(getResid()).toHashCode();
	}
}
