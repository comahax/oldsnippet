package com.gmcc.pboss.control.service.sms.queryordercount;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * ���������޲�ѯ�������ӿ��߼�
 * @author yangdaren
 *
 */
public interface SMSQueryOrderCount extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            �ֻ�����
	 * @return
	 * @throws Exception
	 */
	public String doQueryOrderCount(String mobile)
			throws Exception;
	
}
