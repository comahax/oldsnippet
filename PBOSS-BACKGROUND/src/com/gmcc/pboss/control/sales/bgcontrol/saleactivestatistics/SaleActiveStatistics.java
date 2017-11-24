package com.gmcc.pboss.control.sales.bgcontrol.saleactivestatistics;

import java.util.Date;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface SaleActiveStatistics extends AbstractControl {

	
	
	/**
	 * �׿������ռ�
	 * @param starttime
	 * @param endtime
	 * @throws Exception
	 */
	public void doComressProcess(String starttime,String endtime) throws Exception;
	
	
	/**
	 * ��ֵ�������ռ�
	 * @param starttime
	 * @param endtime
	 * @throws Exception
	 */
	public void doComrescardProcess(String starttime,String endtime) throws Exception;
	
	
	/**
	 * ���������ռ�
	 * @param starttime
	 * @param endtime
	 * @throws Exception
	 */
	public void doActiveProcess(String starttime,String endtime) throws Exception;
	
	/**
	 * ͬ��֮ǰ��ɾ���׿������ռ�ͬһ������ݣ���ֹ�����ظ�
	 * @param starttime
	 * @param endtime
	 * @throws Exception
	 */
	public void doDelComressProcess(String starttime, String endtime) throws Exception;
	/**
	 * ͬ��֮ǰ��ɾ�����������ռ�ͬһ������ݣ���ֹ�����ظ�
	 * @param starttime
	 * @param endtime
	 * @throws Exception
	 */
	public void doDelActiveProcess(String starttime, String endtime) throws Exception;
	/**
	 * ͬ��֮ǰ��ɾ����ֵ�������ռ�ͬһ������ݣ���ֹ�����ظ�
	 * @param starttime
	 * @param endtime
	 * @throws Exception
	 */
	public void doDelComrescardProcess(String starttime, String endtime) throws Exception;
}
