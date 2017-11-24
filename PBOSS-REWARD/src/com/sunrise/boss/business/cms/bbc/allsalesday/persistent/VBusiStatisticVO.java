package com.sunrise.boss.business.cms.bbc.allsalesday.persistent;

import java.io.Serializable;

public class VBusiStatisticVO implements Serializable {
	private String opnid;
	private Long val;
	
	public VBusiStatisticVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VBusiStatisticVO(String opnid, Long val) {
		super();
		this.opnid = opnid;
		this.val = val;
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
