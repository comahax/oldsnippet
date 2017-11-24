package com.sunrise.boss.business.zifee.yxplanpresnt.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.zifee.yxplanpstlog.persistent.YxplanpstlogVO;

/** @author Hibernate CodeGenerator */
public class YxplanpresntVO implements Serializable,OperationLog {

	/** identifier field */
	private Long acctid;

	/** identifier field */
	private Integer presentinterval;

	/** identifier field */
	private Long yxplanid;

	/** persistent field */
	private Integer presentcycles;

	/** nullable persistent field */
	private Float presentrate;

	/** nullable persistent field */
	private Long eboxunitid;

	/** full constructor */
	public YxplanpresntVO(java.lang.Long acctid,
			java.lang.Integer presentinterval, java.lang.Long yxplanid,
			java.lang.Integer presentcycles, java.lang.Float presentrate,
			java.lang.Long eboxunitid) {
		this.acctid = acctid;
		this.presentinterval = presentinterval;
		this.yxplanid = yxplanid;
		this.presentcycles = presentcycles;
		this.presentrate = presentrate;
		this.eboxunitid = eboxunitid;
	}

	/** default constructor */
	public YxplanpresntVO() {
	}

	/** minimal constructor */
	public YxplanpresntVO(java.lang.Long acctid,
			java.lang.Integer presentinterval, java.lang.Long yxplanid) {
		this.acctid = acctid;
		this.presentinterval = presentinterval;
		this.yxplanid = yxplanid;
	}

	public String toString() {
		return new ToStringBuilder(this).append("acctid", getAcctid()).append(
				"presentinterval", getPresentinterval()).append("yxplanid",
				getYxplanid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof YxplanpresntVO))
			return false;
		YxplanpresntVO castOther = (YxplanpresntVO) other;
		return new EqualsBuilder().append(this.getAcctid(),
				castOther.getAcctid()).append(this.getPresentinterval(),
				castOther.getPresentinterval()).append(this.getYxplanid(),
				castOther.getYxplanid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getAcctid()).append(
				getPresentinterval()).append(getYxplanid()).toHashCode();
	}

	public Long getAcctid() {
		return acctid;
	}

	public void setAcctid(Long acctid) {
		this.acctid = acctid;
	}

	public Long getEboxunitid() {
		return eboxunitid;
	}

	public void setEboxunitid(Long eboxunitid) {
		this.eboxunitid = eboxunitid;
	}

	public Integer getPresentcycles() {
		return presentcycles;
	}

	public void setPresentcycles(Integer presentcycles) {
		this.presentcycles = presentcycles;
	}

	public Integer getPresentinterval() {
		return presentinterval;
	}

	public void setPresentinterval(Integer presentinterval) {
		this.presentinterval = presentinterval;
	}

	public Float getPresentrate() {
		return presentrate;
	}

	public void setPresentrate(Float presentrate) {
		this.presentrate = presentrate;
	}

	public Long getYxplanid() {
		return yxplanid;
	}

	public void setYxplanid(Long yxplanid) {
		this.yxplanid = yxplanid;
	}
	public Class logVOClass() {
		return YxplanpstlogVO.class;
	}
}
