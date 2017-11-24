package com.sunrise.boss.business.cms.bbc.bbcrewardtotal.persistent;

/**
 * ChBbcRewardtotal entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BbcRewardtotalVO implements java.io.Serializable {

	// Fields

	private Long totalid;

	private String wayid;

	private Long rewardtype;

	private String rewardmonth;

	private Double paymoney;

	private String countycompname;

	private String wayname;

	private Long starlevel;

	private Integer ossrc;
	
	private String batchno;

	// Constructors

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public String getCountycompname() {
		return countycompname;
	}

	public void setCountycompname(String countycompname) {
		this.countycompname = countycompname;
	}

	public Long getStarlevel() {
		return starlevel;
	}

	public void setStarlevel(Long starlevel) {
		this.starlevel = starlevel;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	/** default constructor */
	public BbcRewardtotalVO() {
	}

	/** minimal constructor */
	public BbcRewardtotalVO(Long totalid) {
		this.totalid = totalid;
	}

	/** full constructor */
	public BbcRewardtotalVO(Long totalid, String wayid, Long rewardtype,
			String rewardmonth, Double paymoney, String countycompname,
			String wayname, Long starlevel) {
		this.totalid = totalid;
		this.wayid = wayid;
		this.rewardtype = rewardtype;
		this.rewardmonth = rewardmonth;
		this.paymoney = paymoney;
		this.countycompname = countycompname;
		this.wayname = wayname;
		this.starlevel = starlevel;
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

	public Long getRewardtype() {
		return this.rewardtype;
	}

	public void setRewardtype(Long rewardtype) {
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

	public Integer getOssrc() {
		return ossrc;
	}

	public void setOssrc(Integer ossrc) {
		this.ossrc = ossrc;
	}

}