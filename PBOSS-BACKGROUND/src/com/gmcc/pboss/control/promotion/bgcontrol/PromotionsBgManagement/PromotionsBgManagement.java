package com.gmcc.pboss.control.promotion.bgcontrol.PromotionsBgManagement;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface PromotionsBgManagement extends AbstractControl {

	/**
	 * 后台管理程序（常驻进程）入口方法
	 * @throws Exception
	 */
	public void doProcess() throws Exception;
}
