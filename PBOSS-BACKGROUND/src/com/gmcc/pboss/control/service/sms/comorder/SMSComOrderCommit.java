package com.gmcc.pboss.control.service.sms.comorder;

import java.util.List;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface SMSComOrderCommit extends AbstractControl {

	public String doResult(String mobile,List<String> ordreData) throws Exception;
	
}
