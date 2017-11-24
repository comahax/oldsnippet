package com.gmcc.pboss.control.sales.bgcontrol.salesstdWarn;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface SalesstdWarn extends AbstractControl {

	/**
	 * 新增【合作商销售提醒】后台逻辑 入口方法
	 * @throws Exception
	 */
	public void doProcess() throws Exception;
}
