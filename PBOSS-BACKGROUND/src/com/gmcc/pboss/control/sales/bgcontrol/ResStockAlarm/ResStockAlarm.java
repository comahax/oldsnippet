package com.gmcc.pboss.control.sales.bgcontrol.ResStockAlarm;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 资源库存预警
 * @author zhangsiwei
 *
 */
public interface ResStockAlarm extends AbstractControl {

	/**
	 * 资源库存预警 入口方法
	 * @throws Exception
	 */
	public void doProcess() throws Exception;
}
