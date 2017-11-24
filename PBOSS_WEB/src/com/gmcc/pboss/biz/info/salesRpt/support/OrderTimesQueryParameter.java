package com.gmcc.pboss.biz.info.salesRpt.support;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class OrderTimesQueryParameter extends QueryParameter {
	public OrderTimesQueryParameter() {
		setAction(QueryAction.SECTION);// ����������Ϣ��ѯ
	}
	/**
	 * ��������
	 */
	private String wayid;
	/**
	 * �������ͣ�Ĭ��Ϊ"WAYAPP"
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
