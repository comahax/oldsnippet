package com.gmcc.pboss.control.sales.bgcontrol.dealDataCollect;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface DealDataCollect extends AbstractControl {
	
	/**
	 * �������������ݲɼ���̨���򡿺�̨�߼� ��ڷ���
	 * @throws Exception
	 */
	public void doProcess(String date) throws Exception;
}
