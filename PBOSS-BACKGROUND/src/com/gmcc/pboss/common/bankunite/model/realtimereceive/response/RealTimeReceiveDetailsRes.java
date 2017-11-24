package com.gmcc.pboss.common.bankunite.model.realtimereceive.response;

public class RealTimeReceiveDetailsRes {
	

	private String sn;
	private String account_no;
	private String account_name;
	private Long amount;
	private String cust_userid;
	private String remark;
	private String ret_code;
	private String err_msg;
	private String reserve1;

	public RealTimeReceiveDetailsRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public RealTimeReceiveDetailsRes(String sn, String account_no,
			String account_name, Long amount, String cust_userid,
			String remark, String ret_code, String err_msg, String reserve1) {
		super();
		this.sn = sn;
		this.account_no = account_no;
		this.account_name = account_name;
		this.amount = amount;
		this.cust_userid = cust_userid;
		this.remark = remark;
		this.ret_code = ret_code;
		this.err_msg = err_msg;
		this.reserve1 = reserve1;
	}



	public String getAccount_no() {
		return account_no;
	}



	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}



	public String getAccount_name() {
		return account_name;
	}



	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}



	public Long getAmount() {
		return amount;
	}



	public void setAmount(Long amount) {
		this.amount = amount;
	}



	public String getCust_userid() {
		return cust_userid;
	}



	public void setCust_userid(String cust_userid) {
		this.cust_userid = cust_userid;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public String getReserve1() {
		return reserve1;
	}



	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}



	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getRet_code() {
		return ret_code;
	}

	public void setRet_code(String ret_code) {
		this.ret_code = ret_code;
	}

	public String getErr_msg() {
		return err_msg;
	}

	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
	}
}
