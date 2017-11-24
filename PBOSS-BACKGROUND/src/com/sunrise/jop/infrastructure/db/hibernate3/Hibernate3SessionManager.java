package com.sunrise.jop.infrastructure.db.hibernate3;

import org.apache.commons.logging.*;
import org.hibernate.*;
import org.hibernate.classic.Session;

import com.sunrise.jop.infrastructure.db.*;

/**
 * Title:
 * <p/>
 * Description:
 * <p/>
 * Copyright: Copyright (c) 2006
 * <p/>
 * Company: sunrise
 * 
 * @author Duhuazheng && HuangBaiming, He Kun
 * @version 1.1 HuangBaiming 2006-8-28 ��Ӷ����ݿ�֧��
 * @version 1.2 Hekun ͨ�û���ע��ʽʵ��
 */
public class Hibernate3SessionManager implements SessionManager, SessionGetter {

	private static Log log = LogFactory.getLog(Hibernate3SessionManager.class);

	private SessionFactory sessionFactory;

	public Hibernate3SessionManager() {
	}

	/**
	 * newDAO �ӿڵľ���ʵ�֡��˴�����һ��Hibernate3BaseDAO ��ʵ�������ݲ�ʹ��
	 */
	public BaseDAO newDAO() {
		BaseDAO dao = new Hibernate3BaseDAO();
		dao.setSessionManager(this); // ע��
		return dao;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Object getCurrentSession() {
		Session session = getSessionFactory().getCurrentSession();
		return session;
		
	}

}
