/**
 * 
 */
package com.sunrise.jop.common.utils.lang;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author He Kun
 * Aug 25, 2008
 *
 */
public class TimeUtils {
	
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	private static Calendar cale=null;

	public Calendar getCale() {
		return cale;
	}

	public void setCale(Calendar cale) {
		this.cale = cale;
	}
	public static String formatDateTime(Date date )throws Exception {
		return dateTimeFormat.format(date);
	}
	
	public static String formatDate(Date date)throws Exception {
		return dateFormat.format(date);
	}
	
	public static String formatTime(Date date)throws Exception {
		return timeFormat.format(date);
	}
	/**
	 * �ж������뵱ǰ�����Ƿ���ͬһ����
	 * @param date
	 * @return
	 */
	public static boolean inSameMonth(Date date)throws Exception{
		return monthFormat.format(new java.util.Date()).equals(monthFormat.format(date));
	}
	
	public static  Date paraseDate(String date)throws Exception{
		return dateFormat.parse(date);
	}

	 /** 
     * ��ȡ����ʱ��֮�ڵĹ�����ʱ�䣨ֻȥ����������֮�����ĩʱ�䣬�����ڼ���δȥ���� 
     * @param start -��ʼʱ��
     * @param end -����ʱ��
     * @return long��ʱ�������� 
     */ 
    public static long getWorkdayTimeInMillis(long start, long end){  
        //�����ʼʱ����ڽ���ʱ��ֱ�ӷ��ظ���
        if(start>end){  
            return -1l;
        }  
        //���ݲ�����ȡ��ʼʱ�������ʱ����������Ͷ���  
        Calendar sdate = Calendar.getInstance();  
        Calendar edate = Calendar.getInstance();  
        sdate.setTimeInMillis(start);  
        edate.setTimeInMillis(end);  
        //�������ʱ����ͬһ�ܲ��Ҷ�������ĩ���ڣ���ֱ�ӷ���ʱ������ִ��Ч��  
        if(sdate.get(Calendar.YEAR)==edate.get(Calendar.YEAR)  
                && sdate.get(Calendar.WEEK_OF_YEAR)==edate.get(Calendar.WEEK_OF_YEAR)  
                && sdate.get(Calendar.DAY_OF_WEEK)!=1 && sdate.get(Calendar.DAY_OF_WEEK)!=7 
                && edate.get(Calendar.DAY_OF_WEEK)!=1 && edate.get(Calendar.DAY_OF_WEEK)!=7){  
            return  end-start;  
        }  
        //����ȡ����ʼ������������ڵ��¸���һ������  
        Calendar sdatetemp = Calendar.getInstance();  
        Calendar edatetemp = Calendar.getInstance();
        sdatetemp.setTimeInMillis(start);  
        edatetemp.setTimeInMillis(end);  
        Calendar snextM = getNextMonday(sdatetemp);  
        Calendar enextM = getNextMonday(edatetemp);  
        //��ȡ��������һ֮���ʵ������  
        int days = getDaysBetween(snextM, enextM);  
        //��ȡ��������һ֮��Ĺ�������(������һ֮��������϶��ܱ�7���������ҹ���������ռ���е�5/7)  
        int workdays = days/7*5;  
        //��ȡ��ʼʱ���ƫ����  (���뱾������ƫ����)
        long scharge = 0;  
        if(sdate.get(Calendar.DAY_OF_WEEK)!=1 && sdate.get(Calendar.DAY_OF_WEEK)!=7){  
            //ֻ���ڿ�ʼʱ��Ϊ����ĩ��ʱ��ż���ƫ����  
            scharge += (7-sdate.get(Calendar.DAY_OF_WEEK))*24*3600000;  
            scharge -= sdate.get(Calendar.HOUR_OF_DAY)*3600000;  
            scharge -= sdate.get(Calendar.MINUTE)*60000;  
            scharge -= sdate.get(Calendar.SECOND)*1000;  
            scharge -= sdate.get(Calendar.MILLISECOND);  
        }  
        //��ȡ����ʱ���ƫ����   (���뱾������ƫ����)
        long echarge = 0;  
        if(edate.get(Calendar.DAY_OF_WEEK)!=1 && edate.get(Calendar.DAY_OF_WEEK)!=7){  
            //ֻ���ڽ���ʱ��Ϊ����ĩ��ʱ��ż���ƫ����  
            echarge += (7-edate.get(Calendar.DAY_OF_WEEK))*24*3600000;  
            echarge -= edate.get(Calendar.HOUR_OF_DAY)*3600000;  
            echarge -= edate.get(Calendar.MINUTE)*60000;  
            echarge -= edate.get(Calendar.SECOND)*1000;  
            echarge -= edate.get(Calendar.MILLISECOND);  
        }  
        //�������ս��������Ϊ��workdays���Ͽ�ʼʱ���ʱ��ƫ��������ȥ����ʱ���ʱ��ƫ����  
        return ((long)workdays)*24*3600000+scharge-echarge;  
    }  
    private static Calendar getNextMonday(Calendar cal){  
        int addnum=9-cal.get(Calendar.DAY_OF_WEEK);  
        if(addnum==8)addnum=1;//���յ����  
        cal.add(Calendar.DATE, addnum);  
        return cal;  
    }  
    /** 
     * ��ȡ��������֮���ʵ��������֧�ֿ��� 
     */ 
    public static int  getDaysBetween(Calendar start, Calendar end){  
        if(start.after(end)){  
            Calendar swap = start;  
            start = end;  
            end = swap;  
        }  
        int days = end.get(Calendar.DAY_OF_YEAR)- start.get(Calendar.DAY_OF_YEAR);  
        int y2 = end.get(Calendar.YEAR);  
        if (start.get(Calendar.YEAR) != y2) {  
            start = (Calendar) start.clone();  
            do {  
                days += start.getActualMaximum(Calendar.DAY_OF_YEAR);  
                start.add(Calendar.YEAR, 1);  
            }while(start.get(Calendar.YEAR) != y2);  
        }  
        return days;  
    }
    
    public static void main(String[] args) throws Exception{
    	long start = PublicUtils.UtilStrToDate("2010-06-26 11:10:00").getTime();
    	long end = new Date().getTime();
    	long between = TimeUtils.getWorkdayTimeInMillis(start, end);
    	double hours = between/3600000;
    	System.out.print(hours);
    }
	
}
