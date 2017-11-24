package com.gmcc.pboss.control.service.sms.cancelbook;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 【合作商拒绝签收】短信营业厅接口之BO
 * @author Jemy
 *
 */
public interface SMSCancelBook extends AbstractControl {

	/**
	 * 
	 * @param mobile  手机号码
	 * @param streamNumber 确认流水号
	 * @return
	 * @throws Exception
	 */
	public String doCancelBook(String mobile,String streamNumber) throws Exception;
	
}
