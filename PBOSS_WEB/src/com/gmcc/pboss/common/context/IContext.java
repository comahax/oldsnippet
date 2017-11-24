package com.gmcc.pboss.common.context;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * 对于系统而言，需要一个贯穿始末的容器，来使信息传递透明化
 * (如用户信息，登陆信息，以及系统信息，通过注入的方式得到。
 * @author ywj
 * @version 0.1 待扩展。
 */
public interface IContext {

	public HttpServletRequest getRequest();
	
	public void setRequest(ServletRequest request);

	public void auth(ServletRequest request);
	
	
	/**
	 * 设置Global对象信息:key:属性名 value:属性值 
	 */
	
	public Object getBean(String name);
}
