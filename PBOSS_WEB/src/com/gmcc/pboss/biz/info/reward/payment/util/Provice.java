package com.gmcc.pboss.biz.info.reward.payment.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class Provice {
	private static Map<String, String> cityMap = new LinkedHashMap<String, String>();
	static {
		cityMap.put("GD", "�㶫");
		cityMap.put("GZ", "����");
		cityMap.put("SZ", "����");
		cityMap.put("ZH", "�麣");
		cityMap.put("ST", "��ͷ");
		cityMap.put("SG", "�ع�");
		cityMap.put("HY", "��Դ");
		cityMap.put("MZ", "÷��");
		cityMap.put("HZ", "����");
		cityMap.put("SW", "��β");
		cityMap.put("DG", "��ݸ");
		cityMap.put("ZS", "��ɽ");
		cityMap.put("JM", "����");
		cityMap.put("FS", "��ɽ");
		cityMap.put("YJ", "����");
		cityMap.put("ZJ", "տ��");
		cityMap.put("MM", "ï��");
		cityMap.put("ZQ", "����");
		cityMap.put("QY", "��Զ");
		cityMap.put("CZ", "����");
		cityMap.put("JY", "����");
		cityMap.put("YF", "�Ƹ�");
	}

	public static Map<String, String> getCityMap() {
		return cityMap;
	}

	public static String getCityName(String key) {
		return cityMap.get(key);
	}
}
