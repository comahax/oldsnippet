package com.asisinfo.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;


/**
 * 请求工具类，主要用来从request提取数据
 * @author johnson
 *
 */
public class RequestUtils {

	/**
	 * 获取页面字符参数
	 */
	public static String getStringParam(HttpServletRequest request,
			String param, String defaultValue) {
		String s = request.getParameter(param);
		return s == null ? defaultValue : StringUtils.trim(s);
	}
	
	/**
	 * 获取页面字符参数，防止中文乱码
	 * @throws UnsupportedEncodingException 
	 */
	public static String getStringParamMemo(HttpServletRequest request,
			String param, String defaultValue) throws UnsupportedEncodingException {
		String s = request.getParameter(param);
		return s == null ? defaultValue : StringUtils.trim(new String(s.getBytes("iso8859-1"),"utf-8"));
	}

	public static String getTrimString(HttpServletRequest request, String param) {
		String s = request.getParameter(param);
		return s == null ? null : s.trim();
	}

	/**
	 * 获取页面double参数
	 */
	public static double getDoubleParam(HttpServletRequest request,
			String param, double defaultValue) {
		String s = request.getParameter(param);
		if (s == null)
			return defaultValue;
		try {
			return Double.parseDouble(s);
		}
		catch (Exception e) {
		}
		return defaultValue;
	}

	/**
	 * 获取页面double参数
	 */
	public static long getLongParam(HttpServletRequest request, String param,
			long defaultValue) {
		String s = request.getParameter(param);
		if (s == null)
			return defaultValue;
		try {
			return Long.parseLong(s);
		}
		catch (Exception e) {
		}
		return defaultValue;
	}

	/**
	 * 获取页面int参数
	 */
	public static int getIntParam(HttpServletRequest request, String param,
			int defaultValue) {
		String s = request.getParameter(param);
		if (s == null)
			return defaultValue;
		try {
			return Integer.parseInt(s);
		}
		catch (Exception e) {
		}
		return defaultValue;
	}

	/**
	 * 获取页面Date参数
	 * 
	 * @param request
	 * @param param
	 * @param pattern
	 * @return
	 */
	public static Date getDateParam(HttpServletRequest request, String param,
			String pattern) {
		String s = request.getParameter(param);
		if (s != null) {
			try {
				return new SimpleDateFormat(pattern).parse(s);
			}
			catch (Exception e) {
			}
		}
		return null;
	}

	public static String[] getArrayParam(HttpServletRequest request,
			String param) {
		String[] s = request.getParameterValues(param);
		return (s == null) ? new String[0] : s;
	}
	
	public static Map<String, String> getParamsMap(HttpServletRequest request,
			String[] queryKeys){
		Map<String, String> paramsMap = new HashMap<String, String>();
		for (int i = 0; i < queryKeys.length; i++) {
			String key = queryKeys[i];
			String value = request.getParameter(key);
			if(value!=null&&value.trim().length()>0)
				paramsMap.put(key,value.trim());
		}
		return paramsMap;
	}
	
	public static Map<String,String> getParamsMap(HttpServletRequest request){
		return getParamsMap(request,false,null);	
	}
	
	public static Map<String,String> getParamsMap(HttpServletRequest request,boolean decode,String charset){
		Map<String,String> paramsMap = new HashMap();
		Map requestMap = request.getParameterMap();
		Set<String> keys = requestMap.keySet();
		for (Iterator key = keys.iterator(); key.hasNext();) {
			String paramName = (String) key.next();
			Object[] value = (Object[])requestMap.get(paramName);
			if(value.length>0){
				String pvalue = value[0].toString().trim();
				if(decode){
					try {
						pvalue = URLDecoder.decode(pvalue,charset);
					} catch (UnsupportedEncodingException e) {
					}
				}	
				paramsMap.put(paramName, pvalue);
			}
		}
		return paramsMap;	
	}
}
