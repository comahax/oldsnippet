package com.gmcc.pboss.biz.info.reward.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.biz.info.node.model.Way;
import com.gmcc.pboss.common.bean.CodeReverse;

/**
 * ChBbcRewardtotal entity. @author MyEclipse Persistence Tools
 */

public class BbcRewardTotal extends CodeReverse implements java.io.Serializable {

	// Fields

	private Long totalid;
	private String wayid;
	private Short rewardtype;
	// 酬金类型名称
	private String rewardtypeName;
	private String rewardmonth;
	private Double paymoney;
	private Byte ossrc;

	// 渠道名称和星级从渠道对象里面取
	private Way way;

	// Constructors

	/** default constructor */
	public BbcRewardTotal() {
	}

	/** minimal constructor */
	public BbcRewardTotal(Long totalid) {
		this.totalid = totalid;
	}

	/** full constructor */
	public BbcRewardTotal(Long totalid, String wayid, Short rewardtype, String rewardmonth, Double paymoney, Byte ossrc) {
		this.totalid = totalid;
		this.wayid = wayid;
		this.rewardtype = rewardtype;
		this.rewardmonth = rewardmonth;
		this.paymoney = paymoney;
		this.ossrc = ossrc;
	}

	// Property accessors

	public Long getTotalid() {
		return this.totalid;
	}

	public void setTotalid(Long totalid) {
		this.totalid = totalid;
	}

	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public Short getRewardtype() {
		return this.rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}

	public String getRewardmonth() {
		return this.rewardmonth;
	}

	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}

	public Double getPaymoney() {
		return this.paymoney;
	}

	public void setPaymoney(Double paymoney) {
		this.paymoney = paymoney;
	}

	public Byte getOssrc() {
		return this.ossrc;
	}

	public void setOssrc(Byte ossrc) {
		this.ossrc = ossrc;
	}

	public Way getWay() {
		return way;
	}

	public void setWay(Way way) {
		this.way = way;
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