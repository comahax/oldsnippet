package com.gmcc.pboss.service.exception;

import com.gmcc.pboss.service.result.RetResult;
import com.sunrise.jop.exception.JOPException;

public class WebSiteException extends JOPException{

	private Integer errCode;
	
	public WebSiteException(String errMsg,Integer errCode){
		super(errMsg);
		setErrCode(errCode);
	}
	
	public Integer getErrCode() {
		return (errCode==null)?RetResult.ERROR:errCode;
	}

	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}

}
