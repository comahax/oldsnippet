package com.gmcc.pboss.common.sms.factory;

import com.gmcc.pboss.common.sms.dictionary.SMSType;
import com.gmcc.pboss.model.sms.SMS;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-12-2
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：短信工厂
 */
public abstract class SMSFactory {
	/**
	 * 根据短信类型创建短信Bean
	 * @param sendMobile	发送号码
	 * @param inceptMobile	接收号码
	 * @param message		短信内容
	 * @param smsType		短信类型
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
