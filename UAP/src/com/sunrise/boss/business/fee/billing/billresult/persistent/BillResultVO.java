package com.sunrise.boss.business.fee.billing.billresult.persistent;

import java.util.Date;

import com.sunrise.jop.infrastructure.db.BaseVO;


public class BillResultVO extends BaseVO {


	private Long logid;

	private Long validbillcyc;

	private String phase;
	
	private Short subphase;

	private Date intime;
	
	private String result;
	
	private String pid;
	
	private Integer region;

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}


	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Short getSubphase() {
		return subphase;
	}

	public void setSubphase(Short subphase) {
		this.subphase = subphase;
	}

	public Long getValidbillcyc() {
		return validbillcyc;
	}

	public void setValidbillcyc(Long validbillcyc) {
		this.validbillcyc = validbillcyc;
	}

	public Date getIntime() {
		return intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}


}