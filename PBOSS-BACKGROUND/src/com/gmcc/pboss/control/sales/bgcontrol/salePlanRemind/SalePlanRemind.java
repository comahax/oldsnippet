package com.gmcc.pboss.control.sales.bgcontrol.salePlanRemind;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface SalePlanRemind extends AbstractControl {
	/**
	 * 
	 * @param sendMsgFlag Y��������
	 * @param sendDate	���ŷ�������(��)����ʽ��dd
	 * @throws Exception
	 */
	public void doProcess(String sendMsgFlag,String sendDate) throws Exception;
}
