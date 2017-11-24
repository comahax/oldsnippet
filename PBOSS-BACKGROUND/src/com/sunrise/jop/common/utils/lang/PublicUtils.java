package com.sunrise.jop.common.utils.lang;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * User: JinBo Date: 2006-4-6 Time: 11:27:00
 */
public class PublicUtils {

	/**
	 * ��java.sql.Date���͵�����ת��Ϊyyyy-MM-dd��ʽ�����ַ��� ע��ֻ������
	 * 
	 * @author mys
	 */
	public static String sqlDateToStr(java.sql.Date date) {
		return formatSqlDate(date, "yyyy-MM-dd");
	}

	/**
	 * ��java.sql.Date���͵�����ת��Ϊpattern��ʽ�������ַ���
	 * 
	 * @author mys
	 */
	public static String formatSqlDate(java.sql.Date date, String pattern) {
		if (date == null)
			return "";
		DateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * ��yyyy-MM-dd��ʽ�������ַ���ת��Ϊjava.sql.Date����
	 * 
	 * @author mys
	 * @throws Exception
	 */
	public static java.sql.Date strToSqlDate(String datetime) throws Exception {
		return strToSqlDate(datetime, "yyyy-MM-dd");
	}

	/**
	 * ��pattern��ʽ�������ַ���ת��Ϊjava.sql.Date����
	 * 
	 * @author mys
	 * @throws Exception
	 */
	public static java.sql.Date strToSqlDate(String datetime, String pattern)
			throws Exception {
		java.sql.Date result = null;
		try {
			if ((datetime != null) && (datetime.length() > 0)) {
				SimpleDateFormat format = new SimpleDateFormat(pattern);
				result = new java.sql.Date(format.parse(datetime).getTime());
			}
		} catch (Exception exp) {
			throw new Exception("have a NG date format");
		}
		return result;
	}

	/**
	 * ��java.utils.Date���͵�����ת��Ϊ��yyyy-MM-dd HH:mm:ss" ��ʽ�����ַ���<br>
	 * ע��ֻ�����ڣ�ʱ���֣���Ϊ��
	 */
	public static String utilDateToStr(java.util.Date date) {
		return formatUtilDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * ��java.utils.Date���͵�����ת��Ϊpattern��ʽ�������ַ���
	 */
	public static String formatUtilDate(java.util.Date date, String pattern) {
		if (date == null)
			return "";
		DateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * xqy ����yyyy-MM-dd HH:mm:ss"��ʽ�������ַ���ת��Ϊjava.utils.Date����
	 * 
	 * @throws Exception
	 */
	public static java.util.Date UtilStrToDate(String datetime)
			throws Exception {
		return UtilStrToDate(datetime, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * xqy ��pattern��ʽ�������ַ���ת��Ϊjava.utils.Date����
	 * 
	 * @throws Exception
	 */
	public static java.util.Date UtilStrToDate(String datetime, String pattern)
			throws Exception {
		java.util.Date result;
		try {
			if ((datetime != null) && (datetime.length() > 0)) {
				SimpleDateFormat format = new SimpleDateFormat(pattern);
				result = format.parse(datetime);
			} else {
				result = null;
			}
		} catch (Exception exp) {
			// ָ���������ַ�����ʽ����
			throw new Exception("have a NG date format");
		}
		return result;
	}

	/**
	 * ������ǿ��ת��Ϊ�ַ��������򷵻�""
	 */
	public static String objToStr(Object obj) {
		if (obj != null)
			return obj.toString();
		return "";
	}

	/**
	 * �Ƚ��������������ٸ��£���d2 - d1
	 */
	public static int compareMonth(java.util.Date d1, java.util.Date d2) {
		java.util.Calendar c1 = java.util.Calendar.getInstance();
		c1.setTime(d1);
		java.util.Calendar c2 = java.util.Calendar.getInstance();
		c2.setTime(d2);
		// int m1 = c1.get(java.utils.Calendar.YEAR) * 12 +
		// c1.get(java.utils.Calendar.MONTH);
		// int m2 = c2.get(java.utils.Calendar.YEAR) * 12 +
		// c2.get(java.utils.Calendar.MONTH);

		return (c1.get(java.util.Calendar.YEAR) - c2
				.get(java.util.Calendar.YEAR))
				* 12
				+ (c1.get(java.util.Calendar.MONTH) - c2
						.get(java.util.Calendar.MONTH));
	}
	/**
	 * �Ƚ����������������죬��d2 - d1
	 */
	public static int compareDate(java.util.Date d1, java.util.Date d2) {

		return (int)((d2.getTime()-d1.getTime())/(1000*60*60*24));
	}
	/**
	 * �Ƚ��������������ٷ��ӣ���d2 - d1
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double compareMinute(java.util.Date d1, java.util.Date d2) {
		
		return ((double)d2.getTime()-(double)d1.getTime())/(1000*60);
	}

	/**
	 * �Ƚ��������������ٸ��£���d2 - d1
	 * 
	 * @author mys
	 */
	public static int compareMonth(java.sql.Date d1, java.sql.Date d2) {
		java.util.Calendar c1 = java.util.Calendar.getInstance();
		c1.setTime(d1);
		java.util.Calendar c2 = java.util.Calendar.getInstance();
		c2.setTime(d2);

		return (c1.get(java.util.Calendar.YEAR) - c2
				.get(java.util.Calendar.YEAR))
				* 12
				+ (c1.get(java.util.Calendar.MONTH) - c2
						.get(java.util.Calendar.MONTH));
	}

	/**
	 * ��֤Ŀ���ַ����Ƿ�����
	 * <p>
	 * PublicUtils.isInteger(null) = false
	 * <p>
	 * PublicUtils.isInteger("") = false
	 * <p>
	 * PublicUtils.isInteger(" ") = false
	 * <p>
	 * PublicUtils.isInteger("02007") = false
	 * <p>
	 * PublicUtils.isInteger("2 007") = false
	 * <p>
	 * PublicUtils.isInteger(" 2007 ") = true
	 * <p>
	 * 
	 * @param str
	 *            Ҫ��֤���ַ���
	 * @return
	 */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("-{0,1}([1-9]+[0-9]*|0)");
		Matcher matcher = pattern.matcher(org.apache.commons.lang.StringUtils
				.trimToEmpty(str));
		return matcher.matches();
	}
	
	/**
	 * ��֤Ŀ���ַ����Ƿ�����
	 * <p>
	 * PublicUtils.isInteger(null) = false
	 * <p>
	 * PublicUtils.isInteger("") = false
	 * <p>
	 * PublicUtils.isInteger(" ") = false
	 * <p>
	 * PublicUtils.isInteger("02007") = true
	 * <p>
	 * PublicUtils.isInteger("2 007") = false
	 * <p>
	 * PublicUtils.isInteger(" 2007 ") = true
	 * <p>
	 * 
	 * @param str
	 *            Ҫ��֤���ַ���
	 * @return
	 */
	public static boolean isIntegerWithZero(String str) {
		Pattern pattern = Pattern.compile("([0-9]+)");
		Matcher matcher = pattern.matcher(org.apache.commons.lang.StringUtils
				.trimToEmpty(str));
		return matcher.matches();
	}

	/**
	 * ��֤Ŀ���ַ����Ƿ�С��
	 * 
	 * @param str
	 *            Ҫ��֤���ַ���
	 * @param scale
	 *            ���ȣ���С�����λ
	 * @param maximum
	 *            ���ֵ��С��maxinum��
	 * @return
	 */
	public static boolean isDecimal(String str, int scale, double maximum) {
		Pattern pattern = Pattern.compile("([1-9]+[0-9]*|0)(\\.[0-9]{1,"
				+ scale + "}|)");
		Matcher matcher = pattern.matcher(org.apache.commons.lang.StringUtils
				.trimToEmpty(str));
		return matcher.matches() && Double.parseDouble(str) <= maximum;
	}

	/**
	 * ���ڽ�Сд���ת���ɴ�д���������Ϊ��
	 * @param value
	 * @return
	 * @see #changeToBig(String)
	 */
	public static String changeToBig(Double value) {
		DecimalFormat df = new DecimalFormat("#.00");
		return changeToBig(df.format(value));
	}

	/**
	 * ���ڽ�Сд���ת���ɴ�д���������Ϊ��
	 * 
	 * @param value
	 *            Сд����ȷ��С�������λ��
	 * @return ��д���
	 * @throws IllegalArgumentException
	 *             ���������Ϊ�ջ��߲�����Ч��������ʱ���׳�������
	 */
	public static String changeToBig(String value) {

		// У�����value��������Ϊ��
		if (org.apache.commons.lang.StringUtils.isBlank(value)) {
			throw new IllegalArgumentException("���뷽�� PublicUtils.changeToBig("
					+ "String value)�Ĳ���������Ϊ�գ�" + value + "��");
		}

		// У�����value���ȼ����ֵ����������ָ����ֵ
		double max = 9999999999d;
		if (!isDecimal(value, 2, max)) {
			throw new IllegalArgumentException("���뷽�� PublicUtils.changeToBig("
					+ "String value)�Ĳ���������Ч���֣�" + value + "��");
		}

		// ������valueת��Ϊ��ʮ���ƣ���ֹ��ֵת��ʱ��������������
		BigDecimal d = new BigDecimal(value);
		BigDecimal d2 = new BigDecimal("100");

		// ������ض��ڣ����������ַ���
		char[] hunit = { 'ʰ', '��', 'Ǫ' };
		char[] vunit = { '��', '��' };
		char[] digit = { '��', 'Ҽ', '��', '��', '��', '��', '½', '��', '��', '��' };
		long midVal = 0;
		String valStr = "";
		String head = "";
		String rail = "";

		// ��ֻ��С�����ֽ������⴦��
		if (d.compareTo(new BigDecimal("1")) < 0) {
			head = "0";
			rail = d.multiply(new BigDecimal("100")).compareTo(
					new BigDecimal("10")) < 0 ? "0"
					+ (d.multiply(d2).toString()) : d.multiply(d2).toString();
		} else {
			midVal = d.multiply(new BigDecimal("100")).longValue();
			valStr = String.valueOf(midVal);
			head = valStr.substring(0, valStr.length() - 2);
			rail = valStr.substring(valStr.length() - 2);
		}

		String prefix = "";
		String suffix = "";

		// ����С������
		if (rail.equals("00")) {
			suffix = "��";
		} else {
			suffix = digit[rail.charAt(0) - '0'] + "��"
					+ digit[rail.charAt(1) - '0'] + "��";
		}

		// ������������
		char[] chDig = head.toCharArray();
		char zero = '0';
		byte zeroSerNum = 0;

		// ����������ѭ������
		for (int i = 0; i < chDig.length; i++) {
			int idx = (chDig.length - i - 1) % 4;
			int vidx = (chDig.length - i - 1) / 4;

			// ��Σ�����ʮ��ǧΪһ���Σ������ڵ���ĸ�������1��Ҳֻ��ʾһ����
			if (chDig[i] == '0') {
				zeroSerNum++;
				if (zero == '0') {
					zero = digit[0];
				}
				if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
					prefix += vunit[vidx - 1];
					zero = '0';
				}
				continue;
			}
			zeroSerNum = 0;
			if (zero != '0') {
				prefix += zero;
				zero = '0';
			}
			prefix += digit[chDig[i] - '0'];
			if (idx > 0)
				prefix += hunit[idx - 1];
			if (idx == 0 && vidx > 0) {
				prefix += vunit[vidx - 1];
			}
		}

		if (prefix.length() > 0)
			prefix += 'Բ';
		return prefix + suffix;
	}
	
	/**
	 * ����������С��ת�����ַ���
	 * @param value
	 * @return
	 * @see #changeToArray(String)
	 */
	public static char[] changeToArray(Double value) {
		DecimalFormat df = new DecimalFormat("#.00");
		return changeToArray(df.format(value));
	}

	/**
	 * ����������С��ת�����ַ���
	 * 
	 * @param value
	 *            ��ת������Ч����
	 * @return
	 * @throws IllegalArgumentException
	 *             ���������Ϊ�ջ��߲�����Ч��������ʱ���׳�������
	 */
	public static char[] changeToArray(String value) {
		if (org.apache.commons.lang.StringUtils.isBlank(value)) {
			throw new IllegalArgumentException(
					"���뷽�� PublicUtils.changeToArray("
							+ "String value)�Ĳ���������Ϊ�գ�" + value + "��");
		}
		if (!isDecimal(value, 2, 99999999)) {
			throw new IllegalArgumentException(
					"���뷽�� PublicUtils.changeToArray("
							+ "String value)�Ĳ���������Ч���֣�" + value + "��");
		}
		BigDecimal d = new BigDecimal(value);
		long midVal = d.multiply(new BigDecimal("100")).longValue();
		String tmp = String.valueOf(midVal);
		char[] chs = tmp.toCharArray();
		return chs;
	}

	/**
	 * @param year
	 * @param month
	 * @return ����ָ�����µĿ�ʼʱ�� ��yyyy-MM-dd 00:00:00��
	 */
	public static String getMonthBegin(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		return formatUtilDate(calendar.getTime(), "yyyy-MM-dd") + " 00:00:00";
	}

	/**
	 * @param year
	 * @param month
	 * @return ����ָ�����µĽ���ʱ�� ��yyyy-MM-dd 23:59:59��
	 */
	public static String getMonthEnd(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, 0);
		return formatUtilDate(calendar.getTime(), "yyyy-MM-dd") + " 23:59:59";
	}
	
	/**
	 * @param year
	 * @param month
	 * @param someTime:����ʱ���
	 * @return ����ָ�����µľ���ʱ�� ��yyyy-MM-dd someTime��yyyy-MM-dd 09:00:00
	 */
	public static String getMonthSomeTime(int year, int month,String someTime) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, calendar.get(Calendar.DATE));
		return formatUtilDate(calendar.getTime(), "yyyy-MM-dd") + " " + someTime;
	}
	
