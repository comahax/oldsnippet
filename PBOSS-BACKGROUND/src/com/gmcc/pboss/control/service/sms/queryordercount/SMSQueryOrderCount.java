package com.gmcc.pboss.control.service.sms.queryordercount;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 【订购上限查询】短厅接口逻辑
 * @author yangdaren
 *
 */
public interface SMSQueryOrderCount extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            手机号码
	 * @return
	 * @throws Exception
	 */
	public String doQueryOrderCount(String mobile)
			throws Exception;
	
}
