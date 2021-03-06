package com.gmcc.pboss.control.service.sms.refusesigning;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 【合作商拒绝签收】短信营业厅接口之BO
 * @author zsw
 *
 */
public interface SMSCoRefuseSigning extends AbstractControl {

	/**
	 * 
	 * @param mobile  手机号码
	 * @param streamNumber 确认流水号
	 * @return
	 * @throws Exception
	 */
	public String doResult(String mobile,String streamNumber) throws Exception;
}
