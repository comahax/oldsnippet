package com.gmcc.pboss.control.sales.bgcontrol.wayStockSnpt;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface WayStockSnapShort extends AbstractControl {

	/**
	 * ��������� ��ڷ���
	 * @throws Exception
	 */
	public void doProcess(String starttime,String endtime) throws Exception;
	/**
	 * ������һ���µ����� ��ڷ���
	 * @throws Exception
	 */
//	public void doDelProcess() throws Exception;
}
