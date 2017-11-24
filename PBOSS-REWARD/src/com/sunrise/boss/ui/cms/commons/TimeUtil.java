package com.sunrise.boss.ui.cms.commons;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	
	/**
	 * ʱ��ĸ�ʽת��
	 * YYYYMMDD-->YYYY-MM-DD 00:00:00
	 * @param begintime
	 * @return YYYY-MM-DD 00:00:00
	 */
	public static String formatBegin(String begintime) {
		String beginyear = begintime.substring(0, 4);
		String beginmonth = begintime.substring(4, 6);
		String beginday = begintime.substring(6);
		String _snl_ywdate = beginyear + "-" + beginmonth + "-" + beginday + " 00:00:00";
		return _snl_ywdate;
	}
	/**
	 * ʱ��ĸ�ʽת��
	 * YYYYMMDD-->YYYY-MM-DD 23:59:59
	 * @param endtime
	 * @return YYYY-MM-DD 23:59:59
	 */
	public static String formatEnd(String endtime) {
		String endyear = endtime.substring(0, 4);
		String endmonth = endtime.substring(4, 6);
		String endday = endtime.substring(6);
		String _snm_ywdate = endyear + "-" + endmonth + "-" + endday + " 23:59:59";
		return _snm_ywdate;
	}
	
	/**
	 * ���ص�ǰʱ�� ��ʽ:YYYYMMDD
	 * @return YYYYMMDD
	 */
	public static String getCurrent(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String now = df.format(new Date());// ���õ�ǰ����	
		return now;
	}
	
	/**
	 * ����װ�� Date->String
	 */
	public static String formatDate(Date date)throws Exception
	{
		SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
		return fmt.format(date);
	}
}