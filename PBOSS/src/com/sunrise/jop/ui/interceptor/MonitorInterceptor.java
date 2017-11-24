package com.sunrise.jop.ui.interceptor;

import java.util.HashMap;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author hbm
 * 
 */

// 用于记录Action方法被访问次数和Action方法调用所使用时间的最大值， 利于系统优化
// 由于数据要求精确度不高，该类为非线程安全。
public class MonitorInterceptor extends AbstractInterceptor {
	public static HashMap<String, Long> timeMap = new HashMap<String, Long>(); // 记录Action方法调用所使用时间的最大值
	public static HashMap<String, Integer> countMap = new HashMap<String, Integer>();// 记录Action方法被访问次数

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		long startTime = System.currentTimeMillis();
		String result = invocation.invoke(); // 正常调用
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
