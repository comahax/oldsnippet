package com.sunrise.pub.tools;

/**
 * ��װһ��split����
 * @author gy
 *
 */
public class StringSplit {
	
	/**
	 * ԭ����split����(����StringUtils��String�����ṩ��)���ڷָ���
	 * "xxx|xxcvxd||"�������ַ�����ʱ��,���ص����ַ����������ʵ�ʵ���
	 * һ��,���������Ӧ����3,���Ƿ��ص�ȴ��2
	 * �˷�����ԭ����������������޸�,���ұ�����String�����ṩ��split��������ȷ
	 * �ָ���"|xxx|xxx|"��"|xxx||xxx|"���ص�
	 * ע��:ԭ�����ַ��������˷���֮��û��
	 * @param str
	 * @param split--����ʹ��"|"����"\\|"
	 * @return
	 */
	public static String[] split(String str, String split) {
		int index = -1;

		String[] items = null;
		String temp = "" + str;
		if (temp.endsWith(split + split)) {
			index = temp.lastIndexOf(split + split);
			temp = temp.substring(0, index + 1);
			temp += " " + split;
		}

		if ("|".equals(split))
			split = "\\" + split;
		
		items = temp.split(split);

		
		if (index != -1) {
			items[items.length - 1] = "";
		}
		return items;
	}
}
