package com.gmcc.pboss.control.service.sms.registerSmsbusi;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 【短信业务登记】短厅接口逻辑
 * @author Yedaoe
 *
 */
public interface SMSRegisterSmsbusi extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            手机号码
	 * @return
	 * @throws Exception
	 */
	public String doRegisterSmsbusi(String mobile,String cityid,String smscontent)
			throws Exception;

}