package com.gmcc.pboss.biz.info.reward.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.biz.info.node.model.Way;

/**
 * ChBbcRewardrecord entity. @author MyEclipse Persistence Tools
 */

public class BbcRewardRecord implements java.io.Serializable {

	// Fields

	private Long rewardlistid;
	private String operseq;
	private String datasrc;
	private String opnid;
	private String wayid;
	private String wayoprcode;
	private Long rewardid;
	private Short rewardtype;
	private String rewardtypeName;
	private Double rewardstd;
	private String rewardmonth;
	private Double totalsum;
	private Double paysum;
	private Date runtime;
	private Date oprtime;
	private Short noncyc;
	private Byte ossrc;

	// 业务名称
	private String opnname;

	// 渠道名称和星级从渠道对象里面取
	private Way way;

	// Constructors

	/** default constructor */
	public BbcRewardRecord() {
	}

	/** minimal constructor */
	public BbcRewardRecord(Long rewardlistid) {
		this.rewardlistid = rewardlistid;
	}

	/** full constructor */
	public BbcRewardRecord(Long rewardlistid, String operseq, String datasrc, String opnid, String wayid, String wayoprcode, Long rewardid, Short rewardtype,
			Double rewardstd, String rewardmonth, Double totalsum, Double paysum, Date runtime, Date oprtime, Short noncyc, Byte ossrc) {
		this.rewardlistid = rewardlistid;
		this.operseq = operseq;
		this.datasrc = datasrc;
		this.opnid = opnid;
		this.wayid = wayid;
		this.wayoprcode = wayoprcode;
		this.rewardid = rewardid;
		this.rewardtype = rewardtype;
		this.rewardstd = rewardstd;
		this.rewardmonth = rewardmonth;
		this.totalsum = totalsum;
		this.paysum = paysum;
		this.runtime = runtime;
		this.oprtime = oprtime;
		this.noncyc = noncyc;
		this.ossrc = ossrc;
	}

	// Property accessors

	public Long getRewardlistid() {
		return this.rewardlistid;
	}

	public void setRewardlistid(Long rewardlistid) {
		this.rewardlistid = rewardlistid;
	}

	public String getOperseq() {
		return this.operseq;
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

	public Short getRewardtype() {
		return this.rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
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

	public Date getOprtime() {
		return this.oprtime;
	}

	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}

	public Short getNoncyc() {
		return this.noncyc;
	}

	public void setNoncyc(Short noncyc) {
		this.noncyc = noncyc;
	}

	public Byte getOssrc() {
		return this.ossrc;
	}

	public void setOssrc(Byte ossrc) {
		this.ossrc = ossrc;
	}

	public String getOpnname() {
		return opnname;
	}

	public void setOpnname(String opnname) {
		this.opnname = opnname;
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