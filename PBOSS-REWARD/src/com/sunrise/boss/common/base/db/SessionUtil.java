package com.sunrise.boss.common.base.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sunrise.boss.common.base.locator.ServiceLocator;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;

/**
 * Title: <p/> Description: <p/> Copyright: Copyright (c) 2006 <p/> Company:
 * sunrise
 * 
 * @author Duhuazheng && HuangBaiming
 * @version 1.1 HuangBaiming 2006-8-28 添加多数据库支持
 * @version 1.2 HuangBaiming 2007-7-26
 *          添加更新sessionFactoryHashMap的方法，修改sessionFactoryHashMap初始化方法
 */
public class SessionUtil {

	private static HashMap sessionFactoryHashMap = new HashMap(); // 保存多个数据库对应的sessionFactory

	public static SessionFactory obtainSessionFactory(String dbFlag) throws Exception {
		dbFlag = SessionFactoryRouter.conversionDbFlag(dbFlag);// dbFlag规则
		if (sessionFactoryHashMap.containsKey(dbFlag)) {
			return (SessionFactory) sessionFactoryHashMap.get(dbFlag);
		}
		throw new Exception("can't obtain sessionFactroy by dbFlag:" + dbFlag);
	}

	private static Logger log = Logger.getRootLogger();

	static { // 初始化操作
		try {
			InputStream in = SessionUtil.class.getResourceAsStream(SysInfo.SESSION_FACTORY_FILE_PATH);
			Properties properties = new Properties();
			properties.load(in);
			in.close();

			Iterator iter = properties.keySet().iterator();

			String dbFlag, configName;
			SessionFactory sessionFactory;

			while (iter.hasNext()) {
				dbFlag = (String) iter.next();
				configName = properties.getProperty(dbFlag).trim();
				sessionFactory = new Configuration().configure(SysInfo.HIBERNATE_PATH_PREFIX + configName + SysInfo.HIBERNATE_PATH_POSTFIX).buildSessionFactory();
				sessionFactoryHashMap.put(dbFlag, sessionFactory);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			log.fatal(ex);
			throw new RuntimeException("Exception building SessionFactory : " + ex.getMessage(), ex);
		}
	}

	private static final ThreadLocal threadSession = new ThreadLocal();

	public static Session currentSession(String dbFlag) throws HibernateException {

		dbFlag = SessionFactoryRouter.conversionDbFlag(dbFlag);// dbFlag规则

		SessionFactory sf = (SessionFactory) sessionFactoryHashMap.get(dbFlag);
		if (sf == null) {
			throw new RuntimeException("SessionFactory not initial by dbFlag:" + dbFlag);
		}
		return sf.getCurrentSession();
	}

	/**
	 * ControlProxy 类专用方法，程序员请不要在代码里使用 如果一定要使用的话，该方法要和newSession()方法同时在一段代码里使用
	 * 
	 * @throws HibernateException
	 */
	public static void closeSession() throws HibernateException {
		ThreadSession ts = (ThreadSession) threadSession.get();
		ts.count = ts.count - 1;
		if (ts.count == 0) {
			HashMap sm = ts.getSessionMap();
			Iterator iter = sm.keySet().iterator();
			String dbFlag;
			Session sess;
			while (iter.hasNext()) {
				dbFlag = (String) iter.next();
				sess = ts.getSession(dbFlag);
				if (sess != null) {
					try {
						sess.close();
					} catch (Throwable e) {
						log.error("session close error", e);
						sess = null;
					}
				}
			}
			sm.clear();
			threadSession.set(null);
		} else if (ts.count < 0) {
			log.fatal("ThreadSession count < 0");
			throw new RuntimeException("ThreadSession count < 0");
		}
		// count 还大于0时不关闭session
	}

	/**
	 * ControlProxy 类专用方法，程序员请不要在代码里使用 如果一定要使用的话，该方法要和closeSession()方法同时在一段代码里使用
	 */
	public static void newSession() {
		ThreadSession ts = (ThreadSession) threadSession.get();
		if (ts == null) {
			ts = new ThreadSession();
			threadSession.set(ts);
		}
		ts.count = ts.count + 1;
	}

	/**
	 * 更新sessionFactoryHashMap 返回更新的地市标识
	 * 
	 * 该方法主要用于割接时可以在不重启应用的情况下放开新地市的数据源
	 * 
	 * @return
	 */
	public synchronized static String[] updateSessionFactoryHashMap() {
		String[] dbFlags = new String[30]; // 保存更新的地市标识
		int i=0;
		
		try {
			java.net.URL cfgPath = SessionUtil.class.getResource("/");
			System.out.println("root = " + cfgPath);
			
			
			InputStream ins = SessionUtil.class.getResourceAsStream(SysInfo.SESSION_FACTORY_FILE_PATH);
			Properties p = new Properties();
			p.load(ins);
			ins.close();

			Iterator iter = p.keySet().iterator();

			String dbFlag, configName;
			SessionFactory sessionFactory;
			while (iter.hasNext()) {
				dbFlag = (String) iter.next();
				if (!sessionFactoryHashMap.containsKey(dbFlag)) {
					dbFlags[i++]=dbFlag;
					configName = p.getProperty(dbFlag).trim();
					sessionFactory = new Configuration().configure(SysInfo.HIBERNATE_PATH_PREFIX + configName + SysInfo.HIBERNATE_PATH_POSTFIX).buildSessionFactory();
					sessionFactoryHashMap.put(dbFlag, sessionFactory);
				}
			}

		} catch (Exception ex) {
			dbFlags[i] = "update error";
			ex.printStackTrace();
			log.fatal(ex);
			throw new RuntimeException("Exception building SessionFactory : " + ex.getMessage(), ex);
		}

		return dbFlags;
	}
}
