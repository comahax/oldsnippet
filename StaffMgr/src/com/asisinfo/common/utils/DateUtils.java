package com.asisinfo.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * ʱ��ĳ�����
 * 
 * @author houyanping
 * @created 2008-11-7 ����03:41:23
 * @version $Id 1.0$ <code>History</code><br/> Date Author Action<br>
 *          2008-11-7 houyanping New File: DateUtils.java<br>
 */
public class DateUtils {
	
	/**
     * ��ȡ��ǰʱ��
     * @return yyyyMMddHHmmss
     */
    public static String GetCurTime()
    {
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String curTime = formatter.format(new Date());
		return curTime;    	
    }

    
    /**
     * ��ȡ��ǰ����
     * @return yyyyMMdd
     */
    public static String GetCurDate()
    {
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    	String curDate = formatter.format(new Date());		
		return curDate;    	
    }
	/**
	 * ��ȡ������ǰ�������ڵĹ�ȥ���������
	 * 
	 * @param daycount ��Ҫ���ص�����
	 * @return yyyy-MM-dd��ʽ���ַ���ɵ�����
	 */
	public static String GetBeforeDate(int daycount) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -daycount);
		Date dt = cal.getTime();
		String str = DateToStr(dt, "yyyyMMdd");
		return str;
	}
    /**
     * ȡǰ���hour��Сʱ��ʱ��
     * @param hour��Ϊ������ȡhourСʱ���ʱ�䣬Ϊ������ȡhourСʱǰ��ʱ�䣩
     * @param format	��ָ����ʽ����
     * @return
     */
    public static String GetLastTime(int hour,String format){
	    java.util.Calendar Cal=java.util.Calendar.getInstance(); 
		Cal.add(java.util.Calendar.HOUR_OF_DAY,hour); 

		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String datetimeStr = formatter.format(Cal.getTime());
		return datetimeStr;
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
	 * �������ַ�ת��Ϊָ����ʽ���ַ�
	 * @param sDate �����ַ�
	 * @param pattern ���ڵĸ�ʽ
	 * @param toPattern Ŀ���ʽ
	 * @return
	 * @throws ParseException
	 */
	public static String format(String sDate, String pattern, String toPattern) throws ParseException{
		return DateToStr(StrToDate(sDate, pattern), toPattern);
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
	
	//�õ���������ǰһ�����ڵ���
	public static String getTableMonth(String triggerDate){
		Date tDate = DateUtils.StrToDate(triggerDate, "yyyyMMdd");
		Date preDate = DateUtils.addDate(tDate, -1);
		return DateUtils.DateToStr(preDate, "yyyyMM");
	}
	/**
	 * ����ָ��ʱ�䷶Χ�ڵ�����Date����
	 * 
	 * <pre>
	 * Date s = new SimpleDateFormat(&quot;yyyyMMdd&quot;).parse(&quot;20081101&quot;);
	 * Date e = new SimpleDateFormat(&quot;yyyyMMdd&quot;).parse(&quot;20081103&quot;);
	 * Iterator&lt;Date&gt; it = DateUtils.iterator(s, e, Calendar.DATE);
	 * while (it.hasNext()) {
	 * 	System.out.println(it.next());
	 * }
	 * </pre>
	 * 
	 * @param start ��ʼʱ��
	 * @param end ����ʱ��
	 * @param field the field from Calendar
	 * @return
	 */
	public static Iterator<Date> iterator(Date start, Date end, int field) {
		List<Date> list = new LinkedList<Date>();
		if (end == null || end.compareTo(start) <= 0) {
			list.add(start);
			return list.iterator();
		}

		Calendar sDate = Calendar.getInstance();
		Calendar eDate = Calendar.getInstance();
		sDate.setTime(start);
		eDate.setTime(end);

		while (sDate.compareTo(eDate) <= 0) {
			list.add(sDate.getTime());
			sDate.add(field, 1);
		}
		return list.iterator();
	}

	public static Iterator<Date> riterator(Date start, Date end, int field) {
		List<Date> list = new LinkedList<Date>();
		if (end == null || end.compareTo(start) <= 0) {
			list.add(start);
			return list.iterator();
		}

		Calendar sDate = Calendar.getInstance();
		Calendar eDate = Calendar.getInstance();
		sDate.setTime(start);
		eDate.setTime(end);

		while (eDate.compareTo(sDate) >= 0) {
			list.add(eDate.getTime());
			eDate.add(field, -1);
		}
		return list.iterator();
	}

	public static Date addDate(Date target,int days){
		Calendar c = Calendar.getInstance();
		c.setTime(target);
		c.add(Calendar.DATE, days);
		return c.getTime();
	}
	
	public static Date addMonth(Date target,int months){
		Calendar c = Calendar.getInstance();
		c.setTime(target);
		c.add(Calendar.MONTH, months);
		return c.getTime();
	}
	
	public static Date addTime(Date target,int num,int field){
		Calendar c = Calendar.getInstance();
		c.setTime(target);
		c.add(field, num);
		return c.getTime();
	}
	/**
     * ��ȡ��ǰ�Ʒ���
     * @return YYYYMM��ʽ
     */
    public static String GetCurPeriod()
    {
    	String billPeriod = null;
		int month = Calendar.getInstance().get( Calendar.MONTH)+1;
		int year = Calendar.getInstance().get( Calendar.YEAR );
		
		billPeriod = Integer.toString(year);
		if(month<10)
			billPeriod = billPeriod + "0" + Integer.toString(month);
		else
			billPeriod = billPeriod + Integer.toString(month);
		return billPeriod;
    }
    
	/**
     * ��ȡָ���·ݵ���һ����
     * @param billPeriod ��ǰ��
     * @return lastMonth ��һ����
     */
    public static String getBeforeMonth(String billPeriod) {
        int lastMonth = 0;
    	if(billPeriod != null && !"".equals(billPeriod)){
    		char[] temp = billPeriod.toCharArray();
    		if (temp[temp.length - 2] == '0' && temp[temp.length - 1] == '1') {
    			lastMonth = Integer.parseInt(billPeriod) - 100 + 11;// ������һ�µ�ʱ������Ӧ������12��
			} else {
				lastMonth = Integer.parseInt(billPeriod) - 1;// ����
			}
        }
        return String.valueOf(lastMonth);
    }
    
    /**
     * ��ȡָ���·ݵ���һ����
     * @param billPeriod ��ǰ��
     * @return ��һ����
     */
    public static String getNextMonth(String billPeriod) {
    	int nextMonth = 0;
    	if(billPeriod != null && !"".equals(billPeriod)){
    		char[] temp = billPeriod.toCharArray();
    		if (temp[temp.length - 2] == '1' && temp[temp.length - 1] == '2') {
    			nextMonth = Integer.parseInt(billPeriod) + 100 - 11;// ������12�µ�ʱ������Ӧ������1��
    		} else {
    			nextMonth = Integer.parseInt(billPeriod) + 1;// ����
    		}
    	}
    	return String.valueOf(nextMonth);
    }
    
    public static Date getLastOfOneDay(Date d){
    	Calendar c = Calendar.getInstance();
    	c.setTime(d);
    	c.set(Calendar.HOUR_OF_DAY, 23);
    	c.set(Calendar.MINUTE,59);
    	c.set(Calendar.SECOND,59);
    	c.set(Calendar.MILLISECOND, 999);
    	return c.getTime();
    }
	
    public static Date getLastMonthOf(Date d){
    	Calendar c = Calendar.getInstance();
    	c.setTime(d);
    	c.add(Calendar.MONTH, -1);
    	return c.getTime();
    }
    
    public static Date getFirstDayOf(Date d){
    	Calendar c = Calendar.getInstance();
    	c.setTime(d);
    	c.set(Calendar.DAY_OF_MONTH, 1);
    	return c.getTime();
    }
    
    public static Date getLastDayOf(Date d){
    	Calendar c = Calendar.getInstance();
    	c.setTime(d);
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.DATE, -1);
		return c.getTime();
    }
    
    public static int get(Date d,int field){
    	Calendar c = Calendar.getInstance();
    	c.setTime(d);
    	return c.get(field);
    }
    
    public static boolean isLastDayOfMonth(Date d){
    	Calendar c = Calendar.getInstance();
    	c.setTime(d);
    	return c.get(Calendar.DAY_OF_MONTH)==c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    
	public static void main(String[] args) throws Exception {
	/*	Date s = new SimpleDateFormat("yyyyMMdd").parse("20081121");
		Date e = new SimpleDateFormat("yyyyMMdd").parse("20081121");
		Iterator<Date> it = DateUtils.riterator(s, e, Calendar.DATE);
		while (it.hasNext()) {			
			System.out.println(it.next());
		}
		
		System.out.println(DateUtils.DateToStr(new Date(),"yyyy-MM-dd'T'HH:mm:ss"));*/
		System.out.println(getLastOfOneDay(new Date()));
	}
}
