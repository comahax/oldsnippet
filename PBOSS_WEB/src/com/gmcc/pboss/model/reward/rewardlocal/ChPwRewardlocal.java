package com.gmcc.pboss.model.reward.rewardlocal;

import java.util.ArrayList;
import java.util.List;

/**
 * ChPwRewardlocal entity. @author MyEclipse Persistence Tools
 */

public class ChPwRewardlocal extends com.gmcc.pboss.common.bean.CodeReverse
		implements java.io.Serializable {

	// Fields

	private Long rewardid;
	private String rewardmonth;
	private String rpttype;
	private String cityname;
	private String localname;
	private String wayidCus;
	private String wayid;
	private String wayname;
	private Byte starlevel;
	private List<ChPwRewardlocalvalue> valuesList=new ArrayList<ChPwRewardlocalvalue>();

	// Constructors

	/** default constructor */
	public ChPwRewardlocal() {
	}

	/** minimal constructor */
	public ChPwRewardlocal(String rewardmonth, String rpttype) {
		this.rewardmonth = rewardmonth;
		this.rpttype = rpttype;
	}

	/** full constructor */
	public ChPwRewardlocal(String rewardmonth, String rpttype, String cityname,
			String localname, String wayidCus, String wayid, String wayname,
			Byte starlevel) {
		this.rewardmonth = rewardmonth;
		this.rpttype = rpttype;
		this.cityname = cityname;
		this.localname = localname;
		this.wayidCus = wayidCus;
		this.wayid = wayid;
		this.wayname = wayname;
		this.starlevel = starlevel;
	}

	// Property accessors

	public Long getRewardid() {
		return this.rewardid;
	}

	public void setRewardid(Long rewardid) {
		this.rewardid = rewardid;
	}

	public String getRewardmonth() {
		return this.rewardmonth;
	}

	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}

	public String getRpttype() {
		return this.rpttype;
	}

	public void setRpttype(String rpttype) {
		this.rpttype = rpttype;
	}

	public String getCityname() {
		return this.cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getLocalname() {
		return this.localname;
	}

	public void setLocalname(String localname) {
		this.localname = localname;
	}

	public String getWayidCus() {
		return this.wayidCus;
	}

	public void setWayidCus(String wayidCus) {
		this.wayidCus = wayidCus;
	}

	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayname() {
		return this.wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public Byte getStarlevel() {
		return this.starlevel;
	}

	public void setStarlevel(Byte starlevel) {
		this.starlevel = starlevel;
	}

	public List<ChPwRewardlocalvalue> getValuesList() {
		return valuesList;
	}

	public void setValuesList(List<ChPwRewardlocalvalue> valuesList) {
		this.valuesList = valuesList;
	}
	
}