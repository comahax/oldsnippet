package com.gmcc.pboss.control.sales.bgcontrol.dealDataCollect;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface DealDataCollect extends AbstractControl {
	
	/**
	 * 新增【交易数据采集后台程序】后台逻辑 入口方法
	 * @throws Exception
	 */
	public void doProcess(String date) throws Exception;
}