	/**
	 * ��ȡָ��ʱ��ǰ����ľ���ʱ��
	 * @param date
	 * @param interval
	 * @param timePoint��ʱ��� ��9��ֻ��ʾСʱ
	 * @return
	 * @throws Exception
	 */
	public static java.util.Date getPreOrAfterDate(java.util.Date date,int interval,int timePoint) throws Exception {
		Calendar cal = Calendar.getInstance();
		Date startDate = getDatePeriod(date, interval)[0];
		cal.setTime(startDate);
		cal.set(Calendar.HOUR_OF_DAY, timePoint);
		return cal.getTime();
	}
	
	/**
	 * ��õ�ǰ��������
	 * 
	 * @return valBillCyc ��ǰ��Ч�������� add by xff
	 */
	public static Long getCurBillCyc() {
		Calendar cal = Calendar.getInstance();
		String curdate = PublicUtils.formatUtilDate(cal.getTime(),
				"yyyyMMdd HH:mm:ss");
		String billcyc = curdate.substring(0, 6) + "00";
		Long valBillCyc = null;
		if (billcyc != null && !"".equals(billcyc)) {
			valBillCyc = new Long(billcyc);
		}
		return valBillCyc;
	}
	
	/**
	 * ���ӵ���ʱ������ڼ���֧��,�޸�JDK��SimpleDataFormat.parse������[20081301]�������ݵ�ͨ��
	 * ����������ж�Ҳ�м����ڷ�������,ʱ����1000-01-01 00:00:00��9999-12-31 23:59:59
	 * @param s
	 * @return
	 * @author linli
	 */
	public static boolean checkDateTime(String s){
		return checkDateTime(4, s, "-", ":", " ");
	}
	
