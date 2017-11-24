package com.sunrise.jop.infrastructure.config;

import java.util.*;

public class CoreConfigInfo {

	/**
	 * --------核心，基本不变的配置------------------------------------------------------
	 */
	// hibernate path 前缀
	public static final String HIBERNATE_PATH_PREFIX = "/";
	// hibernate path 后缀
	public static final String HIBERNATE_PATH_POSTFIX = ".cfg.xml";
	// 配置文件的根目录
	public static final String CFG_ROOT_PATH = "data";
	// sessionFactory组配置文件
	public static final String SESSION_FACTORY_FILE_PATH = "/data/sessionFactory.properties";
	// cityid mapping 配置文件
	public static final String CITYID_MAPPING_FILE_PATH = "/data/cityidMapping.properties";
	// common DAO 配置文件
	public static final String COMMON_DAO_FILE_PATH = "/data/commonDBTable.properties";
	// DAO 实现类
	public static final String DAO_IMPLEMENT = "com.sunrise.jop.infrastructure.db.hibernate3.Hibernate3BaseDAO";
	// SESSION 实现类
	public static final String SESSION_IMPLEMENT = "com.sunrise.jop.infrastructure.db.hibernate3.Hibernate3SessionManager";
	/**
	 * ------------------------------------------------------------------------
	 */

	private static ResourceBundle rs = null;

	/**
	 * --------Flag标识，布尔类型------------------------------------------------------
	 */
	// 是否在WebSphere下运行
	public static boolean RUN_BY_WEBSPHERE_FLAG = true;
	// 是否使用EJB
	public static boolean EJB_FLAG = false;
	// 是否不需要检验登录
	public static boolean LOGIN_FLAG = true;
	// 忽略菜单权限（仅供测试环境）
	public static boolean IGNORE_MENU_PERM_FLAG = true;
	// 是否使用缓存
	public static boolean USE_CACHE_FLAG = false;
	/**
	 * ------------------------------------------------------------------------
	 */

	// 公共库标识
	public static String COMMON_DB_NAME;
	// 默认页码
	public static String DEFAULT_PAGE;
	// 默认页大小
	public static String DEFAULT_PAGE_SIZE;

	// 用于JUNIT测试用的连接配置
	public static String TEST_JDBC_URL;
	public static String TEST_JDBC_DRIVER;
	public static String TEST_JDBC_USER;
	public static String TEST_JDBC_PASSWORD;

	// FTP参数
	public static String FTP_ADDRESS;
	public static String FTP_PORT;
	public static String FTP_USER;
	public static String FTP_PASSWORD;
	public static String FTP_WORK_DIR;

	// 上传、下载目录
	public static String UPLOAD_LOCATION;
	public static String DOWNLOAD_LOCATION;

	// BOSS SOCKET 服务地址和端口
	public static String BOSS_SOCKET_SERVER_ADDRESS;
	public static String BOSS_SOCKET_SERVER_PORT;
	public static String BOSS_SOCKET_SERVER_CHARSET;
	
	//短信营业厅线程数
	public static String SERVICE_SMS_SOCKETSERVER_PROCESSORCOUNT;
	
	static {
		try {
			// 读取部分参数
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