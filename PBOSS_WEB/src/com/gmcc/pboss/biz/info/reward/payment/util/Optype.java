package com.gmcc.pboss.biz.info.reward.payment.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class Optype {
	private static Map<String, String> optypeMap = new LinkedHashMap<String, String>();
	static {
		optypeMap.put("", "ȫ��ҵ��");
		optypeMap.put("����ҵ��", "����ҵ��");
		optypeMap.put("����ҵ��", "����ҵ��");
		optypeMap.put("����ҵ��", "����ҵ��");
		optypeMap.put("˰��ҵ��", "˰��ҵ��");
	}

	public static Map<String, String> getOptypeMap() {
		return optypeMap;
	}

	public static String getOptypeName(String key) {
		return optypeMap.get(key);
	}
}
