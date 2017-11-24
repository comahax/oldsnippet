package com.gmcc.pboss.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import org.apache.struts2.dispatcher.FilterDispatcher;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.HttpDictionary;
import com.gmcc.pboss.common.util.CommonUtil;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-10-22
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ����������Filter�Ļ���
 */
public class BaseFilter extends StrutsPrepareAndExecuteFilter{//FilterDispatcher{
	/**��ҳ*/
	public static final String INDEX = "/";
	/**������ ҳ��*/
	public static final String DELIVERY_PAGE = "/delivery/query.do";
	/**to��¼*/
	public static final String LOGIN = "/tologin.do";
	/**��¼JSP*/
	public static final String LOGIN_JSP = "/login.jsp";
	/**��¼Action*/
	public static final String LOGIN_DO = "/login.do";
	/**��Ϣҳ��*/
	public static final String MESSAGE = "/message.jsp";
	/**������Ա ҳ��*/
	public static final String MANAGER_PAGE = "/managerView/nodeList.do";
	/**�ƹ�רԱ ҳ��*/
	public static final String MISSIONER_PAGE = "/missionerView/missionerList.do";
	
	/** ʡ��˾����Ա��¼*/
	public static final String GD_MANAGER_PAGE = "/gdView/nodeGdList.do";
	/** �й�˾����Աҳ��*/
	public static final String CITY_MANAGER_PAGE = "/cityView/nodeCityList.do";
	/**
	 * ��ȡsession�ı�������
	 * 
	 * @return ��ǰsession
	 */
	public HttpSession getSession(HttpServletRequest request){
		return request.getSession();
	}
	
	/**
		��ȡLoginMember�ı�������
	 * 
	 * @return ��ǰmember
	 */
	public LoginMember getMember(HttpServletRequest request){
		Object obj = getSessionAttribute(request, HttpDictionary.USER_NAME);
		LoginMember member = (obj != null)?(LoginMember)obj:null;
		return member;
	}
	
	/**
	 * �û��Ƿ�����
	 * @param request
	 * @return
	 */
	public boolean isOnline(HttpServletRequest request){
		return (this.getMember(request) != null);
	}
	
	/**
	 * �ж������Ƿ���AJAX����
	 * @param request
	 * @return
	 */
	public boolean isAjaxRequest(HttpServletRequest request){
		String ajax = getRequestParameter(request, HttpDictionary.AJAX_POST);
		return (!CommonUtil.isEmptyOrNull(ajax) && ajax.equals(HttpDictionary.AJAX_BY_JSON));
	}
	/**
	 * ��Request��ȡ����name�����Ķ���
	 * @param name
	 * @return
	 */
	public Object getRequestAttribute(HttpServletRequest request, String name){
		return request.getAttribute(name);
	}
	
	/**
	 * ��ĳ��������name������request��
	 * @param name
	 * @param obj
	 */
	public void setRequestAttribute(HttpServletRequest request, String name, Object obj){
		request.setAttribute(name, obj);
	}
	
	/**
	 * ��Request��ȡ����name������Parameter
	 * @param name
	 * @return
	 */
	public String getRequestParameter(HttpServletRequest request, String name){
		return request.getParameter(name);
	}
	
	/**
	 * ��Session��ȡ����name�����Ķ���
	 * @param name
	 * @return
	 */
	public Object getSessionAttribute(HttpServletRequest request, String name){
		return getSession(request).getAttribute(name);
	}
	
	/**
	 * ��ĳ��������name������session��
	 * @param name
	 * @param obj
	 */
	public void setSessionAttribute(HttpServletRequest request, String name, Object obj){
		getSession(request).setAttribute(name, obj);
	}
}
