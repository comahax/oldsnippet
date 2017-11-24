package com.sunrise.boss.ui.commons.tools;

import java.util.HashMap;

import javax.servlet.ServletRequest;

import com.sunrise.boss.ui.commons.WebConstant;

public class RequestCacheUtils {

	static final int MAX_SIZE = 100;

	static public String get(ServletRequest request, String key) {
		HashMap cache = (HashMap) request.getAttribute(WebConstant.REQUEST_CACHE);
		if (cache != null) {
			return (String) cache.get(key);
		} else {
			return null;
		}
	}

	static public void put(ServletRequest request, String key, String value) {
		HashMap cache = (HashMap) request.getAttribute(WebConstant.REQUEST_CACHE);
		if (cache != null) {
			if (cache.size() >= MAX_SIZE) {
				cache.clear();
			}
		} else {
			cache = new HashMap();
		}
		cache.put(key, value);
	}

	static public boolean containsKey(ServletRequest request, String key) {
		HashMap cache = (HashMap) request.getAttribute(WebConstant.REQUEST_CACHE);
		if (cache != null) {
			return cache.containsKey(key);
		} else {
			return false;
		}
	}
}
