package com.gmcc.pboss.control.sales.bgcontrol.orderAutoDistribute;

import com.sunrise.jop.infrastructure.control.AbstractControl;
/**
 * 订单自动分配
 * @author zhangsiwei
 *
 */
public interface OrderAutoDistribute extends AbstractControl {

	/**订单自动分配入口方法*/
	public void doProcess() throws Exception;
}
