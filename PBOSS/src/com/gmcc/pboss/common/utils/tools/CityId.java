package com.gmcc.pboss.common.utils.tools;

import java.util.LinkedHashMap;
import java.util.Map;

public class CityId {
	private static Map<String, String> cityMap = new LinkedHashMap<String, String>();
	static {
		cityMap.put("", "全省");
		cityMap.put("GZ", "广州");
		cityMap.put("SZ", "深圳");
		cityMap.put("ZH", "珠海");
		cityMap.put("ST", "汕头");
		cityMap.put("SG", "韶关");
		cityMap.put("HY", "河源");
		cityMap.put("MZ", "梅州");
		cityMap.put("HZ", "惠州");
		cityMap.put("SW", "汕尾");
		cityMap.put("DG", "东莞");
		cityMap.put("ZS", "中山");
		cityMap.put("JM", "江门");
		cityMap.put("FS", "佛山");
		cityMap.put("YJ", "阳江");
		cityMap.put("ZJ", "湛江");
		cityMap.put("MM", "茂名");
		cityMap.put("ZQ", "肇庆");
		cityMap.put("QY", "清远");
		cityMap.put("CZ", "潮州");
		cityMap.put("JY", "揭阳");
		cityMap.put("YF", "云浮");
	}

	public static Map<String, String> getCityMap() {
		return cityMap;
	}

	public static String getCityName(String key) {
		return cityMap.get(key);
	}
}

