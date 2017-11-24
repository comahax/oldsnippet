package com.sunrise.boss.business.fee.billing.billstartlog.persistent;

import java.util.Date;

import com.sunrise.jop.infrastructure.db.BaseVO;


public class BillStartLogVO extends BaseVO {


	private Long logid;

	private Long validbillcyc;

	private String startstep;

	private Date starttime;

	private Long ruleid;

	 

	private String opercode;

	private String startrsn;

	private String batchnum;
	
	private Integer region;

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public String getBatchnum() {
		return batchnum;
	}

	public void setBatchnum(String batchnum) {
		this.batchnum = batchnum;
	}

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public String getOpercode() {
		return opercode;
	}

	public void setOpercode(String opercode) {
		this.opercode = opercode;
	}

 
	public Long getRuleid() {
		return ruleid;
	}

	public void setRuleid(Long ruleid) {
		this.ruleid = ruleid;
	}

	public String getStartrsn() {
		return startrsn;
	}

	public void setStartrsn(String startrsn) {
		this.startrsn = startrsn;
	}

	public String getStartstep() {
		return startstep;
	}

	public void setStartstep(String startstep) {
		this.startstep = startstep;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Long getValidbillcyc() {
		return validbillcyc;
	}

	public void setValidbillcyc(Long validbillcyc) {
		this.validbillcyc = validbillcyc;
	}



	

}