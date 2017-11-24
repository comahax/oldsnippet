package com.gmcc.pboss.common.context;

import javax.servlet.http.HttpServletRequest;



/**
 * 调用接口，得到当前操作的Context对象
 * @author ywj
 *
 */
public class ContextUtil {
	
	/**
	 *  context 仓库. 
	 */
	public static final ThreadLocal store = new ThreadLocal();
	
	private ContextUtil() {
		
	}
	
	/**
	 * 得到当前系统Context.
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
	 * 注入系统context:
	 * 现通过filter注入：将来系统实现可以考虑配置注入。
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
