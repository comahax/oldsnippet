package com.sunrise.jop.infrastructure.config;

import java.util.*;

public class CoreConfigInfo {

	/**
	 * --------���ģ��������������------------------------------------------------------
	 */
	// hibernate path ǰ׺
	public static final String HIBERNATE_PATH_PREFIX = "/";
	// hibernate path ��׺
	public static final String HIBERNATE_PATH_POSTFIX = ".cfg.xml";
	// �����ļ��ĸ�Ŀ¼
	public static final String CFG_ROOT_PATH = "data";
	// sessionFactory�������ļ�
	public static final String SESSION_FACTORY_FILE_PATH = "/data/sessionFactory.properties";
	// cityid mapping �����ļ�
	public static final String CITYID_MAPPING_FILE_PATH = "/data/cityidMapping.properties";
	// common DAO �����ļ�
	public static final String COMMON_DAO_FILE_PATH = "/data/commonDBTable.properties";
	// DAO ʵ����
	public static final String DAO_IMPLEMENT = "com.sunrise.jop.infrastructure.db.hibernate3.Hibernate3BaseDAO";
	// SESSION ʵ����
	public static final String SESSION_IMPLEMENT = "com.sunrise.jop.infrastructure.db.hibernate3.Hibernate3SessionManager";
	/**
	 * ------------------------------------------------------------------------
	 */

	private static ResourceBundle rs = null;

	/**
	 * --------Flag��ʶ����������------------------------------------------------------
	 */
	// �Ƿ���WebSphere������
	public static boolean RUN_BY_WEBSPHERE_FLAG = true;
	// �Ƿ�ʹ��EJB
	public static boolean EJB_FLAG = false;
	// �Ƿ���Ҫ�����¼
	public static boolean LOGIN_FLAG = true;
	// ���Բ˵�Ȩ�ޣ��������Ի�����
	public static boolean IGNORE_MENU_PERM_FLAG = true;
	// �Ƿ�ʹ�û���
	public static boolean USE_CACHE_FLAG = false;
	/**
	 * ------------------------------------------------------------------------
	 */

	// �������ʶ
	public static String COMMON_DB_NAME;
	// Ĭ��ҳ��
	public static String DEFAULT_PAGE;
	// Ĭ��ҳ��С
	public static String DEFAULT_PAGE_SIZE;

	// ����JUNIT�����õ���������
	public static String TEST_JDBC_URL;
	public static String TEST_JDBC_DRIVER;
	public static String TEST_JDBC_USER;
	public static String TEST_JDBC_PASSWORD;

	// FTP����
	public static String FTP_ADDRESS;
	public static String FTP_PORT;
	public static String FTP_USER;
	public static String FTP_PASSWORD;
	public static String FTP_WORK_DIR;

	// �ϴ�������Ŀ¼
	public static String UPLOAD_LOCATION;
	public static String DOWNLOAD_LOCATION;

	// BOSS SOCKET �����ַ�Ͷ˿�
	public static String BOSS_SOCKET_SERVER_ADDRESS;
	public static String BOSS_SOCKET_SERVER_PORT;
	public static String BOSS_SOCKET_SERVER_CHARSET;
	
	//����Ӫҵ���߳���
	public static String SERVICE_SMS_SOCKETSERVER_PROCESSORCOUNT;
	
	static {
		try {
			// ��ȡ���ֲ���
			rs = ResourceBundle.getBundle("coreconfiginfo");

			RUN_BY_WEBSPHERE_FLAG = rs.getString("run.by.websphere.flag").equalsIgnoreCase("yes");
			EJB_FLAG = rs.getString("ejb.flag").equalsIgnoreCase("yes");
			LOGIN_FLAG = rs.getString("login.flag").equalsIgnoreCase("yes");
			IGNORE_MENU_PERM_FLAG = rs.getString("ignore.menu.perm.flag").equalsIgnoreCase("yes");
			USE_CACHE_FLAG = rs.getString("use.cache.flag").equalsIgnoreCase("yes");

			COMMON_DB_NAME = rs.getString("common.db.name");
			DEFAULT_PAGE = rs.getString("default.page");
			DEFAULT_PAGE_SIZE = rs.getString("default.page.size");

			TEST_JDBC_URL = rs.getString("jop.test.jdbc.url");
			TEST_JDBC_DRIVER = rs.getString("jop.test.jdbc.driver");
			TEST_JDBC_USER = rs.getString("jop.test.jdbc.user");
			TEST_JDBC_PASSWORD = rs.getString("jop.test.jdbc.password");

			FTP_ADDRESS = rs.getString("ftp.address");
			FTP_PORT = rs.getString("ftp.port");
			FTP_USER = rs.getString("ftp.user");
			FTP_PASSWORD = rs.getString("ftp.password");
			FTP_WORK_DIR = rs.getString("ftp.work.dir");

			UPLOAD_LOCATION = rs.getString("upload.location");
			DOWNLOAD_LOCATION = rs.getString("download.location");
			
			BOSS_SOCKET_SERVER_ADDRESS =  rs.getString("boss.socket.server.address");
			BOSS_SOCKET_SERVER_PORT =  rs.getString("boss.socket.server.port");
			BOSS_SOCKET_SERVER_CHARSET = rs.getString("boss.socket.server.charset");
			SERVICE_SMS_SOCKETSERVER_PROCESSORCOUNT = rs.getString("service.sms.socketserver.processorCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private CoreConfigInfo() {

	}

}