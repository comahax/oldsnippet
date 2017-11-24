package com.gmcc.pboss.business.resource.stkalarmstat;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class StkalarmstatshowVO extends BaseVO implements Serializable {
	private String countyid;
	private String mareacode;
	private Long redalarm;
	private Long yelalarm;
	public String getCountyid() {
		return countyid;
	}
	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}
	public String getMareacode() {
		return mareacode;
	}
	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}
	public Long getRedalarm() {
		return redalarm;
	}
	public void setRedalarm(Long redalarm) {
		this.redalarm = redalarm;
	}
	public Long getYelalarm() {
		return yelalarm;
	}
	public void setYelalarm(Long yelalarm) {
		this.yelalarm = yelalarm;
	}
	
}
