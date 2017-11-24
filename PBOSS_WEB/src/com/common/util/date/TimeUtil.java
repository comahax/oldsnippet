package com.common.util.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.common.util.string.CharacterStrUtil;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * ������
 * 	�������ڲ����Ĺ�����
 */
public class TimeUtil {
	/**
	 * ��ʽΪ��yyyMM
	 */
	public static String YEARMONTH = "yyyyMM";
	/**
	 * ��ʽΪ��yyy-MM
	 */
	public static String YEAR_MONTH = "yyyy-MM";
	/**
	 * ��ʽΪ��yyy-MM-dd
	 */
	public static String YEAR_MONTH_DAY = "yyyy-MM-dd";
	
	/**
	 * ȡȡ��ǰʱ��ǰ����N�������
	 * @param now		��ǰʱ��
	 * @param addDay	ǰ��������ǰ��Ϊ����
	 */
	public static Date getDate(Date now, int addDay)
	{   
		if(now == null){
			now = new Date();
		}
        Calendar cd = Calendar.getInstance();   
        cd.setTime(now);   
        cd.add(Calendar.DATE, addDay);   
        Date date = cd.getTime();
		return date;
    }
	
	
	/**
	 * ���ص�ǰʱ����ϸ���ֵ
	 * @param s	�����ظ�ʽ��yyyy-MM, yyyyMM
	 */
	public static String getNowMonth(String s){
		StringBuffer t = new StringBuffer();
		t.append(getCurrentlyYear());
		
		if(s.equalsIgnoreCase(YEAR_MONTH))
			t.append('-');
		
		t.append(getCurrentlyMonthStr());
		
		return t.toString();
	}
	
	/**
	 * ���ص�ǰʱ����ϸ���ֵ
	 * @param s	�����ظ�ʽ��yyyy-MM, yyyyMM
	 */
	public static String getLastMonth(String s){
		StringBuffer t = new StringBuffer();
		
		int year = getCurrentlyYear();
		int month = getCurrentlyMonth();
		
		//month = 1��
		if(month == 1){
			month = 12;
			year = year - 1;
		}
		//1��<month<=12��
		else{
			month = month - 1;
		}
		
		t.append(year);
		
		if(s.equalsIgnoreCase(YEAR_MONTH))
			t.append('-');
		
		if(month < 10)
			t.append(0).append(month);
		else
			t.append(month);
		
		return t.toString();
	}
	
	/**
     * ���ݴ���ĸ�ʽ���ص�������ڣ�
     * �������ĸ�ʽΪ��ʱ��Ĭ�Ϸ��ظ�ʽΪyyyy-MM-dd
     * @param s 
     * 		Ҫ���ص����ڸ�ʽ����yyyy-MM-dd HH:mm:ss��;
     * 		����Ĭ��Ϊyyyy-MM-dd��
     */
	public static String getToday(String s){
		s = checkPattern(s);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(s);
		
		return sdf.format(date);
	}
	
	/**
     * ���ݴ���ĸ�ʽ������������ڣ�
     * �������ĸ�ʽΪ��ʱ��Ĭ�Ϸ��ظ�ʽΪyyyy-MM-dd
     * @param s 
     * 		Ҫ���ص����ڸ�ʽ����yyyy-MM-dd HH:mm:ss�ȣ�
     * 		����Ĭ��Ϊyyyy-MM-dd��
     */
	public static String getYesterday(String s){
		s = checkPattern(s);
		SimpleDateFormat sdf = new SimpleDateFormat(s);
		Calendar calender = Calendar.getInstance();
		int day = calender.get(Calendar.DAY_OF_MONTH);
		int year = calender.get(Calendar.YEAR);
		int month = calender.get(Calendar.MONTH);
		calender.set(year, month, day - 1);
		return sdf.format(calender.getTime());
	}
	
	/**
     * ���ݴ���ĸ�ʽ����ÿ�������һ������ڣ�
     * �������ĸ�ʽΪ��ʱ��Ĭ�Ϸ��ظ�ʽΪyyyy-MM-dd
     * @param s 
     * 		Ҫ���ص����ڸ�ʽ����yyyy-MM-dd HH:mm:ss�ȣ�
     * 		Ĭ��Ϊyyyy-MM-dd
     */
	public static String getEndDayOfMonth(String s){
		s = checkPattern(s);
		
		SimpleDateFormat sdf = new SimpleDateFormat(s);
		Calendar calender = Calendar.getInstance();
		int lastDay = calender.getActualMaximum(Calendar.DAY_OF_MONTH);
		int year = calender.get(Calendar.YEAR);
		int month = calender.get(Calendar.MONTH);
		calender.set(year, month, lastDay);
		return sdf.format(calender.getTime());
	}
	/**
	 * ȡ�õ�ǰ�꣬yyyy
	 */
	public static int getCurrentlyYear(){
		Calendar calender = Calendar.getInstance();
		int year = calender.get(Calendar.YEAR);
		return year;
	}
	
	/**
	 *ȡ�õ�ǰ�£�M 
	 */
	public static int getCurrentlyMonth(){
		Calendar calender = Calendar.getInstance();
		int month = calender.get(Calendar.MONTH) + 1;
		return month;
	}
	/**
	 * ȡ�õ�ǰ�£�MM
	 */
	public static String getCurrentlyMonthStr(){
		int month = getCurrentlyMonth();
		StringBuffer t = new StringBuffer();
		
		if(month < 10)
			t.append(0);
		
		t.append(month);
		
		return t.toString();
	}
	
	/**
	 * ȡ�õ��죬d
	 */
	public static int getCurrentlyDay(){
		Calendar calender = Calendar.getInstance();
    	int day = calender.get(Calendar.DATE);
    	return day;
	}
	
	/**
	 * ȡ�õ��죬dd
	 */
	public static String getCurrentlyDayStr(){
		int day = getCurrentlyDay();
		StringBuffer t = new StringBuffer();
		if(day < 10)
			t.append(0);
		t.append(day);
		
		return t.toString();
	}
	
	/**
	 * ���������Ƿ�ȵ�ǰʱ��С
	 * @param date ��������
	 */
	public static boolean isBeforeRightNow(Date date){
		Date now = new Date();
		return date.before(now);
	}
	
	/**
	 * ���������Ƿ�ȵ�ǰʱ���
	 * @param date ��������
	 */
	public static boolean isAfterRightNow(Date date){
		Date now = new Date();
		return date.after(now);
	}
	
	
	
	/**
	 * ������ڸ�ʽ��Ϊ�շ��أ�yyyy-MM-dd
	 * @param str
	 */
	private static String checkPattern(String str){
		if(CharacterStrUtil.isBlank(str))
			str = YEAR_MONTH_DAY;
		
		return str;
	}
}	

