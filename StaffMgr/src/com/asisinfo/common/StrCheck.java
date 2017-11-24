package com.asisinfo.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * �ַ���֤��
 */
public class StrCheck {
	

	/*
	 * ��֤�ַ��Ƿ�Ϊ����,ͨ����ʽ   yyy.mmm    ������
	 */
	public static boolean isNumer(String str){
		if(null==str||str.length()==0){
			return false;
		}
		
		int num=0;
		for (int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(c=='.'){
				num+=1;
				if(i==0||i==str.length()){  //��β������С���
					return false;
				}
	        }
		}	
		
		if(num==0){
			if(str.length()==1){
				return isNumerP(str);
			}else{
				if(str.charAt(0)!='0'){
					return isNumerP(str);
				}else{
					return false;
				}
			}
		}else if(num==1){
			if(str.charAt(0)=='.'){
				return false;
			}else if(str.charAt(1)=='.'){
				return isNumerP(Tools.replace(str,".",""));
			}else{
				if(str.charAt(0)!='0'){
					return isNumerP(Tools.replace(str,".",""));
				}else{
					return false;
				}
			}
	    }else{
			return false;
		}
	}
	
	/*
	 * ��֤�ַ��Ƿ�Ϊ����,�����ʱ��
	 */
	public static boolean isNumerC(String str){
		return isNumerP(str);
	}
	
	/*
	 * ��֤�ַ��Ƿ�Ϊ����,������ʽ,�����ʱ��
	 */
	public static boolean isNumerP(String str){ 
		if(null==str||str.length()==0){
			return false;
		}
		Pattern pattern = Pattern.compile("[0-9]*"); 
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
		    return false; 
		} 
		return true; 
	} 
	
	/*
	 * �ж��ַ��Ƿ�Ϊ��ĸ
	 */
	public static boolean isLetter(String str){  
		if(null==str||str.length()==0){
			return false;
		}
		
		for (int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(!isSingleByteAlpha(c)){
	            return false;   
	        }
		}
		return true;
    } 
	
	/*
	 * �ж��ַ��Ƿ�Ϊ��д��ĸ
	 */
	public static boolean isUpperLetter(String str){  
		if(null==str||str.length()==0){
			return false;
		}
		
		for (int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(!isUpperSingleByteAlpha(c)){
	            return false;   
	        }
		}
		return true;
    }
	
	/*
	 * �ж��ַ��Ƿ�Ϊ���ֻ���ĸ���
	 */
	public static boolean isNumberOrLetter(String str){  
		if(null==str||str.length()==0){
			return false;
		}
		
		for (int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(!isSingleByteAlpha(c)&&!isSingleByteDigit(c)){
				return false;   
	        }
		}
		return true;
    } 
	
	/*
	 * �ж��ַ��Ƿ�Ϊ���ֻ��д��ĸ���
	 */
	public static boolean isNumberOrUpperLetter(String str){  
		if(null==str||str.length()==0){
			return false;
		}
		
		for (int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(!isUpperSingleByteAlpha(c)&&!isSingleByteDigit(c)){
				return false;   
	        }
		}
		return true;
    } 
	
	/**
	 * �ж��Ƿ�Ϊ���֣����ж�С����λ��
	 * @param str
	 * @param i
	 * @return
	 */
	public static boolean isNumer(String str,int l){
		if(null==str||str.length()==0){
			return false;
		}
		
		int num=0;
		for (int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(c=='.'){
				num+=1;
				if(i==0 || i==str.length()-1){  //��β������С���
					return false;
				}
	        }
		}	
		
		if(num==0){
			if(str.length()==1){
				return isNumerP(str);
			}
			else{
				if(str.charAt(0)!='0'){
					return isNumerP(str);
				}
				else{
					return false;
				}
			}
		}
		else if(num==1){
			if(str.charAt(0)=='.'){
				return false;
			}
			else if(str.charAt(1)=='.'){
				if(str.substring(str.indexOf(".")+1).length()>l)
					return false;
				else
					return isNumerP(Tools.replace(str,".",""));
			}
			else{
				if(str.charAt(0)!='0'){
					if(str.substring(str.indexOf(".")+1).length()>l)
						return false;
					else
						return isNumerP(Tools.replace(str,".",""));
				}
				else{
					return false;
				}
			}
	    }
		else{
			return false;
		}
	}
	
	/**
	 * ��������ж�
	 * @return �ж��Y�� true:�������
	 */

	public static boolean isSingleByteDigit( final char c ) {
	    return ( '0' <= c ) && ( c <= '9' );
	}

	/**
	 * ���Ӣ���ж�
	 * @return �ж��Y�� true:���Ӣ��
	 */

	public static boolean isSingleByteAlpha( final char c ) {
		return ( ( 'a' <= c ) && ( c <= 'z' ) ) || ( ( 'A' <= c ) && ( c <= 'Z' ) );
	}
	
	/**
	 * ��Ǵ�дӢ���ж�
	 * @return �ж��Y�� true:��Ǵ�дӢ��
	 */

	public static boolean isUpperSingleByteAlpha( final char c ) {
		return ( ( 'A' <= c ) && ( c <= 'Z' ) );
	}
	
	

}
