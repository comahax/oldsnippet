package com.gmcc.pboss.control.service.sms.localcomorder;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface SMSLocalComOrderCommit extends AbstractControl {

	public String doResult(String mobile,String ordreData) throws Exception;
	
}
