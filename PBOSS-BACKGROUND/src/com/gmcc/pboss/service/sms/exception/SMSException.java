package com.gmcc.pboss.service.sms.exception;

import java.util.Map;

import com.gmcc.pboss.service.sms.result.SMSResult;
import com.sunrise.jop.exception.JOPException;

/**
 * ����Ӫҵ���ӿڸ������ӿڵ��쳣��
 * @author Canigar
 */
public class SMSException extends JOPException{
	
	private static final long serialVersionUID = 1L;

	private String errCode;
	
	private Map<String,Object> parammap;//��������map
	
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

	//���ڡ����ػ���Ʒ�����������ӿڣ�����ҵ���쳣��ͬʱ����Ӧ�������Ա��������
	public SMSException(String errMsg,String errCode,Map<String,Object> parammap){
		super(errMsg);
		setErrCode(errCode);
		setParammap(parammap);
	}
	
}
