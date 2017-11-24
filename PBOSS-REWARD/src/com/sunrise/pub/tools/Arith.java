package com.sunrise.pub.tools;

import java.math.BigDecimal;

public class Arith {
	
	/**
	 * User: mys
	 * Date: 2006-10-24
	 * Time: 10:27:00
	 */
	private static final int DEF_DIV_SCALE = 2; 	/** ����2λС�� **/
	private static final double DEF_MUL_SCALE = 100; 	/** ��(��λ)תΪԪ(��λ) **/
	
	/** �ṩ��ȷ�ļӷ�����	 
	  * @param d1 ������	 
	  * @param d2 ����	 
	  * @return ���������ĺ�	 
	  */

	 public static double add(double d1, double d2) {

	  BigDecimal bd1 = new BigDecimal(Double.toString(d1));

	  BigDecimal bd2 = new BigDecimal(Double.toString(d2));

	  return bd1.add(bd2).doubleValue();

	 }

	 /**
	  * �ṩ��ȷ�ļ������㡣
	  * @param d1 ������
	  * @param d2 ����
	  * @return ���������Ĳ�
	  */

	 public static double subtract(double d1, double d2) {

	  BigDecimal bd1 = new BigDecimal(Double.toString(d1));

	  BigDecimal bd2 = new BigDecimal(Double.toString(d2));

	  return bd1.subtract(bd2).doubleValue();

	 }

	 /**	 
	  * �ṩ��ȷ�ĳ˷����㡣	 
	  * @param d1 ������	 
	  * @param d2 ����	 
	  * @return ���������Ļ�	 
	  */

	 public static double multiply(double d1, double d2) {

	  BigDecimal bd1 = new BigDecimal(Double.toString(d1));

	  BigDecimal bd2 = new BigDecimal(Double.toString(d2));

	  return bd1.multiply(bd2).doubleValue();

	 }

	 /**	 
	  * �ṩ����ԣ���ȷ�ĳ������㣬�����������������ʱ����ȷ��	 
	  * С�����Ժ�2λ���Ժ�������������롣	 
	  * @param d1 ������	 
	  * @param d2 ����	 
	  * @return ������������	 
	  */

	 public static double divide(double d1, double d2) {

	  return divide(d1, d2, DEF_DIV_SCALE);

	 }

	 /**	 
	  * �ṩ����ԣ���ȷ�ĳ������㡣�����������������ʱ����scale����ָ	 
	  * �����ȣ��Ժ�������������롣	 
	  * @param d1 ������	 
	  * @param d2 ����	 
	  * @param scale ��ʾ��ʾ��Ҫ��ȷ��С�����Ժ�λ��	 
	  * @return ������������	 
	  */

	 public static double divide(double d1, double d2, int scale) {

	  if (scale < 0) {
		  throw new IllegalArgumentException("The scale must be a positive integer or zero");
	  }

	  BigDecimal bd1 = new BigDecimal(Double.toString(d1));

	  BigDecimal bd2 = new BigDecimal(Double.toString(d2));

	  return bd1.divide(bd2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	 }

	 /**	 
	  * �ṩ��ȷ��С��λ�������봦��	 
	  * @param d ��Ҫ�������������	 
	  * @param scale С���������λ	 
	  * @return ���������Ľ��	 
	  */

	 public static double round(double d, int scale) {

	  if (scale < 0) {
		  throw new IllegalArgumentException("The scale must be a positive integer or zero");
	  }

	  BigDecimal bd = new BigDecimal(Double.toString(d));

	  BigDecimal one = new BigDecimal("1");

	  return bd.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	 }

	 
	 /**	 
	  * �ṩ����ת��λ (�� -> Ԫ)����	 
	  * @param d ��Ҫת��ΪԪ(��λ)������	  
	  * @return ���������Ľ��	 
	  */

	 public static double cent2Yuan(double d) {	 
		 return divide(d, DEF_MUL_SCALE, DEF_DIV_SCALE);	  
	 }
	

	 /**	 
	  * �ṩ����ת��λ (Ԫ -> ��)����	 
	  * @param d ��Ҫת��ΪԪ(��λ)������	  
	  * @return ���������Ľ��	 
	  */

	 public static double yuan2Cent(double d) {	 
		 return multiply(d, DEF_MUL_SCALE);	  
	 }
	 
}
