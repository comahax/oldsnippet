package com.sunrise.boss.common.dproxy;

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
public class AbstractInterceptor implements Interceptor {

	public void before(InvokeInfo info) throws Throwable {
	}

	public void after(InvokeInfo info) throws Throwable {		
	}

	public void exceptionThrow(InvokeInfo info) throws Throwable {		
		throw info.getException();
	}

}
