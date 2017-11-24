package com.gmcc.pboss.biz.info.reward.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.common.bean.CodeReverse;

/**
 * ChPwRewardtotal entity. @author MyEclipse Persistence Tools
 */

public class RewardTotal extends CodeReverse implements java.io.Serializable {

	// Fields

	private Long totalid;
	private Short isbudget;
	private String wayid;
	private Short slv;
	private Short rewardtype;
	// 酬金类型名称
	private String rewardtypeName;
	private String chagmonth;
	private String paymonth;
	private Double paymoney;
	private String rewardmonth1;
	private Double rewardmoney1;
	private String rewardmonth2;
	private Double rewardmoney2;
	private String rewardmonth3;
	private Double rewardmoney3;
	private Short paystat;

	// Constructors

	/** default constructor */
	public RewardTotal() {
	}

	/** minimal constructor */
	public RewardTotal(Long totalid) {
		this.totalid = totalid;
	}

	/** full constructor */
	public RewardTotal(Long totalid, Short isbudget, String wayid, Short slv, Short rewardtype, String chagmonth, String paymonth, Double paymoney,
			String rewardmonth1, Double rewardmoney1, String rewardmonth2, Double rewardmoney2, String rewardmonth3, Double rewardmoney3, Short paystat) {
		this.totalid = totalid;
		this.isbudget = isbudget;
		this.wayid = wayid;
		this.slv = slv;
		this.rewardtype = rewardtype;
		this.chagmonth = chagmonth;
		this.paymonth = paymonth;
		this.paymoney = paymoney;
		this.rewardmonth1 = rewardmonth1;
		this.rewardmoney1 = rewardmoney1;
		this.rewardmonth2 = rewardmonth2;
		this.rewardmoney2 = rewardmoney2;
		this.rewardmonth3 = rewardmonth3;
		this.rewardmoney3 = rewardmoney3;
		this.paystat = paystat;
	}

	// Property accessors

	public Long getTotalid() {
		return this.totalid;
	}

	public void setTotalid(Long totalid) {
		this.totalid = totalid;
	}

	public Short getIsbudget() {
		return this.isbudget;
	}

	public void setIsbudget(Short isbudget) {
		this.isbudget = isbudget;
	}

	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public Short getSlv() {
		return this.slv;
	}

	public void setSlv(Short slv) {
		this.slv = slv;
	}

	public Short getRewardtype() {
		return this.rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}

	public String getChagmonth() {
		return this.chagmonth;
	}

	public void setChagmonth(String chagmonth) {
		this.chagmonth = chagmonth;
	}

	public String getPaymonth() {
		return this.paymonth;
	}

	public void setPaymonth(String paymonth) {
		this.paymonth = paymonth;
	}

	public Double getPaymoney() {
		return this.paymoney;
	}

	public void setPaymoney(Double paymoney) {
		this.paymoney = paymoney;
	}

	public String getRewardmonth1() {
		return this.rewardmonth1;
	}

	public void setRewardmonth1(String rewardmonth1) {
		this.rewardmonth1 = rewardmonth1;
	}

	public Double getRewardmoney1() {
		return this.rewardmoney1;
	}

	public void setRewardmoney1(Double rewardmoney1) {
		this.rewardmoney1 = rewardmoney1;
	}

	public String getRewardmonth2() {
		return this.rewardmonth2;
	}

	public void setRewardmonth2(String rewardmonth2) {
		this.rewardmonth2 = rewardmonth2;
	}

	public Double getRewardmoney2() {
		return this.rewardmoney2;
	}

	public void setRewardmoney2(Double rewardmoney2) {
		this.rewardmoney2 = rewardmoney2;
	}

	public String getRewardmonth3() {
		return this.rewardmonth3;
	}

	public void setRewardmonth3(String rewardmonth3) {
		this.rewardmonth3 = rewardmonth3;
	}

	public Double getRewardmoney3() {
		return this.rewardmoney3;
	}

	public void setRewardmoney3(Double rewardmoney3) {
		this.rewardmoney3 = rewardmoney3;
	}

	public Short getPaystat() {
		return this.paystat;
	}

	public void setPaystat(Short paystat) {
		this.paystat = paystat;
	}

	public String getRewardtypeName() {
		return rewardtypeName;
	}

	public void setRewardtypeName(String rewardtypeName) {
		this.rewardtypeName = rewardtypeName;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}