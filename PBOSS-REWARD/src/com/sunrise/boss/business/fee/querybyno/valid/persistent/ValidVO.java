package com.sunrise.boss.business.fee.querybyno.valid.persistent;

import java.util.Date;



public class ValidVO implements java.io.Serializable {

	private Long sourno;       
	private Long eboxid;       
	private Long eboxchglogid; 
	private Double amt;      		
	private Integer validday;     
	private Integer realday;      
	private Integer isvalid;      
	private Integer isroll;       
	private Date modifydate;
	
	
	public Double getAmt() {
		return amt;
	}
	public void setAmt(Double amt) {
		this.amt = amt;
	}
	public Long getEboxchglogid() {
		return eboxchglogid;
	}
	public void setEboxchglogid(Long eboxchglogid) {
		this.eboxchglogid = eboxchglogid;
	}
	public Long getEboxid() {
		return eboxid;
	}
	public void setEboxid(Long eboxid) {
		this.eboxid = eboxid;
	}
	public Integer getIsroll() {
		return isroll;
	}
	public void setIsroll(Integer isroll) {
		this.isroll = isroll;
	}
	public Integer getIsvalid() {
		return isvalid;
	}
	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}
	public Date getModifydate() {
		return modifydate;
	}
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}
	public Integer getRealday() {
		return realday;
	}
	public void setRealday(Integer realday) {
		this.realday = realday;
	}
	public Long getSourno() {
		return sourno;
	}
	public void setSourno(Long sourno) {
		this.sourno = sourno;
	}
	public Integer getValidday() {
		return validday;
	}
	public void setValidday(Integer validday) {
		this.validday = validday;
	}   







}