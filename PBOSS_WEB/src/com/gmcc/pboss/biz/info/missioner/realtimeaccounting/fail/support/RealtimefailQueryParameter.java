package com.gmcc.pboss.biz.info.missioner.realtimeaccounting.fail.support;

import java.util.Date;

import com.gmcc.pboss.common.support.QueryParameter;

public class RealtimefailQueryParameter extends QueryParameter {
	private String wayid;
	private String opnname;
	private String oprcode;
	private Date oprtimeFrom;
	private Date oprtimeTo;
	public RealtimefailQueryParameter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RealtimefailQueryParameter(String wayid, String opnname,
			String oprcode, Date oprtimeFrom, Date oprtimeTo) {
		super();
		this.wayid = wayid;
		this.opnname = opnname;
		this.oprcode = oprcode;
		this.oprtimeFrom = oprtimeFrom;
		this.oprtimeTo = oprtimeTo;
	}
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
