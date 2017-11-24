package com.sunrise.jop.infrastructure.dproxy;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * AbstractInterceptor
 * <br> Description: class AbstractInterceptor
 * <br> Company: Maywide,Guangzhou</br>
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * 2006-4-19
 */
public abstract class AbstractInterceptor implements Interceptor {

	public static Log log = LogFactory.getLog(AbstractInterceptor.class);
	
	private static Map excludeMethods = new HashMap();
	
	static {
		excludeMethods.put("toString","toString");
		excludeMethods.put("hashCode","hashCode");
		excludeMethods.put("clone","clone");
		excludeMethods.put("equals","equals");
		excludeMethods.put("getClass","getClass");				
	}
		
	/**
	 * ��Щ��������ʹ�ô�����ƽ������ء������˷���ʱ��ֱ�ӵ��á�
	 * @param info
	 */
	public boolean isIncludeMethod(InvokeInfo info) {
		return !isExcludeMethod(info);
	}
	
	/**
	 * 
	 * @param info
	 * @return
	 */
	public boolean isExcludeMethod(InvokeInfo info) {
		Method method = info.getMethod();
		
		//����void����
		if( "void".equals(method.getReturnType().getName())) {
			if(log.isDebugEnabled()) log.debug("����void���� " + method.getName());
			info.setStopProxy(true);
			return true;
		}
		//���Է�public �� protected ����
		if(  !Modifier.isPublic(method.getModifiers()) && !Modifier.isProtected(method.getModifiers()))  {
			if(log.isDebugEnabled()) log.debug("���Ծ�̬���� " + method.getName());
			info.setStopProxy(true);
			return true;
		}
		
		//����Object����� ����
		if(excludeMethods.containsKey(method.getName())) {
			if(log.isDebugEnabled()) log.debug("����Object�������� " + method.getName());
			info.setStopProxy(true);
			return true;
		}
		
		return false;
	}
	
	public abstract void before(InvokeInfo info) throws Throwable;
	
	public abstract void after(InvokeInfo info) throws Throwable;

	public void exceptionThrow(InvokeInfo info) throws Throwable {		
		throw info.getException();
	}

}
