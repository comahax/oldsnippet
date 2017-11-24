package com.asisinfo.common;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 
 * <p>
 * Title: �й��ƶ��㶫ʡ�ƶ���˾BOSSϵͳ
 * </p>
 * 
 * <p>
 * Description:�ṩ�������õķ���
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company: Sunrise Electronics Development Co., LTD
 * </p>
 * 
 * @author chenhm
 * @version 1.0
 */
public class Tools {
	private static Logger logger = Logger.getLogger(Tools.class);
	/**
	 * ����������Կͻ��˴��͹����ľ���URLEncoding������ַ���н���
	 * 
	 * @param is InputStream ����������Ӧ��JSP��request.getInputStream()
	 * @return String ���ؽ���֮����ַ�
	 */
	public static String unEscape(InputStream is) {
		int firstchar, secondchar, thirdchar, fourthchar, fifthchar, sixthchar, actualchar;
		int char1, char2, char3, char4;
		StringBuffer sb = new StringBuffer();
		try {
			while ((firstchar = is.read()) != -1) { // read����ÿ�ζ�ȡһ���ֽ�(byte)��-1��ʾ����
				if (firstchar != 37) // %
				{ // �������%��ͷ��˵��û��ת�룬ֱ�ӱ��浽�ַ����鼴�ɡ�
					sb.append((char) firstchar);
				}
				else { // ˵����Ҫת�룬��ȡ�ڶ����ַ��Ƿ�Ϊu���༴�Ƿ���Unicode
					secondchar = is.read();
					if (secondchar != 117) // u
					{ // ��ASCII��ֻ��Ҫȡ%����λ
						if (secondchar < 58) {
							char1 = secondchar - 48;
						}
						else { //
							char1 = secondchar - 55;
						}
						thirdchar = is.read();
						if (thirdchar < 58) {
							char2 = thirdchar - 48;
						}
						else {
							char2 = thirdchar - 55;
						}
						actualchar = (char) (char1 << 4 | char2);
						sb.append((char) actualchar);
					}
					else { // ��Unicode����Ҫȡ%u����λ
						thirdchar = is.read();
						fourthchar = is.read();
						fifthchar = is.read();
						sixthchar = is.read();
						if (thirdchar < 58) {
							char1 = thirdchar - 48;
						}
						else {
							char1 = thirdchar - 55;
						}
						if (fourthchar < 58) {
							char2 = fourthchar - 48;
						}
						else {
							char2 = fourthchar - 55;
						}
						if (fifthchar < 58) {
							char3 = fifthchar - 48;
						}
						else {
							char3 = fifthchar - 55;
						}
						if (sixthchar < 58) {
							char4 = sixthchar - 48;
						}
						else {
							char4 = sixthchar - 55;
						}
						actualchar = (char) (char1 << 12 | char2 << 8
								| char3 << 4 | char4);
						sb.append((char) actualchar);
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * ʵ��javascript��unescape
	 * 
	 * @param src String
	 * @return String
	 */
	public static String unescape(String src) {
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length());
		int lastPos = 0, pos = 0;
		char ch;
		while (lastPos < src.length()) {
			pos = src.indexOf("%", lastPos);
			if (pos == lastPos) {
				if (src.charAt(pos + 1) == 'u') {
					ch = (char) Integer.parseInt(
						src.substring(pos + 2, pos + 6), 16);
					tmp.append(ch);
					lastPos = pos + 6;
				}
				else {
					ch = (char) Integer.parseInt(
						src.substring(pos + 1, pos + 3), 16);
					tmp.append(ch);
					lastPos = pos + 3;
				}
			}
			else {
				if (pos == -1) {
					tmp.append(src.substring(lastPos));
					lastPos = src.length();
				}
				else {
					tmp.append(src.substring(lastPos, pos));
					lastPos = pos;
				}
			}
		}
		return tmp.toString();
	}

	/**
	 * ʵ��javascript�е�escape()�����������ı���Ϊ����%u4f7f��
	 * 
	 * @param src String
	 * @return String
	 *//*
	public static String escape(String src) {
		int i;
		char j;
		StringBuffer tmp = new StringBuffer();
		// tmp.ensureCapacity(src.length() * 6);

		for (i = 0; i < src.length(); i++) {

			j = src.charAt(i);

			if (Character.isDigit(j) || Character.isLowerCase(j)
					|| Character.isUpperCase(j)) {
				tmp.append(j);
			}
			else {
				if (j < 256) {
					tmp.append("%");
					if (j < 16) {
						tmp.append("0");
					}
					tmp.append(Integer.toString(j, 16));
				}
				else {
					tmp.append("%u");
					tmp.append(Integer.toString(j, 16));
				}
			}
		}
		return tmp.toString();
	}*/

	/**
	 * ��ָ���ķָ���ֿ��ַ�
	 * 
	 * @param str String Ҫ�ֿ����ַ�
	 * @param strpart String �ָ���
	 * @return String[] �����ַ�����
	 */
	public static String[] split(String str, String strpart) {
		if (str == null || strpart == null || str.length() == 0) {
			return new String[0];
		}
		String[] tmparr = null;
		String tmpstr = str;
		int partlen = strpart.length();
		int k = 0;
		if (str.length() > 0) {
			if (partlen <= 0) {
				tmparr = new String[1];
				tmparr[0] = str;
			}
			else {
				for (int strpos = 0; strpos >= 0; k++) {
					if (k == 0) {
						strpos = tmpstr.indexOf(strpart);
					}
					else {
						strpos = tmpstr.indexOf(strpart, strpos + partlen);
					}
				}
				tmparr = new String[k];

				int strpos = 0;
				int currentpos = 0;
				for (int i = 0; i < (k - 1); i++) {
					strpos = str.indexOf(strpart, currentpos);
					tmparr[i] = str.substring(currentpos, strpos);
					if (strpos >= 0) {
						currentpos = strpos + partlen;
					}
				}
				tmparr[k - 1] = str.substring(currentpos);
			}
		}

		return tmparr;
	}

	/**
	 * ��ָ���ķָ���ֿ��ַ�,������ɵ������е�Ԫ��trim.
	 * 
	 * @param str String
	 * @param strpart String
	 * @return String[]
	 */
	public static String[] splitTrim(String str, String strpart) {
		if (str == null || strpart == null || str.length() == 0) {
			return new String[0];
		}
		String[] tmparr = null;
		String tmpstr = str;
		int partlen = strpart.length();
		int k = 0;
		if (str.length() > 0) {
			if (partlen <= 0) {
				tmparr = new String[1];
				tmparr[0] = str;
			}
			else {
				for (int strpos = 0; strpos >= 0; k++) {
					if (k == 0) {
						strpos = tmpstr.indexOf(strpart);
					}
					else {
						strpos = tmpstr.indexOf(strpart, strpos + partlen);
					}
				}
				tmparr = new String[k];

				int strpos = 0;
				int currentpos = 0;
				for (int i = 0; i < (k - 1); i++) {
					strpos = str.indexOf(strpart, currentpos);
					tmparr[i] = str.substring(currentpos, strpos).trim();
					if (strpos >= 0) {
						currentpos = strpos + partlen;
					}
				}
				tmparr[k - 1] = str.substring(currentpos).trim();
			}
		}
		return tmparr;
	}

	// ��ȡ��ǰ���ڵ�YYYY-MM-DD HHMMSS�ַ�
	public static String getCurrentTimeString() {
		return new java.text.SimpleDateFormat("yyyy-MM-dd HHmmss").format(new java.util.Date());
	}

	public static String getDisScond(String start, String stop) {
		try {
			if (start != null && !start.equals("null") && !start.equals("")) {
				DateFormat df = DateFormat.getDateTimeInstance();
				long startTime = df.parse(start).getTime();
				long stopTime = 0;
				if (stop == null || stop.equals("null") || stop.equals("")) {
					stopTime = System.currentTimeMillis();
				}
				else {
					stopTime = df.parse(stop).getTime();
				}
				return String.valueOf((stopTime - startTime) / 1000);
			}
			else {
				return "";
			}
		}
		catch (Exception e) {
			return e.toString();
		}

	}

	public static String replace(String strSource, String strFrom, String strTo) {
		String strDest = "";
		if (strSource == null || strSource.length() == 0) {
			return strDest;
		}
		else {
			int intFromLen = strFrom.length();
			int intPos;
			while ((intPos = strSource.indexOf(strFrom)) != -1) {
				strDest += strSource.substring(0, intPos) + strTo;
				strSource = strSource.substring(intPos + intFromLen);
			}
			strDest = strDest + strSource;
		}
		return strDest;
	}

	public static String toHTMLStr(String str) {
		String value = "";
		value = replace(str, "&", "&amp;");
		value = replace(value, ">", "&gt;");
		value = replace(value, "<", "&lt;");
		value = replace(value, "\"", "&quot;");
		return value;
	}

	/**
	 * check if the string are composite of number character for example
	 * "-48594.94395" return true "454kdf.94" return false
	 * 
	 * @param str String
	 * 
	 * @return true or false
	 */
	static public boolean isNumberString(String str) {
		if (str == null || str.trim().length() == 0) {
			return true;
		}
		try {
			double t = Double.parseDouble(str);
		}
		catch (Exception e) {
			// System.out.println("it is not a number!");
			return false;
		}
		return true;
	}


	static public boolean isNullString(String str) {
		if (str == null || str.trim().length() == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		String ret = delDecimalVal("2.3");
		System.out.println(ret);
		ret = delDecimalVal("2.8");
		System.out.println(ret);
		// String tt = "strSource = strSource.substring(intPos + intFromLen);";
		// long ti = System.currentTimeMillis();
		// for (int i = 0; i < 1000000; i++)
		// {
		// split(tt, " ");
		// }
		// System.out.println(System.currentTimeMillis() - ti);
		// ti = System.currentTimeMillis();
		// for (int i = 0; i < 1000000; i++)
		// {
		// replace(tt, "str", "STR");
		// }
		// System.out.println(System.currentTimeMillis() - ti);
		// java.io.InputStream dd = new
		// ByteArrayInputStream("%D6%D0%CE%C4".getBytes());
		// System.out.println(unEscape(dd));
		//System.out.println(GetCurDate("yyyy-MM-dd HH:mm:ss"));
		//System.out.println(getCurrentTimeString());
		//System.out.println(StrToDate("20121601","yyyyMMdd"));
		//System.out.println(chk3Decimal("0.12"));
		
	}

	/**
	 * ���map���Ƿ����keyֵ��ͬ��valֵ��ͬ�ļ�¼
	 * 
	 * @param map
	 * @param key
	 * @param val
	 * @return
	 */
	public static boolean hasConflict(Map map, String key, String val) {
		Object old = map.get(key);
		if (old == null) {
			map.put(key, val);
			return false;
		}
		else {
			return !val.equals(old);
		}
	}

	/**
	 * ���map���Ƿ����keyֵ��ͬ��valֵ��ͬ�ļ�¼ ����val���飬�����Ǹ���Ԫ�ص�˳���磺01��02��02��01��Ϊ��ͬ
	 * 
	 * @param map
	 * @param key
	 * @param val ����
	 * @return
	 */
	public static boolean hasConflict(Map map, String key, String[] val) {
		String[] old = (String[]) map.get(key);
		if (old == null) {
			map.put(key, val);
			return false;
		}
		else {
			if (val.length != old.length)
				return true;
			else {
				Arrays.sort(val);
				Arrays.sort(old);
				return !Arrays.equals(val, old);
			}
		}
	}

	public static boolean ifArraysEqual(String[] array1, String[] array2) {
		if (array1 == null && array2 == null)
			return true;
		else if (array1 == null || array2 == null)
			return false;
		else if (array1.length != array2.length)
			return false;
		else {
			Arrays.sort(array1);
			Arrays.sort(array2);
			return Arrays.equals(array1, array2);
		}
	}

	/**
	 * ���map���Ƿ���key
	 * 
	 * @param map
	 * @param key
	 * @return
	 * @deprecated
	 */
	public static boolean containsKey(Map map, String key) {
		boolean contains = map.containsKey(key);
		if (!contains) {
			map.put(key, "");
		}
		return contains;
	}

	/**
	 * ���set���Ƿ���key
	 * 
	 * @param set
	 * @param key
	 * @return
	 */
	public static boolean containsKey(java.util.Set set, String key) {
		boolean contains = set.contains(key);
		if (!contains) {
			set.add(key);
		}
		return contains;
	}

	/**
	 * �ж�����ַ��Ƿ���ȫΪ����
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isChinese(String s) {
		return s.matches("^[\u4E00-\u9FA5]+$");
	}

	/**
	 * �����ַ�ʵ�ʵ�byte���ȣ����ں���ݿ��ֶγ��Ƚ��бȽ�
	 * 
	 * @param s
	 * @return
	 */
	public static int byteLength(String s) {
		s = s.replaceAll("[\u4E00-\u9FA5]", "##");
		return s.length();
	}

	/**
	 * ��format��ʽ�������ַ�strת��ΪDate
	 * 
	 * @param str String
	 * @param format String
	 * @return Date
	 */
	public static java.util.Date StrToDate(String str, String format) {
		try {
			return new SimpleDateFormat(format).parse(str);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * ��formatָ���ĸ�ʽ������ʱ��dtת��Ϊ�ַ� ���磺format=yyyyMMddHHmmssʱ���� 20060213113520
	 * format=yyyy-MM-dd HH:mm:ssʱ���� 2006-02-13 11:35:20
	 * 
	 * @param dt Date
	 * @param format String
	 * @return String
	 */
	public static String DateToStr(Date dt, String format) {
		if (dt == null)
			return "";
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateStr = formatter.format(dt);
		return dateStr;
	}

	/**
	 * ��ȡ������ǰ�������ڵĹ�ȥ���������
	 * 
	 * @param daycount ��Ҫ���ص�����
	 * @return yyyy-MM-dd��ʽ���ַ���ɵ�����
	 */
	public static String[] GetBeforeDate(int daycount, Date theDate) {
		String[] dates = new String[daycount];
		Calendar cal = Calendar.getInstance();
		cal.setTime(theDate);
		for (int i = 1; i <= daycount; i++) {
			Date dt = cal.getTime();
			String str = DateToStr(dt, "yyyy-MM-dd");
			dates[i - 1] = str;
			cal.add(Calendar.DATE, -1);
		}

		return dates;
	}

	/**
	 * ����:��ȡ�¸��µ�1��
	 * @param theDate
	 * @return
	 */
	public static java.util.Date getNextMonthFisrtDate(Date theDate){
		Calendar cal = Calendar.getInstance();
		cal.setTime(theDate);
		cal.add(Calendar.MONTH, 1);
		Date retDate = cal.getTime();
		String tmps = Tools.DateToStr(retDate, "yyyyMM") + "01";
		return StrToDate(tmps, "yyyyMMdd");
	}
	/**
	 * ��ȡ�����������ڵĹ�ȥ������
	 * 
	 * @param count ��Ҫ���ص�����
	 * @return YYYYMM��ʽ���ַ���ɵ�����
	 */
	public static String[] getBeforeMonth(int count) {
		String[] months = new String[count];
		java.util.Calendar cal = java.util.Calendar.getInstance();
		for (int i = 1; i <= count; i++) {
			java.util.Date dt = cal.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
			String str = formatter.format(dt);
			months[i - 1] = str;
			cal.add(java.util.Calendar.MONTH, -1);
		}
		return months;
	}

	/**
	 * �������ַ���Double�ͽ��бȽ�
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static int compareNumStr(String A, String B) {
		return compareNum(Double.valueOf(A),Double.valueOf(B));
	}

	/**
	 * ������Double����бȽ�
	 * @param a
	 * @param b
	 */
	public static int compareNum(Double A, Double B){    
		if(Math.abs( A.doubleValue() - B.doubleValue() ) < 0.000000000001 ){
	    	return 0;
		}else{
			return A.compareTo(B);
		}
	}

	
	/**
	 * �ж������ַ������ֵ�Ƿ����
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static boolean numEquals(String A, String B) {
		return compareNumStr(A, B) == 0;
	}

	/**
	 * �ж�һ���ַ��һ��Double�͵�����ֵ�Ƿ����
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static boolean numEquals(String A, Double B) {
		return compareNum(Double.valueOf(A),B) ==0;
	}
	
	/**
	 * �ж�����Double�͵�����ֵ�Ƿ����
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static boolean numEquals(Double A, Double B) {
		return compareNum(A,B) ==0;
	}	
	
	
	/**
	 * �ж�����Double�͵�����ֵ�Ƿ����<br/>
	 * �˷�������ת��Ϊ�ַ������Ƚϣ������������ֻ���Ƚ���ʾ�ַ�λ��<br/>
	 * Doubleת�ַ����鿴 {@link Double} ��� toString������0.1100 ת��Ϊ 0.11<br/>
	 *<br/> 
	 * numEquals(0.111,0.11,4) ����true<br/> 
	 * @param A
	 * @param B
	 * @param len �Ƚ���ʾ�ַ�ȣ�0.11��Ϊ4��0.1��Ϊ3
	 * @return
	 */
	public static boolean numEquals(Double A, Double B, int len) {
		String stri = Double.toString(A);
		String strj = Double.toString(B);
		boolean ret = StringUtils.equals(StringUtils.substring(stri, 0,len), StringUtils.substring(strj, 0,len));
		return ret;
	}

	/**
	 * �ж��ַ�A�Ƿ���X��Y�ķ�Χ֮��
	 * 
	 * @param A
	 * @param X
	 * @param Y
	 * @return
	 */
	public static boolean within(String A, String X, String Y) {
		return A.compareTo(X) >= 0 && A.compareTo(Y) <= 0;
	}

	/**
	 * �����
	 * 
	 * @param strInput
	 * @param intLen ����
	 * @param strPad �����ַ�
	 * @return
	 */
	public static String lpad(String strInput, int intLen, String strPad) {
		if (strInput == null)
			return "";

		int ilen = intLen - strInput.length();

		for (int i = 0; i < ilen; i++) {
			strInput = strPad + strInput;
		}

		return strInput;

	}
	
	/**
	 * �����
	 * 
	 * @param strInput
	 * @param intLen ����
	 * @param strPad �����ַ�
	 * @return
	 */
	public static String rpad(String strInput, int intLen, String strPad) {
		if (strInput == null)
			return "";

		int ilen = intLen - strInput.length();

		for (int i = 0; i < ilen; i++) {
			strInput += strPad;
		}

		return strInput;

	}	

	/**
	 * ��ȡָ��֮��ǰһ���ʱ��
	 * 
	 * @param start_time ָ��ʱ�� �磺2008-05-29 00:00:00
	 * @return ǰһ��ʱ�� �磺2008-05-28 23:59:59
	 */
	public static java.sql.Timestamp getLstScdStopTime(
			java.sql.Timestamp start_time) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(start_time);
		cl.add(Calendar.SECOND, -1);
		Timestamp stop_time = new java.sql.Timestamp(cl.getTime().getTime());

		return stop_time;
	}

	/**
	 * �����ַ��Ƿ�����ǰ׺�е�����һ��
	 * 
	 * @param test
	 * @param prefix
	 * @return
	 */
	public static boolean startsWithAny(String test, String[] prefix) {
		if (test == null)
			return false;
		for (int i = 0; i < prefix.length; i++) {
			if ((!isNullString(prefix[i])) && test.startsWith(prefix[i]))
				return true;
		}
		return false;
	}
	
	/**
	 * ����:��ȡ��ƶ���
	 * @param name
	 * @param length
	 * @return
	 */
	public static String getSubStrFromStart(String name, int length){
		if(name.length() < length){
			return name;
		}else{
			return name.substring( 0, length);
		}
	}
	
	/**
	 * ����:��ȡ��ƶ���(����ָ��byte����)
	 * @param name
	 * @param length
	 * @return
	 */
	public static String getByteSubStr(String name, int length){
		if(Tools.isNullString(name)){
			return "";
		}
		byte[] bytes = name.getBytes();
		
		int l = bytes.length;
		
		if(l < length ){
			return name;
		}else{
			return new String(bytes, 0, length);

		}
	}
	
	/**
	 * ����:������������ʱ���ִ�
	 * 
	 * @param dateStr
	 *            ʱ�� ��ʽ "yyyyMMddHHmmss"
	 * @param diff
	 *            ��������
	 * @return -ʱ�� ��ʽ "yyyyMMddHHmmss"
	 */
	public static String getDiffTime(String dateStr, int diff){
		Date dateValue = Tools.StrToDate(dateStr, "yyyyMMddHHmmss");
		Calendar cl = Calendar.getInstance();
		cl.setTime(new Timestamp(dateValue.getTime()));
		cl.add(Calendar.SECOND, diff);
		Date dateRet = new java.sql.Timestamp(cl.getTime().getTime());

		return DateToStr(dateRet, "yyyyMMddHHmmss");
	}	

	/**
	 * ����:����ʱ������һ�� ��"2008111229443" �򷵻� "20081113235959"
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getLastTimeOfDay(String dateStr){
		return dateStr.substring(0, 8) + "235959";
	}
	
	/**
	 * ����:����ʱ�����һ�� ��"20081113000000" �򷵻� "20081114000000"
	 * @param dateStr
	 * @return
	 */
	public static String getNextDay(String dateStr){
		try{
			Date date = new SimpleDateFormat("yyyyMMddHHmmss").parse(dateStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, 1);
			Date dateRet = new java.sql.Timestamp(cal.getTime().getTime());
			return DateToStr(dateRet, "yyyyMMddHHmmss");
		}catch(Exception e){
			return null;
		}
	}
	
	/**
	 * ����: �Ƚ�ʱ���ִ�
	 * @param str1
	 * @param str2
	 * @return	0 -���; -1  - str1<str2; 1 -str1>str2
	 */
	public static int compareDate(String str1, String str2){
		try {
		long date1 = Tools.StrToDate(str1, "yyyyMMddHHmmss").getTime(); 
		long date2 = Tools.StrToDate(str2, "yyyyMMddHHmmss").getTime();

        return (date1 == date2 ?  0 : // Values are equal
                (date1 < date2 ? -1 : // (-0.0, 0.0) or (!NaN, NaN)
                 1)); 
		}catch (Exception e) {
			return 99;
		}
	}
	/**
	 * ����: �Ƚ�ʱ�����Ϊ������Timestamp.equals(Object)�����У���object����timestampʱֱ�ӷ���false������
	 * @param d1
	 * @param d2
	 * @return	0 -���; -1  - d1<d2; 1 -d1>d2
	 */
	public static boolean equals(Date d1, Date d2){
		long date1 = d1.getTime(); 
		long date2 = d2.getTime();

        return date1 == date2 ;
	}
	
	 /**
     * ��ȡ��ǰ����
     * @return ��ʽ�Զ���
     */
    public static String GetCurDate(String format)
    {
    	SimpleDateFormat formatter = new SimpleDateFormat(format);
    	String curDate = formatter.format(new Date());		
		return curDate;    	
    }
    
	
	
	/**
	 * �Ƚ�dt�����Ƿ���day�����պ�
	 * @param day ���������պ�
	 * @param dt  ���ڣ���ʽYYYYMMDD��
	 * @return
	 */
	public static boolean compareWorkDate(int day,String dt){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		//hour�д�ľ������ڼ��ˣ��䷶Χ 1~7  
		//1=������ 7=��������������  
		
		int hour=cal.get(Calendar.DAY_OF_WEEK);  
		int iday = day;
		if(hour<=3){
			iday = day;
		}else if(hour==7){
			iday = day+1;
		}else{
			iday = day+2;
		}
		
		//��������Ϊָ��day�����պ�����ڣ�
		cal.add(Calendar.DATE, iday);
		Date workdt = cal.getTime();
		String wdt = Tools.DateToStr(workdt, "yyyyMMdd");
		
		long date1 = Tools.StrToDate(wdt+"000000","yyyyMMddHHmmss").getTime();
		long date2 = Tools.StrToDate(dt+"000000", "yyyyMMddHHmmss").getTime();
		
		if(date1>date2){
			return false;
		}else{
			return true;
		}
		
	}
	
	/**
	 * ����ָ��ʱ���ǰ1��
	 * modified by daiwen 2010-08-19 �˷���ʵ�ʷ��ص���ָ��ʱ��ǰһ������һ�룬��ǰһ���23:59:59
	 * modified by daiwen 2011-08-25 ���ִ˷������Ǳ�������ȡָ��ʱ���ǰһ�룬
	 * 						Ϊ�˱���ȱ�ݣ��޸Ĵ˷�����ʵ�֣�����ָ��ʱ���ǰһ��
	 * 
	 * @param dt	��ʽ��yyyy-MM-dd
	 * @return	��ʽ��yyyy-MM-dd HH:mm:ss
	 */
	public static Date getLastSecondOfTime(Date dt){
		Calendar cl = Calendar.getInstance();
		cl.setTime(dt);
		cl.add(Calendar.SECOND, -1);

		return cl.getTime();
	}
	
	/**
	 * ����HSC���ֹʱ���Ĭ��ֵ
	 * @return
	 */
	public static Date getHscStopDate() {
		String stopdate = "2099-12-30 00:00:00";
		String format = "yyyy-MM-dd HH:mm:ss";
		return StrToDate(stopdate, format);
	}
	
	/**
	 * ��Ԫ����Ϊ��
	 * @param str	�ʷѣ���λ��Ԫ
	 * @return
	 */
	public static String chgYuanToFen(String str){
		if("/".equals(str)){//���û���ý�����ֵ����Ϊ-2
			return "-2";
		}else{
			double feeYuan = Double.parseDouble(str);
			BigDecimal bdfee = new BigDecimal(feeYuan*100);
			String feeFen = bdfee.setScale(0,BigDecimal.ROUND_HALF_UP).toString();
			
			return feeFen;
		}
	}
	
	/**
	 * ��Ԫ����Ϊ��
	 * 
	 * @param str
	 *            �ʷѣ���λ��Ԫ
	 * @return
	 */
	public static int chgYuanToFenWithBigDecimal(String str) {
		return new BigDecimal(str).multiply(new BigDecimal("100"))
		.intValue();
	}
	
	/**
	 * ��Ԫ����Ϊ��
	 * 
	 * @param r
	 *            �ʷѣ���λ��Ԫ
	 * @return
	 */
	public static int chgYuanToFenWithBigDecimal(double r) {
		return new BigDecimal("" + r).multiply(new BigDecimal("100"))
				.intValue();
	}
	
	/**
	 * ͳ���ʷѸ���е��ʷ���ƥ�䣬���ʷ�ΪԪ��������Ϊ����*�ۿ���
	 * @param str	���ʣ���λ��Ԫ
	 * @param discount	�ۿ���
	 * @return
	 */
	public static String chgFeeDicount(String str,String discount){
		int disint = Integer.parseInt(discount);
		if("/".equals(str)){//���û���ý�����ֵ����Ϊ-2
			int ret = -2*disint;
			return String.valueOf(ret);
		}else{
			double fee = Double.parseDouble(str);
			BigDecimal bdfee = new BigDecimal(fee*100*disint);
			int feeint = bdfee.setScale(0,BigDecimal.ROUND_HALF_UP).intValue();
			
			return String.valueOf(feeint);
		}
		
	}
	
	/**
	 * �����ۿ��ʣ����û���ý������ۿ�������Ϊ-2
	 * @param str	���ʣ���λ��Ԫ
	 * @param discount	�ۿ���
	 * @return
	 */
	public static String chgDicount(String str,String discount){
		if("/".equals(str)){//���û���ý������ۿ�������Ϊ-2
			return "-2";
		}else{
			return discount;
		}
		
	}
	
	/**
	 * ��ȡ�����������ڵ�δ��������
	 * 
	 * @param count ��Ҫ���ص�����
	 * @return YYYYMM��ʽ���ַ���ɵ�����
	 */
	public static String[] getAfterMonth(Date dt,int count) {
		String[] months = new String[count];
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(dt);
		for (int i = 1; i <= count; i++) {
			dt = cal.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
			String str = formatter.format(dt);
			months[i - 1] = str;
			cal.add(java.util.Calendar.MONTH, 1);
		}
		return months;
	}
	
	/**
	 * ��ȡС�����λ��
	 * @param val
	 * @return
	 */
	public static int getDecimalScale(String val){
		if("/".equals(val)){//���û���ý���򷵻�0
			return 0;
		}
		BigDecimal b = new BigDecimal(val); 
		//scaleָ������С�����λ��
		return b.scale();
	}
	
	/**
	 * �ж�С���λ���Ϲ涨����Ӧ����
	 * @param val
	 * @return
	 */
	public static String delDecimalVal(String val){
		BigDecimal b = new BigDecimal(val); 
		if(b.scale()==3){//scaleָ������С�����λ��
			//����3λС�����С���������һλ
			double feeYuan = Double.parseDouble(val);
			BigDecimal bdfee = new BigDecimal(feeYuan*10);
			String feeFen = bdfee.setScale(2,BigDecimal.ROUND_HALF_UP).toString();
			return feeFen;
		}else{
			return val;
		}
		
	}
	
	public static Map<String, List> putListVal(Map<String, List> map,String key,Object value){
		List list = null;
		boolean contains = map.containsKey(key);
		if(contains){
			list = map.get(key);
			map.remove(key);
		}else{
			list = new LinkedList();
		}
		list.add(value);
		map.put(key, list);
		return map;
	}

	
	
	
	
}
