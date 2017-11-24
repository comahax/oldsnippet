package com.sunrise.boss.business.fee.persistent.batchoper;

import java.util.Date;

public class BatchOperVO {

	private Long logid;

    private String mobileno;
    private String opercode;
    private String wayid;
    private Date operdate;
    private String businame;
    private String menupath;
    private String memo;
    
	public Long getLogid() {
		return logid;
	}
	public void setLogid(Long logid) {
		this.logid = logid;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getOpercode() {
		return opercode;
	}
	public void setOpercode(String opercode) {
		this.opercode = opercode;
	}
	public Date getOperdate() {
		return operdate;
	}
	public void setOperdate(Date operdate) {
		this.operdate = operdate;
	}
	public String getBusiname() {
		return businame;
	}
	public void setBusiname(String businame) {
		this.businame = businame;
	}
	public String getMenupath() {
		return menupath;
	}
	public void setMenupath(String menupath) {
		this.menupath = menupath;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

    
  
}
