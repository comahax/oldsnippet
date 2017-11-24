package com.gmcc.pboss.control.sales.bgcontrol.salePlanRemind;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface SalePlanRemind extends AbstractControl {
	/**
	 * 
	 * @param sendMsgFlag Y：发短信
	 * @param sendDate	短信发送日期(天)，格式：dd
	 * @throws Exception
	 */
	public void doProcess(String sendMsgFlag,String sendDate) throws Exception;
}
