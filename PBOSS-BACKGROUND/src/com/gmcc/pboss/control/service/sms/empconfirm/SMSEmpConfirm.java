package com.gmcc.pboss.control.service.sms.empconfirm;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 【专员二次确认接口】短厅接口逻辑
 * 
 * @author Yedaoe
 * 
 */
public interface SMSEmpConfirm extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            手机号码
	 * @return
	 * @throws Exception
	 */
	public String doEmpConfirm(String mobile,String yesorno)
			throws Exception;

}