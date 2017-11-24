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
 * @version 1.1 HuangBaiming 2006-8-28 添加多数据库支持
 * @version 1.2 Hekun 通用化，注入式实现
 */
public class Hibernate3SessionManager implements SessionManager, SessionGetter {

	private static Log log = LogFactory.getLog(Hibernate3SessionManager.class);

	private SessionFactory sessionFactory;

	public Hibernate3SessionManager() {
	}

	/**
	 * newDAO 接口的具体实现。此处创建一个Hibernate3BaseDAO 的实例供数据层使用
	 */
	public BaseDAO newDAO() {
		BaseDAO dao = new Hibernate3BaseDAO();
		dao.setSessionManager(this); // 注入
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
