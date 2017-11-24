package com.gmcc.pboss.control.sales.bgcontrol.saleactivestatistics;

import java.util.Date;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface SaleActiveStatistics extends AbstractControl {

	
	
	/**
	 * 套卡数据收集
	 * @param starttime
	 * @param endtime
	 * @throws Exception
	 */
	public void doComressProcess(String starttime,String endtime) throws Exception;
	
	
	/**
	 * 充值卡数据收集
	 * @param starttime
	 * @param endtime
	 * @throws Exception
	 */
	public void doComrescardProcess(String starttime,String endtime) throws Exception;
	
	
	/**
	 * 激活数据收集
	 * @param starttime
	 * @param endtime
	 * @throws Exception
	 */
	public void doActiveProcess(String starttime,String endtime) throws Exception;
	
	/**
	 * 同步之前先删除套卡数据收集同一天的数据，防止数据重复
	 * @param starttime
	 * @param endtime
	 * @throws Exception
	 */
	public void doDelComressProcess(String starttime, String endtime) throws Exception;
	/**
	 * 同步之前先删除激活数据收集同一天的数据，防止数据重复
	 * @param starttime
	 * @param endtime
	 * @throws Exception
	 */
	public void doDelActiveProcess(String starttime, String endtime) throws Exception;
	/**
	 * 同步之前先删除充值卡数据收集同一天的数据，防止数据重复
	 * @param starttime
	 * @param endtime
	 * @throws Exception
	 */
	public void doDelComrescardProcess(String starttime, String endtime) throws Exception;
}
