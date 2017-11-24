package com.asisinfo.common.utils;

import java.math.BigDecimal;

public class ViewUtils {
	public static String toString(Object obj){
		if(obj==null)
			return "";
		return obj.toString();
	}
	
	public static String toInt(Object obj){
		String num = "";
		if(obj==null)
			return num;
		try{
			num = new BigDecimal(obj.toString()).setScale(0,BigDecimal.ROUND_HALF_UP).toString();
		}catch(Exception e){
		}
		return num;
	}
	
	public static String toDecimal(Object obj){
		String num = "";
		if(obj==null)
			return num;
		
		try{
			num = new BigDecimal(obj.toString()).setScale(2,BigDecimal.ROUND_HALF_UP).toString();
		}catch(Exception e){
		}
		return num;
	}
	
	public static String toPercent(Object obj){
		String num = "";
		if(obj==null)
			return num;
		try{
			num = new BigDecimal(obj.toString()).multiply(new BigDecimal("100")).setScale(1,BigDecimal.ROUND_HALF_UP).toString()+"%";
		}catch(Exception e){
		}
		return num;
	}
}
