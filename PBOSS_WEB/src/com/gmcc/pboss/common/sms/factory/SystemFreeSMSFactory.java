package com.gmcc.pboss.common.sms.factory;

import com.gmcc.pboss.common.sms.dictionary.FeeType;
import com.gmcc.pboss.common.sms.dictionary.Level;
import com.gmcc.pboss.common.sms.dictionary.State;
import com.gmcc.pboss.model.sms.SMS;
import com.gmcc.pboss.model.sms.WzSmsSend;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-12-2
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������ϵͳ��Ѷ��Ź���
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
