package com.gmcc.pboss.control.service.sms.querybusicountfornet;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 【网点业务量查询】短厅接口逻辑
 * @author Yedaoe
 *
 */
public interface SMSQueryBusiCountForNet extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            手机号码
	 * @return
	 * @throws Exception
	 */
	public String doQueryBusiCountForNet(String mobile,String cityid,String smscontent)
			throws Exception;

}