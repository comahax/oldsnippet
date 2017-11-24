package com.gmcc.pboss.common.sms.factory;

import com.gmcc.pboss.common.sms.dictionary.FeeType;
import com.gmcc.pboss.common.sms.dictionary.Level;
import com.gmcc.pboss.common.sms.dictionary.State;
import com.gmcc.pboss.model.sms.SMS;
import com.gmcc.pboss.model.sms.WzSmsSend;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-12-2
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：系统免费短信工厂
 */
public class SystemFreeSMSFactory extends SMSFactory {

	@Override
	public SMS createSystemFreeSMS(String sendMobile, String inceptMobile,
			String message) {
		// TODO Auto-generated method stub
		
		WzSmsSend sms = new WzSmsSend();
		sms.setSrcterminal(sendMobile);
		sms.setDestterminal(inceptMobile);
		sms.setContent(message);
		sms.setState(new Long(State.UN_SEND ));
		sms.setFeetype(new Long(FeeType.FREE));
		sms.setLevel(new Long(Level.SYSTEM_FREE));
		
		return sms;
	}

}
