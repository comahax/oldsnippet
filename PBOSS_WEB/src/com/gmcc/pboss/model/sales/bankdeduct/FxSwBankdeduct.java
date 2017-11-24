package com.gmcc.pboss.model.sales.bankdeduct;

import java.util.Date;

/**
 * FxSwBankdeduct entity. @author MyEclipse Persistence Tools
 */
public class FxSwBankdeduct implements java.io.Serializable {
	// Fields

	private Long deductid;
	private String orderid;
	private String bankid;
	private String acctnum;
	private Short accttype;
	private String acctname;
	private Double deductamt;
	private Date creatdate;
	private String state;
	private Date statechgtime;
	private String shopnum;
	private String terminalnum;
	private String respcode;
	private String callnum;
	
	private Short formtype;
    private String errmsg;
	
	// Constructors
	public FxSwBankdeduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FxSwBankdeduct(Long deductid, String orderid, String bankid,
			String acctnum, Short accttype, String acctname, Double deductamt,
			Date creatdate, String state, Date statechgtime, String shopnum,
			String terminalnum, String respcode, String callnum, Short formtype, String errmsg) {
		super();
		this.deductid = deductid;
		this.orderid = orderid;
		this.bankid = bankid;
		this.acctnum = acctnum;
		this.accttype = accttype;
		this.acctname = acctname;
		this.deductamt = deductamt;
		this.creatdate = creatdate;
		this.state = state;
		this.statechgtime = statechgtime;
		this.shopnum = shopnum;
		this.terminalnum = terminalnum;
		this.respcode = respcode;
		this.callnum = callnum;
		this.formtype = formtype;
		this.errmsg = errmsg;
	}

	public Long getDeductid() {
		return deductid;
	}

	public void setDeductid(Long deductid) {
		this.deductid = deductid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getBankid() {
		return bankid;
	}

	public void setBankid(String bankid) {
		this.bankid = bankid;
	}

	public String getAcctnum() {
		return acctnum;
	}

	public void setAcctnum(String acctnum) {
		this.acctnum = acctnum;
	}

	public Short getAccttype() {
		return accttype;
	}

	public void setAccttype(Short accttype) {
		this.accttype = accttype;
	}

	public String getAcctname() {
		return acctname;
	}

	public void setAcctname(String acctname) {
		this.acctname = acctname;
	}

	public Double getDeductamt() {
		return deductamt;
	}

	public void setDeductamt(Double deductamt) {
		this.deductamt = deductamt;
	}

	public Date getCreatdate() {
		return creatdate;
	}

	public void setCreatdate(Date creatdate) {
		this.creatdate = creatdate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getStatechgtime() {
		return statechgtime;
	}

	public void setStatechgtime(Date statechgtime) {
		this.statechgtime = statechgtime;
	}

	public String getShopnum() {
		return shopnum;
	}

	public void setShopnum(String shopnum) {
		this.shopnum = shopnum;
	}

	public String getTerminalnum() {
		return terminalnum;
	}

	public void setTerminalnum(String terminalnum) {
		this.terminalnum = terminalnum;
	}

	public String getRespcode() {
		return respcode;
	}

	public void setRespcode(String respcode) {
		this.respcode = respcode;
	}

	public String getCallnum() {
		return callnum;
	}

	public void setCallnum(String callnum) {
		this.callnum = callnum;
	}

	public Short getFormtype() {
		return formtype;
	}

	public void setFormtype(Short formtype) {
		this.formtype = formtype;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}
