package com.sunrise.boss.business.cms.resale2.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.rulelog.persistent.RulelogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class Resale2VO implements Serializable {

	/** identifier field */
	private String opnid;

	private String opntype;

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String toString() {
		return new ToStringBuilder(this).append("opnid", getOpnid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof Resale2VO))
			return false;
		Resale2VO castOther = (Resale2VO) other;
		return new EqualsBuilder()
				.append(this.getOpnid(), castOther.getOpnid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getOpnid()).toHashCode();
	}

	public String getOpntype() {
		return opntype;
	}

	public void setOpntype(String opntype) {
		this.opntype = opntype;
	}

}
