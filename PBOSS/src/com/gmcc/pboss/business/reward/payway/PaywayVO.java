package com.gmcc.pboss.business.reward.payway;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.reward.paywaylog.PaywaylogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class PaywayVO extends BaseVO implements BusinessLog {

	private Long seq;

	private String payee;

	private String wayid;

	private String cityid;

	/** full constructor */
	public PaywayVO(Long seq, String payee, String wayid, String cityid) {
		this.seq = seq;
		this.payee = payee;
		this.wayid = wayid;
		this.cityid = cityid;
	}

	/** default constructor */
	public PaywayVO() {
	}

	/** minimal constructor */
	public PaywayVO(Long seq) {
		this.seq = seq;
	}

	public PaywayVO(String payee, String wayid) {
		this.payee = payee;
		this.wayid = wayid;
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

	public java.lang.String getWayid() {
		return this.wayid;
	}

	public void setWayid(java.lang.String wayid) {
		this.wayid = wayid;
	}

	public java.lang.String getCityid() {
		return this.cityid;
	}

	public void setCityid(java.lang.String cityid) {
		this.cityid = cityid;
	}

	public String toString() {
		return new ToStringBuilder(this).append("seq", getSeq()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof PaywayVO))
			return false;
		PaywayVO castOther = (PaywayVO) other;
		return new EqualsBuilder().append(this.getSeq(), castOther.getSeq())
				.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getSeq()).toHashCode();
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return PaywaylogVO.class;
	}

}
