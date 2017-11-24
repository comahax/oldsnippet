package com.gmcc.pboss.control.examine.gradeconvert;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface GradeConvert extends AbstractControl{
	public void process(String stateTime) throws Exception;
}
