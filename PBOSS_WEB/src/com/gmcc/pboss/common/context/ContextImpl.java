/**
 * 
 */
package com.gmcc.pboss.common.context;


import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author ywj
 * 
 */
public class ContextImpl implements IContext {

	public static final String GLOBAL_INPUT = "GI";
	private HttpServletRequest request = null;
	private ApplicationContext context = null;
	
	public void setRequest(ServletRequest req) {
		this.request = (HttpServletRequest)req;
		
	}

	public HttpServletRequest getRequest() {
		return request;
	}


	/**
	 * Ã·»°Bean
	 */
	public Object getBean(String name) {
		if (context == null) {
			if (request != null) {
				context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());;
			} else {
				System.out.println("get Service from TestContext");
				context = (ApplicationContext)ServletActionContext.getServletContext().getAttribute("context");
//				context = new ClassPathXmlApplicationContext(new String[] {"classpath*:spring/*.xml"});
			}
		}
		return context.getBean(name);
	}

	public void auth(ServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	
}
