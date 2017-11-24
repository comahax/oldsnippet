package com.sunrise.jop.common.utils.lang;

/**
 * 包装一下split方法
 * @author gy
 *
 */
public class StringSplit {
	
	/**
	 * 原来的split函数(包括StringUtils和String本身提供的)对于分隔像
	 * "xxx|xxcvxd||"这样的字符串的时候,返回的子字符串个数会比实际的少
	 * 一个,比如上面的应该是3,但是返回的却是2
	 * 此方法对原来的这个特性做了修改,并且保留了String本身提供的split方法能正确
	 * 分隔像"|xxx|xxx|"和"|xxx||xxx|"的特点
	 * 注意:原来的字符串经过此方法之后没变
	 * @param str
	 * @param split--可以使用"|"或者"\\|"
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
