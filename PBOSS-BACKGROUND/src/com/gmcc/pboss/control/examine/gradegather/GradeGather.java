package com.gmcc.pboss.control.examine.gradegather;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface GradeGather extends AbstractControl{
	public void process(String stateTime) throws Exception;
}
