package com.gmcc.pboss.control.service.sms.resetpassword;

import com.gmcc.pboss.service.sms.result.ResetPasswordResult;
import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 【合作平台短信密码重置】短厅接口逻辑
 * 
 * @author Yedaoe
 * 
 */
public interface SMSResetPasswordPr extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            手机号码
	 * @return
	 * @throws Exception
	 */
	public String doResetPassword(String mobile,String cityid)
			throws Exception;
	
	public ResetPasswordResult doRecordSmshisAndReturnSuccVal (String mobile,String cityid,String templateid)
			throws Exception;

}