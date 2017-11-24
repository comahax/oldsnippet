package com.gmcc.pboss.common.bankunite.model.realtimereceive.request;

public class RealTimeReceiveInfoReq {

	private String trx_code;
	private String version;
	private Short data_type;
	private Short level;
	private String user_name;
	private String user_pass;
	private String req_sn;
	private String signed_msg;

	public RealTimeReceiveInfoReq(String trx_code, String version,
			Short data_type, Short level, String user_name, String user_pass,
			String req_sn, String signed_msg) {
		super();
		this.trx_code = trx_code;
		this.version = version;
		this.data_type = data_type;
		this.level = level;
		this.user_name = user_name;
		this.user_pass = user_pass;
		this.req_sn = req_sn;
		this.signed_msg = signed_msg;
	}

	public RealTimeReceiveInfoReq() {
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

	public Short getLevel() {
		return level;
	}

	public void setLevel(Short level) {
		this.level = level;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public String getReq_sn() {
		return req_sn;
	}

	public void setReq_sn(String req_sn) {
		this.req_sn = req_sn;
	}

	public String getSigned_msg() {
		return signed_msg;
	}

	public void setSigned_msg(String signed_msg) {
		this.signed_msg = signed_msg;
	}

}
