package com.sunrise.jop.infrastructure.db;

/**
 * ԭ����SessionUtil����Ϊ�ӿڣ�ʵ��ΪHibernate3SessionManager
 * @author bo
 *
 */
public interface SessionManager{

	public BaseDAO newDAO();
	
	public SessionFactoryRouter getSessionFactoryRouter();
	
	

}