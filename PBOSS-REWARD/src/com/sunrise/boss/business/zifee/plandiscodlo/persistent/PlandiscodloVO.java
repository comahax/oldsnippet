package com.sunrise.boss.business.zifee.plandiscodlo.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class PlandiscodloVO implements Serializable {

	/** identifier field */
	private Long logid;

	/** persistent field */
	private java.sql.Timestamp optime;

	/** persistent field */
	private String oprcode;

	/** persistent field */
	private String oprtype;

	/** nullable persistent field */
	private String success;

	/** nullable persistent field */
	private Long yxplanid;

	/** nullable persistent field */
	private String disccode;
	
	private String affixinfo;

	private String affixtype;

	private String remark;

	/** full constructor */
	public PlandiscodloVO(java.sql.Timestamp optime, java.lang.String oprcode,
			java.lang.String oprtype, java.lang.String success,
			java.lang.Long yxplanid, java.lang.String disccode) {
		this.optime = optime;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
		this.success = success;
		this.yxplanid = yxplanid;
		this.disccode = disccode;
	}

	/** default constructor */
	public PlandiscodloVO() {
	}

	/** minimal constructor */
	public PlandiscodloVO(java.sql.Timestamp optime, java.lang.String oprcode,
			java.lang.String oprtype) {
		this.optime = optime;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
	}

	public java.lang.Long getLogid() {
		return this.logid;
	}

	public void setLogid(java.lang.Long logid) {
		this.logid = logid;
	}

	public java.sql.Timestamp getOptime() {
		return this.optime;
	}

	public void setOptime(java.sql.Timestamp optime) {
		this.optime = optime;
	}

	public java.lang.String getOprcode() {
		return this.oprcode;
	}

	public void setOprcode(java.lang.String oprcode) {
		this.oprcode = oprcode;
	}

	public java.lang.String getOprtype() {
		return this.oprtype;
	}

	public void setOprtype(java.lang.String oprtype) {
		this.oprtype = oprtype;
	}

	public java.lang.String getSuccess() {
		return this.success;
	}

	public void setSuccess(java.lang.String success) {
		this.success = success;
	}

	public java.lang.Long getYxplanid() {
		return this.yxplanid;
	}

	public void setYxplanid(java.lang.Long yxplanid) {
		this.yxplanid = yxplanid;
	}

	public java.lang.String getDisccode() {
		return this.disccode;
	}

	public void setDisccode(java.lang.String disccode) {
		this.disccode = disccode;
	}

	public String toString() {
		return new ToStringBuilder(this).append("logid", getLogid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof PlandiscodloVO))
			return false;
		PlandiscodloVO castOther = (PlandiscodloVO) other;
		return new EqualsBuilder()
				.append(this.getLogid(), castOther.getLogid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getLogid()).toHashCode();
	}

	public String getAffixtype() {
		return affixtype;
	}

	public void setAffixtype(String affixtype) {
		this.affixtype = affixtype;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAffixinfo() {
		return affixinfo;
	}

	public void setAffixinfo(String affixinfo) {
		this.affixinfo = affixinfo;
	}
}
