package com.gmcc.pboss.common.bankunite.model.queryhistory.response;

public class QhRet_detailsRes {
	
	
	private String orafile_id;
	private String sn;
	private String account;
	private String account_name;
	private Double amount;
	private String cust_userid;
	private String complete_time;
	private String remark;
	private String ret_code;
	private String err_msg;
	public QhRet_detailsRes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QhRet_detailsRes(String orafile_id, String sn, String account,
			String account_name, Double amount, String cust_userid,
			String complete_time, String remark, String ret_code, String err_msg) {
		super();
		this.orafile_id = orafile_id;
		this.sn = sn;
		this.account = account;
		this.account_name = account_name;
		this.amount = amount;
		this.cust_userid = cust_userid;
		this.complete_time = complete_time;
		this.remark = remark;
		this.ret_code = ret_code;
		this.err_msg = err_msg;
	}
	public String getOrafile_id() {
		return orafile_id;
	}
	public void setOrafile_id(String orafile_id) {
		this.orafile_id = orafile_id;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getCust_userid() {
		return cust_userid;
	}
	public void setCust_userid(String cust_userid) {
		this.cust_userid = cust_userid;
	}
	public String getComplete_time() {
		return complete_time;
	}
	public void setComplete_time(String complete_time) {
		this.complete_time = complete_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
