package com.common.util.string;
/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * 描述：
 * 	关于字符串的处理类
 */
public class CharacterStrUtil {
	
	/**
	 * 如果str为空或为null，返回true；否则返回false
	 * @param str
	 * @return true为空，false不为空
	 */
	public static boolean isBlank(String str){
		return (str == null || str.equals(""))?true:false;
	}
}
