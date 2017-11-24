/**
 * 
 */
package com.sunrise.jop.infrastructure.advisor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.jop.common.spring.AbstractAdvisor;

/**
 * ��־�������� ʵ�����岻����Ҫ��Ϊ Advisor�����ķ�����
 * @author He Kun
 *
 */
public class LogAdvisor extends AbstractAdvisor { 
//implements MethodBeforeAdvice,AfterReturningAdvice,ThrowsAdvice, MethodInterceptor  {

	private static Log log = LogFactory.getLog(LogAdvisor.class);


	/**
	 * 
	 */
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		if(log.isDebugEnabled())
			log.debug("��¼��־(ǰ):" + target +", ����:" + method.getName());
	}
	
	/**
	 * 
	 */
	public void afterReturning(Object object, Method method, Object[] args, Object target) throws Throwable {		
		if(log.isDebugEnabled())
			log.debug("��¼��־(��):" + target +", ����:" + method.getName());
	}
	
	public void afterThrowing(Method method, Object[] args, Object target, Throwable t) {
		if(log.isDebugEnabled())
			log.debug("��¼��־(�����쳣):" + target +", ����:" + method.getName() +",�쳣:" + t.getMessage());
	}
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		if(log.isDebugEnabled())
			log.debug("��¼��־(Around before):" + invocation.getThis() +", ����:" + invocation.getMethod().getName());
		
		Object result = null;
		
		try {
			result = invocation.proceed();
		} finally  {
			if(log.isDebugEnabled())
				log.debug("��¼��־(Around after):" + invocation.getThis() +", ����:" + invocation.getMethod().getName());
		}
		return result;
	}
}
