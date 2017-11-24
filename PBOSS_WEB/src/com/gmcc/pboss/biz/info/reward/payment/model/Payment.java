package com.gmcc.pboss.biz.info.reward.payment.model;

public class Payment  {

  private String rewardmonth;
  
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Payment(String rewardmonth) {
		
		this.rewardmonth = rewardmonth;
		
	}
	
	
	public String getRewardmonth() {
		return rewardmonth;
	}

	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}
}
