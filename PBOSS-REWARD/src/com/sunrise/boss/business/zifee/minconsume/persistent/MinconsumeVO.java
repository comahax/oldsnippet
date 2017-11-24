package com.sunrise.boss.business.zifee.minconsume.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.zifee.minconsumelog.persistent.MinconsumelogVO;

/** @author Hibernate CodeGenerator */
public class MinconsumeVO implements Serializable, OperationLog {

	/** identifier field */
	private Integer effectiveinterval;

	/** identifier field */
	private Long yxplanid;

	/** nullable persistent field */
	private Long consumecycle;

	/** nullable persistent field */
	private Integer cyclecount;

	/** nullable persistent field */
	private String effectivetype;

	/** nullable persistent field */
	private Double minconsume;

	/** full constructor */
	public MinconsumeVO(java.lang.Integer effectiveinterval,
			java.lang.Long yxplanid, java.lang.Long consumecycle,
			java.lang.Integer cyclecount, java.lang.String effectivetype,
			java.lang.Double minconsume) {
		this.effectiveinterval = effectiveinterval;
		this.yxplanid = yxplanid;
		this.consumecycle = consumecycle;
		this.cyclecount = cyclecount;
		this.effectivetype = effectivetype;
		this.minconsume = minconsume;
	}

	/** default constructor */
	public MinconsumeVO() {
	}

	/** minimal constructor */
	public MinconsumeVO(java.lang.Integer effectiveinterval,
			java.lang.Long yxplanid) {
		this.effectiveinterval = effectiveinterval;
		this.yxplanid = yxplanid;
	}

	public java.lang.Integer getEffectiveinterval() {
		return this.effectiveinterval;
	}

	public void setEffectiveinterval(java.lang.Integer effectiveinterval) {
		this.effectiveinterval = effectiveinterval;
	}

	public java.lang.Long getYxplanid() {
		return this.yxplanid;
	}

	public void setYxplanid(java.lang.Long yxplanid) {
		this.yxplanid = yxplanid;
	}

	public java.lang.Long getConsumecycle() {
		return this.consumecycle;
	}

	public void setConsumecycle(java.lang.Long consumecycle) {
		this.consumecycle = consumecycle;
	}

	public java.lang.Integer getCyclecount() {
		return this.cyclecount;
	}

	public void setCyclecount(java.lang.Integer cyclecount) {
		this.cyclecount = cyclecount;
	}

	public java.lang.String getEffectivetype() {
		return this.effectivetype;
	}

	public void setEffectivetype(java.lang.String effectivetype) {
		this.effectivetype = effectivetype;
	}

	public java.lang.Double getMinconsume() {
		return this.minconsume;
	}

	public void setMinconsume(java.lang.Double minconsume) {
		this.minconsume = minconsume;
	}

	public String toString() {
		return new ToStringBuilder(this).append("effectiveinterval",
				getEffectiveinterval()).append("yxplanid", getYxplanid())
				.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof MinconsumeVO))
			return false;
		MinconsumeVO castOther = (MinconsumeVO) other;
		return new EqualsBuilder().append(this.getEffectiveinterval(),
				castOther.getEffectiveinterval()).append(this.getYxplanid(),
				castOther.getYxplanid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getEffectiveinterval()).append(
				getYxplanid()).toHashCode();
	}

	public Class logVOClass() {
		return MinconsumelogVO.class;
	}
}
