package com.gmcc.pboss.biz.info.missioner.recommend.success.model;

import java.io.Serializable;
import java.util.Date;

public class Missioner implements Serializable{
	private String ruleid;//У�����  
	private String opnid;//����ҵ�����
	private String name;//����ҵ������  
	private String calcopnid;//����ҵ�����  
	private String calname;//����ҵ������
	private String calcmonth;//�����·�
	private String wayid;//��������  
	private String wayname;//��������
	private Date oprtime;//ҵ����ʱ��
	private String oprcode;//רԱ����
	private String mobile;//ҵ��������
	private Double busivalue;//ҵ����
	private String rewardtype;//�������
	private String ossrc;//ҵ����Դ
	private String empattr2;//��Ա����
	private String srcseq;//Ԫ������ˮ��	
	private String telephone;//��ϵ�绰
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
