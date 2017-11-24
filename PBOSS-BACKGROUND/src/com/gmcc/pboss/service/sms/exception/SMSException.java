package com.gmcc.pboss.service.sms.exception;

import java.util.Map;

import com.gmcc.pboss.service.sms.result.SMSResult;
import com.sunrise.jop.exception.JOPException;

/**
 * 短信营业厅接口跟语音接口的异常类
 * @author Canigar
 */
public class SMSException extends JOPException{
	
	private static final long serialVersionUID = 1L;

	private String errCode;
	
	private Map<String,Object> parammap;//所传参数map
	
	public SMSException(String errMsg,String errCode){
		super(errMsg);
		setErrCode(errCode);
	}
	
	public String getErrCode() {
		return (errCode==null)?SMSResult.RET_TYPE_FAIL_111:errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	
	public Map<String,Object> getParammap() {
		return parammap;
	}

	public void setParammap(Map<String,Object> parammap) {
		this.parammap = parammap;
	}

	//用于《本地化商品订购》短厅接口，补获业务异常的同时传相应参数，以便后续处理
	public SMSException(String errMsg,String errCode,Map<String,Object> parammap){
		super(errMsg);
		setErrCode(errCode);
		setParammap(parammap);
	}
	
}
