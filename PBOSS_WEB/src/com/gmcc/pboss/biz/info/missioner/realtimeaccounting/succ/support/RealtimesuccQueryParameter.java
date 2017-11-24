package com.gmcc.pboss.biz.info.missioner.realtimeaccounting.succ.support;

import java.util.Date;

import com.gmcc.pboss.common.support.QueryParameter;

public class RealtimesuccQueryParameter extends QueryParameter {
	private String wayid;
	private String opnname;
	private String oprcode;
	private Date oprtimeFrom;
	private Date oprtimeTo;
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public String getOpnname() {
		return opnname;
	}
	public void setOpnname(String opnname) {
		this.opnname = opnname;
	}
	public String getOprcode() {
		return oprcode;
	}
	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}
	public Date getOprtimeFrom() {
		return oprtimeFrom;
	}
	public void setOprtimeFrom(Date oprtimeFrom) {
		this.oprtimeFrom = oprtimeFrom;
	}
	public Date getOprtimeTo() {
		return oprtimeTo;
	}
	public void setOprtimeTo(Date oprtimeTo) {
		this.oprtimeTo = oprtimeTo;
	}
}
