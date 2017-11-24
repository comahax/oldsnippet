package com.gmcc.pboss.biz.info.reward.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class CityrecordQueryParameter extends QueryParameter {
	private String wayid;
	private String month;//结算月份
	private String opnid2;
	private String rewardtype;
	private String wayname;
	private String starlevel;
	private String oprmonth;//业务发生月
	private String paymonth;//付款月份
	private boolean supportPaymonth = false;//是否支持付款月份
	public CityrecordQueryParameter() {
		super();
		// TODO Auto-generated constructor stub
	}	
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
	public String getOpnid2() {
		return opnid2;
	}
	public void setOpnid2(String opnid2) {
		this.opnid2 = opnid2;
	}
	public String getRewardtype() {
		return rewardtype;
	}
	public void setRewardtype(String rewardtype) {
		this.rewardtype = rewardtype;
	}
	public String getWayname() {
		return wayname;
	}
	public void setWayname(String wayname) {
		this.wayname = wayname;
	}
	public String getStarlevel() {
		return starlevel;
	}
	public void setStarlevel(String starlevel) {
		this.starlevel = starlevel;
	}
	public String getOprmonth() {
		return oprmonth;
	}
	public void setOprmonth(String oprmonth) {
		this.oprmonth = oprmonth;
	}
	public String getPaymonth() {
		return paymonth;
	}
	public void setPaymonth(String paymonth) {
		this.paymonth = paymonth;
	}
	public boolean isSupportPaymonth() {
		return supportPaymonth;
	}
	public void setSupportPaymonth(boolean supportPaymonth) {
		this.supportPaymonth = supportPaymonth;
	}
}
