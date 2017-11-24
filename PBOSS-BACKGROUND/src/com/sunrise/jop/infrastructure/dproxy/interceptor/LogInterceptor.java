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
		super.before(info);		
		if(log.isDebugEnabled())
			log.debug("��¼��־������ǰ" + info.getMethod().getName());
		
	}
	
	
	public void after(InvokeInfo info) throws Throwable {
		// TODO Auto-generated method stub
		super.after(info);
		if(log.isDebugEnabled())
			log.debug("��¼��־�����ú�" + info.getMethod().getName());
	}
}
