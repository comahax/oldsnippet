package com.gmcc.pboss.control.service.sms.querybusicountformanager;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 【渠道经理业务量查询】短厅接口逻辑
 * @author Yedaoe
 *
 */
public interface SMSQueryBusiCountForManager extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            手机号码
	 * @return
	 * @throws Exception
	 */
	public String doQueryBusiCountForManager(String mobile,String cityid,String smscontent)
			throws Exception;

}