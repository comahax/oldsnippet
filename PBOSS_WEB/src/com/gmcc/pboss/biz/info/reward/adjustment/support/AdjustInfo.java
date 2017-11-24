package com.gmcc.pboss.biz.info.reward.adjustment.support;

public class AdjustInfo  {
  private String wayid ;
  private String wayname ;
  private String starlevel;
  private String rewardmonth;
  private String paymonth;
  private double paysum;
  private double rpmoney;
  private double fees;
  private double taxmoney;
  private double realpay;
  
	public AdjustInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AdjustInfo(String wayid,String wayname,String starlevel,String rewardmonth,String paymonth,double paysum,
			double rpmoney,double fees,double taxmoney,double realpay) {
		this.wayid = wayid;
		this.wayname = wayname;
		this.starlevel = starlevel;
		this.rewardmonth = rewardmonth;
		this.paymonth = paymonth;
		this.paysum = paysum ;
		this.rpmoney = rpmoney;
		this.fees = fees;
		this.taxmoney = taxmoney;
		this.realpay = realpay;
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
	public String getStarlevel() {
		return starlevel;
	}
	public void setStarlevel(String starlevel) {
		this.starlevel = starlevel;
	} 
	public String getPaymonth() {
		return paymonth;
	}
	public void setPaymonth(String paymonth) {
		this.paymonth = paymonth;
	}
	public double getPaysum() {
		return paysum;
	}
	public void setPaysum(double paysum) {
		this.paysum = paysum;
	}
	public double getRpmoney() {
		return rpmoney;
	}
	public void setRpmoney(double rpmoney) {
		this.rpmoney = rpmoney;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public double getTaxmoney() {
		return taxmoney;
	}
	public void setTaxmoney(double taxmoney) {
		this.taxmoney = taxmoney;
	}
	public double getRealpay() {
		return realpay;
	}
	public void setRealpay(double realpay) {
		this.realpay = realpay;
	}

	public String getRewardmonth() {
		return rewardmonth;
	}

	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}
}
