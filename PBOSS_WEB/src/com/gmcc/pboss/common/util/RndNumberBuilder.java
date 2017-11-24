package com.gmcc.pboss.common.util;
/**
 * 
 * @author Administrator
 *随机数发生器
 */
public class RndNumberBuilder {
	private static final String numbers[] = {"0","1","2","3","4","5","6","7","8","9"};
	
	/**
	 * 长度为length的随机码
	 * @param length
	 * @return
	 */
	public static String getRndNumber(int length){
		StringBuffer strBuffer = new StringBuffer();
		for(int i=0;i<length;i++ ){
			strBuffer.append(numbers[(int)(Math.random()*10)]);
		}
		return strBuffer.toString();
	}
	
	public static void main(String [] args){
		System.out.println(RndNumberBuilder.getRndNumber(6));
	}
}
