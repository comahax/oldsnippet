package com.gmcc.pboss.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.common.util.date.TimeUtil;
import com.gmcc.pboss.common.exception.AssertConditionException;
import com.gmcc.pboss.common.service.ServiceRetCode;

public class DateUtil {
	private static Log log = LogFactory.getLog(DateUtil.class);
	private static final String TIME_PATTERN = "HH:mm";

	/**
	 * Checkstyle rule: utility classes should not have public constructor
	 */
	private DateUtil() {
	}

	/**
	 * Return default datePattern (yyyy-MM-dd)
	 * 
	 * @return a string representing the date pattern on the UI
	 */
	public static String getDatePattern() {
		String defaultDatePattern;

		defaultDatePattern = "yyyy-MM-dd";

		return defaultDatePattern;
	}

	public static String getDateTimePattern() {
		return DateUtil.getDatePattern() + " HH:mm:ss";
	}

	/**
	 * This method attempts to convert an Oracle-formatted date in the form
	 * dd-MMM-yyyy to yyyy-MM-dd.
	 * 
	 * @param aDate
	 *            date from database as a string
	 * @return formatted string for the ui
	 */
	public static String getDate(Date aDate) {
		SimpleDateFormat df;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(getDatePattern());
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * @return a converted Date object
	 * @see java.text.SimpleDateFormat
	 * @throws ParseException
	 *             when String doesn't match the expected format
	 */
	public static Date convertStringToDate(String aMask, String strDate) throws ParseException {
		SimpleDateFormat df;
		Date date;
		df = new SimpleDateFormat(aMask);

		if (log.isDebugEnabled()) {
			log.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
		}

		try {
			if (strDate.length() == 16)
				strDate = strDate + ":00";
			date = df.parse(strDate);
		} catch (ParseException pe) {
			// log.error("ParseException: " + pe);
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}

	/**
	 * This method returns the current date time in the format: yyyy-MM-dd HH:MM
	 * a
	 * 
	 * @param theTime
	 *            the current time
	 * @return the current date/time
	 */
	public static String getTimeNow(Date theTime) {
		return getDateTime(TIME_PATTERN, theTime);
	}

	/**
	 * This method returns the current date in the format: yyyy-MM-dd
	 * 
	 * @return the current date
	 * @throws ParseException
	 *             when String doesn't match the expected format
	 */
	public static Calendar getToday() throws ParseException {
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

		// This seems like quite a hack (date -> string -> date),
		// but it works ;-)
		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		cal.setTime(convertStringToDate(todayAsString));

		return cal;
	}

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 * 
	 * @see java.text.SimpleDateFormat
	 */
	public static String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
			log.error("aDate is null!");
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date based on the
	 * System Property 'dateFormat' in the format you specify on input
	 * 
	 * @param aDate
	 *            A date to convert
	 * @return a string representation of the date
	 */
	public static String convertDateToString(Date aDate) {
		return getDateTime(getDatePattern(), aDate);
	}

	/**
	 * This method converts a String to a date using the datePattern
	 * 
	 * @param strDate
	 *            the date to convert (in format yyyy-MM-dd)
	 * @return a date object
	 * @throws ParseException
	 *             when String doesn't match the expected format
	 */
	public static Date convertStringToDate(String strDate) throws ParseException {
		Date aDate = null;

		try {
			if (log.isDebugEnabled()) {
				log.debug("converting date with pattern: " + getDatePattern());
			}

			if (strDate.length() > 10) {
				aDate = convertStringToDate(getDateTimePattern(), strDate);
			} else {
				aDate = convertStringToDate(getDatePattern(), strDate);
			}

		} catch (ParseException pe) {
			log.error("Could not convert '" + strDate + "' to a date, throwing exception");
			pe.printStackTrace();
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return aDate;
	}

	public static java.util.Date DateDiff(java.util.Date fDateTime, int timeDiff) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.set(fDateTime.getYear() + 1900, fDateTime.getMonth(), fDateTime.getDate());
		c.add(Calendar.DATE, timeDiff);
		// c.set(Calendar.DAY_OF_YEAR,fDateTime.getDate()+timeDiff);

		return c.getTime();
	}

	// ---日期加值（i -- 标识,dDateTime -- 当前日期,Diff -- 差值）
	public static java.util.Date DateDiff(String i, java.util.Date dDateTime, int Diff) {
		// java.util.Date date = new java.util.Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dDateTime);
		if (i.equals("M")) {
			calendar.add(Calendar.MONTH, Diff);
		} else if (i.equals("D")) {
			calendar.add(Calendar.DATE, Diff);
		} else if (i.equals("Y")) {
			calendar.add(Calendar.YEAR, Diff);
		}

		return calendar.getTime();
	}

	/**
	 * 返回包含当前月第一天的日期格式：如 20090801
	 * @param dateString 格式如 200908
	 * @return
	 */
	public static String getCurrentMonthBegin(String dateString) {
		return getMonth(dateString, 0);
	}
	/**
	 * 返回当前月的第一天 时间重置为 0时0分0秒
	 * @param curDate
	 * @return
	 */
	public static Date getCurrentMonthFirstDay(Date curDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(curDate);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND,0);
		return cal.getTime();
	}

	/**
	 * 根据日期返回当前月份标识(返回类似200910)
	 * @param curDate
	 * @return
	 */
	public static String getCustomerMonth(Date curDate) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(curDate);
		int year = calender.get(Calendar.YEAR);
		int month = calender.get(Calendar.MONTH)+1;
		if (month < 10)
		    return year + "0" + month;
		else
		    return year + "" + month;
	}

