package com.gmcc.pboss.manager.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class NodeMemberQueryParameter extends QueryParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6062818687529652377L;
	
	//根据渠道编码wayid,查询所有所属店员
	public String wayid;
	public void setWayid(String wayid){
		this.wayid = wayid;
	}
	public String getWayid(){
		return this.wayid;
	}
	

}
