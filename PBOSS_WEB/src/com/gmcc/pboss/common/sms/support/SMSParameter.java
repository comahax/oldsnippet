package com.gmcc.pboss.common.sms.support;

import com.gmcc.pboss.common.bean.SMSRndCode;
import com.gmcc.pboss.common.support.QueryParameter;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-9-9
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：
 */
public class SMSParameter extends QueryParameter {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6104418341244619773L;
	private String sendMobile;
	
	private String officeTel;
	
	private SMSRndCode smsRndCode;

	public SMSRndCode getSmsRndCode() {
		return smsRndCode;
	}

	public void setSmsRndCode(SMSRndCode smsRndCode) {
		this.smsRndCode = smsRndCode;
	}

	public String getOfficeTel() {
		return officeTel;
	}

	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}

	public String getSendMobile() {
		return sendMobile;
	}

	public void setSendMobile(String sendMobile) {
		this.sendMobile = sendMobile;
	}
	
	
}
