package com.gmcc.pboss.control.service.sms.refusesigning;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * �������ܾ̾�ǩ�ա�����Ӫҵ���ӿ�֮BO
 * @author zsw
 *
 */
public interface SMSCoRefuseSigning extends AbstractControl {

	/**
	 * 
	 * @param mobile  �ֻ�����
	 * @param streamNumber ȷ����ˮ��
	 * @return
	 * @throws Exception
	 */
	public String doResult(String mobile,String streamNumber) throws Exception;
}
