package com.gmcc.pboss.business.reward.payment;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class VPaymentVO extends BaseVO {

	private static final long serialVersionUID = -8268134818256419253L;

	/** identifier field */
	private Long seq;

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

	private String bkactname;

	/** nullable persistent field */
	private Double paysum;

	/** nullable persistent field */
	private String rewardstd;

	/** nullable persistent field */
	private String rule;

	/** nullable persistent field */
	private String deduction;

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

	/** nullable persistent field */
	private String pubpri;

	/** nullable persistent field */
	private Float rate;

	private String upoprcode;

	private String checkedflag;

	private String calcmonth;

	private String sendstate;

	/** full constructor */
	public VPaymentVO(Long seq, String optype, String opmonth,
			String paymonth, String stype, String ltype, String payee,
			Double paysum, String rewardstd, String rule,
			String deduction, String batch, String note, String pubpri,
			Float rate, String wayid, String upoprcode,
			String checkedflag, String calcmonth, String sendstate,
			String bkactname) {
		this.seq = seq;
		this.optype = optype;
		this.opmonth = opmonth;
		this.paymonth = paymonth;
		this.stype = stype;
		this.ltype = ltype;
		this.payee = payee;
		this.paysum = paysum;
		this.rewardstd = rewardstd;
		this.rule = rule;
		this.deduction = deduction;
		this.batch = batch;
		this.note = note;
		this.rate = rate;
		this.pubpri = pubpri;
		this.wayid = wayid;
		this.upoprcode = upoprcode;
		this.checkedflag = checkedflag;
		this.calcmonth = calcmonth;
		this.sendstate = sendstate;
		this.bkactname = bkactname;
	}

	/** default constructor */
	public VPaymentVO() {
	}

	/** minimal constructor */
	public VPaymentVO(Long seq) {
		this.seq = seq;
	}

	public Long getSeq() {
		return this.seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
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

	public String getBkactname() {
		return bkactname;
	}

	public void setBkactname(String bkactname) {
		this.bkactname = bkactname;
	}

	public Double getPaysum() {
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

	public String getBatch() {
		return this.batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getNote() {
		return this.note;
	}

	public String getLtype() {
		return ltype;
	}

	public void setLtype(String ltype) {
		this.ltype = ltype;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public String getPubpri() {
		return pubpri;
	}

	public void setPubpri(String pubpri) {
		this.pubpri = pubpri;
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

	public String getCalcmonth() {
		return calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}

	public String getSendstate() {
		return sendstate;
	}

	public void setSendstate(String sendstate) {
		this.sendstate = sendstate;
	}

	public String toString() {
		return new ToStringBuilder(this).append("seq", getSeq()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof VPaymentVO))
			return false;
		VPaymentVO castOther = (VPaymentVO) other;
		return new EqualsBuilder().append(this.getSeq(), castOther.getSeq())
				.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getSeq()).toHashCode();
	}

}
