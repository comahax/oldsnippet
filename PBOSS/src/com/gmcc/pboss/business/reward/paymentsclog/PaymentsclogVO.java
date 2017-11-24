package com.gmcc.pboss.business.reward.paymentsclog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PaymentsclogVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = -3359925188448651919L;

	/** identifier field */
	private Long logid;

	/** nullable persistent field */
	private Date optime;

	/** nullable persistent field */
	private String oprcode;

	/** nullable persistent field */
	private String oprtype;

	/** nullable persistent field */
	private String success;

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

	private String note;

	private String upoprcode;

	private String checkedflag;

	private String Settleperiods;

	/** full constructor */
	public PaymentsclogVO(Long logid, Date optime, String oprcode,
			String oprtype, String success, Long seq, String wayid,
			String calcmonth, String optype, String ltype, String stype,
			String mobile, String imei, String paymonth, Double paysum,
			String note, String upoprcode, String checkedflag,
			String Settleperiods) {
		this.logid = logid;
		this.optime = optime;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
		this.success = success;

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
		this.Settleperiods = Settleperiods;
	}

	/** default constructor */
	public PaymentsclogVO() {
	}

	/** minimal constructor */
	public PaymentsclogVO(Long logid) {
		this.logid = logid;
	}

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public Date getOptime() {
		return optime;
	}

	public void setOptime(Date optime) {
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
		return Settleperiods;
	}

	public void setSettleperiods(String settleperiods) {
		Settleperiods = settleperiods;
	}

	public String toString() {
		return new ToStringBuilder(this).append("logid", getLogid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof PaymentsclogVO))
			return false;
		PaymentsclogVO castOther = (PaymentsclogVO) other;
		return new EqualsBuilder()
				.append(this.getLogid(), castOther.getLogid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getLogid()).toHashCode();
	}
}
