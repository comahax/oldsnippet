package com.gmcc.pboss.control.sales.bgcontrol.wayStockSnpt;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface WayStockSnapShort extends AbstractControl {

	/**
	 * 网点库存快照 入口方法
	 * @throws Exception
	 */
	public void doProcess(String starttime,String endtime) throws Exception;
	/**
	 * 清理超过一个月的数据 入口方法
	 * @throws Exception
	 */
//	public void doDelProcess() throws Exception;
}
