package com.gmcc.pboss.business.reward.paywaylog;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.reward.paywaylog.PaywaylogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class PaywaylogVO extends BaseVO implements Serializable {

	private Long logid;

	/** nullable persistent field */
	private java.util.Date optime;

	/** nullable persistent field */
	private String oprcode;

	/** nullable persistent field */
	private String oprtype;

	/** nullable persistent field */
	private String success;

	private String payee;

	private String wayid;

	private String cityid;

	private Long seq;

	/** full constructor */
	public PaywaylogVO(Long logid, java.util.Date optime, String oprcode,
			String oprtype, String success, Long seq, String payee,
			String wayid, String cityid) {
		this.logid = logid;
		this.optime = optime;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
		this.success = success;
		this.seq = seq;
		this.payee = payee;
		this.wayid = wayid;
		this.cityid = cityid;
	}

	/** default constructor */
	public PaywaylogVO() {
	}

	/** minimal constructor */
	public PaywaylogVO(Long seq) {
		this.seq = seq;
	}

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public java.util.Date getOptime() {
		return optime;
	}

	public void setOptime(java.util.Date optime) {
		this.optime = optime;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
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

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String toString() {
		return new ToStringBuilder(this).append("logid", getLogid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof PaywaylogVO))
			return false;
		PaywaylogVO castOther = (PaywaylogVO) other;
		return new EqualsBuilder()
				.append(this.getLogid(), castOther.getLogid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getLogid()).toHashCode();
	}

}
