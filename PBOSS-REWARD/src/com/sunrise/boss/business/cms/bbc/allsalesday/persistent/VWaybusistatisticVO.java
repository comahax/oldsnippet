package com.sunrise.boss.business.cms.bbc.allsalesday.persistent;

import java.io.Serializable;

public class VWaybusistatisticVO implements Serializable {
	private String wayid;
	private String opnid;
	private Long val;
	public VWaybusistatisticVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VWaybusistatisticVO(String wayid, String opnid){
		super();
		this.wayid = wayid;
		this.opnid = opnid;
	}
	public VWaybusistatisticVO(String wayid, String opnid, Long val) {
		super();
		this.wayid = wayid;
		this.opnid = opnid;
		this.val = val;
	}
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public String getOpnid() {
		return opnid;
	}
	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}
	public Long getVal() {
		return val;
	}
	public void setVal(Long val) {
		this.val = val;
	}
}
