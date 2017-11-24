package com.gmcc.pboss.biz.info.way.support;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class WayQueryParameter extends QueryParameter {

	public WayQueryParameter() {
		setAction(QueryAction.SECTION);// 网点明细查询分页
	}
	
	private String wayid;
	private String upperwayid;
	private String wayname;
	private String cityid;
	private String waymagcode;
	
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
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getUpperwayid() {
		return upperwayid;
	}
	public void setUpperwayid(String upperwayid) {
		this.upperwayid = upperwayid;
	}
	public String getWaymagcode() {
		return waymagcode;
	}
	public void setWaymagcode(String waymagcode) {
		this.waymagcode = waymagcode;
	}
}
