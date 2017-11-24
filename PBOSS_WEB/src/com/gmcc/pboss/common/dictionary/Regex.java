package com.gmcc.pboss.common.dictionary;
/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date Jul 8, 2009
 * ������Ŀ��
 * ����ģ�飺
 * �������ָ���
 */
public class Regex {
	/**�ָ�����| */
	public static final String UPRIGHT = "\\|";
	/**�ָ�����| (��־��)*/
	public static final String UPRIGHT_LOG = "|";
	
	/**�ָ�����_ */
	public static final String UNDERLINE = "_";
	
	/**�ָ����� / */
	public static final String SKEWLINE = "/";
	
	/**�ָ�����? */
	public static final String QUESTION = "\\?";
	
	/**�ָ����$*/
	public static final String REPLAYCE = "\\$";
	
	/**�ָ����.*/
	public static final String POINT = "\\.";
	
	/**�ָ����~*/
	public static final String WAVE = "~";
	
	/**�ָ����,*/
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
