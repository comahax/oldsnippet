package com.sunrise.boss.business.fee.woff.changewait.persistent;

import java.io.Serializable;
import java.util.Date;

public class ChargeWaitVO implements Serializable {


	private Long chargeid;
	private Long eboxid;
	private Long subsid;
	private String acctstr;
	private String eboxstr;
	private Long billcyc;
	private Integer chargetype;
	private Integer source;
	private Double amt;
	private String servnumber;
	private Date reqtime;
	private Integer iscredit;
	private Long orgid;
	private String memo;
	
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Long getOrgid() {
		return orgid;
	}
	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}
	public String getAcctstr() {
		return acctstr;
	}
	public void setAcctstr(String acctstr) {
		this.acctstr = acctstr;
	}
	public String getEboxstr() {
		return eboxstr;
	}
	public void setEboxstr(String eboxstr) {
		this.eboxstr = eboxstr;
	}
	public Double getAmt() {
		return amt;
	}
	public void setAmt(Double amt) {
		this.amt = amt;
	}
	public Long getBillcyc() {
		return billcyc;
	}
	public void setBillcyc(Long billcyc) {
		this.billcyc = billcyc;
	}
	public Long getChargeid() {
		return chargeid;
	}
	public void setChargeid(Long chargeid) {
		this.chargeid = chargeid;
	}
	public Integer getChargetype() {
		return chargetype;
	}
	public void setChargetype(Integer chargetype) {
		this.chargetype = chargetype;
	}
	public Long getEboxid() {
		return eboxid;
	}
	public void setEboxid(Long eboxid) {
		this.eboxid = eboxid;
	}
	public Date getReqtime() {
		return reqtime;
	}
	public void setReqtime(Date reqtime) {
		this.reqtime = reqtime;
	}
	public String getServnumber() {
		return servnumber;
	}
	public void setServnumber(String servnumber) {
		this.servnumber = servnumber;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public Long getSubsid() {
		return subsid;
	}
	public void setSubsid(Long subsid) {
		this.subsid = subsid;
	}
	public Integer getIscredit() {
		return iscredit;
	}
	public void setIscredit(Integer iscredit) {
		this.iscredit = iscredit;
	}
	
	
	
	
}
