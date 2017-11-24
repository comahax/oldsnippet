package com.sunrise.boss.business.rightmanage.operator.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class Operator2VO implements Serializable {

	/** identifier field */
	private String operid;

	/** nullable persistent field */
	private Integer region;

	/** persistent field */
	private String opername;

	/** nullable persistent field */
	private String password;

	/** persistent field */
	private java.util.Date passchgdate;

	/** nullable persistent field */
	private String opergroup;

	/** persistent field */
	private String opertype;

	/** nullable persistent field */
	private String operlevel;

	/** persistent field */
	private Byte ismanager;

	/** nullable persistent field */
	private String contactphone;

	/** persistent field */
	private String orgid;

	/** persistent field */
	private Byte isrestrict;

	/** persistent field */
	private Short starttime;

	/** persistent field */
	private Short endtime;

	/** persistent field */
	private Byte enablegprs;

	/** persistent field */
	private Short gprsstarttime;

	/** persistent field */
	private Short gprsendtime;

	/** persistent field */
	private Byte ischkmac;

	/** nullable persistent field */
	private String mac;

	/** nullable persistent field */
	private String notes;

	/** persistent field */
	private java.util.Date createdate;

	/** persistent field */
	private Byte status;

	/** nullable persistent field */
	private java.util.Date statusdate;

	/** default constructor */
	public Operator2VO() {
	}

	public String toString() {
		return new ToStringBuilder(this).append("operid", getOperid())
				.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof Operator2VO))
			return false;
		Operator2VO castOther = (Operator2VO) other;
		return new EqualsBuilder().append(this.getOperid(),
				castOther.getOperid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getOperid()).toHashCode();
	}

	public String getContactphone() {
		return contactphone;
	}

	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}

	public java.util.Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(java.util.Date createdate) {
		this.createdate = createdate;
	}

	public Byte getEnablegprs() {
		return enablegprs;
	}

	public void setEnablegprs(Byte enablegprs) {
		this.enablegprs = enablegprs;
	}

	public Short getEndtime() {
		return endtime;
	}

	public void setEndtime(Short endtime) {
		this.endtime = endtime;
	}

	public Short getGprsendtime() {
		return gprsendtime;
	}

	public void setGprsendtime(Short gprsendtime) {
		this.gprsendtime = gprsendtime;
	}

	public Short getGprsstarttime() {
		return gprsstarttime;
	}

	public void setGprsstarttime(Short gprsstarttime) {
		this.gprsstarttime = gprsstarttime;
	}

	public Byte getIschkmac() {
		return ischkmac;
	}

	public void setIschkmac(Byte ischkmac) {
		this.ischkmac = ischkmac;
	}

	public Byte getIsmanager() {
		return ismanager;
	}

	public void setIsmanager(Byte ismanager) {
		this.ismanager = ismanager;
	}

	public Byte getIsrestrict() {
		return isrestrict;
	}

	public void setIsrestrict(Byte isrestrict) {
		this.isrestrict = isrestrict;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getOpergroup() {
		return opergroup;
	}

	public void setOpergroup(String opergroup) {
		this.opergroup = opergroup;
	}

	public String getOperid() {
		return operid;
	}

	public void setOperid(String operid) {
		this.operid = operid;
	}

	public String getOperlevel() {
		return operlevel;
	}

	public void setOperlevel(String operlevel) {
		this.operlevel = operlevel;
	}

	public String getOpername() {
		return opername;
	}

	public void setOpername(String opername) {
		this.opername = opername;
	}

	public String getOpertype() {
		return opertype;
	}

	public void setOpertype(String opertype) {
		this.opertype = opertype;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public java.util.Date getPasschgdate() {
		return passchgdate;
	}

	public void setPasschgdate(java.util.Date passchgdate) {
		this.passchgdate = passchgdate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public Short getStarttime() {
		return starttime;
	}

	public void setStarttime(Short starttime) {
		this.starttime = starttime;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public java.util.Date getStatusdate() {
		return statusdate;
	}

	public void setStatusdate(java.util.Date statusdate) {
		this.statusdate = statusdate;
	}

}
