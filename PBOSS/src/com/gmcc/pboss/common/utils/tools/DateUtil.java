package com.gmcc.pboss.common.utils.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期公共类
 * 
 * @auther caiwr 
 * @version 2.0 2015-08-17 16:00
 * 
 */
public class DateUtil {
	
	private final static Logger log = LoggerFactory.getLogger(DateUtil.class);
	
	public static final String pattern10 = "yyyy-MM-dd";
	public static final String pattern19 = "yyyy-MM-dd HH:mm:ss";
	public static final String pattern14 = "yyyyMMddHHmmss";

	public static final String pattern19ToDate = "yyyy-MM-dd HH24:mi:ss";

	public static final long day = 1000 * 60 * 60 * 24;
	public static final long hour = 1000 * 60 * 60;
	public static final int minute = 1000 * 60;
	public static final int second = 1000;
	
	/**
	 * 
	 * 求日期的下一天
	 * 
	 * @param 字符串格式的日期
	 * @return 返回 日期下一天的日期
	 * @exception 异常描述
	 */
	public static String nextDayAfterDate(String date) {
		String[] current = date.split("-");
		// 分隔字符串格式的日期
		int year = Integer.parseInt(current[0]);
		int month = Integer.parseInt(current[1]);
		int day = Integer.parseInt(current[2]);
		// 如果日数少于该月的最大天数，天数加一天
		if (day < DateUtil.maxDay(year, month)) {
			day++;
		} else {
			// 如果月份少于12，则月份加一个月
			if (month < 12) {

				month++;
			} else {
				// 如果月份大于等于12，则月份置1，年份加1年
				month = 1;
				year++;
			}
			// 如果日数超过该月的天数，天数置1
			day = 1;
		}
		// 计算出处理后的日期
		date = year + "-" + DateUtil.formatData(month) + "-"
				+ DateUtil.formatData(day);

		return date;
	}

	/**
	 * 
	 * 日期数据格式的处理
	 * 
	 * @param 整型
	 *            data
	 * @return 返回String类型的新数据
	 * @exception 异常描述
	 */
	public static String formatData(int data) {
		// 如果数字小于10，数字前加0
		if (data < 10) {
			return "0" + data;
		} else {
			return data + "";
		}
	}

