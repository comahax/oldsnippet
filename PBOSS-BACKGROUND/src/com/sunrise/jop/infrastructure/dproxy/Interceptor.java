/**
 * @author He Kun (Henry He), Guangzhou, China
 * 2006-4-19
 */
package com.sunrise.jop.infrastructure.dproxy;

/**
 * Interceptor
 * <br> Description: class Interceptor
 * <br> Company: Maywide,Guangzhou</br>
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * 2006-4-19
 */
public interface Interceptor {
	
	/**
	 * �жϵ�ǰ������ķ����Ƿ���Ҫ�ų���Ĭ��Ϊfalse
	 * @param info
	 * @return
	 */
	boolean isIncludeMethod(InvokeInfo info);
	
	void before(InvokeInfo info) throws Throwable;
	
	void after(InvokeInfo info) throws Throwable;
	
	void exceptionThrow(InvokeInfo info) throws Throwable;
}
