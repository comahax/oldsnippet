package com.sunrise.boss.ui.commons.taglib;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.taglib.html.Constants;
import org.apache.struts.taglib.html.SelectTag;

/**
 * Title: DateOptionsTag
 * Description:  
 * Copyright: Copyright (c) 2006
 * Company: Maywide Tech Ltd.
 * @author mys
 * @version 1.0
 */

public class DateOptionsTag extends TagSupport {

	/**
	 * 
	 * 属性：type begin end step desc fillZero type 属于必填属性 #YY 代表年 #MM 代表月
	 * begin 起始年/月 （默认为年：1990 月为： 1）
	 * end 结束年/月 （默认为年：当前年 月为： 12） 
	 * desc 升序/降序（false/true） 默认为 false 
	 * step 每次迭代的间隔数 （只能为正数 默认为1）
	 * fillZero （false/true） 默认为false；只有type为#MM时才有效 
	 * stepNowYear 是指在显示当前年的时候  + n ； 只能为大于0的整数
	 * 为帐务周期服务的，true时，月份的下拉框对应的value后面多加00；如：20060800\
	 * 注意：begin是可以大于end，desc优先级高些
	 * 
	 */
	
	private static final Log log = LogFactory.getLog(DateOptionsTag.class);
	
	static public final String TAG_YEAR_SIGN = "#YY";
	static public final String TAG_MONTH_SIGN = "#MM";
	
	static public final String TAG_HOUR_SIGN = "#HOUR";
	static public final String TAG_MINUTE_SIGN = "#MINUTE";
	static public final String TAG_SECOND_SIGN = "#SECOND";
	
	static public final int TAG_FIRST_MONTH = 1;
	static public final int TAG_LAST_MONTH = 12;
	static public final int TAG_FIRST_YEAR = 1990;
	static public final int TAG_DEFAUTL_MAX_YEAR_STEP = 100;
	static public final int TAG_DEFAUTL_STEP = 1;
	static public final String TAG_DEFAUTL_FALSE = "false";
	static public final String TAG_DEFAUTL_TRUE = "true";

	
	private String begin;

	private String end;	

	private String step;  //只能为正整数

	private String type;   //只能为  #YY  或者  #MM
	
	private int nowYear;   //当前年
	
	private String stepNowYear;   //当前年进街 n 年
	
	private String desc;    //排序
	
	private String fillZero;   //月份后补00
	
	public DateOptionsTag() {		
		super();
	}

	public int doEndTag() {
		
		try{
			
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date(System.currentTimeMillis()));
	    	setNowYear(doStepNowYear(calendar.get(Calendar.YEAR)));    //取当前年
			
	    	String type = getType();

			if(null != type && !"".equals(type)){
				if(type.equals(TAG_YEAR_SIGN)){
					doYear();  							//做年下拉列表					
				}
				if(type.equals(TAG_MONTH_SIGN)){
					doMonth();							//做月下拉列表
				}
				if(type.equals(TAG_HOUR_SIGN)){
					doHour();  							//做小时下拉列表					
				}
				if(type.equals(TAG_MINUTE_SIGN)){
					doMinute();							//做分下拉列表
				}
				if(type.equals(TAG_SECOND_SIGN)){
					doSecond();  							//做秒下拉列表					
				}
				
			}
		}catch(Exception ex){
			if (log.isInfoEnabled()){
		        if(null != ex.getMessage()){
		        	log.info("DateOption Tag exception:" + ex.getMessage(),ex);
			    }else{
		           log.info("DateOption Tag exception",ex);
		        }	
			}
		}
		
