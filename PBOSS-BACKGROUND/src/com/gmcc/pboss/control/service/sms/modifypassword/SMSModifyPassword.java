package com.gmcc.pboss.control.service.sms.modifypassword;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 【合作平台短信密码修改】短厅接口逻辑
 * 
 * @author Yedaoe
 * 
 */
public interface SMSModifyPassword extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            手机号码
	 * @return
	 * @throws Exception
	 */
	public String doModifyPassword(String mobile,String cityid,String smscontent)
			throws Exception;

}