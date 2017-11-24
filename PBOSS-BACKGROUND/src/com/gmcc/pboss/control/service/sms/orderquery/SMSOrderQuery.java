package com.gmcc.pboss.control.service.sms.orderquery;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface SMSOrderQuery extends AbstractControl {

	public String doResult(String mobile, String orderid) throws Exception;
	
}
