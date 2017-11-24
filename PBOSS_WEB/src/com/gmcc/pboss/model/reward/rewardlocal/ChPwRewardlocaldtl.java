package com.gmcc.pboss.model.reward.rewardlocal;

/**
 * ChPwRewardlocaldtl entity. @author MyEclipse Persistence Tools
 */

public class ChPwRewardlocaldtl extends com.gmcc.pboss.common.bean.CodeReverse
		implements java.io.Serializable {

	// Fields

	private Long id;
	private String rewardmonth;
	private String wayid;
	private String mobleno;
	private String type;
	private Double paymoney;
	 private String failureexplain;

	// Constructors

	public String getFailureexplain() {
		return failureexplain;
	}

	public void setFailureexplain(String failureexplain) {
		this.failureexplain = failureexplain;
	}

	/** default constructor */
	public ChPwRewardlocaldtl() {
	}

	/** minimal constructor */
	public ChPwRewardlocaldtl(String rewardmonth, String wayid) {
		this.rewardmonth = rewardmonth;
		this.wayid = wayid;
	}

	/** full constructor */
	public ChPwRewardlocaldtl(String rewardmonth, String wayid, String mobleno,
			String type, Double paymoney) {
		this.rewardmonth = rewardmonth;
		this.wayid = wayid;
		this.mobleno = mobleno;
		this.type = type;
		this.paymoney = paymoney;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRewardmonth() {
		return this.rewardmonth;
	}

	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}

	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getMobleno() {
		return this.mobleno;
	}

	public void setMobleno(String mobleno) {
		this.mobleno = mobleno;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPaymoney() {
		return this.paymoney;
	}

	public void setPaymoney(Double paymoney) {
		this.paymoney = paymoney;
	}

}