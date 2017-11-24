package com.gmcc.pboss.biz.info.missioner.recommend.unvrcfailday.support;

import java.util.Date;

import com.gmcc.pboss.common.support.QueryParameter;

public class UnvrcfaildayParameter extends QueryParameter {
	private String wayid;
	private String wayname;
	private String opnid;
	private String opnname;
	private String rcno;
	private String empattr2;
	private Date oprtimeFrom;
	private Date oprtimeTo;
	public UnvrcfaildayParameter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public String getWayname() {
		return wayname;
	}
	public void setWayname(String wayname) {
		this.wayname = wayname;
	}
	public String getOpnid() {
		return opnid;
	}
	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}
	public String getOpnname() {
		return opnname;
	}
	public void setOpnname(String opnname) {
		this.opnname = opnname;
	}
	public String getRcno() {
		return rcno;
	}
	public void setRcno(String rcno) {
		this.rcno = rcno;
	}
	public String getEmpattr2() {
		return empattr2;
	}
	public void setEmpattr2(String empattr2) {
		this.empattr2 = empattr2;
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
