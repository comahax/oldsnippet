package com.sunrise.jop.infrastructure.locator;

import java.util.*;

import javax.ejb.*;
import javax.naming.*;
import javax.sql.*;

import org.springframework.orm.toplink.*;

import com.sunrise.jop.exception.system.*;
import com.sunrise.jop.infrastructure.config.*;

/**
 * 
 * <p>
 * Title: GDIBOSS
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author HuangBaiming
 * 
 * @version 1.0
 */
public class ServiceLocator {
	private static ServiceLocator serviceLocator;

	private static InitialContext initialContext;

	private static Hashtable localhomeTable = new Hashtable();

	private static Hashtable datasourceTable = new Hashtable();

	private static Hashtable sessionFactoryTable = new Hashtable();

	protected ServiceLocator() throws ServiceLocatorException {
		try {
			initialContext = getInitialContext();
		} catch (Exception e) {
			throw new ServiceLocatorException(
					ServiceLocatorException.ERROR_CODE_LOCATOR_COMMON, "", e);
		}
	}

	/**
	 * 取得一个服务定位器的实例
	 */
	public static synchronized ServiceLocator getInstance()
			throws ServiceLocatorException {
		if (serviceLocator == null) {
			serviceLocator = new ServiceLocator();
		}
		return serviceLocator;
	}

	/**
	 * 取J2EE服务器的相关环境变量
	 */
	public static InitialContext getInitialContext() throws NamingException {
		return new InitialContext();
	}

	/**
	 * 取指定的 ejb local home
	 */
	public synchronized EJBLocalHome getEjbLocalHome(String ejbName)
			throws ServiceLocatorException {
		try {
			EJBLocalHome ejbLocalHome = (EJBLocalHome) localhomeTable
					.get(ejbName);
			if (ejbLocalHome == null) {
				String jndi = makeJndi(ejbName);
				Object object = initialContext.lookup(jndi);
				ejbLocalHome = (EJBLocalHome) object;
				if (ejbLocalHome == null) {
					throw new ServiceLocatorException("locator.err.ejb",
							ejbName, null);
				}
				localhomeTable.put(ejbName, ejbLocalHome);
			}
			return ejbLocalHome;
		} catch (NamingException ne) {
			throw new ServiceLocatorException(ne.getMessage(), ne);
		}
	}

	/**
	 * 取指定的 data source
	 */
	public synchronized DataSource getDataSource(String datasourceName)
			throws ServiceLocatorException {
		try {
			DataSource dataSource = (DataSource) datasourceTable
					.get(datasourceName);
			if (dataSource == null) {
				dataSource = (DataSource) initialContext.lookup(datasourceName);
				if (dataSource == null) {
					throw new ServiceLocatorException("locator.err.datasource",
							datasourceName, null);
				}
				datasourceTable.put(datasourceName, dataSource);
			}
			return dataSource;
		} catch (NamingException ne) {
			throw new ServiceLocatorException(ne.getMessage(), ne);
		}
	}

	/**
	 * 取指定的 Session Factory
	 * 
	 */
	public SessionFactory getSessionFactory(String sessionFactoryName)
			throws ServiceLocatorException {
		try {
			SessionFactory sessionFactory = (SessionFactory) sessionFactoryTable
					.get(sessionFactoryName);
			if (sessionFactory == null) {
				sessionFactory = (SessionFactory) initialContext
						.lookup(sessionFactoryName);
				if (sessionFactory == null) {
					throw new ServiceLocatorException(
							"locator.err.sessionfactory", sessionFactoryName,
							null);
				}
				sessionFactoryTable.put(sessionFactoryName, sessionFactory);
			}
			return sessionFactory;
		} catch (NamingException ne) {
			throw new ServiceLocatorException(ne.getMessage(), ne);
		}
	}

	public String makeJndi(String jndi) {
		// jboss4 local jindi prefix :
		// websphere6 local jindi prefix : local:ejb/

		if (CoreConfigInfo.RUN_BY_WEBSPHERE_FLAG)
			return "local:ejb/" + jndi.replace('.', '/');
		else
			return "" + jndi.replace('.', '/');
	}
}
