package com.gmcc.pboss.common.sms.support;

import com.gmcc.pboss.common.bean.SMSRndCode;
import com.gmcc.pboss.common.support.QueryParameter;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-9-9
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������
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
