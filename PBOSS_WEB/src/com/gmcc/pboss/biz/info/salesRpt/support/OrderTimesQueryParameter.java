package com.gmcc.pboss.biz.info.salesRpt.support;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class OrderTimesQueryParameter extends QueryParameter {
	public OrderTimesQueryParameter() {
		setAction(QueryAction.SECTION);// 订购次数信息查询
	}
	/**
	 * 渠道编码
	 */
	private String wayid;
	/**
	 * 渠道类型：默认为"WAYAPP"
	 */
	private String waytype="WAYAPP";
	
	public String getWayid(){
		return this.wayid;
	}
	public void setWayid(String wayid){
		this.wayid = wayid;
	}
	
	public String getWaytype(){
		return this.waytype;
	}
	public void setWaytype(String waytype){
		this.waytype = waytype;
	}
}
