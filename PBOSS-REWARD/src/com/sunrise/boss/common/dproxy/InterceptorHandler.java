/**
 * @author He Kun (Henry He), Guangzhou, China
 * 2006-4-19
 */
package com.sunrise.boss.common.dproxy;

import java.lang.reflect.*;
import java.util.*;
import net.sf.cglib.proxy.*;
import org.apache.commons.logging.*;

/**
 * InterceptorHandler
 * <br> Description: class InterceptorHandler
 * <br> Company: Maywide,Guangzhou</br>
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * 2006-4-19
 */
public class InterceptorHandler implements MethodInterceptor {
	private static Log log = LogFactory.getLog(InterceptorHandler.class);
	
	private static List interceptors = new ArrayList(3) ;
	
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		Object result = null;		
		InvokeInfo invokeInfo = new InvokeInfo(proxy,method,args,null,null);
		
		if(log.isDebugEnabled()) log.debug("Invoking Before Intercepors!");
		invokeInterceptorBefore( invokeInfo );
		try {
			if(log.isDebugEnabled()) log.debug("Invoking Proxy Method!");
			result = proxy.invokeSuper( obj , args);			
			invokeInfo.setResult(result);
			
			if(log.isDebugEnabled()) log.debug("Invoking after method!");
			invokeInterceptorAfter( invokeInfo );
			
		}catch(Throwable e) {
			Throwable t = e instanceof InvocationTargetException ? e.getCause() : e;
			invokeInfo.setException(t);
			if(log.isDebugEnabled()) log.debug("Invoking exceptionThrow method!");
			invokeInterceptorExceptionThrow(invokeInfo);
		}		
		return result;
	}
	
	public static List getInterceptors() {
		return interceptors;
	}
	
	public static void registerInterceptor(Class clazz) {
		if(!Interceptor.class.isAssignableFrom(clazz))
			throw new IllegalArgumentException("Interceptor class must implement interface " + Interceptor.class.getName() +" . But it's " + clazz.getName());
		interceptors.add(clazz);
	}
	
	public static void removeInterceptor(Class clazz) {
		interceptors.remove(clazz);
	}

	private void invokeInterceptorBefore(InvokeInfo invokeInfo) {
		List interceptors = getInterceptors();
		
		for (Iterator iter = interceptors.iterator(); iter.hasNext();) {			
			try {
				Class clazz = (Class) iter.next();			
				Interceptor interceptor = (Interceptor)clazz.newInstance();
				interceptor.before(invokeInfo);
			} catch (Throwable e) {				
				e.printStackTrace();
			}
		}
	}

	private void invokeInterceptorAfter(InvokeInfo invokeInfo) {
		List interceptors = getInterceptors();
		
		for (Iterator iter = interceptors.iterator(); iter.hasNext();) {			
			try {
				Class clazz = (Class) iter.next();			
				Interceptor interceptor = (Interceptor)clazz.newInstance();
				interceptor.after(invokeInfo);
			} catch (Throwable e) {				
				e.printStackTrace();
			}
		}
	}
	
	private void invokeInterceptorExceptionThrow(InvokeInfo invokeInfo) throws Throwable {
		List interceptors = getInterceptors();
		
		for (Iterator iter = interceptors.iterator(); iter.hasNext();) {			
			try {
				Class clazz = (Class) iter.next();			
				Interceptor interceptor = (Interceptor)clazz.newInstance();
				interceptor.exceptionThrow(invokeInfo);
			} catch (Throwable e) {				
				e.printStackTrace();
				throw e;
			}
		}
	}	
}
