package com.gmcc.pboss.biz.info.regactInfo.support;

import com.gmcc.pboss.common.support.QueryAction;

public class RegactInfoQueryParameter extends RegactStatisticsQueryParameter {

	public RegactInfoQueryParameter() {
		setAction(QueryAction.SECTION);// 月度套卡激活明细查询分页
	}

	private String mobile;

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
