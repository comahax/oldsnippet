package com.gmcc.pboss.business.reward.payway;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class VPaywayVO extends BaseVO {

	private Long seq;

	private String payee;

	private String wayid;

	private String wayname;

	private String cityid;

	/** full constructor */
	public VPaywayVO(Long seq, String payee, String wayid, String wayname,
			String cityid) {
		this.seq = seq;
		this.payee = payee;
		this.wayid = wayid;
		this.wayname = wayname;
		this.cityid = cityid;
	}

	/** default constructor */
	public VPaywayVO() {
	}

	/** minimal constructor */
	public VPaywayVO(Long seq) {
		this.seq = seq;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String toString() {
		return new ToStringBuilder(this).append("seq", getSeq()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof VPaywayVO))
			return false;
		VPaywayVO castOther = (VPaywayVO) other;
		return new EqualsBuilder().append(this.getSeq(), castOther.getSeq())
				.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getSeq()).toHashCode();
	}
}
