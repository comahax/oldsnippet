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
 * @version 1.1 HuangBaiming 2006-8-28 ��Ӷ����ݿ�֧��
 * @version 1.2 HuangBaiming 2007-7-26
 *          ��Ӹ���sessionFactoryHashMap�ķ������޸�sessionFactoryHashMap��ʼ������
 */
public class SessionUtil {

	private static HashMap sessionFactoryHashMap = new HashMap(); // ���������ݿ��Ӧ��sessionFactory

	public static SessionFactory obtainSessionFactory(String dbFlag) throws Exception {
		dbFlag = SessionFactoryRouter.conversionDbFlag(dbFlag);// dbFlag����
		if (sessionFactoryHashMap.containsKey(dbFlag)) {
			return (SessionFactory) sessionFactoryHashMap.get(dbFlag);
		}
		throw new Exception("can't obtain sessionFactroy by dbFlag:" + dbFlag);
	}

	private static Logger log = Logger.getRootLogger();

	static { // ��ʼ������
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

		dbFlag = SessionFactoryRouter.conversionDbFlag(dbFlag);// dbFlag����

		SessionFactory sf = (SessionFactory) sessionFactoryHashMap.get(dbFlag);
		if (sf == null) {
			throw new RuntimeException("SessionFactory not initial by dbFlag:" + dbFlag);
		}
		return sf.getCurrentSession();
	}

	/**
	 * ControlProxy ��ר�÷���������Ա�벻Ҫ�ڴ�����ʹ�� ���һ��Ҫʹ�õĻ����÷���Ҫ��newSession()����ͬʱ��һ�δ�����ʹ��
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
		// count ������0ʱ���ر�session
	}

	/**
	 * ControlProxy ��ר�÷���������Ա�벻Ҫ�ڴ�����ʹ�� ���һ��Ҫʹ�õĻ����÷���Ҫ��closeSession()����ͬʱ��һ�δ�����ʹ��
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
	 * ����sessionFactoryHashMap ���ظ��µĵ��б�ʶ
	 * 
	 * �÷�����Ҫ���ڸ��ʱ�����ڲ�����Ӧ�õ�����·ſ��µ��е�����Դ
	 * 
	 * @return
	 */
	public synchronized static String[] updateSessionFactoryHashMap() {
		String[] dbFlags = new String[30]; // ������µĵ��б�ʶ
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
