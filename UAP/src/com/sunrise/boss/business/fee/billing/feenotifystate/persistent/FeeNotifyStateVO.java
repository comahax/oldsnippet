package com.sunrise.boss.business.fee.billing.feenotifystate.persistent;

import java.util.Date;

import com.sunrise.jop.infrastructure.db.BaseVO;



public class FeeNotifyStateVO  extends BaseVO {

     private Long validbillcyc;
     private Short smsfilestate;
     private Date filestarttime;
     private Date fileendtime;
     private Short smssendstate;
     private Date smsstarttime;
     private Date smsendtime;
     private String oprcode;
	public String getOprcode() {
		return oprcode;
	}
	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}
	public Short getSmsfilestate() {
		return smsfilestate;
	}
	public void setSmsfilestate(Short smsfilestate) {
		this.smsfilestate = smsfilestate;
	}
	public Short getSmssendstate() {
		return smssendstate;
	}
	public void setSmssendstate(Short smssendstate) {
		this.smssendstate = smssendstate;
	}
	public Long getValidbillcyc() {
		return validbillcyc;
	}
	public void setValidbillcyc(Long validbillcyc) {
		this.validbillcyc = validbillcyc;
	}
	public Date getFileendtime() {
		return fileendtime;
	}
	public void setFileendtime(Date fileendtime) {
		this.fileendtime = fileendtime;
	}
	public Date getFilestarttime() {
		return filestarttime;
	}
	public void setFilestarttime(Date filestarttime) {
		this.filestarttime = filestarttime;
	}
	public Date getSmsendtime() {
		return smsendtime;
	}
	public void setSmsendtime(Date smsendtime) {
		this.smsendtime = smsendtime;
	}
	public Date getSmsstarttime() {
		return smsstarttime;
	}
	public void setSmsstarttime(Date smsstarttime) {
		this.smsstarttime = smsstarttime;
	}

}