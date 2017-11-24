package com.sunrise.jop.common.utils.lang;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunrise.jop.common.spring.SpringContextManager;

/**
 * 后台程序只有一个SessionFactory，所以这里简化SessionUtils的代码。
 * @author hbm
 *
 */
public class SessionUtils {

	public static Session currentSession(String dbFlag) throws HibernateException {
//		return currentSession();
		SessionFactory sf = getSessionFactory(dbFlag);
		return sf.getCurrentSession();
	}
	
	public static Session currentSession() throws HibernateException {
		return currentSession(null);
	}
	
	public static SessionFactory getSessionFactory() throws HibernateException{
		return getSessionFactory(null);
	}
	
	public static SessionFactory getSessionFactory(String dbFlag) throws HibernateException{
		//2层捕获
		SessionFactory sf ;
		if(SpringContextManager.containsBean(SpringContextManager.HIBERNATE_SESSION_FACTORY_NAME)){
			sf = (SessionFactory) SpringContextManager.getBean(SpringContextManager.HIBERNATE_SESSION_FACTORY_NAME );
		}else{
			String dbName = dbFlag.startsWith("DB_")? dbFlag : "DB_" + dbFlag;
			sf = (SessionFactory) SpringContextManager.getBean(SpringContextManager.HIBERNATE_SESSION_FACTORY_NAME + "_" + dbName);
		}
		return sf;
	}	

	
	public static Session currentSession(Class clazz,String dbFlag) throws HibernateException {
		return currentSession(dbFlag);
	}
	
	public static SessionFactory getSessionFactory(Class clazz,String dbFlag) throws HibernateException{
		return getSessionFactory(dbFlag);
	}
}
