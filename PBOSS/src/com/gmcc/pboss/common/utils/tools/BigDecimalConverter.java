package com.gmcc.pboss.common.utils.tools;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 
 * ����Java�ļ����Ͳ��ܹ���ȷ�ĶԸ������������㣬����������ṩ��ȷ�ĸ��������㣬�����Ӽ��˳����������롣
 * 
 * @auther caiwr
 * @version 1.0 2014-7-03
 * 
 */
public class BigDecimalConverter {

	// Ĭ�ϳ������㾫��
	private static final int DEF_DIV_SCALE = 10;

	// ����಻��ʵ����
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
	 * �ṩ��ȷ�ļӷ����㡣
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @return ���������ĺ�
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * �ṩ��ȷ�ļ������㡣
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @return ���������Ĳ�
	 */
	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * �ṩ��ȷ�ĳ˷����㡣
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @return ���������Ļ�
	 */
	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * �ṩ����ԣ���ȷ�ĳ������㣬�����������������ʱ����ȷ��С�����Ժ�10λ���Ժ�������������롣
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @return ������������
	 */
	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * �ṩ����ԣ���ȷ�ĳ������㡣�����������������ʱ����scale����ָ�����ȣ��Ժ�������������롣
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @param scale
	 *            ��ʾ��ʾ��Ҫ��ȷ��С�����Ժ�λ��
	 * @return ������������
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
	 * �ṩ��ȷ��С��λ�������봦��
	 * 
	 * @param v
	 *            ��Ҫ�������������
	 * @param scale
	 *            С���������λ
	 * @return ���������Ľ��
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
	 * �ṩ��ȷ��С��λ�������봦��
	 * 
	 * @param ��Ҫ�������������
	 * @param scale
	 *            С���������λ
	 * @return ���������Ľ��
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
	 * �ṩ��ȷ������ת��(Float)
	 * 
	 * @param v
	 *            ��Ҫ��ת��������
	 * @return ����ת�����
	 */
	public static float convertsToFloat(double v) {
		BigDecimal b = new BigDecimal(v);
		return b.floatValue();
	}

	/**
	 * �ṩ��ȷ������ת��(Int)��������������
	 * 
	 * @param v
	 *            ��Ҫ��ת��������
	 * @return ����ת�����
	 */
	public static int convertsToInt(double v) {
		BigDecimal b = new BigDecimal(v);
		return b.intValue();
	}

	/**
	 * �ṩ��ȷ������ת��(Long)
	 * 
	 * @param v
	 *            ��Ҫ��ת��������
	 * @return ����ת�����
	 */
	public static long convertsToLong(double v) {
		BigDecimal b = new BigDecimal(v);
		return b.longValue();
	}

	/**
	 * �����������д��һ��ֵ
	 * 
	 * @param v1
	 *            ��Ҫ���Աȵĵ�һ����
	 * @param v2
	 *            ��Ҫ���Աȵĵڶ�����
	 * @return �����������д��һ��ֵ
	 */
	public static double returnMax(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.max(b2).doubleValue();
	}

	/**
	 * ������������С��һ��ֵ
	 * 
	 * @param v1
	 *            ��Ҫ���Աȵĵ�һ����
	 * @param v2
	 *            ��Ҫ���Աȵĵڶ�����
	 * @return ������������С��һ��ֵ
	 */
	public static double returnMin(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.min(b2).doubleValue();
	}

	/**
	 * ��ȷ�Ա���������
	 * 
	 * @param v1
	 *            ��Ҫ���Աȵĵ�һ����
	 * @param v2
	 *            ��Ҫ���Աȵĵڶ�����
	 * @return ���������һ���򷵻�0�������һ�����ȵڶ��������򷵻�1����֮����-1
	 */
	public static int compareTo(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.compareTo(b2);
	}

	public static String chgString(Double v1) {
		// ��ʽ������
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
