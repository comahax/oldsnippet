package com.gmcc.pboss.control.sales.bgcontrol.ResStockAlarm;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * ��Դ���Ԥ��
 * @author zhangsiwei
 *
 */
public interface ResStockAlarm extends AbstractControl {

	/**
	 * ��Դ���Ԥ�� ��ڷ���
	 * @throws Exception
	 */
	public void doProcess() throws Exception;
}
