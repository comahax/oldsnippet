package com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.support;

public class RewardTdRecordInfo {
	//ҵ����ʱ�䣨��ȡ���·ݣ��������·ݣ�Ӧ����˰ǰ����
	private String  name;
	private String rewardtype;
	private String oprtime;
	private String rewardmonth;
	private double paysum;
	public RewardTdRecordInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(String rewardtype) {
		this.rewardtype = rewardtype;
	}

	public RewardTdRecordInfo(String name,String rewardtype,String oprtime,String rewardmonth,double paysum){
		this.name = name;
		this.rewardtype = rewardtype;
		this.oprtime = oprtime;
		this.rewardmonth = rewardmonth;
		this.paysum = paysum;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
	public String getOprtime() {
		return oprtime;
	}
	public void setOprtime(String oprtime) {
		this.oprtime = oprtime;
	}
	public String getRewardmonth() {
		return rewardmonth;
	}
	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}
	public double getPaysum() {
		return paysum;
	}
	public void setPaysum(double paysum) {
		this.paysum = paysum;
	}
	
}
