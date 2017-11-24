package com.sunrise.pub.tools;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
		Pattern pattern = Pattern.compile("([1-9]+[0-9]*|0)");
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
	
	public static void main(String[] args) throws Exception{
		
//		Date d1 = PublicUtils.UtilStrToDate("2010-05-24 12:00:22");
//		Date d2 = PublicUtils.UtilStrToDate("2010-05-25 12:02:00");
//		System.out.println(PublicUtils.compareMinute(d1, d2));
		
//		Date[] result = getMonthPeriod(new Date(),6);
//		Date[] result = getDatePeriod(new Date(),0,true);
//		System.out.println(PublicUtils.formatUtilDate(result[0], "yyyy-MM-dd HH:mm:ss"));
//		System.out.println(PublicUtils.formatUtilDate(result[1], "yyyy-MM-dd HH:mm:ss"));
		System.out.println(PublicUtils.checkDateTime(2, "20110731", "", ":", " "));
	}

}
