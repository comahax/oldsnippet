package com.gmcc.pboss.biz.info.missioner.recommend.success.model;

import java.io.Serializable;
import java.util.Date;

public class Missioner implements Serializable{
	private String ruleid;//校验规则  
	private String opnid;//发生业务编码
	private String name;//发生业务名称  
	private String calcopnid;//结算业务编码  
	private String calname;//结算业务名称
	private String calcmonth;//结算月份
	private String wayid;//渠道编码  
	private String wayname;//渠道名称
	private Date oprtime;//业务发生时间
	private String oprcode;//专员号码
	private String mobile;//业务发生号码
	private Double busivalue;//业务量
	private String rewardtype;//酬金类型
	private String ossrc;//业务来源
	private String empattr2;//成员属性
	private String srcseq;//元数据流水号	
	private String telephone;//联系电话
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
	public String getCalname() {
		return calname;
	}
	public void setCalname(String calname) {
		this.calname = calname;
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
	public String getWayname() {
		return wayname;
	}
	public void setWayname(String wayname) {
		this.wayname = wayname;
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
	public String getRewardtype() {
		return rewardtype;
	}
	public void setRewardtype(String rewardtype) {
		this.rewardtype = rewardtype;
	}
	public String getOssrc() {
		return ossrc;
	}
	public void setOssrc(String ossrc) {
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
