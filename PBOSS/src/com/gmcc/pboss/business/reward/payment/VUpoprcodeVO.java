package com.gmcc.pboss.business.reward.payment;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class VUpoprcodeVO extends BaseVO {

	private static final long serialVersionUID = -71991178830342925L;

	private String operid;

	private String opername;

	public VUpoprcodeVO(String operid, String opername) {
		this.operid = operid;
		this.opername = opername;
	}
	
	public VUpoprcodeVO() {

	}

	public String getOperid() {
		return operid;
	}

	public void setOperid(String operid) {
		this.operid = operid;
	}

	public String getOpername() {
		return opername;
	}

	public void setOpername(String opername) {
		this.opername = opername;
	}

	public String toString() {
		return new ToStringBuilder(this).append("operid", getOperid())
				.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof VUpoprcodeVO))
			return false;
		VUpoprcodeVO castOther = (VUpoprcodeVO) other;
		return new EqualsBuilder().append(this.getOperid(),
				castOther.getOperid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getOperid()).toHashCode();
	}
}
