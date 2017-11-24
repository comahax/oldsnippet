package com.gmcc.pboss.biz.info.reward.payment.support; 

import com.gmcc.pboss.common.support.QueryParameter;

public class PaymentQueryParameter extends QueryParameter {
 

	private String rewardmonth;//¸¶¿îÔÂ·Ý

	public PaymentQueryParameter() {
		super();
		// TODO Auto-generated constructor stub
	}	
	public String getRewardmonth() {
		return rewardmonth;
	}
	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}
}
