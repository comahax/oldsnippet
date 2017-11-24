package com.gmcc.pboss.biz.info.salesRpt.support;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class SalesHistoryQueryParameter extends QueryParameter {

	public SalesHistoryQueryParameter() {
		setAction(QueryAction.SECTION);// 月度套卡激活明细查询分页
	}
	/**
	 * 渠道编码
	 */
	private String wayid;
	
	/**
	 * 商品种类
	 */
	private String comType;

	/**
	 * 套卡/充值卡号码
	 */
	private String mobileNo;

	private String month;
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
	 * @return the comType
	 */
	public String getComType() {
		return comType;
	}
	/**
	 * @param comType the comType to set
	 */
	public void setComType(String comType) {
		this.comType = comType;
	}
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
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
}
