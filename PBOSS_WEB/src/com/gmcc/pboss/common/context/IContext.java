package com.gmcc.pboss.common.context;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * ����ϵͳ���ԣ���Ҫһ���ᴩʼĩ����������ʹ��Ϣ����͸����
 * (���û���Ϣ����½��Ϣ���Լ�ϵͳ��Ϣ��ͨ��ע��ķ�ʽ�õ���
 * @author ywj
 * @version 0.1 ����չ��
 */
public interface IContext {

	public HttpServletRequest getRequest();
	
	public void setRequest(ServletRequest request);

	public void auth(ServletRequest request);
	
	
	/**
	 * ����Global������Ϣ:key:������ value:����ֵ 
	 */
	
	public Object getBean(String name);
}
