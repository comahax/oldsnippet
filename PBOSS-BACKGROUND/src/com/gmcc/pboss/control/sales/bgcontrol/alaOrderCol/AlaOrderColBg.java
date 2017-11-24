package com.gmcc.pboss.control.sales.bgcontrol.alaOrderCol;

import com.sunrise.jop.infrastructure.control.AbstractControl;
/**
 * 【预警分配单汇总】后台程序
 * @author yedaoe
 *
 */
public interface AlaOrderColBg extends AbstractControl {

	/**预警分配单汇总入口方法*/
	public void doProcess(String coldate) throws Exception;
}
