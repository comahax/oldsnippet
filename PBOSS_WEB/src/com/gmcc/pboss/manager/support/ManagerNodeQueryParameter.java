package com.gmcc.pboss.manager.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class ManagerNodeQueryParameter extends QueryParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7914290168663261794L;
	
	//查询经理下属网点的waymagcode,等于登陆录理的id值，返回渠道列表
	private String waymagcode;
	public void setWaymagcode(String managerid){
		this.waymagcode = managerid;
	}
	public String getWaymagcode(){
		return this.waymagcode;
	}
	//根据渠道名称，支持模糊查询
	private String wayname;
	public void setWayname(String name){
		this.wayname = name;
	}
	public String getWayname(){
		return this.wayname;
	}
	
	//根据wayid查询网点详细信息
	public String wayid;
	public void setWayid(String wayid){
		this.wayid = wayid;
	}
	public String getWayid(){
		return this.wayid;
	}
	
	//是否为网点编码选择弹出框
	private boolean popup;
	public boolean isPopup() {
		return popup;
	}
	public void setPopup(boolean popup) {
		this.popup = popup;
	}

}
