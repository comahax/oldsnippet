package com.sunrise.jop.ui.interceptor;

import java.util.HashMap;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author hbm
 * 
 */

// ���ڼ�¼Action���������ʴ�����Action����������ʹ��ʱ������ֵ�� ����ϵͳ�Ż�
// ��������Ҫ��ȷ�Ȳ��ߣ�����Ϊ���̰߳�ȫ��
public class MonitorInterceptor extends AbstractInterceptor {
	public static HashMap<String, Long> timeMap = new HashMap<String, Long>(); // ��¼Action����������ʹ��ʱ������ֵ
	public static HashMap<String, Integer> countMap = new HashMap<String, Integer>();// ��¼Action���������ʴ���

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		long startTime = System.currentTimeMillis();
		String result = invocation.invoke(); // ��������
		long executionTime = System.currentTimeMillis() - startTime;

		StringBuilder key = new StringBuilder(100);
		String namespace = invocation.getProxy().getNamespace();
		if ((namespace != null) && (namespace.trim().length() > 0)) {
			key.append(namespace).append("/");
		}
		key.append(invocation.getProxy().getActionName());

		addToTimeMap(key.toString(), executionTime);
		addToCountMap(key.toString());

		return result;
	}

	private void addToCountMap(String key) {
		if (countMap.containsKey(key)) {
			Integer count = (Integer) countMap.get(key);
			countMap.put(key, count + 1);
		} else {
			countMap.put(key, 1);
		}

	}

	private void addToTimeMap(String key, Long newTime) {
		if (timeMap.containsKey(key)) {
			Long oldTime = (Long) timeMap.get(key);
			if (newTime > oldTime) {
				timeMap.put(key, newTime);
			}
		} else {
			timeMap.put(key, newTime);
		}

	}

}
