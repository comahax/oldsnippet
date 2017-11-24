package com.gmcc.pboss.biz.info.salesRpt.support;

import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class OrderDtlQueryParameter extends QueryParameter {

	public OrderDtlQueryParameter() {
		setAction(QueryAction.SECTION);// 月度套卡激活明细查询分页
	}
	/**
	 * 渠道编码
	 */
	private String wayid;
	
	/**
	 * 订单ID
	 */
	private String orderid;

	/**
	 * 查询类型
	 */
	private String selecType = ConstantsType.SALES_SELECTYPE_RESDETS;//默认查订购资源明细
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
