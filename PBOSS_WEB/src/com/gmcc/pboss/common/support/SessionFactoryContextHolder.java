package com.gmcc.pboss.common.support;

public final class SessionFactoryContextHolder {

	private static final ThreadLocal SESSION_FACTORY_CONTEXT = new ThreadLocal();

	public static final void setSessionFactoryContext(String context) {
		SESSION_FACTORY_CONTEXT.set(context);
	}

	public static final String getSessionFactoryContext() {
		return (String) SESSION_FACTORY_CONTEXT.get();
	}

}
