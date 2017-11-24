package com.sunrise.boss.business.cms.cityrecord.persistent;

import java.io.Serializable;

public class CityrecordTableVO implements Serializable{
	
	private String opnidone;
	private String opnidtwo;
	private String rewardtype;
	private String rewardtypename;
	private String oprmonth;
	private Double sumbusivalue;
	private Double sumpaymoney;
	private Double sumconfirmmoney;
	private Double sumnotconfirmmoney;
	private Long recordid;
	
	//替身，用于存储它们的值，因为值在界面格式化时需被清空
	private String opnidonereplacer;
	private String opnidtworeplacer;
	private String rewardtypereplacer;
	private String oprmonthreplacer;
	
	//附加属性 为页面分组显示用 
	private int opnidoneCount = 1; 
	private int opnidtwoCount = 1;
	private int rewardtypeCount = 1;
	private int oprmonthCount = 1;
	
	public String getOpnidone() {
		return opnidone;
	}
	public void setOpnidone(String opnidone) {
		this.opnidone = opnidone;
	}
	public String getOpnidtwo() {
		return opnidtwo;
	}
	public void setOpnidtwo(String opnidtwo) {
		this.opnidtwo = opnidtwo;
	}
	public String getRewardtype() {
		return rewardtype;
	}
	public void setRewardtype(String rewardtype) {
		this.rewardtype = rewardtype;
	}
	public String getRewardtypename() {
		return rewardtypename;
	}
	public void setRewardtypename(String rewardtypename) {
		this.rewardtypename = rewardtypename;
	}
	public String getOprmonth() {
		return oprmonth;
	}
	public void setOprmonth(String oprmonth) {
		this.oprmonth = oprmonth;
	}
	public Double getSumbusivalue() {
		return sumbusivalue;
	}
	public void setSumbusivalue(Double sumbusivalue) {
		this.sumbusivalue = sumbusivalue;
	}
	public Double getSumpaymoney() {
		return sumpaymoney;
	}
	public void setSumpaymoney(Double sumpaymoney) {
		this.sumpaymoney = sumpaymoney;
	}
	public Double getSumconfirmmoney() {
		return sumconfirmmoney;
	}
	public void setSumconfirmmoney(Double sumconfirmmoney) {
		this.sumconfirmmoney = sumconfirmmoney;
	}
	public Double getSumnotconfirmmoney() {
		return sumnotconfirmmoney;
	}
	public void setSumnotconfirmmoney(Double sumnotconfirmmoney) {
		this.sumnotconfirmmoney = sumnotconfirmmoney;
	}
	public Long getRecordid() {
		return recordid;
	}
	public void setRecordid(Long recordid) {
		this.recordid = recordid;
	}
	public int getOpnidoneCount() {
		return opnidoneCount;
	}
	public void setOpnidoneCount(int opnidoneCount) {
		this.opnidoneCount = opnidoneCount;
	}
	public int getOpnidtwoCount() {
		return opnidtwoCount;
	}
	public void setOpnidtwoCount(int opnidtwoCount) {
		this.opnidtwoCount = opnidtwoCount;
	}
	public int getRewardtypeCount() {
		return rewardtypeCount;
	}
	public void setRewardtypeCount(int rewardtypeCount) {
		this.rewardtypeCount = rewardtypeCount;
	}
	public int getOprmonthCount() {
		return oprmonthCount;
	}
	public void setOprmonthCount(int oprmonthCount) {
		this.oprmonthCount = oprmonthCount;
	}
	public String getOpnidonereplacer() {
		return opnidonereplacer;
	}
	public void setOpnidonereplacer(String opnidonereplacer) {
		this.opnidonereplacer = opnidonereplacer;
	}
	public String getOpnidtworeplacer() {
		return opnidtworeplacer;
	}
	public void setOpnidtworeplacer(String opnidtworeplacer) {
		this.opnidtworeplacer = opnidtworeplacer;
	}
	public String getRewardtypereplacer() {
		return rewardtypereplacer;
	}
	public void setRewardtypereplacer(String rewardtypereplacer) {
		this.rewardtypereplacer = rewardtypereplacer;
	}
	public String getOprmonthreplacer() {
		return oprmonthreplacer;
	}
	public void setOprmonthreplacer(String oprmonthreplacer) {
		this.oprmonthreplacer = oprmonthreplacer;
	}
	
	
}
