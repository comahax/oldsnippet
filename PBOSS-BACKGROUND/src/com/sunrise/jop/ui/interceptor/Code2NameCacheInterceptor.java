package com.sunrise.jop.ui.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.jop.infrastructure.dproxy.interceptor.CacheInterceptor;

public class Code2NameCacheInterceptor extends CacheInterceptor {
	
	private static Log log = LogFactory.getLog(Code2NameCacheInterceptor.class);
	
	public static final String DATA_DICT_CACHE = "DATA_DICT_CACHE";
	public static final String SINGLE_TABLE_CACHE = "SINGLE_TABLE_CACHE";
	
	public Code2NameCacheInterceptor() {		
	}
	
	/**
	 * ��ȡcache�������ص�cache��������ehcache������
	 */
	protected String getCacheName(String clazz, String method, Object[] args) {
		
		try {
			if(args!= null && args.length > 2)
			if("code2Name".equals(method) || "valueList".equals(method)) {
				String definition = (String)args[0];
				
				if(definition.startsWith("$")) {
					return DATA_DICT_CACHE;
				}else if(definition.startsWith("#")) {
					return SINGLE_TABLE_CACHE;
				}
			}
		}catch(Exception e) {
			if(log.isWarnEnabled()) 
				log.warn("��ȡcode2Name cache ����ʱ��������, ����ʹ��Ĭ�ϻ���." + e.getMessage());			
		}
		return super.getCacheName(clazz, method, args);
		
	}
	
	/**
	 * ����code2name����ع�key���ɷ�ʽ
	 * ֻ��Ҫ���� args �ĵ�һ��������: code,dbFlag
	 */
	protected String buildKey(String clazz, String method, Object[] args) {
		
		StringBuffer key = new StringBuffer(16);
		for (int i = 0; i < args.length; i++) {
			if(args[i] == null)
				key.append("null");
			else 
				key.append( args[i]);
			if( i != args.length -1 )
				key.append("-");
		}
		return key.toString();
	}
	
}
