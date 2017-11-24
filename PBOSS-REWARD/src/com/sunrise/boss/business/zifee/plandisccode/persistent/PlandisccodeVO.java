package com.sunrise.boss.business.zifee.plandisccode.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.zifee.plandiscodlo.persistent.PlandiscodloVO;

/** @author Hibernate CodeGenerator */
public class PlandisccodeVO implements Serializable, OperationLog {

	/** identifier field */
	private String disccode;

	/** identifier field */
	private Long yxplanid;

	private String affixinfo;

	private String affixtype;

	private String remark;

	/** default constructor */
	public PlandisccodeVO() {
	}

	public PlandisccodeVO(java.lang.String disccode, java.lang.Long yxplanid) {
		this.disccode = disccode;
		this.yxplanid = yxplanid;
	}

	public java.lang.String getDisccode() {
		return this.disccode;
	}

	public void setDisccode(java.lang.String disccode) {
		this.disccode = disccode;
	}

	public java.lang.Long getYxplanid() {
		return this.yxplanid;
	}

	public void setYxplanid(java.lang.Long yxplanid) {
		this.yxplanid = yxplanid;
	}

	public String toString() {
		return new ToStringBuilder(this).append("disccode", getDisccode())
				.append("yxplanid", getYxplanid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof PlandisccodeVO))
			return false;
		PlandisccodeVO castOther = (PlandisccodeVO) other;
		return new EqualsBuilder().append(this.getDisccode(),
				castOther.getDisccode()).append(this.getYxplanid(),
				castOther.getYxplanid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getDisccode())
				.append(getYxplanid()).toHashCode();
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return PlandiscodloVO.class;
	}

	public String getAffixinfo() {
		return affixinfo;
	}

	public void setAffixinfo(String affixinfo) {
		this.affixinfo = affixinfo;
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

}
