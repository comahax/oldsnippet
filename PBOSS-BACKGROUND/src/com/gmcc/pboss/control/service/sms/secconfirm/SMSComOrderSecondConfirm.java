package com.gmcc.pboss.control.service.sms.secconfirm;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * [商品订购二次确认] 短信营业厅接口之BO
 * @author zsw
 *
 */
public interface SMSComOrderSecondConfirm extends AbstractControl {
	/**
	 * 
	 * @param mobile   手机号码
	 * @param streamNumber  确认流水号
	 * @return
	 * @throws Exception 若此方法中有运行时异常，必须抛出，否则spring无法捕获,导致无法回滚
	 */
	public String doResult(String mobile,String streamNumber) throws Exception;

}
