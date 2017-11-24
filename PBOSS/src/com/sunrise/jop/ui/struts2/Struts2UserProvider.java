/**
 * 
 */
package com.sunrise.jop.ui.struts2;

import com.opensymphony.xwork2.ActionContext;
import com.sunrise.jop.infrastructure.db.DBAccessUser;

/**
 * @author He Kun
 *
 */
public class Struts2UserProvider implements UserProvider {

	/**
	 * ����Struts2 �ķ�ʽ��ȡUser
	 */
	public DBAccessUser getUser() {				
		DBAccessUser user = (DBAccessUser)ActionContext.getContext().getSession().get(WebConstant.SESSION_ATTRIBUTE_USER);		
		return user;
	}
}
