package com.asisinfo.staff.bean;


public class Bill {
	//员工账单
		private String mainsubsid;
		private Integer billcyc;
		private Integer reposition;
		private Integer flag;
		private Integer acctid;
		private String acctname;
		private Float amt;
		private Float discount;
		//核销话费
		private float verification; 
		//自付话费
		private float pay;
		//年度累计核销话费
		private float cumulative;
		//年度核销话费余额
		private float balance;
		
		private String svrnum;
		private int status;
		private String numberattr;
		private int isprimary;
		private String staffid;
		private String staffname;
		private String staffattr;
		private int states;
		private String subsid; 
		private int position;
		private int acctsid;
		
		public String getMainsubsid() {
			return mainsubsid;
		}
		public void setMainsubsid(String mainsubsid) {
			this.mainsubsid = mainsubsid;
		}
		public Integer getBillcyc() {
			return billcyc;
		}
		public void setBillcyc(Integer billcyc) {
			this.billcyc = billcyc;
		}
		public Integer getReposition() {
			return reposition;
		}
		public void setReposition(Integer reposition) {
			this.reposition = reposition;
		}
		public Integer getFlag() {
			return flag;
		}
		public void setFlag(Integer flag) {
			this.flag = flag;
		}
		public Integer getAcctid() {
			return acctid;
		}
		public void setAcctid(Integer acctid) {
			this.acctid = acctid;
		}
		public String getAcctname() {
			return acctname;
		}
		public void setAcctname(String acctname) {
			this.acctname = acctname;
		}
		public Float getAmt() {
			return amt;
		}
		public void setAmt(Float amt) {
			this.amt = amt;
		}
		public float getVerification() {
			return verification;
		}
		public void setVerification(float verification) {
			this.verification = verification;
		}
		public float getPay() {
			return pay;
		}
		public void setPay(float pay) {
			this.pay = pay;
		}
		public float getCumulative() {
			return cumulative;
		}
		public void setCumulative(float cumulative) {
			this.cumulative = cumulative;
		}
		public float getBalance() {
			return balance;
		}
		public void setBalance(float balance) {
			this.balance = balance;
		}
		public String getSvrnum() {
			return svrnum;
		}
		public void setSvrnum(String svrnum) {
			this.svrnum = svrnum;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getNumberattr() {
			return numberattr;
		}
		public void setNumberattr(String numberattr) {
			this.numberattr = numberattr;
		}
		public int getIsprimary() {
			return isprimary;
		}
		public void setIsprimary(int isprimary) {
			this.isprimary = isprimary;
		}
		public String getStaffid() {
			return staffid;
		}
		public void setStaffid(String staffid) {
			this.staffid = staffid;
		}
		public String getStaffname() {
			return staffname;
		}
		public void setStaffname(String staffname) {
			this.staffname = staffname;
		}
		public String getStaffattr() {
			return staffattr;
		}
		public void setStaffattr(String staffattr) {
			this.staffattr = staffattr;
		}
		public int getStates() {
			return states;
		}
		public void setStates(int states) {
			this.states = states;
		}
		
		public String getSubsid() {
			return subsid;
		}
		public void setSubsid(String subsid) {
			this.subsid = subsid;
		}
		public int getPosition() {
			return position;
		}
		public void setPosition(int position) {
			this.position = position;
		}
		public int getAcctsid() {
			return acctsid;
		}
		public void setAcctsid(int acctsid) {
			this.acctsid = acctsid;
		}
		public Float getDiscount() {
			return discount;
		}
		public void setDiscount(Float discount) {
			this.discount = discount;
		}
		
}
