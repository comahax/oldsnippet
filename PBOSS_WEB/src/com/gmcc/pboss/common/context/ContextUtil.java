package com.gmcc.pboss.common.context;

import javax.servlet.http.HttpServletRequest;



/**
 * ���ýӿڣ��õ���ǰ������Context����
 * @author ywj
 *
 */
public class ContextUtil {
	
	/**
	 *  context �ֿ�. 
	 */
	public static final ThreadLocal store = new ThreadLocal();
	
	private ContextUtil() {
		
	}
	
	/**
	 * �õ���ǰϵͳContext.
	 * @return
	 */
	public static IContext getContext() {
		if (store.get() == null) {
			IContext context =  new ContextImpl();
			store.set(context);
			return context;
		} else {
			return (IContext) store.get();
		}
	}
	
	/**
	 * ע��ϵͳcontext:
	 * ��ͨ��filterע�룺����ϵͳʵ�ֿ��Կ�������ע�롣
	 */
	public static void setContext(IContext context) {
		store.set(context);
	}
	
	public void setRequest(HttpServletRequest request) {
		getContext().setRequest(request);
	}
	public void auth(HttpServletRequest request) {
		getContext().auth(request);
	}
	
}
