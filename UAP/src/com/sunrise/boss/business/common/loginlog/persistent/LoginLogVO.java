package com.sunrise.boss.business.common.loginlog.persistent;

import java.util.Date;

import com.sunrise.jop.infrastructure.db.BaseVO;


public class LoginLogVO extends BaseVO {

    private Long logid;
    
    private String staffid;
    
    private String systemid;
    
    private Date opertime;
    
    private Byte result;
    
    private String errormsg;

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public String getStaffid() {
		return staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}

	public String getSystemid() {
		return systemid;
	}

	public void setSystemid(String systemid) {
		this.systemid = systemid;
	}

	public Date getOpertime() {
		return opertime;
	}

	public void setOpertime(Date opertime) {
		this.opertime = opertime;
	}

	public Byte getResult() {
		return result;
	}

	public void setResult(Byte result) {
		this.result = result;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
    
    

}
