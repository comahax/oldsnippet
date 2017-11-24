package com.sunrise.jop.common.spring;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.hibernate.engine.SessionFactoryImplementor;
import org.springframework.orm.hibernate3.SpringSessionContext;

/**
 * @author hbm
 */
public class JopSessionContext extends SpringSessionContext {

	private static final long serialVersionUID = -6655445442107764080L;
	private static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
	private static SessionFactoryImplementor sessionFactory;

	/**
	 * @param sessionFactory
	 */
	public JopSessionContext(SessionFactoryImplementor sf) {
		super(sf);
		sessionFactory = sf;
	}

	public Session currentSession() throws HibernateException {
		try {
			return super.currentSession(); // 默认使用SpringSessionContext来获取session
		} catch (Exception ex) {
			return jopCurrentSession();
		}
	}

	public static Session jopCurrentSession() {
		Session session = (Session) threadSession.get();
		if (session == null || !session.isOpen()) {
			session = sessionFactory.openSession();
			threadSession.set(session);
		}
		return session;
	}

}
