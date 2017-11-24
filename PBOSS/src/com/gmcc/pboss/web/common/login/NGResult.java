package com.gmcc.pboss.web.common.login;

public class NGResult {
	private String code;
	private String authresult;
	public NGResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NGResult(String code, String authresult) {
		super();
		this.code = code;
		this.authresult = authresult;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAuthresult() {
		return authresult;
	}
	public void setAuthresult(String authresult) {
		this.authresult = authresult;
	}
	
}
