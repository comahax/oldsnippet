package com.sunrise.jop.infrastructure.dproxy;

import com.sunrise.jop.infrastructure.dproxy.interceptor.LogInterceptor;

/**
 * ȱʡ�����ش�������ֻע����־���������ʺ���ͨ����;
 * @author He Kun
 *
 */
public class DefaultIntercepterHandler extends InterceptorHandler {	
	/**
	 * 
	 */
	public void registerInterceptors() {			
		registerInterceptor(LogInterceptor.class);
		
	}	
}
