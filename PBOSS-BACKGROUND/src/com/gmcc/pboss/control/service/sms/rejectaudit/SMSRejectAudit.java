package com.gmcc.pboss.control.service.sms.rejectaudit;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * ��������˲�ͨ���������ӿ��߼�
 * 
 * @author Yedaoe
 * 
 */
public interface SMSRejectAudit extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            �ֻ�����
	 * @param streamNumber
	 *            ȷ����ˮ��
	 * @return
	 * @throws Exception
	 */
	public String doRejectAudit(String mobile, String streamNumber)
			throws Exception;

}