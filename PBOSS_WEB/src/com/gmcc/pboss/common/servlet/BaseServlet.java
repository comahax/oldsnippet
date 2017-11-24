package com.gmcc.pboss.common.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.HttpDictionary;


/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-10-23
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：servlet基类
 */
public abstract class BaseServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(BaseServlet.class);
	public static final String OPEARTION = "operation";
	
	/**
	 * 入口
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String operation = getRequestParameter(request, OPEARTION);
		logger.info("Operation>>>"+operation);
		LoginMember member = getLoginMember(request);
		perform(request, response, member, operation);
	}
	/**子类实现该方法*/
	public abstract String perform(HttpServletRequest request, HttpServletResponse response, 
									LoginMember member, String operation);
	/**
	 * Get Request Parameter By Name
	 * @param request
	 * @param name
	 * @return
	 */
	public String getRequestParameter(HttpServletRequest request, String name){
		String str = (request.getParameter(name) != null)?request.getParameter(name):"";
		return str;
	}
	/**
	 * Get Request Attribute By Name
	 * @param request
	 * @param name
	 * @return
	 */
	public Object getRequestAttribute(HttpServletRequest request,String name){
		return request.getAttribute(name);
	}
	/**
	 * Set Request Attribute By Name
	 * @param request
	 * @param name
	 * @param obj
	 */
	public void setRequestAttribute(HttpServletRequest request, String name,Object obj){
		request.setAttribute(name, obj);
	}
	/**
	 * Get Session Attribute By Name
	 * @param request
	 * @param name
	 * @return
	 */
	public Object getSessionAttribute(HttpServletRequest request,String name){
		return getSession(request).getAttribute(name);
	}
	/**
	 * Set Session Attribute By Name
	 * @param request
	 * @param name
	 * @param obj
	 */
	public void setSeesionAttribute(HttpServletRequest request, String name,Object obj){
		getSession(request).setAttribute(name, obj);
	}
	/**
	 * Get Session By Reqeust
	 * @param request
	 * @return
	 */
	public HttpSession getSession(HttpServletRequest request){
		return request.getSession();
	}
	/**
	 * Get LoginMember in Session
	 * @param request
	 * @return
	 */
	public LoginMember getLoginMember(HttpServletRequest request){
		Object obj = this.getSessionAttribute(request, HttpDictionary.USER_NAME);
		LoginMember member = (obj != null)?(LoginMember)obj:null;
		return member;
	}
}
