package com.gmcc.pboss.control.service.sms.resetpassword;

import com.gmcc.pboss.service.sms.result.ResetPasswordResult;
import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * ������ƽ̨�����������á������ӿ��߼�
 * 
 * @author Yedaoe
 * 
 */
public interface SMSResetPasswordPr extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            �ֻ�����
	 * @return
	 * @throws Exception
	 */
	public String doResetPassword(String mobile,String cityid)
			throws Exception;
	
	public ResetPasswordResult doRecordSmshisAndReturnSuccVal (String mobile,String cityid,String templateid)
			throws Exception;

}