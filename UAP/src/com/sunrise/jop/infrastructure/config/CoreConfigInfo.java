package com.sunrise.jop.infrastructure.config;

import com.sunrise.jop.common.encrypt.DESCrypterandDecrypter;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class CoreConfigInfo {
	
	/**
	 * --------核心，基本不变的配置------------------------------------------------------
	 */
	// hibernate path 前缀，好像已经没用
	public static final String HIBERNATE_PATH_PREFIX = "/";
	// hibernate path 后缀，好像已经没用
	public static final String HIBERNATE_PATH_POSTFIX = ".cfg.xml";
	// 配置文件的根目录
	public static final String CFG_ROOT_PATH = "data";
	// sessionFactory组配置文件, 已经改到applicationcontext.xml
	public static final String SESSION_FACTORY_FILE_PATH = "/data/sessionFactory.properties";
	// cityid mapping 配置文件
	public static final String CITYID_MAPPING_FILE_PATH = "/data/cityidMapping.properties";
	// common DAO 配置文件
	public static final String COMMON_DAO_FILE_PATH = "/data/commonDBTable.properties";
	// DAO 实现类
	public static final String DAO_IMPLEMENT = "com.sunrise.jop.infrastructure.db.hibernate3.Hibernate3BaseDAO";
	// SESSION 实现类
	public static final String SESSION_IMPLEMENT = "com.sunrise.jop.infrastructure.db.hibernate3.Hibernate3SessionManager";
	//add by 2013-10-30
	public static final String ACCBILL_SOP_URL="";
	/**
	 * ------------------------------------------------------------------------
	 */

	/**
	 * 2011-8-24 jinbo 增加配置清单properties，用于指定JOP2使用的核心配置文件与其它配置文件 路径列表
	 * --------在程序启动路径找配置文件coreconfiginfo.properties,可随意改名--------------------------------
	 * --------提供给独立程序设置日志与配置路径的参数 ------------------------------------------------------
	 */
	// 配置文件清单MAP，可以存点任意的东西，前缀按业务组英文缩写标准
	private static Properties properties = new Properties();
	/**
	 * ------------------------------------------------------------------------
	 */

	private static ResourceBundle rs = null;

	/**
	 * --------Flag标识，布尔类型------------------------------------------------------
	 */
	// 是否在WebSphere下运行
	public static boolean RUN_BY_WEBSPHERE_FLAG = true;
	// 是否使用缓存
	public static boolean USE_CACHE_FLAG = false;
	//登录验证的版本（new/old）
	public static String LOGIN_VERSION="new";
	/**
	 * ------------------------------------------------------------------------
	 */

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
	
	// 测试环境开关
	public static boolean LOGIN_FLAG;
	// 令牌鉴权开关
	public static boolean TOKEN_FLAG;
	// 菜单鉴权开关
	public static boolean MENU_FLAG;
	// 单点登录验证开关
	public static boolean SSO_FLAG;
	// CRM令牌鉴权服务地址 
	public static String TOKEN_WEBSERVICE_URL;
	// CRM票据验证,菜单鉴权服务地址
	public static String SSO_WEBSERVICE_URL;
	
	
	static {
		initial(null);
	}

	// 2011-8-27  jinbo 改造为读取到properties里，并提供给其它程序使用
	private static void initial(String path) {
		try {
			try {
				if (path != null && !path.equals("")){
					properties.load(new FileInputStream(path));
				} else {
					InputStream in = CoreConfigInfo.class.getResourceAsStream("/coreconfiginfo.properties"); 
					properties.load(in);
//					properties.load(ResourceBundle.class.getClassLoader().getResourceAsStream("coreconfiginfo.properties"));
				}
			} catch (Exception e) {
				System.out.println("runtime load error...");
				throw e;
			}
			
			RUN_BY_WEBSPHERE_FLAG = getRuntimeParamString("run.by.websphere.flag").equalsIgnoreCase("yes");
			
			USE_CACHE_FLAG = getRuntimeParamString("use.cache.flag").equalsIgnoreCase("yes");
			LOGIN_VERSION=getRuntimeParam("login.version");

			DEFAULT_PAGE = getRuntimeParam("default.page");
			DEFAULT_PAGE_SIZE = getRuntimeParam("default.page.size");

			TEST_JDBC_URL = getRuntimeParam("jop.test.jdbc.url");
			TEST_JDBC_DRIVER = getRuntimeParam("jop.test.jdbc.driver");
			TEST_JDBC_USER = getRuntimeParam("jop.test.jdbc.user");
			TEST_JDBC_PASSWORD = getRuntimeParam("jop.test.jdbc.password");

			FTP_ADDRESS = getRuntimeParam("ftp.address");
			FTP_PORT = getRuntimeParam("ftp.port");
			FTP_USER = getRuntimeParam("ftp.user");
			FTP_PASSWORD = getRuntimeParam("ftp.password");
			FTP_WORK_DIR = getRuntimeParam("ftp.work.dir");

			UPLOAD_LOCATION = getRuntimeParam("upload.location");
			DOWNLOAD_LOCATION = getRuntimeParam("download.location");
			
			BOSS_SOCKET_SERVER_ADDRESS =  getRuntimeParam("boss.socket.server.address");
			BOSS_SOCKET_SERVER_PORT =  getRuntimeParam("boss.socket.server.port");
			
			TOKEN_WEBSERVICE_URL = getRuntimeParam("token.webservice.url");
			SSO_WEBSERVICE_URL = getRuntimeParam("sso.webservice.url");
			
			LOGIN_FLAG = getRuntimeParamString("login.flag").equalsIgnoreCase("yes");
			SSO_FLAG = getRuntimeParamString("sso.flag").equalsIgnoreCase("yes");
			TOKEN_FLAG = getRuntimeParamString("token.flag").equalsIgnoreCase("yes");
			MENU_FLAG = getRuntimeParamString("menu.flag").equalsIgnoreCase("yes");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private CoreConfigInfo() {
	}
	
	/**
	 * 提供配置文件，强制CoreConfigInfo按这个配置文件进行重新刷新配置
	 * @param path 配置清单文件路径
	 */
	public static void setRuntime(String path){
		initial(path);
	}
	
	/**
	 * 用key来查询配置清单中指定的配置文件路径，没值则返回空
	 * @param key KEY值  
	 */
	public static String getRuntimeParam(String key) {
		String value = null;
		if (properties != null)
			value = properties.getProperty(key);
		return value;
	}

    /**
     * 用key来查询配置清单中指定的配置文件路径，没值则返回空字符串
     */
    public static String getRuntimeParamString(String key) {
        String v = getRuntimeParam(key);
        if (v == null) v = "";
        return v;
    }
	/**
	 * 用key来查询配置清单中指定的配置,解密后再返回，没值则返回空
	 * @param key KEY值
	 */
	public static String getRuntimeDecryptParam(String key) throws Exception {
		String value = null;
		if (properties != null){
			value = properties.getProperty(key);
			DESCrypterandDecrypter des;
			des = new DESCrypterandDecrypter();
			value = des.decrypt(value);
		}
		return value;
	}
	
	/**
	 * 直接将独立程序的启动参数全部传过来设置配置清单，如果有 runtime=/xxx,则设置配置清单文件，无则没反应
	 * @param args 独立程序启动参数
	 */
	public static void setRuntimeByArgs(String[] args){
		if (args != null){
			String runtimePath = null;
			for (int i = 0; i < args.length; i++){
				String param = args[i];
				
				int pos = param.indexOf("runtime=");
				if (pos >= 0){
					runtimePath = param.substring(8);
				}
			}
			setRuntime(runtimePath);
		}
	}
}