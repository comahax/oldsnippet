package com.sunrise.boss.business.cms.provagent.chpdauditdispute.persistent;

import java.io.Serializable;

/** @author Hibernate CodeGenerator */
public class VChPdAuditdisputeVO implements Serializable {
	private Long disputeid;
	private String cityid;
	private Long rewardid;
	private String provagentid;
	private String prodno;
	private String prodid;
	private String prodname;
	private String custid;
	private String custname;
	private Short phase;
	private String rewardmonth;
	private Double rewardmoney;
	private Byte auditrole;
	private String content;
	private String auditeename;
	private String telephone;
	private Byte isaccepted;
	private Byte isdealed;
	private Byte dealtype;
	private Long suppleseq;
	private java.util.Date incomstime;

	public Long getDisputeid() {
		return disputeid;
	}

	public void setDisputeid(Long disputeid) {
		this.disputeid = disputeid;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public Long getRewardid() {
		return rewardid;
	}

	public void setRewardid(Long rewardid) {
		this.rewardid = rewardid;
	}

	public String getProvagentid() {
		return provagentid;
	}

	public void setProvagentid(String provagentid) {
		this.provagentid = provagentid;
	}

	public String getProdno() {
		return prodno;
	}

	public void setProdno(String prodno) {
		this.prodno = prodno;
	}

	public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public Short getPhase() {
		return phase;
	}

	public void setPhase(Short phase) {
		this.phase = phase;
	}

	public String getRewardmonth() {
		return rewardmonth;
	}

	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}

	public Double getRewardmoney() {
		return rewardmoney;
	}

	public void setRewardmoney(Double rewardmoney) {
		this.rewardmoney = rewardmoney;
	}

	public Byte getAuditrole() {
		return auditrole;
	}

	public void setAuditrole(Byte auditrole) {
		this.auditrole = auditrole;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuditeename() {
		return auditeename;
	}

	public void setAuditeename(String auditeename) {
		this.auditeename = auditeename;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Byte getIsaccepted() {
		return isaccepted;
	}

	public void setIsaccepted(Byte isaccepted) {
		this.isaccepted = isaccepted;
	}

	public Byte getIsdealed() {
		return isdealed;
	}

	public void setIsdealed(Byte isdealed) {
		this.isdealed = isdealed;
	}

	public Byte getDealtype() {
		return dealtype;
	}

	public void setDealtype(Byte dealtype) {
		this.dealtype = dealtype;
	}

	public Long getSuppleseq() {
		return suppleseq;
	}

	public void setSuppleseq(Long suppleseq) {
		this.suppleseq = suppleseq;
	}

	public java.util.Date getIncomstime() {
		return incomstime;
	}

	public void setIncomstime(java.util.Date incomstime) {
		this.incomstime = incomstime;
	}
}
