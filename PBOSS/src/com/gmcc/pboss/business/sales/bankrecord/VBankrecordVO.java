package com.gmcc.pboss.business.sales.bankrecord;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class VBankrecordVO extends BaseVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Long deductid;
    
    private Long aaa_deductid;

    private Double amount;

    private java.sql.Timestamp completetime;
    
    private java.sql.Timestamp statechgtime;

    private String shopnum;
    
    private String acctnum;
    
    private String acctname;
    
    private String retcode;

    private String errmsg;

    private String countyid;

    private String recordinfo;

    private Short recordstate;

	public Long getDeductid() {
		return deductid;
	}

	public void setDeductid(Long deductid) {
		this.deductid = deductid;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public java.sql.Timestamp getCompletetime() {
		return completetime;
	}

	public void setCompletetime(java.sql.Timestamp completetime) {
		this.completetime = completetime;
	}

	public String getShopnum() {
		return shopnum;
	}

	public void setShopnum(String shopnum) {
		this.shopnum = shopnum;
	}

	public String getAcctnum() {
		return acctnum;
	}

	public void setAcctnum(String acctnum) {
		this.acctnum = acctnum;
	}

	public String getAcctname() {
		return acctname;
	}

	public void setAcctname(String acctname) {
		this.acctname = acctname;
	}

	public String getRetcode() {
		return retcode;
	}

	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getRecordinfo() {
		return recordinfo;
	}

	public void setRecordinfo(String recordinfo) {
		this.recordinfo = recordinfo;
	}

	public Short getRecordstate() {
		return recordstate;
	}

	public void setRecordstate(Short recordstate) {
		this.recordstate = recordstate;
	}

	public Long getAaa_deductid() {
		return aaa_deductid;
	}

	public void setAaa_deductid(Long aaa_deductid) {
		this.aaa_deductid = aaa_deductid;
	}

	public java.sql.Timestamp getStatechgtime() {
		return statechgtime;
	}

	public void setStatechgtime(java.sql.Timestamp statechgtime) {
		this.statechgtime = statechgtime;
	}

}
