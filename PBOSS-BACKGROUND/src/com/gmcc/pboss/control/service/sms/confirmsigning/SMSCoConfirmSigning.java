package com.gmcc.pboss.control.service.sms.confirmsigning;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * ��������ȷ��ǩ�ա�����Ӫҵ���ӿ��߼�֮BO
 * @author zsw
 *
 */
public interface SMSCoConfirmSigning extends AbstractControl {

	/**
	 * 
	 * @param mobile  �ֻ�����
	 * @param streamNumber ȷ����ˮ��
	 * @return
	 * @throws Exception
	 */
	public String doResult(String mobile,String streamNumber) throws Exception;
}
