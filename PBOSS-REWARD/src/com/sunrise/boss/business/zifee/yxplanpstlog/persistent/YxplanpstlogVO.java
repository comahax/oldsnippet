package com.sunrise.boss.business.zifee.yxplanpstlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class YxplanpstlogVO implements Serializable {

	/** identifier field */
	private Long logid;

	/** persistent field */
	private java.util.Date optime;

	/** persistent field */
	private String oprcode;

	/** persistent field */
	private String oprtype;

	/** nullable persistent field */
	private String success;

	/** nullable persistent field */
	private Long yxplanid;

	/** nullable persistent field */
	private Long acctid;

	/** nullable persistent field */
	private Integer presentinterval;

	/** nullable persistent field */
	private Integer presentcycles;

	/** nullable persistent field */
	private Float presentrate;

	/** nullable persistent field */
	private Long eboxunitid;

	/** full constructor */
	public YxplanpstlogVO(java.lang.Long logid, java.util.Date optime,
			java.lang.String oprcode, java.lang.String oprtype,
			java.lang.String success, java.lang.Long yxplanid,
			java.lang.Long acctid, java.lang.Integer presentinterval,
			java.lang.Integer presentcycles, java.lang.Float presentrate,
			java.lang.Long eboxunitid) {
		this.logid = logid;
		this.optime = optime;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
		this.success = success;
		this.yxplanid = yxplanid;
		this.acctid = acctid;
		this.presentinterval = presentinterval;
		this.presentcycles = presentcycles;
		this.presentrate = presentrate;
		this.eboxunitid = eboxunitid;
	}

	/** default constructor */
	public YxplanpstlogVO() {
	}

	/** minimal constructor */
	public YxplanpstlogVO(java.lang.Long logid, java.util.Date optime,
			java.lang.String oprcode, java.lang.String oprtype) {
		this.logid = logid;
		this.optime = optime;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
	}

	public String toString() {
		return new ToStringBuilder(this).append("logid", getLogid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof YxplanpstlogVO))
			return false;
		YxplanpstlogVO castOther = (YxplanpstlogVO) other;
		return new EqualsBuilder()
				.append(this.getLogid(), castOther.getLogid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getLogid()).toHashCode();
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

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	public java.util.Date getOptime() {
		return optime;
	}

	public void setOptime(java.util.Date optime) {
		this.optime = optime;
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

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Long getYxplanid() {
		return yxplanid;
	}

	public void setYxplanid(Long yxplanid) {
		this.yxplanid = yxplanid;
	}

}
