package com.gmcc.pboss.control.sales.bgcontrol.SMPOrderUpperLimitUpdate;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface SMPOrderUpperLimitUpdate extends AbstractControl {

	/**
	 * 网点套卡订购上限更新 入口方法
	 * @param 
	 * @throws Exception
	 */
	public void doProcess() throws Exception;
}
