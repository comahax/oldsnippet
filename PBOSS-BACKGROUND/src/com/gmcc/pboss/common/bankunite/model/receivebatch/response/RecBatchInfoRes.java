package com.gmcc.pboss.common.bankunite.model.receivebatch.response;


public class RecBatchInfoRes{


	private String trx_code;
	private String version;
	private Short data_type;
	private String req_sn;
	private String ret_code;
	private String err_msg;
	private String signed_msg;
	
	
	


	public RecBatchInfoRes(String trx_code, String version, Short data_type,
			String req_sn, String ret_code, String err_msg, String signed_msg) {
		super();
		this.trx_code = trx_code;
		this.version = version;
		this.data_type = data_type;
		this.req_sn = req_sn;
		this.ret_code = ret_code;
		this.err_msg = err_msg;
		this.signed_msg = signed_msg;
	}


	public RecBatchInfoRes() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getTrx_code() {
		return trx_code;
	}


	public void setTrx_code(String trx_code) {
		this.trx_code = trx_code;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public Short getData_type() {
		return data_type;
	}


	public void setData_type(Short data_type) {
		this.data_type = data_type;
	}


	public String getReq_sn() {
		return req_sn;
	}


	public void setReq_sn(String req_sn) {
		this.req_sn = req_sn;
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


	public String getSigned_msg() {
		return signed_msg;
	}


	public void setSigned_msg(String signed_msg) {
		this.signed_msg = signed_msg;
	}
	
	
	
}
