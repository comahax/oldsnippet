package com.gmcc.pboss.business.reward.paymentsc;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class VPaymentscVO extends BaseVO {

	private static final long serialVersionUID = -4635513255635500063L;

	private Long seq;

	private String wayid;

	private String calcmonth;

	private String paymonth;

	private String optype;

	private String ltype;

	private String stype;

	private String mobile;

	private String imei;

	private Double paysum;

	private String settleperiods;

	private String note;

	private String upoprcode;

	private String checkedflag;

	public VPaymentscVO(Long seq, String wayid, String calcmonth,
			String optype, String ltype, String stype, String mobile,
			String imei, String paymonth, Double paysum, String settleperiods,
			String note, String upoprcode, String checkedflag) {
		this.seq = seq;
		this.wayid = wayid;
		this.calcmonth = calcmonth;
		this.paymonth = paymonth;
		this.optype = optype;
		this.ltype = ltype;
		this.stype = stype;
		this.mobile = mobile;
		this.imei = imei;

		this.paysum = paysum;
		this.settleperiods = settleperiods;
		this.note = note;
		this.upoprcode = upoprcode;
		this.checkedflag = checkedflag;
	}

	/** default constructor */
	public VPaymentscVO() {
	}

	/** minimal constructor */
	public VPaymentscVO(java.lang.Long seq) {
		this.seq = seq;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getCalcmonth() {
		return calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}

	public String getOptype() {
		return optype;
	}

	public void setOptype(String optype) {
		this.optype = optype;
	}

	public String getLtype() {
		return ltype;
	}

	public void setLtype(String ltype) {
		this.ltype = ltype;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getPaymonth() {
		return paymonth;
	}

	public void setPaymonth(String paymonth) {
		this.paymonth = paymonth;
	}

	public Double getPaysum() {
		return paysum;
	}

	public void setPaysum(Double paysum) {
		this.paysum = paysum;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getUpoprcode() {
		return upoprcode;
	}

	public void setUpoprcode(String upoprcode) {
		this.upoprcode = upoprcode;
	}

	public String getCheckedflag() {
		return checkedflag;
	}

	public void setCheckedflag(String checkedflag) {
		this.checkedflag = checkedflag;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getSettleperiods() {
		return settleperiods;
	}

	public void setSettleperiods(String settleperiods) {
		this.settleperiods = settleperiods;
	}

	public String toString() {
		return new ToStringBuilder(this).append("seq", getSeq()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof VPaymentscVO))
			return false;
		VPaymentscVO castOther = (VPaymentscVO) other;
		return new EqualsBuilder().append(this.getSeq(), castOther.getSeq())
				.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getSeq()).toHashCode();
	}

}
