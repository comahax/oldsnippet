package com.gmcc.pboss.web.sales.bankrecord;

import com.gmcc.pboss.business.sales.bankrecord.BankrecordVO;

public class BankrecordDetailForm extends BankrecordVO{
	private java.lang.Long a_deductid ;
	private java.lang.String a_shopnum ;
	
	private java.lang.String a_acctnum ;
	private java.lang.String a_acctname ;
	
	private java.lang.Double a_deductamt ;
	private java.util.Date a_statechgtime ;
	
	private java.lang.String a_respcode ;
	private java.lang.String a_errmsg ;
	public java.lang.Long getA_deductid() {
		return a_deductid;
	}
	public void setA_deductid(java.lang.Long a_deductid) {
		this.a_deductid = a_deductid;
	}
	public java.lang.String getA_shopnum() {
		return a_shopnum;
	}
	public void setA_shopnum(java.lang.String a_shopnum) {
		this.a_shopnum = a_shopnum;
	}
	public java.lang.String getA_acctnum() {
		return a_acctnum;
	}
	public void setA_acctnum(java.lang.String a_acctnum) {
		this.a_acctnum = a_acctnum;
	}
	public java.lang.String getA_acctname() {
		return a_acctname;
	}
	public void setA_acctname(java.lang.String a_acctname) {
		this.a_acctname = a_acctname;
	}
	public java.lang.Double getA_deductamt() {
		return a_deductamt;
	}
	public void setA_deductamt(java.lang.Double a_deductamt) {
		this.a_deductamt = a_deductamt;
	}
	public java.util.Date getA_statechgtime() {
		return a_statechgtime;
	}
	public void setA_statechgtime(java.util.Date a_statechgtime) {
		this.a_statechgtime = a_statechgtime;
	}
	public java.lang.String getA_respcode() {
		return a_respcode;
	}
	public void setA_respcode(java.lang.String a_respcode) {
		this.a_respcode = a_respcode;
	}
	public java.lang.String getA_errmsg() {
		return a_errmsg;
	}
	public void setA_errmsg(java.lang.String a_errmsg) {
		this.a_errmsg = a_errmsg;
	}
}
