package com.gmcc.pboss.biz.info.reward.support;

import java.util.Date;

import com.gmcc.pboss.common.support.QueryParameter;

/**
 * 酬金明细查询条件
 * 
 */
public class RewardQueryParameter extends QueryParameter {

	// 业务代码
	private String opnid;
	// 渠道标识
	private String wayid;
	// 酬金类型
	private String rewardtype;
	// 结算月份 /发放月份yyyyMM
	private String month;
	// 人员手机号码
	private String opermobile;
	// 结算期数
	private String term;
	
	private String type;
	
	private Date nowDate;
	// 结算月份 /发放月份yyyy年MM月
	private String zhmonth;
	// 是否汇总
	private boolean group = false;
	
	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(String rewardtype) {
		this.rewardtype = rewardtype;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getOpermobile() {
		return opermobile;
	}

	public void setOpermobile(String opermobile) {
		this.opermobile = opermobile;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	/**
	 * @return the group
	 */
	public boolean isGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(boolean group) {
		this.group = group;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getNowDate() {
		return nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	public String getZhmonth() {
		return zhmonth;
	}

	public void setZhmonth(String zhmonth) {
		this.zhmonth = zhmonth;
	}
	
	
}