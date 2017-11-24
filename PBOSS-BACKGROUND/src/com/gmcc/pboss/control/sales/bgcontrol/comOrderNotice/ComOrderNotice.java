package com.gmcc.pboss.control.sales.bgcontrol.comOrderNotice;

import com.sunrise.jop.infrastructure.control.AbstractControl;
/**
 * 商品订购提醒
 * @author yedaoe
 *
 */
public interface ComOrderNotice extends AbstractControl {

	/**商品订购提醒入口方法*/
	public void doProcess() throws Exception;
}