	/**
	 * 
	 * 判断是否是闰年
	 * 
	 * @param 整型
	 *            year
	 * @return 返回 boolean
	 * @exception 异常描述
	 */
	public static boolean isLeap(int year) {
		// 如果是闰年返回true，否则为false
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * 求一个月的最大一天
	 * 
	 * @param 年，月
	 * @return 返回 整型天数
	 * @exception 异常描述
	 */
	public static int maxDay(int year, int month) {
		// 初始化12个月份的天数
		int[] months = { 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// 如果不是2月则返回该月份的天数
		if (month != 2) {
			return months[month - 1];
		} else {
			// 如果是闰年返回为29天，否则28天
			if (isLeap(year)) {
				return 29;
			} else {
				return 28;
			}
		}
	}

	/**
	 * 
	 * 比较两个字符串的日期的大小
	 * 
	 * @param 两个日期
	 * @return 返回 boolean
	 * @exception 异常描述
	 */
	public static boolean compareToDate(String dateFrom, String dateTo) {
		// 如果开始日期小于等于结束日期返回为true,否则为false
		if (dateFrom.compareTo(dateTo) <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * 由日历获取星期几
	 * 
	 * @param 年，月，日
	 * @return 返回整型星期 1：星期日；2：星期一；3：星期二；4：星期三；5：星期四；6：星期五；7：星期六；
	 * @exception 异常描述
	 */
	public static int getWeekValue(int year, int month, int day) {
		// 实例化Calendar
		Calendar now = Calendar.getInstance();
		// 设置某年某月某日的参数
		now.set(Calendar.YEAR, year);
		now.set(Calendar.MONTH, month - 1);
		now.set(Calendar.DATE, day);
		return now.get(Calendar.DAY_OF_WEEK);
	}

	public enum DateFormatType {
		/**
		 * 格式为：yyyy-MM-dd HH:mm:ss
		 */
		DATE_FORMAT_STR("yyyy-MM-dd HH:mm:ss"),
		/**
		 * 格式为：yyyyMMddHHmmss
		 */
		SIMPLE_DATE_TIME_FORMAT_STR("yyyyMMddHHmmss"),

		/**
		 * 格式为：yyyy-MM-dd
		 */
		SIMPLE_DATE_FORMAT_STR("yyyy-MM-dd"),

		/**
		 * 格式为：yyyy/MM/dd
		 */
		SIMPLE_DATE_FORMAT_VIRGULE_STR("yyyy/MM/dd"),

		/**
		 * 格式为：HH:mm:ss
		 */
		HOUR_MINUTE_SECOND("HH:mm:ss"),

		/**
		 * 格式为：HH:mm
		 */
		HOUR_MINUTE("HH:mm");

		private final String value;

		DateFormatType(String formatStr) {
			this.value = formatStr;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * 获取当前时间日期的字符串
	 */
	public static String getCurrentDateStr(DateFormatType dateFormatType) {
		Date date = getCurrentDate();
		return (String) OpearationDate(date, dateFormatType.getValue());
	}

	/**
	 * 时间、日期格式化成字符串
	 */
	public static String formatDate(Date date, DateFormatType dateFormatType) {
		return (String) OpearationDate(date, dateFormatType.getValue());
	}

	/**
	 * 从字符串解析成时间、日期
	 */
	public static Date parseDate(String dateStr, DateFormatType dateFormatType) {
		return (Date) OpearationDate(dateStr, dateFormatType.getValue());
	}

	/**
	 * 获取当前系统时间(原始格式)
	 */
	public static Date getCurrentDate() {
		Date date = new Date(System.currentTimeMillis());
		return date;
	}

	/**
	 * 获取当前日期的年、月、日、时、分、秒
	 */
	public static int getCurrentTime(TimeFormatType timeFormatType) {
		return getTime(getCurrentDate(), timeFormatType);
	}

	/**
	 * 获取指定日期的年、月、日、时、分、秒
	 */
	public static int getTime(Date date, TimeFormatType timeFormatType) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			int type = timeFormatType.getValue();
			int i = c.get(type);
			return type == 2 ? i + 1 : i;
		} catch (Exception e) {
			throw new RuntimeException("获取失败", e);
		}
	}

	/**
	 * 获取指定日期的毫秒数
	 */
	public static long getMillis(Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 日期相加、减操作
	 * 
	 * 所返回结果单位为:天数
	 */
	public static int operationDate(Date date, Date diffDate,
			DateOperationType dateOperationType) {
		long add = getMillis(date) + getMillis(diffDate);
		long diff = getMillis(date) - getMillis(diffDate);
		return (int) ((dateOperationType.getValue() ? add : diff) / (24 * 3600 * 1000));
	}

	/**
	 * 日期月份相加、减操作
	 */
	public static Date operationDateOfMonth(Date date, int month,
			DateOperationType dateOperationType) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, dateOperationType.getValue() ? month : month
				- (month * 2));
		return c.getTime();
	}

	/**
	 * 日期天数相加、减操作
	 */
	public static Date operationDateOfDay(Date date, int day,
			DateOperationType dateOperationType) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		long millis = c.getTimeInMillis();
		long millisOfday = day * 24 * 3600 * 1000;
		long sumMillis = dateOperationType.getValue() ? (millis + millisOfday)
				: (millis - millisOfday);
		c.setTimeInMillis(sumMillis);
		return c.getTime();
	}

	private static Object OpearationDate(Object object, String formatStr) {
		if (object == null || null == formatStr || "".equals(formatStr)) {
			throw new RuntimeException("参数不能为空");
		}
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		try {
			if (object instanceof Date)
				return format.format(object);
			else
				return format.parse(object.toString());
		} catch (Exception e) {
			throw new RuntimeException("操作失败", e);
		}

	}

	public enum DateOperationType {

		/**
		 * 加操作
		 */
		ADD(true),

		/**
		 * 减操作
		 */
		DIFF(false);

		private final boolean value;

		DateOperationType(boolean operation) {
			this.value = operation;
		}

		public boolean getValue() {
			return value;
		}
	}

	public enum TimeFormatType {

		YEAR(1), MONTH(2), DAY(5), HOUR(11), MINUTE(12), SECOND(13);
		private final int value;

		TimeFormatType(int formatStr) {
			this.value = formatStr;
		}

		public int getValue() {
			return value;
		}
	}
	
	/**
	 * 返回今天的格式为yyyy-MM-dd的日期String
	 * 
	 * @return String
	 */
	public static String date_today() {
		return convertDateToString(new Date(), pattern10);
	}

	/**
	 * 返回今天的自定义格式日期String 如　yyyy-MM-dd HH:mm:ss
	 * 
	 * @return String
	 */
	public static String date_today(String pattern) {
		return convertDateToString(new Date(), pattern);
	}

	/**
	 * 把date转换成字串
	 * 
	 * @param date
	 *            Date
	 * @param pattern
	 *            String 日期格式，如：yyyy-MM-dd hh:mm:ss　或　yyyy/MM/dd 等
	 * @return String
	 */
	public static String convertDateToString(Date date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		if (date == null) {
			return "";
		}
		return format.format(date);
	}

	public static String convertDateToString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(pattern19);
		return format.format(date);
	}

	/**
	 * 获得系统当前时间
	 * 
	 * @return Date 当前时间
	 */
	public static String getNowTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(pattern19);
		String nowTime = formatter.format(cal.getTime());
		return nowTime;
	}

