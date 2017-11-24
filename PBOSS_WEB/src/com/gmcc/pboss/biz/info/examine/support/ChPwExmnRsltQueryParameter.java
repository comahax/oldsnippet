package com.gmcc.pboss.biz.info.examine.support;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class ChPwExmnRsltQueryParameter extends QueryParameter{
	// 构造函数
	public ChPwExmnRsltQueryParameter() {
		setAction(QueryAction.ALL);// 月度套卡激活明细查询分页
	}
	private String wayid;

	private String month;

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
}
