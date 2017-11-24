package com.gmcc.pboss.biz.info.reward.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.common.bean.CodeReverse;

/**
 * ChPwRewardrecord entity. @author MyEclipse Persistence Tools
 */

public class RewardRecord extends CodeReverse implements java.io.Serializable {

	// Fields

	private Long rewardlistid;
	private Long operseq;
	private String opnid;
	private String wayid;
	private String wayoprcode;
	private Short slv;
	private Long rewardid;
	private Short rewardtype;
	// 酬金类型名称
	private String rewardtypeName;
	private Double rewardstd;
	private String rewardmonth;
	private Short isbudget;
	private Double totalsum;
	private Double paysum;
	private String paymonth1;
	private Double paymoney1;
	private String paymonth2;
	private Double paymoney2;
	private String paymonth3;
	private Double paymoney3;
	private Date runtime;
	private Short acctype;
	//计酬方式名称
	private String acctypeName;
	private String mobile;
	private Double assegrade;
	private String opermobile;

	private String opnname;

	// Constructors

	/** default constructor */
	public RewardRecord() {
	}

	/** minimal constructor */
	public RewardRecord(Long rewardlistid) {
		this.rewardlistid = rewardlistid;
	}

	/** full constructor */
	public RewardRecord(Long rewardlistid, Long operseq, String opnid, String wayid, String wayoprcode, Short slv, Long rewardid, Short rewardtype,
			Double rewardstd, String rewardmonth, Short isbudget, Double totalsum, Double paysum, String paymonth1, Double paymoney1, String paymonth2,
			Double paymoney2, String paymonth3, Double paymoney3, Date runtime, Short acctype, String mobile, Double assegrade, String opermobile) {
		this.rewardlistid = rewardlistid;
		this.operseq = operseq;
		this.opnid = opnid;
		this.wayid = wayid;
		this.wayoprcode = wayoprcode;
		this.slv = slv;
		this.rewardid = rewardid;
		this.rewardtype = rewardtype;
		this.rewardstd = rewardstd;
		this.rewardmonth = rewardmonth;
		this.isbudget = isbudget;
		this.totalsum = totalsum;
		this.paysum = paysum;
		this.paymonth1 = paymonth1;
		this.paymoney1 = paymoney1;
		this.paymonth2 = paymonth2;
		this.paymoney2 = paymoney2;
		this.paymonth3 = paymonth3;
		this.paymoney3 = paymoney3;
		this.runtime = runtime;
		this.acctype = acctype;
		this.mobile = mobile;
		this.assegrade = assegrade;
		this.opermobile = opermobile;
	}

	// Property accessors

	public Long getRewardlistid() {
		return this.rewardlistid;
	}

	public void setRewardlistid(Long rewardlistid) {
		this.rewardlistid = rewardlistid;
	}

	public Long getOperseq() {
		return this.operseq;
	}

	public void setOperseq(Long operseq) {
		this.operseq = operseq;
	}

	public String getOpnid() {
		return this.opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayoprcode() {
		return this.wayoprcode;
	}

	public void setWayoprcode(String wayoprcode) {
		this.wayoprcode = wayoprcode;
	}

	public Short getSlv() {
		return this.slv;
	}

	public void setSlv(Short slv) {
		this.slv = slv;
	}

	public Long getRewardid() {
		return this.rewardid;
	}

	public void setRewardid(Long rewardid) {
		this.rewardid = rewardid;
	}

	public Short getRewardtype() {
		return this.rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}

	public String getRewardtypeName() {
		return rewardtypeName;
	}

	public void setRewardtypeName(String rewardtypeName) {
		this.rewardtypeName = rewardtypeName;
	}

	public Double getRewardstd() {
		return this.rewardstd;
	}

	public void setRewardstd(Double rewardstd) {
		this.rewardstd = rewardstd;
	}

	public String getRewardmonth() {
		return this.rewardmonth;
	}

	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}

	public Short getIsbudget() {
		return this.isbudget;
	}

	public void setIsbudget(Short isbudget) {
		this.isbudget = isbudget;
	}

	public Double getTotalsum() {
		return this.totalsum;
	}

	public void setTotalsum(Double totalsum) {
		this.totalsum = totalsum;
	}

	public Double getPaysum() {
		return this.paysum;
	}

	public void setPaysum(Double paysum) {
		this.paysum = paysum;
	}

	public String getPaymonth1() {
		return this.paymonth1;
	}

	public void setPaymonth1(String paymonth1) {
		this.paymonth1 = paymonth1;
	}

	public Double getPaymoney1() {
		return this.paymoney1;
	}

	public void setPaymoney1(Double paymoney1) {
		this.paymoney1 = paymoney1;
	}

	public String getPaymonth2() {
		return this.paymonth2;
	}

	public void setPaymonth2(String paymonth2) {
		this.paymonth2 = paymonth2;
	}

	public Double getPaymoney2() {
		return this.paymoney2;
	}

	public void setPaymoney2(Double paymoney2) {
		this.paymoney2 = paymoney2;
	}

	public String getPaymonth3() {
		return this.paymonth3;
	}

	public void setPaymonth3(String paymonth3) {
		this.paymonth3 = paymonth3;
	}

	public Double getPaymoney3() {
		return this.paymoney3;
	}

	public void setPaymoney3(Double paymoney3) {
		this.paymoney3 = paymoney3;
	}

	public Date getRuntime() {
		return this.runtime;
	}

	public void setRuntime(Date runtime) {
		this.runtime = runtime;
	}

	public Short getAcctype() {
		return this.acctype;
	}

	public void setAcctype(Short acctype) {
		this.acctype = acctype;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Double getAssegrade() {
		return this.assegrade;
	}

	public void setAssegrade(Double assegrade) {
		this.assegrade = assegrade;
	}

	public String getOpermobile() {
		return this.opermobile;
	}

	public void setOpermobile(String opermobile) {
		this.opermobile = opermobile;
	}

	public String getOpnname() {
		return opnname;
	}

	public void setOpnname(String opnname) {
		this.opnname = opnname;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this) + "\n";
	}

	public String getAcctypeName() {
		return acctypeName;
	}

	public void setAcctypeName(String acctypeName) {
		this.acctypeName = acctypeName;
	}
	
}