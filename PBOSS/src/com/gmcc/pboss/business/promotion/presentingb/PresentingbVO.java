package com.gmcc.pboss.business.promotion.presentingb;

import com.gmcc.pboss.business.promotion.presentingblog.PresentingblogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PresentingbVO extends BaseVO implements BusinessLog, Serializable {

	/** identifier field */
	private String comcategory;

	/** identifier field */
	private Long ruleid;

	/** nullable persistent field */
	private Short quantity;

	/** nullable persistent field */
	private String pcomcategory;

	/** nullable persistent field */
	private Short pquantity;

	/** full constructor */
	public PresentingbVO(java.lang.String comcategory, java.lang.Long ruleid,
			java.lang.Short quantity, java.lang.String pcomcategory,
			java.lang.Short pquantity) {
		this.comcategory = comcategory;
		this.ruleid = ruleid;
		this.quantity = quantity;
		this.pcomcategory = pcomcategory;
		this.pquantity = pquantity;
	}

	/** default constructor */
	public PresentingbVO() {
	}

	/** minimal constructor */
	public PresentingbVO(java.lang.String comcategory, java.lang.Long ruleid) {
		this.comcategory = comcategory;
		this.ruleid = ruleid;
	}

	public java.lang.String getComcategory() {
		return this.comcategory;
	}

	public void setComcategory(java.lang.String comcategory) {
		this.comcategory = comcategory;
	}

	public java.lang.Long getRuleid() {
		return this.ruleid;
	}

	public void setRuleid(java.lang.Long ruleid) {
		this.ruleid = ruleid;
	}

	public java.lang.Short getQuantity() {
		return this.quantity;
	}

	public void setQuantity(java.lang.Short quantity) {
		this.quantity = quantity;
	}

	public java.lang.String getPcomcategory() {
		return this.pcomcategory;
	}

	public void setPcomcategory(java.lang.String pcomcategory) {
		this.pcomcategory = pcomcategory;
	}

	public java.lang.Short getPquantity() {
		return this.pquantity;
	}

	public void setPquantity(java.lang.Short pquantity) {
		this.pquantity = pquantity;
	}

	public String toString() {
		return new ToStringBuilder(this)
				.append("comcategory", getComcategory()).append("ruleid",
						getRuleid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof PresentingbVO))
			return false;
		PresentingbVO castOther = (PresentingbVO) other;
		return new EqualsBuilder().append(this.getComcategory(),
				castOther.getComcategory()).append(this.getRuleid(),
				castOther.getRuleid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getComcategory()).append(
				getRuleid()).toHashCode();
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return PresentingblogVO.class;
	}

}
