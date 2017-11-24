package com.gmcc.pboss.biz.info.salescnt.support;

import java.util.Date;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class SalescntQueryParameter extends QueryParameter {

	public SalescntQueryParameter() {
		setAction(QueryAction.SECTION);// 销售汇总查询分页
	}
	
	private String employeeid;
	private Date startoprtime;
	private Date endoprtime;
	private String wayid;
	private String wayid2;
	private String flg;
	private String opEmployeeid;
	
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public Date getStartoprtime() {
		return startoprtime;
	}
	public void setStartoprtime(Date startoprtime) {
		this.startoprtime = startoprtime;
	}
	public Date getEndoprtime() {
		return endoprtime;
	}
	public void setEndoprtime(Date endoprtime) {
		this.endoprtime = endoprtime;
	}
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public String getWayid2() {
		return wayid2;
	}
	public void setWayid2(String wayid2) {
		this.wayid2 = wayid2;
	}
	public String getFlg() {
		return flg;
	}
	public void setFlg(String flg) {
		this.flg = flg;
	}
	public String getOpEmployeeid() {
		return opEmployeeid;
	}
	public void setOpEmployeeid(String opEmployeeid) {
		this.opEmployeeid = opEmployeeid;
	}
}
