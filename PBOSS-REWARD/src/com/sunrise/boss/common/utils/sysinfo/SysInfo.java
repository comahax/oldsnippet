package com.sunrise.boss.common.utils.sysinfo;

import java.util.*;

/**
 * User: JinBo Date: 2006-4-19 Time: 16:55:06
 */
public class SysInfo {
	

	private static ResourceBundle rs = null;

	private static SysInfo _instance = null;

	// 是否使用容器的DataSource
	public static boolean USE_DATASOURCE = false;

	// 是否在WebSphere下运行
	public static boolean RUN_BY_WEBSPHERE = true;
	
	public static boolean TESTFLAG;
	
	public static boolean LOGINFLAG;

	public static String COMMON_DB_FLAG = "DB_TEST";

	public static String DEFAULT_PAGE = "1";

	public static int DEFAULT_PAGE_SIZE = 15;

	public static String DEFAULT_LINES_PER_PAGE = "15";

	public static String SESSION_ATTRIBUTE_USER = "BOSS_USER";

	public static String RESOURCE_REG_PATH = "/resource/resourcereg.xml";
	public static String RESOURCE_SAVE_PATH="/com/sunrise/boss/resource/";
	
    // hibernate path 前缀
	public static String HIBERNATE_PATH_PREFIX = "/";
    // hibernate path 后缀
    public static String HIBERNATE_PATH_POSTFIX = ".cfg.xml";
	// code2name的配置文件路径
	public static String CODE2NAME_FILE_PATH = "/com/sunrise/boss/resource/code2name/code2name.xml";
    // morecode2name的配置文件路径
	public static String MORECODE2NAME_FILE_PATH = "/com/sunrise/boss/resource/morecode2name/morecode2name.xml";
    // sessionFactory组配置文件
	public static String SESSION_FACTORY_FILE_PATH = "/com/sunrise/boss/resource/db/sessionFactory.properties";
	//cityid mapping 配置文件
	public static  String CITYID_MAPPING_FILE_PATH = "/com/sunrise/boss/resource/db/cityidMapping.properties";
	//common DAO 配置文件
	public static String COMMON_DAO_FILE_PATH = "/com/sunrise/boss/resource/db/commonDBTable.properties";
	//	访问计费出帐步骤状态
    public static String ACCBILL_SOP_URL = "http://10.243.178.225:9080/monitor/bam/billStatus.jsp"; 
    //	各个cityid对应的内存数据库dbflag 配置文件
	public static  String CITYIDTT_MAPPING_FILE_PATH = "/com/sunrise/boss/resource/db/cityidTimesTenMaping.properties";
	//	各个号段对应的内存数据库dbflag 配置文件
	public static  String NODEIDTT_MAPPING_FILE_PATH = "/com/sunrise/boss/resource/db/nodeid2jndi.properties";
	
    public static String CACHE_JOB_NAME = "dictcachejob";

    public static boolean USE_CACHE_FLAG=true;
    
    public static boolean IS_CHECK_PERMISSION=true;
    public static boolean IS_USE_WEBSPHERE_CACHE=true;
    //在23楼访问服务开通的正式地址
    //public static String WEBSERVICE_SOP_URL = "http://180.200.3.109/bosssp/services/PublicFacade";
    //在10楼访问服务开通的正式地址
    //public static String WEBSERVICE_SOP_URL = "http://10.243.210.118/bosssp/services/PublicFacade";
    //在23楼访问服务开通的暂时地址，迟点将失效
    public static String WEBSERVICE_SOP_URL = "http://180.200.3.170:21004/bosssp/services/PublicFacade";

    public static String FTP_ADDRESS = "10.243.212.40";
    public static int FTP_PORT = 21;
    public static String FTP_USER = "cxbak";
    public static String FTP_PASSWORD = "cxbak123";
    public static String FTP_WORKDIR = "cxbak";
    
    public static String FTP_REWARDUPLOAD = "rewardupload";
    
//    public static int THRESHHOLD = 65000;

    static {
		try {
			rs = ResourceBundle.getBundle("sysinfo");
			USE_DATASOURCE = rs.getString("user.datasource").equalsIgnoreCase("yes");
			RUN_BY_WEBSPHERE = rs.getString("run.by.websphere").equalsIgnoreCase("yes");
//			TESTFLAG = rs.getString("testflag").equalsIgnoreCase("yes");
			LOGINFLAG = rs.getString("loginflag").equalsIgnoreCase("yes");
			COMMON_DB_FLAG = rs.getString("common.db.flag");
			DEFAULT_PAGE = rs.getString("default.page");
			DEFAULT_PAGE_SIZE = Integer.parseInt(rs.getString("default.page.size"));
			DEFAULT_LINES_PER_PAGE = rs.getString("default.lines.per.page");
			SESSION_ATTRIBUTE_USER = rs.getString("session.attribute.user");
			HIBERNATE_PATH_PREFIX = rs.getString("hibernate.path.prefix");
			HIBERNATE_PATH_POSTFIX = rs.getString("hibernate.path.postfix");
//	下面的文件路径还是不读取配置文件比较适合			
//			CODE2NAME_FILE_PATH = rs.getString("code2name.file.path");
//			MORECODE2NAME_FILE_PATH = rs.getString("morecode2name.file.path");
//			SESSION_FACTORY_FILE_PATH = rs.getString("session.factory.file.path");
//			CITYID_MAPPING_FILE_PATH = rs.getString("cityid.mapping.file.path");
//			COMMON_DAO_FILE_PATH = rs.getString("common.dao.file.path");
			
			ACCBILL_SOP_URL = rs.getString("accbill.sop.url");
			CACHE_JOB_NAME = rs.getString("cache.job.name");
			USE_CACHE_FLAG = rs.getString("use.cache.flag").equalsIgnoreCase("yes");
            WEBSERVICE_SOP_URL = rs.getString("webservice.sop.url");
            IS_CHECK_PERMISSION = rs.getString("check.permission")
			.equalsIgnoreCase("yes")||rs.getString("check.permission")
			.equalsIgnoreCase("true");
            IS_USE_WEBSPHERE_CACHE=rs.getString("cache.use.websphere")
			.equalsIgnoreCase("yes")||rs.getString("cache.use.websphere")
			.equalsIgnoreCase("true");
            RESOURCE_REG_PATH=rs.getString("resource.reg.path");
            RESOURCE_SAVE_PATH=rs.getString("resource.save.path");
            
            FTP_ADDRESS=rs.getString("ftp.address");
            FTP_PORT=Integer.parseInt(rs.getString("ftp.port"));
            FTP_USER=rs.getString("ftp.user");
            FTP_PASSWORD=rs.getString("ftp.password");
            FTP_WORKDIR=rs.getString("ftp.workdir");
            
            FTP_REWARDUPLOAD=rs.getString("ftp.rewardUpload");
            
//            THRESHHOLD=Integer.parseInt(rs.getString("query.export.collection.threshhold"));
        } catch (MissingResourceException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean testFlag = TESTFLAG;

	private String pageNo = DEFAULT_PAGE;

	private int pageSize = DEFAULT_PAGE_SIZE;

	private String linePerPage = DEFAULT_LINES_PER_PAGE;

	private SysInfo(){

	}

	public static SysInfo getInstance() {
		if (_instance == null)
			_instance = new SysInfo();
		return _instance;
	}

	public String getPageNo() {
		return pageNo;
	}


	public int getPageSize() {
		return pageSize;
	}


	public boolean getTestFlag() {
		return testFlag;
	}


	public String getLinePerPage() {
		return linePerPage;
	}

}