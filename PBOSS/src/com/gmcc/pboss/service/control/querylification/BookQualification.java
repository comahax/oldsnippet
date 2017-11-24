package com.gmcc.pboss.service.control.querylification;

import com.gmcc.pboss.service.result.RetResult;
import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface BookQualification extends AbstractControl {

	public RetResult doCheck(String wayid) throws Exception;
	
}
