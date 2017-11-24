package com.sunrise.jop.common.utils.lang;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunrise.jop.infrastructure.db.SessionGetter;
import com.sunrise.jop.infrastructure.db.SessionManager;
import com.sunrise.jop.infrastructure.db.hibernate3.Hibernate3SessionFactoryRouter;
import com.sunrise.jop.infrastructure.db.hibernate3.Hibernate3SessionManager;

public class SessionUtils {

	public static Session currentSession(String dbFlag) throws HibernateException {
		SessionManager sessionManager = Hibernate3SessionFactoryRouter.getInstance().getSessionManager(dbFlag);
		SessionGetter getter = (SessionGetter)sessionManager;
		return (Session) getter.getCurrentSession();
	}
	
	public static Session currentSession(Class clazz,String dbFlag) throws HibernateException {
		SessionManager sessionManager = Hibernate3SessionFactoryRouter.getInstance().getSessionManager(clazz,dbFlag);
		SessionGetter getter = (SessionGetter)sessionManager;
		return (Session) getter.getCurrentSession();
	}
	
	public static SessionFactory getSessionFactory(Class clazz,String dbFlag) throws HibernateException{
		Hibernate3SessionManager sessionManager = (Hibernate3SessionManager)Hibernate3SessionFactoryRouter.getInstance().getSessionManager(clazz,dbFlag);
		SessionFactory sessionFactory = sessionManager.getSessionFactory();
		return sessionFactory;
	}
}
