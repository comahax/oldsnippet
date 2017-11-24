package com.gmcc.pboss.biz.info.salesRpt.support;

import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class OrderDtlQueryParameter extends QueryParameter {

	public OrderDtlQueryParameter() {
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
	 * ��ѯ����
	 */
	private String selecType = ConstantsType.SALES_SELECTYPE_RESDETS;//Ĭ�ϲ鶩����Դ��ϸ
	/**
	 * @return the selecType
	 */
	public String getSelecType() {
		return selecType;
	}

	/**
	 * @param selecType the selecType to set
	 */
	public void setSelecType(String selecType) {
		this.selecType = selecType;
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


}
