/**
 * 
 */
package com.sunrise.boss.ui.commons.taglib.morecode2name.impl;

import java.util.Map;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.morecode2name.MoreCode2Name;

/**
 * @author mys
 * ����˵��ʵ��morecode2name�Ľӿڷ���
 */


public class Example implements MoreCode2Name {

	/**
	 * params ���Դ�listvo���� ����ȡ��ҳ��Ϣ���������Լ������bean�ȵȣ�
	 */
	public String translateMore(Object params, User user) throws Exception {
		// TODO  ʵ�����Լ��ķ���
		return null;
	}

	public Object getList(Object params, User user) throws Exception {
		// TODO  ʵ�����Լ��ķ���
		return null;
	}
	
	public String getAllName() throws Exception {		
		return "ȫ��ƥ��";
	}
	public String getAllCode() throws Exception {	
		return "*,";
	}

	public Object getObject(Object params, User user) throws Exception {
		return null;
	}
	
}
