package com.sunrise.jop.infrastructure.dproxy;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.cglib.proxy.Enhancer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * �����������ڴ���һ��aop�Ķ���ʵ���� ��ʵ���ķ���������ʱ����Ӧ�����������Զ�����
 * @author He Kun
 *
 */
public class ProxyFactory {
	
	private static Log LOG = LogFactory.getLog(ProxyFactory.class);
	
	private static String configName = "/jop-aop.xml";
	
	private static Map handlerMap = new HashMap(5);
	
	static {
		loadConfig(configName);
	}
	
	/**
	 * ��������
	 * @param configName
	 */
	private static void loadConfig(String configName) {
		SAXReader saxReader = new SAXReader();
		URL url = Thread.currentThread().getContextClassLoader().getResource(configName);
		
		if(url == null) {
			url = ProxyFactory.class.getResource(configName);
		}
		
		if(url== null) {
			throw new RuntimeException("�޷��ҵ������ļ�" + configName);
		}
			
		InputStream in = null;
		Document document;
		try {
			 in = url.openStream();
			document = saxReader.read(in);
			Element root = document.getRootElement();
			List handlers = root.selectNodes("interceptorHandlers/interceptorHandler");
			
			Iterator iter = handlers.iterator();
			while (iter.hasNext()) {
				Element handlerEle = (Element) iter.next();
				String handlerName = handlerEle.attributeValue("name"); //ע�⣬Ҫȥ���ո�
				String handlerDescription = handlerEle.attributeValue("description"); //ע�⣬Ҫȥ���ո�
				String handlerClass = handlerEle.attributeValue("class"); //ע�⣬Ҫȥ���ո�
				
				if(handlerName==null || "".equals(handlerName)) {
					if(LOG.isErrorEnabled()) LOG.error("���ش�����Ԫ�� name���� ��������!");
				}
				
				if(handlerClass==null || "".equals(handlerClass)) {
					handlerClass = InterceptorHandler.class.getName(); //���û�ж���class�������Ĭ�ϵġ�
					if(LOG.isErrorEnabled()) LOG.error("���ش����� " + handlerName + " δ����class  ����Ĭ��ֵ" + InterceptorHandler.class.getName());
				}
				InterceptorHandler handler = new InterceptorHandler();
				handler.setName(handlerName);
				handler.setDescription(handlerDescription);
				
				
				try {
					Class clazz = Class.forName(handlerClass);
					if(!InterceptorHandler.class.isAssignableFrom(clazz)) {
						if(LOG.isErrorEnabled()) LOG.error("���ش����� class " + handlerClass +" must implement interface " + InterceptorHandler.class.getName());
					}else {
						if(LOG.isInfoEnabled()) LOG.info("�������ش����� " + handlerName );
						handler.setClazz(clazz);
						loadHandler(handlerEle,handler);
					}
						
				} catch (ClassNotFoundException e) {
					if(LOG.isErrorEnabled()) LOG.error("���ش����� class " + handlerClass +" not found");
				}
				
				
			}
		} catch (DocumentException e) {
			if(LOG.isErrorEnabled()) LOG.error("Can't locad config " + configName + " " + e.getMessage());
		} catch (IOException e) {
				if(LOG.isErrorEnabled()) LOG.error("Can't locad config " + configName + " " + e.getMessage()) ;
		}
		finally {
			 if (in!=null) 
				 try { in.close();	 }catch(IOException e) { }
		}
	}
	
	private static void loadHandler(Element handlerEle, InterceptorHandler handler ) {
		Iterator interceptors = handlerEle.elementIterator("interceptor");
		while (interceptors.hasNext()) {
			Element interceptorEle = (Element) interceptors.next();
			String interceptorClass = interceptorEle.attributeValue("class").trim(); //ע�⣬Ҫȥ���ո�
			try {
				Class clazz = Class.forName(interceptorClass);
				if(!Interceptor.class.isAssignableFrom(clazz)) {
					if(LOG.isErrorEnabled()) LOG.error("Interceptor class " + interceptorClass +" must implement interface " + Interceptor.class.getName() +" OR extends class " + AbstractInterceptor.class.getName());
				}else {
					if(LOG.isInfoEnabled()) LOG.info("ע�������� " + interceptorClass +" to InterceptorHandler " + handler.getName());
					handler.registerInterceptor(clazz);
				}
					
			} catch (ClassNotFoundException e) {
				if(LOG.isErrorEnabled()) LOG.error("Interceptor class " + interceptorClass +" not found");
			}
			
		}
		handlerMap.put(handler.getName(), handler);	
	}
	
	/**
	 * �������õ�handlerName����һ��ָ������Ĵ�����󣬶�includeMethods��Ҫ��ķ�����������
	 * @param proxyClass
	 * @param includeMethods
	 * @param handlerName
	 * @return
	 * @throws InstantiationException
	 */
	public static Object createObject(Class proxyClass,String[] includeMethods,String handlerName) throws InstantiationException {
		InterceptorHandler handler = (InterceptorHandler) handlerMap.get(handlerName);
		if(handler == null) {
			throw new InstantiationException("���ش����� not found name:" + handlerName);
		}
		
		return createObject(proxyClass, includeMethods, handler);
	}
	
	public static Object createObject(Class proxyClass,InterceptorHandler handler) throws InstantiationException {
		return createObject(proxyClass, null, handler);
	}
	
	public static Object createObject(Class proxyClass,String[] includeMethods,InterceptorHandler handler) throws InstantiationException {
		 Enhancer enhancer = new Enhancer();
		 enhancer.setSuperclass(proxyClass);  //���������
		 
		 InterceptorHandler interceptorHandler = null;
		try {
			Class interceptorHandlerClass = handler.getClazz();
			interceptorHandler = (InterceptorHandler)interceptorHandlerClass.newInstance();
			interceptorHandler.setIncludeMethods(includeMethods);
			
			interceptorHandler.setName(handler.getName());
			interceptorHandler.setDescription(handler.getDescription());
			interceptorHandler.setClazz(handler.getClazz());
					
			interceptorHandler.setInterceptors(handler.getInterceptors());
			
			enhancer.setCallback( interceptorHandler );
			Object proxyObject = enhancer.create();
			return proxyObject;
			 
		} catch (InstantiationException e) {
			
			throw new InstantiationException("Can't create instance of class " + proxyClass  +" with interceptorHandler " + handler.getName() + ". Cause:" + e); 
		} catch (IllegalAccessException e) {
			throw new InstantiationException("Can't create instance of class " + proxyClass  +" with interceptorHandler " + handler.getName() +". Cause:" + e);
		}
	}
	
	public static void main(String[] args) {
		try {
			Map map = (Map) ProxyFactory.createObject(HashMap.class, new String[] {"get"}, "DAOInterceptorHandler");
			map.put("1111111", "AAAAAAAA");
			System.out.println("1st get " + map.get("1111111"));
			System.out.println("2rd get " + map.get("1111111"));
			System.out.println("2rd get " + map.get("1111111"));
			System.out.println("2rd get " + map.get("1111111"));
			System.out.println("2rd get " + map.get("1111111"));
			System.out.println("3rd get " + map);
			
			map.clear();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
