package com.gmcc.pboss.control.service.sms.passaudit;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * ���������ͨ���������ӿ��߼�
 * 
 * @author Yedaoe
 * 
 */
public interface SMSPassAudit extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            �ֻ�����
	 * @param streamNumber
	 *            ȷ����ˮ��
	 * @return
	 * @throws Exception
	 */
	public String doPassAudit(String mobile, String streamNumber)
			throws Exception;

}