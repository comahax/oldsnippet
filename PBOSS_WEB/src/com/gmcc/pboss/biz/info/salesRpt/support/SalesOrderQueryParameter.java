package com.gmcc.pboss.biz.info.salesRpt.support;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class SalesOrderQueryParameter extends QueryParameter {

	public SalesOrderQueryParameter() {
		setAction(QueryAction.SECTION);// �¶��׿�������ϸ��ѯ��ҳ
	}
	/**
	 * ��������
	 */
	private String wayid;
	
	/**
	 * ����ID
	 */
	private String orderid;
	
	/**
	 * �·�
	 */

	private String month;
	/**
	 * ����״̬
	 */
	private String orderstate;
	

	/**
	 * ����ID
	 */
	private Long advId;
	
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @return the wayid
	 */
	public String getWayid() {
		return wayid;
	}
	/**
	 * @param wayid the wayid to set
	 */
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	/**
	 * @return the orderid
	 */
	public String getOrderid() {
		return orderid;
	}
	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	/**
	 * @return the orderstate
	 */
	public String getOrderstate() {
		return orderstate;
	}
	/**
	 * @param orderstate the orderstate to set
	 */
	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}
	/**
	 * @return the advId
	 */
	public Long getAdvId() {
		return advId;
	}
	/**
	 * @param advId the advId to set
	 */
	public void setAdvId(Long advId) {
		this.advId = advId;
	}
	
	

}
