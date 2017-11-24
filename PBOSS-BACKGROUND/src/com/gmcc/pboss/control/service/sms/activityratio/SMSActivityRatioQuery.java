package com.gmcc.pboss.control.service.sms.activityratio;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface SMSActivityRatioQuery extends AbstractControl {

	public String doResult(String mobile) throws Exception;
	
}
