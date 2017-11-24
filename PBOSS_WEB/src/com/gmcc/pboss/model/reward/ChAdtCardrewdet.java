package com.gmcc.pboss.model.reward;

import java.io.Serializable;
import java.util.Date;

import com.gmcc.pboss.common.bean.CodeReverse;

public class ChAdtCardrewdet extends CodeReverse implements Serializable {

	// Fields

	private Long seqid;
	private String wayid;
	private String mobile;
	private Date activetime;
	private Double rechargenum;
	private Date rechargetime;
	private Double rewardnum;
	private String cmonth;
	private Integer rewardtype;
	
	// Constructors
	
	/** default constructor */
	public ChAdtCardrewdet() {
	}	
	/** minimal constructor */
	public ChAdtCardrewdet(Long seqid) {
		this.seqid = seqid;
	}
	/** full constructor */
	public ChAdtCardrewdet(Long seqid, String wayid, String mobile,
			Date activetime, Double rechargenum, Date rechargetime,
			Double rewardnum, String cmonth, Integer rewardtype) {
		super();
		this.seqid = seqid;
		this.wayid = wayid;
		this.mobile = mobile;
		this.activetime = activetime;
		this.rechargenum = rechargenum;
		this.rechargetime = rechargetime;
		this.rewardnum = rewardnum;
		this.cmonth = cmonth;
		this.rewardtype = rewardtype;
	}
	
	// Property accessors

	public Long getSeqid() {
		return this.seqid;
	}

	public void setSeqid(Long seqid) {
		this.seqid = seqid;
	}

	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getActivetime() {
		return this.activetime;
	}

	public void setActivetime(Date activetime) {
		this.activetime = activetime;
	}

	public Double getRechargenum() {
		return this.rechargenum;
	}

	public void setRechargenum(Double rechargenum) {
		this.rechargenum = rechargenum;
	}

	public Date getRechargetime() {
		return this.rechargetime;
	}

	public void setRechargetime(Date rechargetime) {
		this.rechargetime = rechargetime;
	}

	public Double getRewardnum() {
		return this.rewardnum;
	}

	public void setRewardnum(Double rewardnum) {
		this.rewardnum = rewardnum;
	}

	public String getCmonth() {
		return this.cmonth;
	}

	public void setCmonth(String cmonth) {
		this.cmonth = cmonth;
	}

	public Integer getRewardtype() {
		return this.rewardtype;
	}

	public void setRewardtype(Integer rewardtype) {
		this.rewardtype = rewardtype;
	}
	
}
