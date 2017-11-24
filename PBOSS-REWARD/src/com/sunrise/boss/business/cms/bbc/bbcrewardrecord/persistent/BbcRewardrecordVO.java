package com.sunrise.boss.business.cms.bbc.bbcrewardrecord.persistent;

import java.util.Date;

/**
 * AbstractChBbcRewardrecord entity provides the base persistence definition of
 * the ChBbcRewardrecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BbcRewardrecordVO implements java.io.Serializable {

	// Fields

	private Long rewardlistid;

	private String operseq;

	private String datasrc;

	private String opnid;

	private String wayid;

	private String wayoprcode;

	private Long rewardid;

	private Long rewardtype;

	private Double rewardstd;

	private String rewardmonth;

	private Double totalsum;

	private Double paysum;

	private Date runtime;

	private String wayname;

	private String countycompname;

	private Long noncyc;

	private Date oprtime;

	private Long starlevel;

	private Integer ossrc;
	
	private String mobile;
	
	private String batchno;
	// Constructors

	// Property accessors

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public Long getRewardlistid() {
		return this.rewardlistid;
	}

	public void setRewardlistid(Long rewardlistid) {
		this.rewardlistid = rewardlistid;
	}

	public String getOperseq() {
		return operseq;
	}

	public void setOperseq(String operseq) {
		this.operseq = operseq;
	}

	public String getDatasrc() {
		return this.datasrc;
	}

	public void setDatasrc(String datasrc) {
		this.datasrc = datasrc;
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

	public Long getRewardid() {
		return this.rewardid;
	}

	public void setRewardid(Long rewardid) {
		this.rewardid = rewardid;
	}

	public Long getRewardtype() {
		return this.rewardtype;
	}

	public void setRewardtype(Long rewardtype) {
		this.rewardtype = rewardtype;
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

	public Date getRuntime() {
		return this.runtime;
	}

	public void setRuntime(Date runtime) {
		this.runtime = runtime;
	}

	public String getCountycompname() {
		return countycompname;
	}

	public void setCountycompname(String countycompname) {
		this.countycompname = countycompname;
	}

	public Long getNoncyc() {
		return noncyc;
	}

	public void setNoncyc(Long noncyc) {
		this.noncyc = noncyc;
	}

	public Date getOprtime() {
		return oprtime;
	}

	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
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

	public Integer getOssrc() {
		return ossrc;
	}

	public void setOssrc(Integer ossrc) {
		this.ossrc = ossrc;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}