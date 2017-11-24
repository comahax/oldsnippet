package com.gmcc.pboss.control.examine.autograde;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface Autograde extends AbstractControl{

	public void process(String stateTime) throws Exception;
}
