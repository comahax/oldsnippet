package com.gmcc.pboss.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import org.apache.struts2.dispatcher.FilterDispatcher;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.HttpDictionary;
import com.gmcc.pboss.common.util.CommonUtil;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-10-22
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：所有Filter的基类
 */
public class BaseFilter extends StrutsPrepareAndExecuteFilter{//FilterDispatcher{
	/**首页*/
	public static final String INDEX = "/";
	/**配送商 页面*/
	public static final String DELIVERY_PAGE = "/delivery/query.do";
	/**to登录*/
	public static final String LOGIN = "/tologin.do";
	/**登录JSP*/
	public static final String LOGIN_JSP = "/login.jsp";
	/**登录Action*/
	public static final String LOGIN_DO = "/login.do";
	/**消息页面*/
	public static final String MESSAGE = "/message.jsp";
	/**经理人员 页面*/
	public static final String MANAGER_PAGE = "/managerView/nodeList.do";
	/**推广专员 页面*/
	public static final String MISSIONER_PAGE = "/missionerView/missionerList.do";
	
	/** 省公司管理员登录*/
	public static final String GD_MANAGER_PAGE = "/gdView/nodeGdList.do";
	/** 市公司管理员页面*/
	public static final String CITY_MANAGER_PAGE = "/cityView/nodeCityList.do";
	/**
	 * 获取session的便利方法
	 * 
	 * @return 当前session
	 */
	public HttpSession getSession(HttpServletRequest request){
		return request.getSession();
	}
	
	/**
		获取LoginMember的便利方法
	 * 
	 * @return 当前member
	 */
	public LoginMember getMember(HttpServletRequest request){
		Object obj = getSessionAttribute(request, HttpDictionary.USER_NAME);
		LoginMember member = (obj != null)?(LoginMember)obj:null;
		return member;
	}
	
	/**
	 * 用户是否在线
	 * @param request
	 * @return
	 */
	public boolean isOnline(HttpServletRequest request){
		return (this.getMember(request) != null);
	}
	
	/**
	 * 判断请求是否是AJAX请求
	 * @param request
	 * @return
	 */
	public boolean isAjaxRequest(HttpServletRequest request){
		String ajax = getRequestParameter(request, HttpDictionary.AJAX_POST);
		return (!CommonUtil.isEmptyOrNull(ajax) && ajax.equals(HttpDictionary.AJAX_BY_JSON));
	}
	/**
	 * 从Request中取出以name命名的对象
	 * @param name
	 * @return
	 */
	public Object getRequestAttribute(HttpServletRequest request, String name){
		return request.getAttribute(name);
	}
	
	/**
	 * 将某个对象以name保存在request中
	 * @param name
	 * @param obj
	 */
	public void setRequestAttribute(HttpServletRequest request, String name, Object obj){
		request.setAttribute(name, obj);
	}
	
	/**
	 * 从Request中取出以name命名的Parameter
	 * @param name
	 * @return
	 */
	public String getRequestParameter(HttpServletRequest request, String name){
		return request.getParameter(name);
	}
	
	/**
	 * 从Session中取出以name命名的对象
	 * @param name
	 * @return
	 */
	public Object getSessionAttribute(HttpServletRequest request, String name){
		return getSession(request).getAttribute(name);
	}
	
	/**
	 * 将某个对象以name保存在session中
	 * @param name
	 * @param obj
	 */
	public void setSessionAttribute(HttpServletRequest request, String name, Object obj){
		getSession(request).setAttribute(name, obj);
	}
}