	/**
	 * 返回包含下一月第一天的日期格式：如 20090901
	 * @param dateString 格式如 200908
	 * @return
	 */
	public static String getNextMonthBegin(String dateString) {
		return getMonth(dateString, 1);
	}
	/**
	 * 返回少于当前日的月分最后一天
	 * @param dateString 格式如 200908
	 * @return 返回少于当前日的月分最后一天,(上一个月返回上个月最后一天,本月返回当前日)
	 */
	public static String getNowMonthEnd(String dateString){
		//日期整理,提取当前日期
		Date dateNow = new Date();
		//String dResult = dDateTime.toString();
		String y = Integer.toString(dateNow.getYear() + 1900);
		String m = Integer.toString(dateNow.getMonth() + 1);
		String d = Integer.toString(dateNow.getDate());
//		String h = Integer.toString(dateNow.getHours());
//		String n = Integer.toString(dateNow.getMinutes());
//		String s = Integer.toString(dateNow.getSeconds());
		
		String yy = y;
		y = y.substring(2, 4);
		String mm = m;
		String dd = d;
		
		if (m.length() == 1)
			mm = "0" + m;
		if (d.length() == 1)
			dd = "0" + d;
		
		
		if (!dateString.equals(yy+mm)){//由业务决定,目前不能传入比当前月大的月份,所以,不等于当前会就为以前的月份
			return getMonth(dateString, 1);//返回指定月的最后一天
		}else{
			//是当前月,返回当前日期
			return yy+mm+dd;
		}
	};
	/**
	 * 根据传入的字符串，和需要增加的月份来返回每月第一天的字符串日期
	 * @param dateString 格式如200908
	 * @param diff 只能为正整数
	 * @return
	 */
	private static String getMonth(String dateString, int diff) {
		Pattern pattern = Pattern.compile("^(20\\d{2})(0[1-9]|1[0-2])$");
		Matcher matcher = pattern.matcher(dateString);
		Assert.notBlank(dateString, ServiceRetCode.DATE_FORMAT, "日期格式错误");
		if (!matcher.matches()) {
			throw new AssertConditionException(ServiceRetCode.DATE_FORMAT, "日期格式错误");
		}
		int year = Integer.valueOf(matcher.replaceAll("$1")).intValue();
		int month = Integer.valueOf(matcher.replaceAll("$2")).intValue();
		if (diff <= 0) {
			return "" + year + (month < 10 ? "0" + month : "" + month) + "01";
		} else if (diff + month >= 13) {
			return "" + (year + 1) + "0101";
		}
		return "" + year + (month + diff < 10 ? "0" + (month + diff) : "" + (month + diff)) + "01";
	}
	
	/**
	 * 取加、减N天后的日期
	 * @param now
	 * @param addDay
	 * @return
	 */
	public static Date getDate(Date now, int addDay)
	{   
		return TimeUtil.getDate(now, addDay);
    }
	
	/**
	 * 传入日期是否比当前时间大
	 * @param date
	 * @return
	 */
	public static boolean isAfterRightNow(Date date){
		return TimeUtil.isAfterRightNow(date);
	}
	
	/**
	 * 传入日期是否比当前时间小
	 * @param date
	 * @return
	 */
	public static boolean isBeforeRightNow(Date date){
		if(date==null){
			return false;
		}
		return TimeUtil.isBeforeRightNow(date);
	}
}
