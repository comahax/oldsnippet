package com.gmcc.pboss.common.sms.factory;

import com.gmcc.pboss.common.sms.dictionary.SMSType;
import com.gmcc.pboss.model.sms.SMS;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-12-2
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ���������Ź���
 */
public abstract class SMSFactory {
	/**
	 * ���ݶ������ʹ�������Bean
	 * @param sendMobile	���ͺ���
	 * @param inceptMobile	���պ���
	 * @param message		��������
	 * @param smsType		��������
	 * @return
	 */
	public SMS createSMS(String sendMobile, String inceptMobile, String message, int smsType){
		SMS sms = null;
		
		switch(smsType){
			case SMSType.SYSTEM_FREE:
				sms = this.createSystemFreeSMS(sendMobile, inceptMobile, message);
				break;
		}
		
		return sms;
	}
	
	public abstract SMS createSystemFreeSMS(String sendMobile, String inceptMobile, String message );
}
