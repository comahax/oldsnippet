package com.gmcc.pboss.biz.info.reward.payment.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class Optype {
	private static Map<String, String> optypeMap = new LinkedHashMap<String, String>();
	static {
		optypeMap.put("", "全部业务");
		optypeMap.put("个人业务", "个人业务");
		optypeMap.put("数据业务", "数据业务");
		optypeMap.put("集团业务", "集团业务");
		optypeMap.put("税金业务", "税金业务");
	}

	public static Map<String, String> getOptypeMap() {
		return optypeMap;
	}

	public static String getOptypeName(String key) {
		return optypeMap.get(key);
	}
}
