package com.gmcc.pboss.model.reward.allsalesday;

import java.util.Date;

import com.gmcc.pboss.common.bean.BaseModel;

public class ChBbcAllsalesday extends BaseModel{
	private String ruleid;//校验规则  
	private String opnid;//发生业务编码
	private String name;//发生业务名称  
	private String calcopnid;//结算业务编码  
	//private String calname;//结算业务名称
	private String calcmonth;//结算月份
	private String wayid;//渠道编码  
	//private String wayname;//渠道名称
	private Date oprtime;//业务发生时间
	private String oprcode;//专员号码
	private String mobile;//业务发生号码
	private Double busivalue;//业务量
	private Double rewardtype;//酬金类型
	private Double ossrc;//业务来源
	private String empattr2;//成员属性
	private String srcseq;//元数据流水号
	
	private Long seq;//流水号
	private String src;//数据来源
	
	public String getRuleid() {
		return ruleid;
	}
	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}
	public String getOpnid() {
		return opnid;
	}
	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCalcopnid() {
		return calcopnid;
	}
	public void setCalcopnid(String calcopnid) {
		this.calcopnid = calcopnid;
	}
	public String getCalcmonth() {
		return calcmonth;
	}
	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public Date getOprtime() {
		return oprtime;
	}
	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}
	public String getOprcode() {
		return oprcode;
	}
	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Double getBusivalue() {
		return busivalue;
	}
	public void setBusivalue(Double busivalue) {
		this.busivalue = busivalue;
	}
	public Double getRewardtype() {
		return rewardtype;
	}
	public void setRewardtype(Double rewardtype) {
		this.rewardtype = rewardtype;
	}
	public Double getOssrc() {
		return ossrc;
	}
	public void setOssrc(Double ossrc) {
		this.ossrc = ossrc;
	}
	public String getEmpattr2() {
		return empattr2;
	}
	public void setEmpattr2(String empattr2) {
		this.empattr2 = empattr2;
	}
	public String getSrcseq() {
		return srcseq;
	}
	public void setSrcseq(String srcseq) {
		this.srcseq = srcseq;
	}
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
}
