package com.gmcc.pboss.common.utils.tools;

import java.math.BigDecimal;

public class Arith {
	
	/**
	 * User: mys
	 * Date: 2006-10-24
	 * Time: 10:27:00
	 */
	private static final int DEF_DIV_SCALE = 2; 	/** 保留2位小数 **/
	private static final double DEF_MUL_SCALE = 100; 	/** 分(单位)转为元(单位) **/
	
	/** 提供精确的加法运算	 
	  * @param d1 被加数	 
	  * @param d2 加数	 
	  * @return 两个参数的和	 
	  */

	 public static double add(double d1, double d2) {

	  BigDecimal bd1 = new BigDecimal(Double.toString(d1));

	  BigDecimal bd2 = new BigDecimal(Double.toString(d2));

	  return bd1.add(bd2).doubleValue();

	 }

	 /**
	  * 提供精确的减法运算。
	  * @param d1 被减数
	  * @param d2 减数
	  * @return 两个参数的差
	  */

	 public static double subtract(double d1, double d2) {

	  BigDecimal bd1 = new BigDecimal(Double.toString(d1));

	  BigDecimal bd2 = new BigDecimal(Double.toString(d2));

	  return bd1.subtract(bd2).doubleValue();

	 }

	 /**	 
	  * 提供精确的乘法运算。	 
	  * @param d1 被乘数	 
	  * @param d2 乘数	 
	  * @return 两个参数的积	 
	  */

	 public static double multiply(double d1, double d2) {

	  BigDecimal bd1 = new BigDecimal(Double.toString(d1));

	  BigDecimal bd2 = new BigDecimal(Double.toString(d2));

	  return bd1.multiply(bd2).doubleValue();

	 }

	 /**	 
	  * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到	 
	  * 小数点以后2位，以后的数字四舍五入。	 
	  * @param d1 被除数	 
	  * @param d2 除数	 
	  * @return 两个参数的商	 
	  */

	 public static double divide(double d1, double d2) {

	  return divide(d1, d2, DEF_DIV_SCALE);

	 }

	 /**	 
	  * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指	 
	  * 定精度，以后的数字四舍五入。	 
	  * @param d1 被除数	 
	  * @param d2 除数	 
	  * @param scale 表示表示需要精确到小数点以后几位。	 
	  * @return 两个参数的商	 
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
	  * 提供精确的小数位四舍五入处理。	 
	  * @param d 需要四舍五入的数字	 
	  * @param scale 小数点后保留几位	 
	  * @return 四舍五入后的结果	 
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
	  * 提供数字转单位 (分 -> 元)处理。	 
	  * @param d 需要转换为元(单位)的数字	  
	  * @return 四舍五入后的结果	 
	  */

	 public static double cent2Yuan(double d) {	 
		 return divide(d, DEF_MUL_SCALE, DEF_DIV_SCALE);	  
	 }
	

	 /**	 
	  * 提供数字转单位 (元 -> 分)处理。	 
	  * @param d 需要转换为元(单位)的数字	  
	  * @return 四舍五入后的结果	 
	  */

	 public static double yuan2Cent(double d) {	 
		 return multiply(d, DEF_MUL_SCALE);	  
	 }
	 
}
