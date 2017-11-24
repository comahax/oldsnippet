package com.gmcc.pboss.model.reward.cityrecord;


import java.util.Date;

import com.gmcc.pboss.common.bean.BaseModel;

/**
 * ChAdtCityRecord entity. @author MyEclipse Persistence Tools
 */
public class ChAdtCityRecord extends BaseModel{

	// Fields    

    private Long recordid;
    private String opnid;
    private String wayid;
    private Short rewardtype;
    private String rewardmonth;
    private String mobile;
    private Date oprtime;
    private Double busivalue;
    private Double paysum;
    private String approveid;
    private Short isflag;
    private String oprcode;
    private Date optime;
    private Short systemflag;
    private Long rewardlistid;
    private Double paymoney;
    
    // Constructors

    /** default constructor */
    public ChAdtCityRecord() {
    }

    
    /** full constructor */
    public ChAdtCityRecord(Long recordid, String opnid, String wayid,
			Short rewardtype, String rewardmonth, String mobile, Date oprtime,
			Double busivalue, Double paysum, String approveid, Short isflag,
			String oprcode, Date optime, Short systemflag, Long rewardlistid,
			Double paymoney) {
		super();
		this.recordid = recordid;
		this.opnid = opnid;
		this.wayid = wayid;
		this.rewardtype = rewardtype;
		this.rewardmonth = rewardmonth;
		this.mobile = mobile;
		this.oprtime = oprtime;
		this.busivalue = busivalue;
		this.paysum = paysum;
		this.approveid = approveid;
		this.isflag = isflag;
		this.oprcode = oprcode;
		this.optime = optime;
		this.systemflag = systemflag;
		this.rewardlistid = rewardlistid;
		this.paymoney = paymoney;
	}

	public Long getRecordid() {
		return recordid;
	}

	public void setRecordid(Long recordid) {
		this.recordid = recordid;
	}


	public String getOpnid() {
		return opnid;
	}


	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}


	public String getWayid() {
		return wayid;
	}


	public void setWayid(String wayid) {
		this.wayid = wayid;
	}


	public Short getRewardtype() {
		return rewardtype;
	}


	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}


	public String getRewardmonth() {
		return rewardmonth;
	}


	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public Date getOprtime() {
		return oprtime;
	}


	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}


	public Double getBusivalue() {
		return busivalue;
	}


	public void setBusivalue(Double busivalue) {
		this.busivalue = busivalue;
	}


	public Double getPaysum() {
		return paysum;
	}


	public void setPaysum(Double paysum) {
		this.paysum = paysum;
	}


	public String getApproveid() {
		return approveid;
	}


	public void setApproveid(String approveid) {
		this.approveid = approveid;
	}


	public Short getIsflag() {
		return isflag;
	}


	public void setIsflag(Short isflag) {
		this.isflag = isflag;
	}


	public String getOprcode() {
		return oprcode;
	}


	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}


	public Date getOptime() {
		return optime;
	}


	public void setOptime(Date optime) {
		this.optime = optime;
	}


	public Short getSystemflag() {
		return systemflag;
	}


	public void setSystemflag(Short systemflag) {
		this.systemflag = systemflag;
	}


	public Long getRewardlistid() {
		return rewardlistid;
	}


	public void setRewardlistid(Long rewardlistid) {
		this.rewardlistid = rewardlistid;
	}

	public Double getPaymoney() {
		return paymoney;
	}
	
	public void setPaymoney(Double paymoney) {
		this.paymoney = paymoney;
	}   
}
