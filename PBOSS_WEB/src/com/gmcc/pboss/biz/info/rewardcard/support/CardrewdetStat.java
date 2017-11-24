package com.gmcc.pboss.biz.info.rewardcard.support;

import java.math.BigDecimal;

import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;

public class CardrewdetStat {
	private String wayid;
	private String wayname;
	private String rewardtype;
	private String rechmonth;
	private String activemonth;
	private String cmonth;
	private String sum;
	
	public CardrewdetStat(){
	}

	public CardrewdetStat(String wayid, String wayname, String rewardtype,
			String rechmonth, String activemonth, String cmonth, String sum) {
		super();
		this.wayid = wayid;
		this.wayname = wayname;
		//this.rewardtype = rewardtype;
		this.rewardtype = Constant.getConstantName(ConstantsType.CH_REWARD_TYPE,rewardtype.trim());
		this.rechmonth = rechmonth;
		this.activemonth = activemonth;
		this.cmonth = cmonth;
		this.sum = sum;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public String getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(String rewardtype) {
		this.rewardtype = rewardtype;
	}

	public String getRechmonth() {
		return rechmonth;
	}

	public void setRechmonth(String rechmonth) {
		this.rechmonth = rechmonth;
	}

	public String getActivemonth() {
		return activemonth;
	}

	public void setActivemonth(String activemonth) {
		this.activemonth = activemonth;
	}

	public String getCmonth() {
		return cmonth;
	}

	public void setCmonth(String cmonth) {
		this.cmonth = cmonth;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}
}
