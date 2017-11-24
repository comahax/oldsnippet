package com.gmcc.pboss.control.service.sms.passaudit;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 【订单审核通过】短厅接口逻辑
 * 
 * @author Yedaoe
 * 
 */
public interface SMSPassAudit extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            手机号码
	 * @param streamNumber
	 *            确认流水号
	 * @return
	 * @throws Exception
	 */
	public String doPassAudit(String mobile, String streamNumber)
			throws Exception;

}