	/**
	 * 获得系统当前日期
	 * 
	 * @return EX: 2005-11-09
	 * @author liutt
	 */
	public static String getNowDate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(pattern10);
		String nowTime = formatter.format(cal.getTime());
		return nowTime;

	}

	/**
	 * 获得当前日期的年月日时分 如：200511091212
	 * 
	 * @return
	 */
	public static String getNowYMDHM() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");
		String nowTime = formatter.format(cal.getTime());
		return nowTime;

	}

	/**
	 * 获得当前日期的年月日时分秒 如：20051109121212
	 * 
	 * @return
	 */
	public static String getNowYMDHMS() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String nowTime = formatter.format(cal.getTime());
		return nowTime;

	}

	/**
	 * 获得当前日期的年月日 如：20051109
	 * 
	 * @return
	 */
	public static String getDateYMD() {
		String ymd = getNowTime();
		if (ymd != null && !ymd.equals("")) {
			ymd = ymd.substring(0, 10);
			ymd = ymd.replaceAll("-", "");
		}
		else {
			ymd = "";
		}
		return ymd;
	}

	/**
	 * 获得当前日期的年月 如：200511
	 * 
	 * @return
	 */
	public static String getDateYM() {
		String ym = getNowTime();
		if (ym != null && !ym.equals("")) {
			ym = ym.substring(0, 8);
			ym = ym.replaceAll("-", "");
		}
		else {
			ym = "";
		}
		return ym;
	}

	/**
	 * 以输入格式返回输入的日期
	 * 
	 * @return
	 */
	public static String date2String(Date date, String pattern) {
		if (date == null) date = new Date();
		if (pattern == null || pattern.trim().length() == 0) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		String datestr = format.format(date);
		return datestr;
	}

	/**
	 * 获得指定日期提前或延后天数的字符串
	 * 
	 * @param dateString
	 *            输入的日期字符串
	 * @param beforeDays
	 *            提前或延后天数
	 * @param pattern
	 *            日期格式
	 * @return
	 * @throws ParseException
	 */
	public static String getDateStrByDays(String dateString, int days,
			String pattern) {
		String beforeDay = "";
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		Date inputDate = null;
		try {
			inputDate = dateFormat.parse(dateString);
			Calendar date = Calendar.getInstance();
			date.setTime(inputDate);
			date.add(Calendar.DATE, days);
			beforeDay = dateFormat.format(date.getTime());
		}
		catch (Exception ex) {
			log.error(ex.getMessage());
		}

		return beforeDay;
	}

	/**
	 * 获得指定日期提前或延后月份的字符串
	 * 
	 * @param dateString
	 *            输入的日期字符串
	 * @param beforeDays
	 *            提前或延后天数
	 * @param pattern
	 *            日期格式
	 * @return
	 * @throws ParseException
	 */
	public static String getDateStrByMonths(String dateString, int months,
			String pattern) {
		String beforeYmd = "";
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		Date inputDate = null;
		try {
			inputDate = dateFormat.parse(dateString);
			Calendar date = Calendar.getInstance();
			date.setTime(inputDate);
			date.add(Calendar.MONTH, months);
			beforeYmd = dateFormat.format(date.getTime());
		}
		catch (Exception ex) {
			log.error(ex.getMessage());
		}

		return beforeYmd;
	}

	/**
	 * 返回秒钟
	 * 
	 * @param date
	 *            日期
	 * @return int 秒钟
	 */
	public static int getSecond(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.SECOND);
	}

	/**
	 * 返回分钟
	 * 
	 * @param date
	 *            日期
	 * @return int 分钟
	 */
	public static int getMinute(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.MINUTE);
	}

	/**
	 * 返回小时
	 * 
	 * @param date
	 *            日期
	 * @return int 小时
	 */
	public static int getHour(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.HOUR_OF_DAY);
	}

	/**
	 * 返回月份
	 * 
	 * @param date
	 *            日期
	 * @return int 月份
	 */
	public static int getMonth(java.util.Date date) {
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(java.util.Calendar.MONTH) + 1;
	}

	/**
	 * 返回年份
	 * 
	 * @param date
	 *            日期
	 * @return int 年份
	 */
	public static int getYear(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.YEAR);
	}

	/**
	 * 把日期格式化为日期字符串（yyyy-MM-dd hh:mm:ss）
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            格式（yyyy-MM-dd hh:mm:ss）
	 * @return String 字符型日期
	 */
	public static String formatDataTime(java.util.Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				java.text.DateFormat df = new java.text.SimpleDateFormat(format);
				result = df.format(date);
			}
		}
		catch (Exception e) {
		}
		return result;
	}

	/**
	 * 根据指定格式把日期字符串转换为日期类型（"yyyy-MM-dd"）
	 * 
	 * @param dateStr
	 *            字符型日期
	 * @param format
	 *            格式（"yyyy-MM-dd"）
	 * @return Date 日期
	 */
	public static java.util.Date parseDate(String dateStr, String format) {
		java.util.Date date = null;
		try {
			final java.text.DateFormat df = new java.text.SimpleDateFormat(
					format);
			ParsePosition pp = new ParsePosition(0);
			date = df.parse(dateStr, pp);

		}
		catch (Exception e) {
			log.error(e.getMessage());
		}
		return date;
	}

	/**
	 * 把字符串日期转换为日期（"yyyy-MM-dd HH:mm:ss"）
	 * 
	 * @param dateStr
	 *            字符型日期
	 * @return Date 日期
	 */
	public static java.util.Date parseTime(String dateStr) {
		return parseDate(dateStr, "yyyy-MM-dd HH:mm:ss");
	}

	public static boolean isNum(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * 根据输入月份查得下一个月
	 * 
	 * @param qryMonth
	 * @return
	 */
	public static String getNextYearMonth(String qryMonth) {
		String next = null;
		if (StringUtils.isNotEmpty(qryMonth)) {
			if ((qryMonth.length() != 6) || !isNum(qryMonth)) {
				return null;
			}

			else {
				int year = Integer.parseInt(qryMonth.substring(0, 4));
				int month = Integer.parseInt(qryMonth.substring(4));
				if (month < 12) {
					++month;
					if (month < 10) {
						next = year + "0" + month;
					}
					else {
						next = year + "" + month;
					}
				}
				else {
					++year;
					month = 1;
					next = year + "0" + month;
				}

				return next;
			}
		}
		else {
			return null;
		}
	}

	/**
	 * 将一位数字转成带'0'的字符串，用于时间格式的拼接
	 * 
	 * @param number
	 * @return
	 */
	public static String chgIntToString(int number) {
		if (number > 9) {
			return String.valueOf(number);
		}
		else {
			StringBuffer strb = new StringBuffer();
			strb.append("0");
			strb.append(number);

			return strb.toString();
		}
	}

	public static String getSubDayNum(String first, String last)
			throws ParseException {
		if (first.equals(last)) {
			return "0s";
		}

		StringBuffer strb = new StringBuffer();

		SimpleDateFormat bartDateFormat = new SimpleDateFormat(pattern19);
		Date tempfirst = bartDateFormat.parse(first);
		Date templast = bartDateFormat.parse(last);
		long subTime = templast.getTime() - tempfirst.getTime();

		long beishu = subTime / day;

		if (beishu > 0) {
			strb.append(beishu);
			strb.append("d");
		}

		long yushu = subTime % day;
		if (yushu > 0) {
			subTime = yushu;
			beishu = subTime / hour;
			if (beishu > 0) {
				strb.append(beishu);
				strb.append("h");
			}
			yushu = subTime % hour;
			if (yushu > 0) {
				subTime = yushu;
				beishu = subTime / minute;
				if (beishu > 0) {
					strb.append(beishu);
					strb.append("m");
				}
				yushu = subTime % minute;
				if (yushu > 0) {
					subTime = yushu;
					beishu = subTime / second;
					yushu = subTime % second;
					if (yushu == 0) {
						strb.append(beishu);
					}
					else {
						strb.append(beishu + 1);
					}
					strb.append("s");
				}
			}
		}
		return strb.toString();
	}
	
	/**
	 * 判断输入的字符串是否符合yyyymm的格式
	 * @param ymStr
	 * @return
	 */
	public static boolean chkIfYmFormat(String ymStr) {
		if(StringUtils.isNotBlank(ymStr) && ymStr.length() == 6){
			Pattern pattern = Pattern.compile("2[01]\\d{2}((0[1-9])|(1[012]))");
			Matcher matcher = pattern.matcher(ymStr);
			if (matcher.find()){
			    return true;
			}else {
			    return false;
			}
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		String first = "2015-08-15 16:02:53";
		String last = "2015-08-17 16:09:25";
		
		String diff = "";
		try {
			diff = DateUtil.getSubDayNum( first,last);
		} catch (ParseException e) {
			log.error(e.getMessage());
		}
		System.out.println(diff);

		System.out.println(getCurrentDateStr(DateFormatType.DATE_FORMAT_STR));
		
//		String ymStr = "211200";
//		boolean flag = chkIfYmFormat(ymStr);
//		if(flag){
//			System.out.println("true");
//		}else{
//			System.out.println("false");
//		}
		
		 
	}

}
