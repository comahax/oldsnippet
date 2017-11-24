package com.sunrise.boss.business.resmanage.oprresmanage.audit.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AuditVO implements Serializable {

	/** identifier field */
	private String inoprcode;

	private String outoprcode;

	private String reqoprcode;
	/** identifier field */
	private String sheetid;

	/** persistent field */
	private java.util.Date createtime;

	/** nullable persistent field */
	private Short state;

	private String auditoprcode;

	private String wayid;// 20081106ÐÂÔö

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getAuditoprcode() {
		return auditoprcode;
	}

	public void setAuditoprcode(String auditoprcode) {
		this.auditoprcode = auditoprcode;
	}

	/** full constructor */
	public AuditVO(java.lang.String sheetid, java.lang.String inoprcode,
			java.lang.String outoprcode, java.lang.String reqoprcode,
			java.lang.String auditoprcode, java.util.Date createtime,
			java.util.Date updatetime, java.lang.Short state,
			java.lang.String wayid) {
		this.inoprcode = inoprcode;
		this.outoprcode = outoprcode;
		this.reqoprcode = reqoprcode;
		this.sheetid = sheetid;
		this.createtime = createtime;
		this.state = state;
		this.auditoprcode = auditoprcode;
		this.wayid = wayid;
	}

	/** default constructor */
	public AuditVO() {
	}

	/** minimal constructor */
	public AuditVO(java.lang.String sheetid) {
		this.sheetid = sheetid;
	}

	public java.lang.String getSheetid() {
		return this.sheetid;
	}

	public void setSheetid(java.lang.String sheetid) {
		this.sheetid = sheetid;
	}

	public java.util.Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public java.lang.Short getState() {
		return this.state;
	}

	public void setState(java.lang.Short state) {
		this.state = state;
	}

	public String toString() {
		return new ToStringBuilder(this).append("sheetid", getSheetid())
				.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof AuditVO))
			return false;
		AuditVO castOther = (AuditVO) other;
		return new EqualsBuilder().append(this.getSheetid(),
				castOther.getSheetid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getSheetid()).toHashCode();
	}

	public String getInoprcode() {
		return inoprcode;
	}

	public void setInoprcode(String inoprcode) {
		this.inoprcode = inoprcode;
	}

	public String getOutoprcode() {
		return outoprcode;
	}

	public void setOutoprcode(String outoprcode) {
		this.outoprcode = outoprcode;
	}

	public String getReqoprcode() {
		return reqoprcode;
	}

	public void setReqoprcode(String reqoprcode) {
		this.reqoprcode = reqoprcode;
	}

}
