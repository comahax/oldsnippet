package com.gmcc.pboss.control.sales.bgcontrol.orderConfirmnotice;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 订单确认提醒入口
 * @author panyonghui
 *
 */
public interface OrderConfirmnotice extends AbstractControl {

	/**
	 * 订单确认提醒
	 * @throws Exception
	 */
	public void doProcess() throws Exception;
	
	
}
