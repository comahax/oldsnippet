package com.sunrise.boss.business.cms.bbc.yxplan.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.bbc.yxplanlog.persistent.YxplanbbclogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class YxplanVO implements Serializable, OperationLog {

	/** identifier field */
	private String opnid;

	/** identifier field */
	private Long yxplanid;

	/** nullable persistent field */
	private Double wrapfee;

	/** nullable persistent field */
	private String cityid;

	/** full constructor */
	public YxplanVO(java.lang.String opnid, java.lang.Long yxplanid,
			java.lang.Double wrapfee, java.lang.String cityid) {
		this.opnid = opnid;
		this.yxplanid = yxplanid;
		this.wrapfee = wrapfee;
		this.cityid = cityid;
	}

	/** default constructor */
	public YxplanVO() {
	}

	/** minimal constructor */
	public YxplanVO(java.lang.String opnid, java.lang.Long yxplanid) {
		this.opnid = opnid;
		this.yxplanid = yxplanid;
	}

	public java.lang.String getOpnid() {
		return this.opnid;
	}

	public void setOpnid(java.lang.String opnid) {
		this.opnid = opnid;
	}

	public java.lang.Long getYxplanid() {
		return this.yxplanid;
	}

	public void setYxplanid(java.lang.Long yxplanid) {
		this.yxplanid = yxplanid;
	}

	public java.lang.Double getWrapfee() {
		return this.wrapfee;
	}

	public void setWrapfee(java.lang.Double wrapfee) {
		this.wrapfee = wrapfee;
	}

	public java.lang.String getCityid() {
		return this.cityid;
	}

	public void setCityid(java.lang.String cityid) {
		this.cityid = cityid;
	}

	public String toString() {
		return new ToStringBuilder(this).append("opnid", getOpnid()).append(
				"yxplanid", getYxplanid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof YxplanVO))
			return false;
		YxplanVO castOther = (YxplanVO) other;
		return new EqualsBuilder()
				.append(this.getOpnid(), castOther.getOpnid()).append(
						this.getYxplanid(), castOther.getYxplanid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getOpnid()).append(getYxplanid())
				.toHashCode();
	}

	public Class logVOClass() {
		return YxplanbbclogVO.class;
	}
}
