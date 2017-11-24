package com.sunrise.jop.infrastructure.dproxy.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.web.common.login.LoginAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.WebConstant;

public class LoginInterceptor implements Interceptor{

	private static Log log = LogFactory.getLog(LogInterceptor.class);

	public String intercept(ActionInvocation invocation) throws Exception {
		Object action = invocation.getAction();
		if (action instanceof LoginAction) {
			return invocation.invoke();
		}
		User user = (User) invocation.getInvocationContext().getSession().get(WebConstant.SESSION_ATTRIBUTE_USER);
		if (user != null) {
			return invocation.invoke();
		} else {
			return "overtime";
		}
	}
	
	public void init() {
		
	}

	public void destroy() {
		
	}

}
