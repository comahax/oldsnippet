package com.gmcc.pboss.common.bankunite.model.receivebatch.response;


public class RecBatchDetailsRes{

	private String sn;
	private String ret_code;
	private String err_msg;
	



	public RecBatchDetailsRes() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RecBatchDetailsRes(String sn, String ret_code, String err_msg) {
		super();
		this.sn = sn;
		this.ret_code = ret_code;
		this.err_msg = err_msg;
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