	/**
	 * ���ӵ���ʱ������ڼ���֧��,�޸�JDK��SimpleDataFormat.parse������[20081301]�������ݵ�ͨ��
	 * ����������ж�Ҳ�м����ڷ�������,ʱ����1000-01-01 00:00:00��9999-12-31 23:59:59
	 * @param type<br>
	 *   ���� 1 ֧�ֵ�����ʽyyyy-MM,��2009-01<br>
	 *   ���� 2 ֧�ֵ�����ʽyyyy-MM-dd,��2009-01-01<br>
	 *   ���� 3 ֧�ֵ�����ʽHH:mm:ss,��00:00:00<br>
	 *   ���� 4 ֧�ֵ�����ʽyyyy-MM-dd HH:mm:ss,��2009-01-01 00:00:00<br>
	 * @param s
	 * @return
	 * @author linli
	 */
	public static boolean checkDateTime(int type, String s){
		return checkDateTime(type, s, "-", ":", " ");
	}
	
	/**
	 * ���ӵ���ʱ������ڼ���֧��,�޸�JDK��SimpleDataFormat.parse������[20081301]�������ݵ�ͨ��
	 * ����������ж�Ҳ�м����ڷ�������,ʱ����1000-01-01 00:00:00��9999-12-31 23:59:59
	 * @param type<br>
	 *   ���� 1 ֧�ֵ�����ʽyyyy-MM,��2009-01<br>
	 *   ���� 2 ֧�ֵ�����ʽyyyy-MM-dd,��2009-01-01<br>
	 *   ���� 3 ֧�ֵ�����ʽHH:mm:ss,��00:00:00<br>
	 *   ���� 4 ֧�ֵ�����ʽyyyy-MM-dd HH:mm:ss,��2009-01-01 00:00:00<br>
	 * @param s
	 * @param datePrefix
	 * 	 ��������֮��ķָ��� Ĭ�� -
	 * @param timePrefix
	 * 	 ����ʱ��֮��ķָ��� Ĭ�� :
	 * @param blank
	 * 	 ����������ʱ��֮��ķָ��� Ĭ�� �ո�
	 * @return
	 * @author linli
	 */
	public static boolean checkDateTime(int type, String s, String datePrefix, String timePrefix, String blank){
		
		if(null == datePrefix)datePrefix="";
		if(null == timePrefix)timePrefix="";
		if(null == blank)blank="";
		
		StringBuffer regex = new StringBuffer();
		switch(type){
			case 1:
				regex.append("([1-9][0-9]{3}").append(datePrefix).append("[0][1-9])").	//���ǰ9����
					append("|").
					append("([1-9][0-9]{3}").append(datePrefix).append("[1][0-2])");	//�����3����
				break;
			case 2:
				regex.append("(").
							append("([1-9][0-9]{3})").append(datePrefix).
							append("(").
								append("((0[13578]|1[02])").append(datePrefix).append("(0[1-9]|[12][0-9]|3[01]))").  //1 3 5 7 8 10 12��Ϊ31��
								append("|").
								append("((0[469]|11)").append(datePrefix).append("(0[1-9]|[12][0-9]|30))").		//4 6 9 11��Ϊ30��
								append("|").
								append("(02").append(datePrefix).append("(0[1-9]|[1][0-9]|2[0-8]))").	//Ĭ���������2��Ϊ28��
							append(")").
					  append(")").
					  append("|").
					  append("((([1-9][0-9])(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))").append(datePrefix).append("02").append(datePrefix).append("29)");   //���������Ϊ29��
				break;
			case 3:
				regex.append("((20|21|22|23|[0-1]?\\d)").append(timePrefix).append("[0-5]?\\d").append(timePrefix).append("[0-5]?\\d)");
				break;
			case 4:
				String date = s.substring(0, 8 + 2 * datePrefix.length());
				String time = s.substring(8 + 2 * datePrefix.length() + blank.length());
				return checkDateTime(2, date, datePrefix, timePrefix, blank) && checkDateTime(3, time, datePrefix, timePrefix, blank) ;
			default:
				return false;
		}
		
		Pattern p = Pattern.compile(regex.toString());
		Matcher m = p.matcher(s);
		return m.matches();
	}