		return EVAL_PAGE;

	}
	private void doSecond() {
		for( int i = 0 ; i < 60 ; i++ ){
			String code = i + "";
			if(code.length() == 1) code = "0" + code;		
			writeOption(i,code);
		}
		
	}

	private void doMinute() {
		for( int i = 0 ; i < 60 ; i++ ){
			String code = i + "";
			if(code.length() == 1) code = "0" + code;		
			writeOption(i,code);
		}
	}

	private void doHour() {
		for( int i = 0 ; i < 24 ; i++ ){
			String code = i + "";
			if(code.length() == 1) code = "0" + code;		
			writeOption(i,code);
		}
		
	}

	public void doYear(){
		int begin = getIntBegin(getBegin(),getType());
		int end = getIntEnd(getEnd(),getType());
		int step = getIntStep(getStep());
		if(getDesc() == null){
			setDesc( begin > end ? TAG_DEFAUTL_TRUE : TAG_DEFAUTL_FALSE );
		}else{
			if(getDesc().equalsIgnoreCase(TAG_DEFAUTL_FALSE)){
				int temp = begin;
				if( begin > end ){
					begin = end;
					end = temp;
				}
			}else{
				int temp = begin;
				if( begin < end ){
					begin = end;
					end = temp;
				}	
			}
		}

		if(getDesc().equalsIgnoreCase(TAG_DEFAUTL_FALSE)){
			for( int i = begin ; i <= end ; i = i + step ){
				String code = i + "";
				writeOption(i,code);
			}
		}else{
			for( int i = begin ; i >= end ; i = i - step ){
				String code = i + "";
				writeOption(i,code);
			}			
		}
	}
	
	
	public void doMonth(){
		int begin = getIntBegin(getBegin(),getType());
		int end = getIntEnd(getEnd(),getType());
		int step = getIntStep(getStep());
		if(null == getFillZero() || "".equals(getFillZero())){
			setFillZero(TAG_DEFAUTL_FALSE);
		}
		
		if(getDesc() == null || "".equals(getDesc())){
			setDesc( begin > end ? TAG_DEFAUTL_TRUE : TAG_DEFAUTL_FALSE );
		}else{
			if(getDesc().equalsIgnoreCase(TAG_DEFAUTL_FALSE)){
				int temp = begin;
				if( begin > end ){
					begin = end;
					end = temp;
				}
			}
		}

		if(getDesc().equalsIgnoreCase(TAG_DEFAUTL_FALSE)){
			for( int i = begin ; i <= end ; i = i + step ){
				String code = i + "";
				if(code.length() == 1) code = "0" + code;
				if(getFillZero().equalsIgnoreCase(TAG_DEFAUTL_TRUE)) code = code + "00";
				writeOption(i,code);
			}
		}else{
			for( int i = begin ; i >= end ; i = i - step ){
				String code = i + "";
				if(code.length() == 1) code = "0" + code;
				if(getFillZero().equalsIgnoreCase(TAG_DEFAUTL_TRUE)) code = code + "00";
				writeOption(i,code);
			}			
		}			
	}
	
	public void writeOption(int i ,String code) {
		
		SelectTag selectTag = (SelectTag) pageContext.getAttribute(Constants.SELECT_KEY);
		boolean isSelect = selectTag.isMatched(code); 
		
		StringBuffer sb = new StringBuffer();
		sb.append("<option value=\"").append(code).append("\" ").append((isSelect ? "selected" : ""))
			.append(" >").append(i).append("</option>");             
		try {
			pageContext.getOut().println(sb.toString());
		} catch (IOException e) {
			if (log.isInfoEnabled()) {
                log.info("option print error!");
            }
		}
	}


	
	public int getIntBegin(String begin,String type){
		boolean isValid = false;
		if(null != begin && !"".equals(begin)){
			try { 
				Long temp = Long.valueOf(begin);
				if(temp.longValue() > 0){
					isValid = true;
				}
				
			} catch (Exception e) {
				if (log.isInfoEnabled()) {
	                log.info("begin type error!");
	            }
			}
		}
		if(!isValid){
			if(null != type && !"".equals(type)){
				if(type.equals(TAG_YEAR_SIGN)){
					return TAG_FIRST_YEAR;
				}
				if(type.equals(TAG_MONTH_SIGN)){
					return TAG_FIRST_MONTH;
				}			
			}
		}
		return new Integer(begin).intValue();
		
	}
	public int getIntEnd(String end,String type){
		boolean isValid = false;
		if(null != end && !"".equals(end)){
			try { 
				Long temp = Long.valueOf(end);
				if(temp.longValue() > 0){
					isValid = true;
				}				
			} catch (Exception e) {
				if (log.isInfoEnabled()) {
	                log.info("end type error!");
	            }
			}
		}
		if(!isValid){
			if(null != type && !"".equals(type)){
				if(type.equals(TAG_YEAR_SIGN)){
					return nowYear;
				}
				if(type.equals(TAG_MONTH_SIGN)){
					return TAG_LAST_MONTH;
				}			
			}
		}
		return new Integer(end).intValue();
		
	}
	
	
	public int getIntStep(String step){
		if(null != step && !"".equals(step)){
			try { 
				Long temp = Long.valueOf(step);
				if(temp.longValue() > 0){
					return temp.intValue();
				}
				
			} catch (Exception e) {
				if (log.isInfoEnabled()) {
	                log.info("step type error!");
	            }
			}
		}
		return TAG_DEFAUTL_STEP;
	}
	
	/**当前年是否提前n年*/
	public int doStepNowYear(int nowyear){
		
		try { 
			String  stepnowyear = getStepNowYear();
			
			if(null != stepnowyear && !"".equals(stepnowyear)){
				int stepyear = Integer.parseInt(stepnowyear);
				if(stepyear > 0){
					return nowyear + stepyear;
				}
			}	
		} catch (Exception e) {
	        log.info("doStepNowYear error!");
		}
		
		return nowyear;
	}
	
	
	
	
	
	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}


	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}


	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getNowYear() {
		return nowYear;
	}

	public void setNowYear(int nowYear) {
		this.nowYear = nowYear;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getFillZero() {
		return fillZero;
	}

	public void setFillZero(String fillZero) {
		this.fillZero = fillZero;
	}

	public String getStepNowYear() {
		return stepNowYear;
	}

	public void setStepNowYear(String stepNowYear) {
		this.stepNowYear = stepNowYear;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
