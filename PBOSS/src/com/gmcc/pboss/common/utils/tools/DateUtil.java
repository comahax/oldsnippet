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
 * ���ڹ�����
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
	 * �����ڵ���һ��
	 * 
	 * @param �ַ�����ʽ������
	 * @return ���� ������һ�������
	 * @exception �쳣����
	 */
	public static String nextDayAfterDate(String date) {
		String[] current = date.split("-");
		// �ָ��ַ�����ʽ������
		int year = Integer.parseInt(current[0]);
		int month = Integer.parseInt(current[1]);
		int day = Integer.parseInt(current[2]);
		// ����������ڸ��µ����������������һ��
		if (day < DateUtil.maxDay(year, month)) {
			day++;
		} else {
			// ����·�����12�����·ݼ�һ����
			if (month < 12) {

				month++;
			} else {
				// ����·ݴ��ڵ���12�����·���1����ݼ�1��
				month = 1;
				year++;
			}
			// ��������������µ�������������1
			day = 1;
		}
		// ���������������
		date = year + "-" + DateUtil.formatData(month) + "-"
				+ DateUtil.formatData(day);

		return date;
	}

	/**
	 * 
	 * �������ݸ�ʽ�Ĵ���
	 * 
	 * @param ����
	 *            data
	 * @return ����String���͵�������
	 * @exception �쳣����
	 */
	public static String formatData(int data) {
		// �������С��10������ǰ��0
		if (data < 10) {
			return "0" + data;
		} else {
			return data + "";
		}
	}

	/**
	 * 
	 * �ж��Ƿ�������
	 * 
	 * @param ����
	 *            year
	 * @return ���� boolean
	 * @exception �쳣����
	 */
	public static boolean isLeap(int year) {
		// ��������귵��true������Ϊfalse
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * ��һ���µ����һ��
	 * 
	 * @param �꣬��
	 * @return ���� ��������
	 * @exception �쳣����
	 */
	public static int maxDay(int year, int month) {
		// ��ʼ��12���·ݵ�����
		int[] months = { 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// �������2���򷵻ظ��·ݵ�����
		if (month != 2) {
			return months[month - 1];
		} else {
			// ��������귵��Ϊ29�죬����28��
			if (isLeap(year)) {
				return 29;
			} else {
				return 28;
			}
		}
	}

	/**
	 * 
	 * �Ƚ������ַ��������ڵĴ�С
	 * 
	 * @param ��������
	 * @return ���� boolean
	 * @exception �쳣����
	 */
	public static boolean compareToDate(String dateFrom, String dateTo) {
		// �����ʼ����С�ڵ��ڽ������ڷ���Ϊtrue,����Ϊfalse
		if (dateFrom.compareTo(dateTo) <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * ��������ȡ���ڼ�
	 * 
	 * @param �꣬�£���
	 * @return ������������ 1�������գ�2������һ��3�����ڶ���4����������5�������ģ�6�������壻7����������
	 * @exception �쳣����
	 */
	public static int getWeekValue(int year, int month, int day) {
		// ʵ����Calendar
		Calendar now = Calendar.getInstance();
		// ����ĳ��ĳ��ĳ�յĲ���
		now.set(Calendar.YEAR, year);
		now.set(Calendar.MONTH, month - 1);
		now.set(Calendar.DATE, day);
		return now.get(Calendar.DAY_OF_WEEK);
	}

	public enum DateFormatType {
		/**
		 * ��ʽΪ��yyyy-MM-dd HH:mm:ss
		 */
		DATE_FORMAT_STR("yyyy-MM-dd HH:mm:ss"),
		/**
		 * ��ʽΪ��yyyyMMddHHmmss
		 */
		SIMPLE_DATE_TIME_FORMAT_STR("yyyyMMddHHmmss"),

		/**
		 * ��ʽΪ��yyyy-MM-dd
		 */
		SIMPLE_DATE_FORMAT_STR("yyyy-MM-dd"),

		/**
		 * ��ʽΪ��yyyy/MM/dd
		 */
		SIMPLE_DATE_FORMAT_VIRGULE_STR("yyyy/MM/dd"),

		/**
		 * ��ʽΪ��HH:mm:ss
		 */
		HOUR_MINUTE_SECOND("HH:mm:ss"),

		/**
		 * ��ʽΪ��HH:mm
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
	 * ��ȡ��ǰʱ�����ڵ��ַ���
	 */
	public static String getCurrentDateStr(DateFormatType dateFormatType) {
		Date date = getCurrentDate();
		return (String) OpearationDate(date, dateFormatType.getValue());
	}

	/**
	 * ʱ�䡢���ڸ�ʽ�����ַ���
	 */
	public static String formatDate(Date date, DateFormatType dateFormatType) {
		return (String) OpearationDate(date, dateFormatType.getValue());
	}

	/**
	 * ���ַ���������ʱ�䡢����
	 */
	public static Date parseDate(String dateStr, DateFormatType dateFormatType) {
		return (Date) OpearationDate(dateStr, dateFormatType.getValue());
	}

	/**
	 * ��ȡ��ǰϵͳʱ��(ԭʼ��ʽ)
	 */
	public static Date getCurrentDate() {
		Date date = new Date(System.currentTimeMillis());
		return date;
	}

	/**
	 * ��ȡ��ǰ���ڵ��ꡢ�¡��ա�ʱ���֡���
	 */
	public static int getCurrentTime(TimeFormatType timeFormatType) {
		return getTime(getCurrentDate(), timeFormatType);
	}

	/**
	 * ��ȡָ�����ڵ��ꡢ�¡��ա�ʱ���֡���
	 */
	public static int getTime(Date date, TimeFormatType timeFormatType) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			int type = timeFormatType.getValue();
			int i = c.get(type);
			return type == 2 ? i + 1 : i;
		} catch (Exception e) {
			throw new RuntimeException("��ȡʧ��", e);
		}
	}

	/**
	 * ��ȡָ�����ڵĺ�����
	 */
	public static long getMillis(Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * ������ӡ�������
	 * 
	 * �����ؽ����λΪ:����
	 */
	public static int operationDate(Date date, Date diffDate,
			DateOperationType dateOperationType) {
		long add = getMillis(date) + getMillis(diffDate);
		long diff = getMillis(date) - getMillis(diffDate);
		return (int) ((dateOperationType.getValue() ? add : diff) / (24 * 3600 * 1000));
	}

	/**
	 * �����·���ӡ�������
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
	 * ����������ӡ�������
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
			throw new RuntimeException("��������Ϊ��");
		}
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		try {
			if (object instanceof Date)
				return format.format(object);
			else
				return format.parse(object.toString());
		} catch (Exception e) {
			throw new RuntimeException("����ʧ��", e);
		}

	}

	public enum DateOperationType {

		/**
		 * �Ӳ���
		 */
		ADD(true),

		/**
		 * ������
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
	 * ���ؽ���ĸ�ʽΪyyyy-MM-dd������String
	 * 
	 * @return String
	 */
	public static String date_today() {
		return convertDateToString(new Date(), pattern10);
	}

	/**
	 * ���ؽ�����Զ����ʽ����String �硡yyyy-MM-dd HH:mm:ss
	 * 
	 * @return String
	 */
	public static String date_today(String pattern) {
		return convertDateToString(new Date(), pattern);
	}

	/**
	 * ��dateת�����ִ�
	 * 
	 * @param date
	 *            Date
	 * @param pattern
	 *            String ���ڸ�ʽ���磺yyyy-MM-dd hh:mm:ss����yyyy/MM/dd ��
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
	 * ���ϵͳ��ǰʱ��
	 * 
	 * @return Date ��ǰʱ��
	 */
	public static String getNowTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(pattern19);
		String nowTime = formatter.format(cal.getTime());
		return nowTime;
	}

	/**
	 * ���ϵͳ��ǰ����
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
	 * ��õ�ǰ���ڵ�������ʱ�� �磺200511091212
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
	 * ��õ�ǰ���ڵ�������ʱ���� �磺20051109121212
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
	 * ��õ�ǰ���ڵ������� �磺20051109
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
	 * ��õ�ǰ���ڵ����� �磺200511
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
	 * �������ʽ�������������
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
	 * ���ָ��������ǰ���Ӻ��������ַ���
	 * 
	 * @param dateString
	 *            ����������ַ���
	 * @param beforeDays
	 *            ��ǰ���Ӻ�����
	 * @param pattern
	 *            ���ڸ�ʽ
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
	 * ���ָ��������ǰ���Ӻ��·ݵ��ַ���
	 * 
	 * @param dateString
	 *            ����������ַ���
	 * @param beforeDays
	 *            ��ǰ���Ӻ�����
	 * @param pattern
	 *            ���ڸ�ʽ
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
	 * ��������
	 * 
	 * @param date
	 *            ����
	 * @return int ����
	 */
	public static int getSecond(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.SECOND);
	}

	/**
	 * ���ط���
	 * 
	 * @param date
	 *            ����
	 * @return int ����
	 */
	public static int getMinute(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.MINUTE);
	}

	/**
	 * ����Сʱ
	 * 
	 * @param date
	 *            ����
	 * @return int Сʱ
	 */
	public static int getHour(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.HOUR_OF_DAY);
	}

	/**
	 * �����·�
	 * 
	 * @param date
	 *            ����
	 * @return int �·�
	 */
	public static int getMonth(java.util.Date date) {
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(java.util.Calendar.MONTH) + 1;
	}

	/**
	 * �������
	 * 
	 * @param date
	 *            ����
	 * @return int ���
	 */
	public static int getYear(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.YEAR);
	}

	/**
	 * �����ڸ�ʽ��Ϊ�����ַ�����yyyy-MM-dd hh:mm:ss��
	 * 
	 * @param date
	 *            ����
	 * @param format
	 *            ��ʽ��yyyy-MM-dd hh:mm:ss��
	 * @return String �ַ�������
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
	 * ����ָ����ʽ�������ַ���ת��Ϊ�������ͣ�"yyyy-MM-dd"��
	 * 
	 * @param dateStr
	 *            �ַ�������
	 * @param format
	 *            ��ʽ��"yyyy-MM-dd"��
	 * @return Date ����
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
	 * ���ַ�������ת��Ϊ���ڣ�"yyyy-MM-dd HH:mm:ss"��
	 * 
	 * @param dateStr
	 *            �ַ�������
	 * @return Date ����
	 */
	public static java.util.Date parseTime(String dateStr) {
		return parseDate(dateStr, "yyyy-MM-dd HH:mm:ss");
	}

	public static boolean isNum(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * ���������·ݲ����һ����
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
	 * ��һλ����ת�ɴ�'0'���ַ���������ʱ���ʽ��ƴ��
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
	 * �ж�������ַ����Ƿ����yyyymm�ĸ�ʽ
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
