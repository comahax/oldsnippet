package com.gmcc.pboss.control.service.sms.resetpassword;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * ������ƽ̨�����������á������ӿ��߼�
 * 
 * @author Yedaoe
 * 
 */
public interface SMSResetPassword extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            �ֻ�����
	 * @return
	 * @throws Exception
	 */
	public String doResetPassword(String mobile,String cityid)
			throws Exception;

}