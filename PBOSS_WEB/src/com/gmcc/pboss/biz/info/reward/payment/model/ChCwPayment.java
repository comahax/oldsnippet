package com.gmcc.pboss.biz.info.reward.payment.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * <p>
 * Title: ChCwPayment
 * </p>
 * <p>
 * Description: 付款数据上传表
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author caiwr
 * @version 1.0
 */
public class ChCwPayment {

	/** identifier field */
	private Long seq;

	private String optype;

	private String opmonth;

	private String paymonth;

	private String ltype;

	private String stype;

	private String payee;

	private Double paysum;

	private String rewardstd;

	private String rule;

	private String deduction;

	private String batch;

	private String note;

	private String wayid;

	private String wayname;

	private String bank;

	private String depositbank;

	private String account;

	private String billnumber;

	private String countyid;

	private String pubpri;

	private Float rate;

	private String upoprcode;

	private String checkedflag;

	public ChCwPayment(String optype, String paymonth, String stype,
			String payee, Double paysum, String deduction, String batch,
			Long seq, String wayid, String bank, String depositbank,
			String account, String billnumber, String countyid, String pubpri,
			Float rate, String upoprcode, String checkedflag) {
		this.seq = seq;
		this.optype = optype;
		this.paymonth = paymonth;
		this.stype = stype;
		this.payee = payee;
		this.paysum = paysum;
		this.deduction = deduction;
		this.batch = batch;
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
	}

	/** full constructor */
	public ChCwPayment(Long seq, String optype, String opmonth,
			String paymonth, String ltype, String stype, String payee,
			Double paysum, String rewardstd, String rule, String deduction,
			String batch, String note, String wayid, String wayname,
			String bank, String depositbank, String account, String billnumber,
			String countyid, String pubpri, Float rate, String upoprcode,
			String checkedflag) {
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
		this.wayname = wayname;

		this.bank = bank;
		this.depositbank = depositbank;
		this.account = account;
		this.billnumber = billnumber;
		this.countyid = countyid;
		this.pubpri = pubpri;
		this.rate = rate;

		this.upoprcode = upoprcode;
		this.checkedflag = checkedflag;
	}

	/** default constructor */
	public ChCwPayment(Long seq) {
		this.seq = seq;
	}

	public ChCwPayment() {
		
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

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
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

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
