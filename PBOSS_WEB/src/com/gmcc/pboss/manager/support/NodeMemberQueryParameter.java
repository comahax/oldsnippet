package com.gmcc.pboss.manager.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class NodeMemberQueryParameter extends QueryParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6062818687529652377L;
	
	//������������wayid,��ѯ����������Ա
	public String wayid;
	public void setWayid(String wayid){
		this.wayid = wayid;
	}
	public String getWayid(){
		return this.wayid;
	}
	

}