	 /**
	 * ȡ��ָ��ʱ�����һ���µ�ʱ�䷶Χ
	 * @param date ����
	 * @return �������ڵ��ϸ��µ�ʱ�䷶Χ��ʽ(yyyyMMdd) string[0]:���µ�һ��,string[1]:�������һ��
	 */
	public static String[] getLastMonthDay(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String[] resultDate = new String[2];
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);//����ָ���µĵ�һ��
		calendar.add(Calendar.DATE, -1);//���õ�ǰ���ڵ���һ��(�������һ��)
		resultDate[1] = format.format(calendar.getTime());
		calendar.set(Calendar.DAY_OF_MONTH, 1);//����ָ���µĵ�һ��
		resultDate[0] = format.format(calendar.getTime());
		return resultDate;
	}
	
	/**
	 * ��ȡָ���·ݵĵ�һ�죬 ʱ����Ϊ0ʱ0��0��
	 * @param month
	 * @return
	 */
	public static java.util.Date getFirstDateOfMonth(Calendar month) {
		Calendar firstDayCal = Calendar.getInstance();
		firstDayCal.set(Calendar.YEAR,month.get(Calendar.YEAR));
		firstDayCal.set(Calendar.MONTH, month.get(Calendar.MONTH));
		firstDayCal.set(Calendar.DAY_OF_MONTH,month.getActualMinimum(Calendar.DAY_OF_MONTH));
		firstDayCal.set(Calendar.HOUR_OF_DAY, 0);
		firstDayCal.set(Calendar.MINUTE, 0);
		firstDayCal.set(Calendar.SECOND, 0);
		return firstDayCal.getTime();
	}
	
	/**
	 * ��ȡָ���·ݵ����һ�죬 ʱ����Ϊ23ʱ59��59��
	 * @param month
	 * @return
	 */
	public static java.util.Date getEndDateOfMonth(Calendar month) {
		Calendar endDayCal = Calendar.getInstance();
		endDayCal.set(Calendar.YEAR,month.get(Calendar.YEAR));
		endDayCal.set(Calendar.MONTH, month.get(Calendar.MONTH));
		endDayCal.set(Calendar.DAY_OF_MONTH,month.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDayCal.set(Calendar.HOUR_OF_DAY, 23);
		endDayCal.set(Calendar.MINUTE, 59);
		endDayCal.set(Calendar.SECOND, 59);
		return endDayCal.getTime();
	}
	/**
	 * ��ȡָ�����ڵĳ�ʼʱ����߽���ʱ��  
	 * @param type<br>
	 * 	����0 ����ȡ��ʼʱ�� 00:00:00<br>
	 *  ����1�� ��ȡ����ʱ�� 23:59:59<br>
	 * @param cal ָ�����ڣ���Ϊnull��Ĭ��ȡ��ǰ����
	 * @return
	 */
	public static java.util.Date getFirstTimeOrEndTimeOfDate(int type,Calendar cal) {
		
		if(cal == null) cal =Calendar.getInstance();
		switch(type) {
			case 0:
				cal.set(Calendar.HOUR_OF_DAY, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);
				return cal.getTime();
			case 1:
				cal.set(Calendar.HOUR_OF_DAY, 23);
				cal.set(Calendar.MINUTE, 59);
				cal.set(Calendar.SECOND, 59);
				return cal.getTime();
			default:
				return null;
		}
	}
	/**
	 * <pre>
	 * ��ȡָ��ʱ��date��
	 * 		ǰN����(intervalΪ������) 
	 * 		���N����(intervalΪ������)
	 * 		��ǰ��(intervalΪ0)
	 * ��ʱ�䷶Χ
	 * ��ע��������ָ���·�date�����統ǰ����Ϊ2010��7��15�գ�����NΪ6����ǰ������Ϊ2010��1��1����2010��6��30�գ�
	 * </pre>
	 * @param date
	 * @param interval
	 * @return
	 * @throws Exception
	 */
	public static java.util.Date[] getMonthPeriod(java.util.Date date,int interval) throws Exception {
		Calendar cal = Calendar.getInstance();
		
		java.util.Date[] resultDate = new java.util.Date[2];
		if(interval < 0) { // ��N����
			cal.setTime(date);
			cal.add(Calendar.MONTH,1);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			//��ʼʱ��
			resultDate[0] = cal.getTime();
			
			cal.setTime(date);
			cal.add(Calendar.MONTH, -interval);
			cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			//����ʱ��
			resultDate[1] = cal.getTime();
		}else { // ǰN����
			cal.add(Calendar.MONTH, -interval);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			// ��ʼʱ��
			resultDate[0] = cal.getTime();
			cal.setTime(date);
			if(interval > 0) {
				cal.add(Calendar.MONTH, -1);
			}
			cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			// ����ʱ��
			resultDate[1] = cal.getTime();
		}
		
		return resultDate;
	}
	
	/**
	 * <pre>
	 * ��ȡָ��ʱ��date��
	 * 		ǰN��(intervalΪ������) 
	 * 		���N��(intervalΪ������)
	 * 		����(intervalΪ0)
	 * ��ʱ�䷶Χ
	 * ��������ָ������date�����統ǰ����Ϊ2010��7��15�գ�����NΪ2��
	 *  ��ʼʱ��Ϊ2010��7��13�� 0ʱ0��0��;����ʱ��Ϊ2010��7��14�� 23ʱ59��59�룩
	 *  </pre>
	 * @param date
	 * @param interval
	 * @return
	 * @throws Exception
	 */
	public static java.util.Date[] getDatePeriod(java.util.Date date,int interval) throws Exception {
		return getDatePeriod(date,interval,false);
	}
	
	/**
	 * <pre>
	 * ��ȡָ��ʱ��date��
	 * 		ǰN��(intervalΪ������) 
	 * 		���N��(intervalΪ������)
	 * 		����(intervalΪ0)
	 * ��ʱ�䷶Χ
	 * ��ע��includeSpecDate == false : ������ָ������date�����統ǰ����Ϊ2010��7��15�գ�����NΪ2��
	 *  ��ʼʱ��Ϊ2010��7��13�� 0ʱ0��0��;����ʱ��Ϊ2010��7��14�� 23ʱ59��59��
	 *  includeSpecDate == true : ����ָ������date�����統ǰ����Ϊ2010��7��15�գ�����NΪ2��
	 *  ��ʼʱ��Ϊ2010��7��14�� 0ʱ0��0��;����ʱ��2010��7��15�� 23ʱ59��59�� ��
	 *  </pre>
	 * @param date
	 * @param interval
	 * @param includeSpecDate �Ƿ���� ����date ָ��������
	 * @return
	 * @throws Exception
	 */
	public static java.util.Date[] getDatePeriod(java.util.Date date,int interval,boolean includeSpecDate) throws Exception {
		Calendar cal = Calendar.getInstance();
		java.util.Date[] resultDate = new java.util.Date[2];
		if(interval > 0) { // ǰinterval��
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_MONTH,
					includeSpecDate == true ? -interval + 1 : -interval);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			// ��ʼʱ��
			resultDate[0] = cal.getTime();
			
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_MONTH, includeSpecDate == true ? 0 : -1);
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			// ����ʱ��
			resultDate[1] = cal.getTime();
		}else {	// ��interval��
			cal.setTime(date);
			if(interval < 0 && includeSpecDate == false) {
				cal.add(Calendar.DAY_OF_MONTH, 1);
			}
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			// ��ʼʱ��
			resultDate[0] = cal.getTime();
			
			cal.setTime(date);
			if(interval < 0) {
				cal.add(Calendar.DAY_OF_MONTH, includeSpecDate == true ? -(interval+1) : -interval);
			}
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			// ����ʱ��
			resultDate[1] = cal.getTime();
		}
		return resultDate;
	}
	public static boolean checkWayid(String str) throws Exception {
		String strCheck="[a-zA-Z][a-zA-z0-9-]{0,18}";
		return str.matches(strCheck);
	}
	public static void main(String[] args) throws Exception{
		
//		Date d1 = PublicUtils.UtilStrToDate("2010-05-24 12:00:22");
//		Date d2 = PublicUtils.UtilStrToDate("2010-05-25 12:02:00");
//		System.out.println(PublicUtils.compareMinute(d1, d2));
		
//		Date[] result = getMonthPeriod(new Date(),6);
		Date[] result = getDatePeriod(new Date(),0,true);
		System.out.println(PublicUtils.formatUtilDate(result[0], "yyyy-MM-dd HH:mm:ss"));
		System.out.println(PublicUtils.formatUtilDate(result[1], "yyyy-MM-dd HH:mm:ss"));
		Calendar calendar = Calendar.getInstance();
		String t2 = utilDateToStr(getPreOrAfterDate(new Date(), -1, 23));
		String t1 = getMonthSomeTime(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, "0:00:00");
		System.out.println(t2+"========="+t1);
		System.out.println(compareDate(UtilStrToDate(t1), UtilStrToDate(t2)));
	}
}
