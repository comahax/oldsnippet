package com.gmcc.pboss.business.promotion.pquantity;

import com.gmcc.pboss.business.promotion.pquantitylog.PquantitylogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PquantityVO extends BaseVO implements BusinessLog, Serializable {

	/** identifier field */
	private String prodid;

	/** identifier field */
	private Long ruleid;

	/** nullable persistent field */
	private String incat;

	/** nullable persistent field */
	private Float incratio;

	/** full constructor */
	public PquantityVO(java.lang.String prodid, java.lang.Long ruleid,
			java.lang.String incat, java.lang.Float incratio) {
		this.prodid = prodid;
		this.ruleid = ruleid;
		this.incat = incat;
		this.incratio = incratio;
	}

	/** default constructor */
	public PquantityVO() {
	}

	/** minimal constructor */
	public PquantityVO(java.lang.String prodid, java.lang.Long ruleid) {
		this.prodid = prodid;
		this.ruleid = ruleid;
	}

	public java.lang.String getProdid() {
		return this.prodid;
	}

	public void setProdid(java.lang.String prodid) {
		this.prodid = prodid;
	}

	public java.lang.Long getRuleid() {
		return this.ruleid;
	}

	public void setRuleid(java.lang.Long ruleid) {
		this.ruleid = ruleid;
	}

	public java.lang.String getIncat() {
		return this.incat;
	}

	public void setIncat(java.lang.String incat) {
		this.incat = incat;
	}

	public java.lang.Float getIncratio() {
		return this.incratio;
	}

	public void setIncratio(java.lang.Float incratio) {
		this.incratio = incratio;
	}

	public String toString() {
		return new ToStringBuilder(this).append("prodid", getProdid()).append(
				"ruleid", getRuleid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof PquantityVO))
			return false;
		PquantityVO castOther = (PquantityVO) other;
		return new EqualsBuilder().append(this.getProdid(),
				castOther.getProdid()).append(this.getRuleid(),
				castOther.getRuleid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getProdid()).append(getRuleid())
				.toHashCode();
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return PquantitylogVO.class;
	}

}
