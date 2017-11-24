package com.gmcc.pboss.business.promotion.tieinsale;

import com.gmcc.pboss.business.promotion.tieinsalelog.TieinsalelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TieinsaleVO extends BaseVO implements BusinessLog, Serializable {

	/** identifier field */
	private String comcategory;

	/** identifier field */
	private Long ruleid;

	/** nullable persistent field */
	private Short quantity;

	/** nullable persistent field */
	private String tcomcategory;

	/** nullable persistent field */
	private Short tquantity;

	/** full constructor */
	public TieinsaleVO(java.lang.String comcategory, java.lang.Long ruleid,
			java.lang.Short quantity, java.lang.String tcomcategory,
			java.lang.Short tquantity) {
		this.comcategory = comcategory;
		this.ruleid = ruleid;
		this.quantity = quantity;
		this.tcomcategory = tcomcategory;
		this.tquantity = tquantity;
	}

	/** default constructor */
	public TieinsaleVO() {
	}

	/** minimal constructor */
	public TieinsaleVO(java.lang.String comcategory, java.lang.Long ruleid) {
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

	public java.lang.String getTcomcategory() {
		return this.tcomcategory;
	}

	public void setTcomcategory(java.lang.String tcomcategory) {
		this.tcomcategory = tcomcategory;
	}

	public java.lang.Short getTquantity() {
		return this.tquantity;
	}

	public void setTquantity(java.lang.Short tquantity) {
		this.tquantity = tquantity;
	}

	public String toString() {
		return new ToStringBuilder(this)
				.append("comcategory", getComcategory()).append("ruleid",
						getRuleid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof TieinsaleVO))
			return false;
		TieinsaleVO castOther = (TieinsaleVO) other;
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
		return TieinsalelogVO.class;
	}

}
