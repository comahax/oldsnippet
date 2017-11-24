package com.gmcc.pboss.business.reward.paymentsc;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.reward.paymentsclog.PaymentsclogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

public class PaymentscVO extends BaseVO implements BusinessLog {

	private static final long serialVersionUID = 2396228276831316101L;

	private Long seq;

	private String wayid;

	private String calcmonth;

	private String optype;

	private String ltype;

	private String stype;

	private String paymonth;

	private Double paysum;

	private String note;

	private String upoprcode;

	private String checkedflag;

	private String mobile;

	private String imei;

	private String settleperiods;

	public PaymentscVO(Long seq, String wayid, String calcmonth, String optype,
			String ltype, String stype, String paymonth, Double paysum,
			String note, String upoprcode, String checkedflag, String mobile,
			String imei, String settleperiods) {
		this.seq = seq;
		this.wayid = wayid;
		this.calcmonth = calcmonth;
		this.optype = optype;
		this.ltype = ltype;
		this.stype = stype;
		this.paymonth = paymonth;
		this.paysum = paysum;
		this.note = note;
		this.upoprcode = upoprcode;
		this.checkedflag = checkedflag;

		this.mobile = mobile;
		this.imei = imei;
		this.settleperiods = settleperiods;
	}

	public PaymentscVO() {
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
		if (!(other instanceof PaymentscVO))
			return false;
		PaymentscVO castOther = (PaymentscVO) other;
		return new EqualsBuilder().append(this.getSeq(), castOther.getSeq())
				.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getSeq()).toHashCode();
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return PaymentsclogVO.class;
	}

}
