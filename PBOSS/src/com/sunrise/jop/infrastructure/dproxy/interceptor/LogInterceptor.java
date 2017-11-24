package com.sunrise.jop.infrastructure.dproxy.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.jop.infrastructure.dproxy.AbstractInterceptor;
import com.sunrise.jop.infrastructure.dproxy.InvokeInfo;

public class LogInterceptor extends AbstractInterceptor {
	
	private static Log log = LogFactory.getLog(LogInterceptor.class);
	/**
	 * 
	 */
	public void before(InvokeInfo info) throws Throwable {		
		if(log.isDebugEnabled())
			log.debug("记录日志：调用前" + info.getMethod().getName());
		
	}
	
	
	public void after(InvokeInfo info) throws Throwable {
		// TODO Auto-generated method stub
		if(log.isDebugEnabled())
			log.debug("记录日志：调用后" + info.getMethod().getName());
	}
}
