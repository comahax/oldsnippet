package com.common.util.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.common.util.string.CharacterStrUtil;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * 描述：
 * 	关于日期操作的工具类
 */
public class TimeUtil {
	/**
	 * 格式为：yyyMM
	 */
	public static String YEARMONTH = "yyyyMM";
	/**
	 * 格式为：yyy-MM
	 */
	public static String YEAR_MONTH = "yyyy-MM";
	/**
	 * 格式为：yyy-MM-dd
	 */
	public static String YEAR_MONTH_DAY = "yyyy-MM-dd";
	
	/**
	 * 取取当前时间前、后N天的日期
	 * @param now		当前时间
	 * @param addDay	前后天数，前天为负数
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
	 * 返回当前时间的上个月值
	 * @param s	代表返回格式：yyyy-MM, yyyyMM
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
	 * 返回当前时间的上个月值
	 * @param s	代表返回格式：yyyy-MM, yyyyMM
	 */
	public static String getLastMonth(String s){
		StringBuffer t = new StringBuffer();
		
		int year = getCurrentlyYear();
		int month = getCurrentlyMonth();
		
		//month = 1月
		if(month == 1){
			month = 12;
			year = year - 1;
		}
		//1月<month<=12月
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
     * 根据传入的格式返回当天的日期，
     * 如果传入的格式为空时，默认返回格式为yyyy-MM-dd
     * @param s 
     * 		要返回的日期格式，如yyyy-MM-dd HH:mm:ss等;
     * 		不传默认为yyyy-MM-dd。
     */
	public static String getToday(String s){
		s = checkPattern(s);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(s);
		
		return sdf.format(date);
	}
	
	/**
     * 根据传入的格式返回昨天的日期，
     * 如果传入的格式为空时，默认返回格式为yyyy-MM-dd
     * @param s 
     * 		要返回的日期格式，如yyyy-MM-dd HH:mm:ss等；
     * 		不传默认为yyyy-MM-dd。
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
     * 根据传入的格式返回每个月最后一天的日期，
     * 如果传入的格式为空时，默认返回格式为yyyy-MM-dd
     * @param s 
     * 		要返回的日期格式，如yyyy-MM-dd HH:mm:ss等，
     * 		默认为yyyy-MM-dd
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
	 * 取得当前年，yyyy
	 */
	public static int getCurrentlyYear(){
		Calendar calender = Calendar.getInstance();
		int year = calender.get(Calendar.YEAR);
		return year;
	}
	
	/**
	 *取得当前月，M 
	 */
	public static int getCurrentlyMonth(){
		Calendar calender = Calendar.getInstance();
		int month = calender.get(Calendar.MONTH) + 1;
		return month;
	}
	/**
	 * 取得当前月，MM
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
	 * 取得当天，d
	 */
	public static int getCurrentlyDay(){
		Calendar calender = Calendar.getInstance();
    	int day = calender.get(Calendar.DATE);
    	return day;
	}
	
	/**
	 * 取得当天，dd
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
	 * 传入日期是否比当前时间小
	 * @param date 传入日期
	 */
	public static boolean isBeforeRightNow(Date date){
		Date now = new Date();
		return date.before(now);
	}
	
	/**
	 * 传入日期是否比当前时间大
	 * @param date 传入日期
	 */
	public static boolean isAfterRightNow(Date date){
		Date now = new Date();
		return date.after(now);
	}
	
	
	
	/**
	 * 检查日期格式，为空返回，yyyy-MM-dd
	 * @param str
	 */
	private static String checkPattern(String str){
		if(CharacterStrUtil.isBlank(str))
			str = YEAR_MONTH_DAY;
		
		return str;
	}
}	

