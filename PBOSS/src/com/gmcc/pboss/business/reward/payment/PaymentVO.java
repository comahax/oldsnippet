package com.gmcc.pboss.business.reward.payment;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.reward.paymentlog.PaymentlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class PaymentVO extends BaseVO implements BusinessLog {

	private static final long serialVersionUID = -3456673709016810070L;

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

	private String pubpri;

	private Float rate;

	private String upoprcode;

	private String checkedflag;

	private String calcmonth;

	private String sendstate;

	private String bkactname;
	
	/** full constructor */
	public PaymentVO(Long seq, String optype, String opmonth, String paymonth,
			String ltype, String stype, String payee, Double paysum,
			String rewardstd, String rule, String deduction, String batch,
			String note, String wayid, String bank, String depositbank,
			String account, String billnumber, String countyid, String pubpri,
			Float rate, String upoprcode, String checkedflag, String calcmonth,
			String sendstate, String bkactname) {
		this.seq = seq;
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
		this.calcmonth = calcmonth;

		this.sendstate = sendstate;
		this.bkactname = bkactname;
	}

	/** default constructor */
	public PaymentVO() {
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getOptype() {
		return optype;
	}

	public void setOptype(String optype) {
		this.optype = optype;
	}

	public String getOpmonth() {
		return opmonth;
	}

	public void setOpmonth(String opmonth) {
		this.opmonth = opmonth;
	}

	public String getPaymonth() {
		return paymonth;
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
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public Double getPaysum() {
		return paysum;
	}

	public void setPaysum(Double paysum) {
		this.paysum = paysum;
	}

	public String getRewardstd() {
		return rewardstd;
	}

	public void setRewardstd(String rewardstd) {
		this.rewardstd = rewardstd;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getDeduction() {
		return deduction;
	}

	public void setDeduction(String deduction) {
		this.deduction = deduction;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getNote() {
		return note;
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

	public String getBkactname() {
		return bkactname;
	}

	public void setBkactname(String bkactname) {
		this.bkactname = bkactname;
	}

	public String toString() {
		return new ToStringBuilder(this).append("seq", getSeq()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof PaymentVO))
			return false;
		PaymentVO castOther = (PaymentVO) other;
		return new EqualsBuilder().append(this.getSeq(), castOther.getSeq())
				.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getSeq()).toHashCode();
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return PaymentlogVO.class;
	}

}
