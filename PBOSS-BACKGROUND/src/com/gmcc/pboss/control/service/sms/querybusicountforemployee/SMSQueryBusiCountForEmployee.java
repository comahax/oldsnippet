package com.gmcc.pboss.control.service.sms.querybusicountforemployee;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 【店员业务量查询】短厅接口逻辑
 * @author Yedaoe
 *
 */
public interface SMSQueryBusiCountForEmployee extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            手机号码
	 * @return
	 * @throws Exception
	 */
	public String doQueryBusiCountForEmployee(String mobile,String cityid,String smscontent)
			throws Exception;

}