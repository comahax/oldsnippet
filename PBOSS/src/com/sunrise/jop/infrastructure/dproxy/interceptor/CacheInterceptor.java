package com.sunrise.jop.infrastructure.dproxy.interceptor;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.jop.infrastructure.cache.CacheFactory;
import com.sunrise.jop.infrastructure.dproxy.AbstractInterceptor;
import com.sunrise.jop.infrastructure.dproxy.InvokeInfo;
/**
 * CacheInterceptor �Ǹ�ͨ�õĻ��������������ȱʡ�Ļ������ù������ݡ�
 * �� ehcache-config.xml �б�����һ��ȱʡ�Ļ��������ã�defaultCache
 * @author He Kun
 *
 */
public class CacheInterceptor extends AbstractInterceptor {
	
	private static Log log = LogFactory.getLog(CacheInterceptor.class);
	
	public static final String defaultCacheName = "DEFAULT_CACHE";
	
	public CacheInterceptor() {		
	}

	/**
	 * ����ȱʡ�Ļ������ù������ݡ�
	 * ��黺��,��ѯ�����Żػ���
	 */
	public void before(InvokeInfo info) throws Throwable {			
		Object[] args = info.getArgs();
		String clazz = info.getObj().getClass().getName();
		String method = info.getMethod().getName();
		String key = buildKey(clazz, method, args);
		
		String cacheName = getCacheName(clazz, method, args);
		Cache defaultCache = CacheFactory.getCacheManager().getCache( cacheName );
		
		if(defaultCache ==null) {  //ʹ��default���� 
			 CacheFactory.getCacheManager().addCache( cacheName );
			 defaultCache = CacheFactory.getCacheManager().getCache( cacheName );
		}
		
		if(defaultCache!=null) {
			Element element = defaultCache.get(key);
			if(element!=null) {
				Object value = (Object)element.getValue();						
				info.setResult(value);
				
				if(log.isDebugEnabled()) log.debug("��������" + cacheName + "���ҵ����ݣ�key:" + key + ",Value:" + info.getResult());
				info.setStopInvoke(true);
				info.setStopProxy(true);  //�ڻ������ҵ����ݣ�������Ҫִ��������
			}else {
				if(log.isDebugEnabled()) log.debug("����δ����" + cacheName + "��δ�ҵ����ݣ�key:" + key + ",Value:" + info.getResult());
			}
		}else {
			cacheNotConfiged(cacheName);			
			//info.setStopProxy(true);
		}	
	}
	
	/**
	 * 
	 */
	public void after(InvokeInfo info) throws Throwable {		
		Object[] args = info.getArgs();
		String clazz = info.getObj().getClass().getName();
		String method = info.getMethod().getName();
		String key = buildKey(clazz, method, args);
		
		String cacheName = getCacheName(clazz, method, args);
		Cache defaultCache = CacheFactory.getCacheManager().getCache( cacheName );
		
		if(info.getResult()!=null) {			
			if(defaultCache!=null) {
				Element element = defaultCache.get(key);
				//element��Ϊ��ʱ����������� ��Ϊ��ʱ�����»����
				if(info.getResult()!=null) {
					if(log.isDebugEnabled()) log.debug(cacheName + " �������ݣ�key:" + key + ",Value:" + info.getResult());
					
					element = new Element(key,info.getResult());
					defaultCache.put(element);
				}					
				
			}else {
				cacheNotConfiged(cacheName);
			}
		}
	}
	
	private void cacheNotConfiged(String cacheName) {
		if(log.isWarnEnabled()) 
			log.warn("Ĭ�ϻ����� " +cacheName + " û���ҵ�! ���� /ehcache.xml �ļ��н��ж��壡");
	}
	/**
	 * ��ȡ���õ�cache���ƣ�ȱʡΪ defaultCache�� ����ɸ�д�˷�������Բ�ͬ�����ʹ�ò�ͬ�Ļ������������ݡ�
	 * @return
	 */
	protected String getCacheName(String clazz, String method, Object[] args) {
		return defaultCacheName;
	}
	/**
	 * ���챻���ط����Ļ���Keyֵ�� ���������������Ͳ������ɡ�
	 * @param clazz
	 * @param method
	 * @param args
	 * @return
	 */
	protected String buildKey(String clazz,String method, Object[] args) {
		StringBuffer buffer = new StringBuffer(120);
		buffer.append(clazz).append("#")
				.append(method).append("#");
		
		for (int i = 0; i < args.length; i++) {
			if(args[i] == null)
				buffer.append("null").append("_");
			else 
				buffer.append( args[i]).append("_");
		}
		return buffer.toString();
	}
}
