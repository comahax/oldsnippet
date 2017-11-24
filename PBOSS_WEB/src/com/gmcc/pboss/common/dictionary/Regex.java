package com.gmcc.pboss.common.dictionary;
/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date Jul 8, 2009
 * 所属项目：
 * 所属模块：
 * 描述：分隔符
 */
public class Regex {
	/**分隔符：| */
	public static final String UPRIGHT = "\\|";
	/**分隔符：| (日志用)*/
	public static final String UPRIGHT_LOG = "|";
	
	/**分隔符：_ */
	public static final String UNDERLINE = "_";
	
	/**分隔符： / */
	public static final String SKEWLINE = "/";
	
	/**分隔符：? */
	public static final String QUESTION = "\\?";
	
	/**分割符：$*/
	public static final String REPLAYCE = "\\$";
	
	/**分割符：.*/
	public static final String POINT = "\\.";
	
	/**分割符：~*/
	public static final String WAVE = "~";
	
	/**分割符：,*/
	public static final String COMMA = ",";
	
	public static void printArray(String[]s){
		for(int i=0; i<s.length; i++){
			System.out.println("s["+i+"]="+s[i]);
		}
	}
	public static void main(String[]args){
		String s = "123342?9080";
		String[]ss = s.split(Regex.QUESTION);
		Regex.printArray(ss);
	}
}
