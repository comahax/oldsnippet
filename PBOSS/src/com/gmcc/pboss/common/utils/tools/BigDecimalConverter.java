package com.gmcc.pboss.common.utils.tools;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 
 * 由于Java的简单类型不能够精确的对浮点数进行运算，这个工具类提供精确的浮点数运算，包括加减乘除和四舍五入。
 * 
 * @auther caiwr
 * @version 1.0 2014-7-03
 * 
 */
public class BigDecimalConverter {

	// 默认除法运算精度
	private static final int DEF_DIV_SCALE = 10;

	// 这个类不能实例化
	private BigDecimalConverter() {
	}

	public static Object convertFromString(String[] values, Class toClass) {
		BigDecimal bd = null;
		if (BigDecimal.class == toClass) {
			String bdStr = values[0];
			if (bdStr != null && !"".equals(bdStr)) {
				bd = new BigDecimal(bdStr);
			} else {
				// bd = BigDecimal.valueOf(-1);
			}
			return bd;
		}
		return BigDecimal.ZERO;
	}

	public static String convertToString(Object o, int scale) {
		if (o != null) {
			if (o instanceof BigDecimal) {
				BigDecimal b = new BigDecimal(o.toString()).setScale(scale,
						BigDecimal.ROUND_HALF_DOWN);
				return b.toString();
			}
			return o.toString();
		} else {
			return "";
		}
	}

	public static int convertToInt(Object o) {
		int i = -1;
		if (o != null) {
			if (o instanceof BigDecimal) {
				i = ((BigDecimal) o).intValue();
			} else if (o instanceof Integer) {
				i = ((Integer) o).intValue();
			} else {
				i = Integer.parseInt(o.toString());
			}
		}

		return i;
	}

	public static long convertToLong(Object o) {
		long l = 0l;
		if (o != null) {
			if (o instanceof BigDecimal) {
				l = ((BigDecimal) o).longValue();
			} else if (o instanceof Long) {
				l = ((Long) o).longValue();
			} else {
				l = Long.parseLong(o.toString());
			}
		}

		return l;
	}

	public static float convertToFloat(Object o) {
		float f = -1f;
		if (o != null) {
			if (o instanceof BigDecimal) {
				f = ((BigDecimal) o).floatValue();
			} else if (o instanceof Float) {
				f = ((Float) o).floatValue();
			} else {
				f = Float.parseFloat(o.toString());
			}
		}
		return f;
	}

	public static double convertToDouble(Object o) {
		double f = -1f;
		if (o != null) {
			if (o instanceof BigDecimal) {
				f = ((BigDecimal) o).doubleValue();
			}
		}
		return f;
	}

	/**
	 * 提供精确的加法运算。
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 提供精确的减法运算。
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 提供精确的乘法运算。
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到小数点以后10位，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double roundToD(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * @param 需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static BigDecimal round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 提供精确的类型转换(Float)
	 * 
	 * @param v
	 *            需要被转换的数字
	 * @return 返回转换结果
	 */
	public static float convertsToFloat(double v) {
		BigDecimal b = new BigDecimal(v);
		return b.floatValue();
	}

	/**
	 * 提供精确的类型转换(Int)不进行四舍五入
	 * 
	 * @param v
	 *            需要被转换的数字
	 * @return 返回转换结果
	 */
	public static int convertsToInt(double v) {
		BigDecimal b = new BigDecimal(v);
		return b.intValue();
	}

	/**
	 * 提供精确的类型转换(Long)
	 * 
	 * @param v
	 *            需要被转换的数字
	 * @return 返回转换结果
	 */
	public static long convertsToLong(double v) {
		BigDecimal b = new BigDecimal(v);
		return b.longValue();
	}

	/**
	 * 返回两个数中大的一个值
	 * 
	 * @param v1
	 *            需要被对比的第一个数
	 * @param v2
	 *            需要被对比的第二个数
	 * @return 返回两个数中大的一个值
	 */
	public static double returnMax(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.max(b2).doubleValue();
	}

	/**
	 * 返回两个数中小的一个值
	 * 
	 * @param v1
	 *            需要被对比的第一个数
	 * @param v2
	 *            需要被对比的第二个数
	 * @return 返回两个数中小的一个值
	 */
	public static double returnMin(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.min(b2).doubleValue();
	}

	/**
	 * 精确对比两个数字
	 * 
	 * @param v1
	 *            需要被对比的第一个数
	 * @param v2
	 *            需要被对比的第二个数
	 * @return 如果两个数一样则返回0，如果第一个数比第二个数大则返回1，反之返回-1
	 */
	public static int compareTo(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.compareTo(b2);
	}

	public static String chgString(Double v1) {
		// 格式化设置
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
		return decimalFormat.format(v1);
	}

	public static String chgString2(Double v1, int scale) {
		BigDecimal bigDecimal = new BigDecimal(v1);
		return convertToString(bigDecimal, scale);
	}

	public static void main(String[] args) {
		Double v1 = 6.325441162E7;
		System.out.println(chgString(v1));
		int scale = 2;
		System.out.println(chgString2(v1, scale));
	}

}
