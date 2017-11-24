package com.gmcc.pboss.business.reward.paymentlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PaymentlogVO extends BaseVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8885708653515524569L;

	/** identifier field */
	private Long logid;

	/** nullable persistent field */
	private java.util.Date optime;

	/** nullable persistent field */
	private String oprcode;

	/** nullable persistent field */
	private String oprtype;

	/** nullable persistent field */
	private String success;

	/** nullable persistent field */
	private String optype;

	/** nullable persistent field */
	private String opmonth;

	/** nullable persistent field */
	private String paymonth;

	/** nullable persistent field */
	private String ltype;

	/** nullable persistent field */
	private String stype;

	/** nullable persistent field */
	private String payee;

	/** nullable persistent field */
	private Double paysum;

	/** nullable persistent field */
	private String rewardstd;

	/** nullable persistent field */
	private String rule;

	/** nullable persistent field */
	private String deduction;

	/** nullable persistent field */
	private Long seq;

	/** nullable persistent field */
	private String batch;

	/** nullable persistent field */
	private String note;

	/** nullable persistent field */
	private String wayid;

	private String bank;

	private String depositbank;

	private String account;

	private String billnumber;

	private String countyid;

	private String pubpri;

	private Float rate;

	private String upoprcode;

	private String checkedflag;

	private String sendstate;

	private String bkactname;

	/** full constructor */
	public PaymentlogVO(Long logid, Date optime, String oprcode,
			String oprtype, String success, String optype, String opmonth,
			String paymonth, String ltype, String stype, String payee,
			Double paysum, String rewardstd, String rule, String deduction,
			Long seq, String batch, String note, String wayid, String bank,
			String depositbank, String account, String billnumber,
			String countyid, String pubpri, Float rate, String upoprcode,
			String checkedflag, String sendstate, String bkactname) {
		this.logid = logid;
		this.optime = optime;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
		this.success = success;
		this.optype = optype;
		this.opmonth = opmonth;
		this.paymonth = paymonth;
		this.ltype = ltype;
		this.stype = stype;
		this.payee = payee;
		this.paysum = paysum;
		this.rewardstd = rewardstd;
		this.rule = rule;
		this.deduction = deduction;
		this.seq = seq;
		this.batch = batch;
		this.note = note;
		this.wayid = wayid;

		this.bank = bank;
		this.depositbank = depositbank;
		this.account = account;
		this.billnumber = billnumber;
		this.countyid = countyid;
		this.pubpri = pubpri;
		this.rate = rate;

		this.upoprcode = upoprcode;
		this.checkedflag = checkedflag;

		this.sendstate = sendstate;
		this.bkactname = bkactname;
	}

	/** default constructor */
	public PaymentlogVO() {
	}

	/** minimal constructor */
	public PaymentlogVO(Long logid) {
		this.logid = logid;
	}

	public Long getLogid() {
		return this.logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public java.util.Date getOptime() {
		return this.optime;
	}

	public void setOptime(java.util.Date optime) {
		this.optime = optime;
	}

	public String getOprcode() {
		return this.oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getOprtype() {
		return this.oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	public String getSuccess() {
		return this.success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getOptype() {
		return this.optype;
	}

	public void setOptype(String optype) {
		this.optype = optype;
	}

	public String getOpmonth() {
		return this.opmonth;
	}

	public void setOpmonth(String opmonth) {
		this.opmonth = opmonth;
	}

	public String getPaymonth() {
		return this.paymonth;
	}

	public void setPaymonth(String paymonth) {
		this.paymonth = paymonth;
	}

	public String getLtype() {
		return ltype;
	}

	public void setLtype(String ltype) {
		this.ltype = ltype;
	}

	public String getStype() {
		return this.stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getPayee() {
		return this.payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public java.lang.Double getPaysum() {
		return this.paysum;
	}

	public void setPaysum(Double paysum) {
		this.paysum = paysum;
	}

	public String getRewardstd() {
		return this.rewardstd;
	}

	public void setRewardstd(String rewardstd) {
		this.rewardstd = rewardstd;
	}

	public String getRule() {
		return this.rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getDeduction() {
		return this.deduction;
	}

	public void setDeduction(String deduction) {
		this.deduction = deduction;
	}

	public Long getSeq() {
		return this.seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getBatch() {
		return this.batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getDepositbank() {
		return depositbank;
	}

	public void setDepositbank(String depositbank) {
		this.depositbank = depositbank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBillnumber() {
		return billnumber;
	}

	public void setBillnumber(String billnumber) {
		this.billnumber = billnumber;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getPubpri() {
		return pubpri;
	}

	public void setPubpri(String pubpri) {
		this.pubpri = pubpri;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
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

	public String getSendstate() {
		return sendstate;
	}

	public void setSendstate(String sendstate) {
		this.sendstate = sendstate;
	}

	public String getBkactname() {
		return bkactname;
	}

	public void setBkactname(String bkactname) {
		this.bkactname = bkactname;
	}

	public String toString() {
		return new ToStringBuilder(this).append("logid", getLogid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof PaymentlogVO))
			return false;
		PaymentlogVO castOther = (PaymentlogVO) other;
		return new EqualsBuilder()
				.append(this.getLogid(), castOther.getLogid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getLogid()).toHashCode();
	}
}
