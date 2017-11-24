package com.sunrise.boss.business.fee.hangbill.persistent;


import java.io.Serializable;
import java.util.Date;

public class MonitorUserVO implements Serializable {
	
	
	private String servnumber ;
	private String authservice;	
	private Long subsid	;
	private Long eboxid	;
	private Date eff_date ;
	private Date exp_date ;
	private Date synctime ;
	private Long syncstatus;
	private Long usertype ;
	private Long billdate ;
	private Date applydate;
	
	public String getServnumber() {
		return servnumber;
	}
	public void setServnumber(String servnumber) {
		this.servnumber = servnumber;
	}
	public String getAuthservice() {
		return authservice;
	}
	public void setAuthservice(String authservice) {
		this.authservice = authservice;
	}
	public Long getSubsid() {
		return subsid;
	}
	public void setSubsid(Long subsid) {
		this.subsid = subsid;
	}
	public Long getEboxid() {
		return eboxid;
	}
	public void setEboxid(Long eboxid) {
		this.eboxid = eboxid;
	}
	public Date getEff_date() {
		return eff_date;
	}
	public void setEff_date(Date eff_date) {
		this.eff_date = eff_date;
	}
	public Date getExp_date() {
		return exp_date;
	}
	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}
	public Date getSynctime() {
		return synctime;
	}
	public void setSynctime(Date synctime) {
		this.synctime = synctime;
	}
	public Long getSyncstatus() {
		return syncstatus;
	}
	public void setSyncstatus(Long syncstatus) {
		this.syncstatus = syncstatus;
	}
	public Long getUsertype() {
		return usertype;
	}
	public void setUsertype(Long usertype) {
		this.usertype = usertype;
	}
	public Long getBilldate() {
		return billdate;
	}
	public void setBilldate(Long billdate) {
		this.billdate = billdate;
	}
	public Date getApplydate() {
		return applydate;
	}
	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}

	
	
}
