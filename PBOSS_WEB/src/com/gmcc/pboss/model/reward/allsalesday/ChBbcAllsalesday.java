package com.gmcc.pboss.model.reward.allsalesday;

import java.util.Date;

import com.gmcc.pboss.common.bean.BaseModel;

public class ChBbcAllsalesday extends BaseModel{
	private String ruleid;//У�����  
	private String opnid;//����ҵ�����
	private String name;//����ҵ������  
	private String calcopnid;//����ҵ�����  
	//private String calname;//����ҵ������
	private String calcmonth;//�����·�
	private String wayid;//��������  
	//private String wayname;//��������
	private Date oprtime;//ҵ����ʱ��
	private String oprcode;//רԱ����
	private String mobile;//ҵ��������
	private Double busivalue;//ҵ����
	private Double rewardtype;//�������
	private Double ossrc;//ҵ����Դ
	private String empattr2;//��Ա����
	private String srcseq;//Ԫ������ˮ��
	
	private Long seq;//��ˮ��
	private String src;//������Դ
	
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
