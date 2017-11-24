package com.gmcc.pboss.web.sales.stockalarm;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Iterator;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class AlarmUtils {

	/*
	 * 主要用于预警设置翻译（有点丑）
	 */
	public  static String alarmCode2Name(String alarmValue,String dbFlag){
		if( null == alarmValue || alarmValue.trim().length() == 0)
			return alarmValue;
		StringBuilder sb = new StringBuilder(50);
		String temp = alarmValue.replaceAll(";&", "");
		
		String[] typeAlarms = temp.split(";");
		for(String typeAlarm :typeAlarms){
			String[] alarm = typeAlarm.split(":");
			if(alarm.length == 2)
				sb.append(Code2NameUtils.code2Name("$FX_STOCKALARMLEVEL", alarm[0], dbFlag)).append(":").append(alarm[1]).append(";");
			else
				sb.append(typeAlarm).append(";");
		}
		return sb.toString();
	}
	
	
	/*
	 * 套卡库存预警设置 品牌翻译 dbtopage
	 */
	public static String alarmbrandinterpret(String brand, User user)
			throws Exception {
		Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
		DictitemDBParam param2 = new DictitemDBParam();
		DataPackage dp2 = dictitem.doQuery(param2);
		param2.set_se_groupid("FX_SMPBRAND");
		param2.set_sne_dictid("AllBrand");
		dp2 = dictitem.doQuery(param2);

		String starr[] = brand.split(",");

		StringBuffer restr = new StringBuffer();

		if (starr.length > 0) {
			for (Iterator<DictitemVO> it = dp2.getDatas().iterator(); it
					.hasNext();) {
				DictitemVO dictitemvo = it.next();
				for (int i = 0; i < starr.length; i++) {
					if (dictitemvo.getDictid().toString().equals(starr[i])) {
						if (i == starr.length - 1) {
							restr.append(dictitemvo.getDictname());
						} else {
							restr.append(dictitemvo.getDictname() + ",");
						}
					}
				}
			}
		}
		return restr.toString();
	}

	/*
	 * 套卡库存预警设置 品牌翻译 pagetodb
	 */
	public static String brandPageToDb(String str[]) {

		StringBuffer strbu = new StringBuffer();

		for (int i = 0; i < str.length; i++) {
			if (i == str.length - 1) {
				strbu.append(str[i]);
			} else {
				strbu.append(str[i] + ",");
			}
		}
		return strbu.toString();
	}
	
	public static String [] getStrArr(String [] s){
		String [] newArr = new String [s.length];
		for(int i=0;i<s.length;i++){
			newArr[i]=s[i].trim();
		}
		return newArr;
	}
	
	/**
	 * 金额大小写转换
	 */
	public static String NumberToChinese(String input)throws Exception{   
        String s1="零壹贰叁肆伍陆柒捌玖";   
        String s4="分角整元拾佰仟万拾佰仟亿拾佰仟";   
        String temp="";   
        String result="";   
        if (input==null) throw new Exception( "输入的字串不是数字串只能包括以下字符（'0'~'9','.'),输入字串最大只能精确到仟亿，小数点只能两位！");   
        temp=input.trim();   
        float f;   
        try{   
            f=Float.parseFloat(temp);   
        }catch(Exception e){   
        	throw new Exception("输入的字串不是数字串只能包括以下字符（'0'~'9','.'),输入字串最大只能精确到仟亿，小数点只能两位！");   
        }   
        int len=0;   
        if(temp.indexOf(".")==-1) len=temp.length();   
        else len=temp.indexOf(".");   
        if(len>s4.length()-3) throw new Exception("输入字串最大只能精确到仟亿，小数点只能两位！");   
        int n1=0;   
        String num="";   
        String unit="";   
        for(int i=0;i<temp.length();i++){   
            if(i>len+2){break;}   
            if(i==len) {continue;}   
            n1=Integer.parseInt(String.valueOf(temp.charAt(i)));   
            num=s1.substring(n1,n1+1);   
            n1=len-i+2;   
            unit=s4.substring(n1,n1+1);   
            result=result.concat(num).concat(unit);   
        }   
        if((len==temp.length())||(len==temp.length()-1)) result=result.concat("整");   
        if(len==temp.length()-2) result=result.concat("零分");   
        return result;   
    }
	
	
	/**
	 * 金额大小写转换(不要单位)
	 */
	public static String NumberToChinese2(String input){   
        String s1="零壹贰叁肆伍陆柒捌玖";   
        String temp="";   
        String result="";   
        if (input==null) return "输入的字串不是数字串只能包括以下字符（'0'~'9','.'),输入字串最大只能精确到仟亿，小数点只能两位！";   
        temp=input.trim();   
        float f;   
        try{   
            f=Float.parseFloat(temp);   
        }catch(Exception e){   
            return "输入的字串不是数字串只能包括以下字符（'0'~'9','.'),输入字串最大只能精确到仟亿，小数点只能两位！";   
        }   
        int len=0;   
        if(temp.indexOf(".")==-1) len=temp.length();   
        else len=temp.indexOf(".");   
        int n1=0;   
        String num="";   
        for(int i=0;i<temp.length();i++){   
            if(i>len+2){break;}   
            if(i==len) {continue;}   
            n1=Integer.parseInt(String.valueOf(temp.charAt(i)));   
            num=s1.substring(n1,n1+1);   
            n1=len-i+2;   
            result=result.concat(num);
        }   
        return result;   
    } 
}
