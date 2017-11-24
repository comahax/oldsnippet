package com.gmcc.pboss.BgProcess.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

import com.atomikos.jdbc.nonxa.AtomikosNonXADataSourceBean;
import com.sunrise.jop.common.spring.SpringContextManager;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.common.utils.logging.DailyRollingFileLoggerCreator;
import com.sunrise.jop.common.utils.logging.LoggerCreator;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;


public class MdbgBase extends BgBase{

	private String hibernateCommonConfigPath = "/hibernate_comm.cfg.xml";
	private static HashMap<String, Logger> loggers = new HashMap<String, Logger>();
	
	public String getHibernateCommonConfigPath() {
		return hibernateCommonConfigPath;
	}

	public void setHibernateCommonConfigPath(String hibernateCommonConfigPath) {
		this.hibernateCommonConfigPath = hibernateCommonConfigPath;
	}
	
	public static Logger getLogger(String logname) throws Exception {
		Logger logger = loggers.get(logname);
		if(logger == null){
			logger = Logger.getLogger(MdbgBase.class);
		}
		return logger;
	}
	
	/**
	 * 根据当前日期 为 指定的Logger 生成新的日志文件(以当前日期为后缀)
	 * 
	 * @param logger
	 * @throws Exception
	 */
	public static void changeLogFileAttribute(Logger logger) throws Exception {
		DailyRollingFileAppender appender = (DailyRollingFileAppender) logger.getAppender("File");
		String oldFilename = appender.getFile();
		String dateSuffix = oldFilename.substring(oldFilename
				.lastIndexOf(".") + 1);
		String today = PublicUtils.formatUtilDate(new Date(), "yyMMdd");
		if(!today.equals(dateSuffix)) {
			String newFilename = oldFilename.substring(0, oldFilename
					.lastIndexOf(".") + 1)
					+ new SimpleDateFormat("yyMMdd").format(new Date());
			appender.setFile(newFilename);
			appender.activateOptions();
		}
	}
	
	/**
	 * 针对不同的参数检查，这个方法建议大家重写一下
	 */
	protected boolean checkArgs(String[] args) {
		if (args.length < 1) {
			System.out.println(getHelp());
			return false;
		}
		if (!CityMappingUtil.contain(args[0]) || !args[0].equals(CoreConfigInfo.COMMON_DB_NAME)) {
			System.out.println("[cityid] must be ["+CoreConfigInfo.COMMON_DB_NAME+"]");
			return false;
		}
		return true;
	}
	
	/**
	 * 返回帮助信息
	 */
	protected static String getHelp() {
		StringBuffer sb = new StringBuffer();
		sb.append("Explain of args:").append("\n");
		sb.append("the args number is 1").append("\n");
		sb.append("[cityid] must be ["+CoreConfigInfo.COMMON_DB_NAME+"]" ).append("\n");
		return sb.toString();
	}
	
	/**
	 * @throws Exception
	 * 
	 */
	protected void init(String[] args) throws Exception {

		super.initProperties();
		
		// 为短信营业厅接口专门设置独立的根日志文件  by zsw
		Logger rootLogger = Logger.getRootLogger();
		rootLogger.setLevel(Level.INFO);//因日志文件过大，提高日志级别为warn; by yedaoe//2011.5.31:改回info级别
		DailyRollingFileAppender appender = (DailyRollingFileAppender) rootLogger.getAppender("FILE");
		String server_logname = properties.getProperty("Server_log");
		if(server_logname == null) {
			throw new Exception("请先配置好log文件的路径，路径参数名称为Server_log");
		}
		// 日志文件生成在与classpath同级的目录下; by zhangsiwei
		//appender.setFile(MdbgBase.class.getResource("/").getPath()+"../"+server_logname);
		//为方便维护人员修改日志生成目录，改为在SMSService.properties中读取绝对路径;by yedaoe
		appender.setFile(server_logname);
		appender.activateOptions();
		
		LoggerCreator loggerCreator = new DailyRollingFileLoggerCreator();
		
		for(Iterator<String> ittCityid = CityMappingUtil.getMap().keySet().iterator(); ittCityid.hasNext();){
			String cityid = ittCityid.next();
			
			this.createLoggerForCity(loggerCreator,cityid);
			
			// 初始化hibernate相关信息
			String url = properties.getProperty(cityid + "_db_url");
			String username = properties.getProperty(cityid + "_db_user");
			String password = properties.getProperty(cityid + "_db_password");
			String tempPoolsize = properties.getProperty(cityid + "_sms_db_poolsize");
			String poolsize = "5";
			if (tempPoolsize != null) {
				poolsize = tempPoolsize;
			}
			if(StringUtils.isEmpty(url) || StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
				getLogger(cityid+LoggingConstant.SMS_CITY_LOG_ROOT_NAME)
					.warn("------ "+cityid+" DataBase Setting error ! ---------------");
				continue;
			}else{
				getLogger(cityid+LoggingConstant.SMS_CITY_LOG_ROOT_NAME)
					.warn("------ registing "+cityid+" DataBase Setting ---------------");
			}
			
			password = new String(SecurityPass.decode(SecurityPass.hex2byte(password), SecurityPass.hex2byte(mkey)));

			Properties hibernateProperties = new Properties();
			hibernateProperties.setProperty("url", url);
			hibernateProperties.setProperty("user", username);
			hibernateProperties.setProperty("password", password);
			hibernateProperties.setProperty("poolSize", poolsize);
			
			String dbFlag = cityid.startsWith("DB_") ? cityid : "DB_" + cityid;
			this.registerAtomikosDataSourceBean(hibernateProperties, dbFlag);
			this.registerSessionFactoryBean(hibernateProperties , dbFlag);
		}
		
		this.createMonitorDBLogger(loggerCreator, properties.getProperty("Sms_monitorDB_log"));
		SpringContextManager.init3(); // @todo 这里调用初始化有点丑陋，以后改进之
		
		registerTypeConvert();//注册类型转换器
	}
	/**
	 * 为指定地市创建Logger对象，日志信息将输出到与该地市对应的日志文件中
	 * @param loggerCreator
	 * @param cityid
	 * @param args
	 * @throws Exception
	 */
	private void createLoggerForCity(LoggerCreator loggerCreator,String cityid) throws Exception {
		// 初始化log
		String logFilename = properties.getProperty(cityid + "_log");
		if (logFilename != null) {
			// 日志文件生成在与classpath同级的目录下; by zhangsiwei
			//String fileName = MdbgBase.class.getResource("/").getPath()+"../"+logFilename + "." + (new SimpleDateFormat("yyMMdd")).format(new Date());
			//为方便维护人员修改日志生成目录，改为在SMSService.properties中读取绝对路径;by yedaoe
			String fileName = logFilename + "." + (new SimpleDateFormat("yyMMdd")).format(new Date());
			// loggerParams:[ datePattern,conversionPattern,filename,appender,
			// ConsoleAppender.target,ConsoleAppender.threshold ]
			Object[] loggerParams = {"'.'yyyy-MM-dd","%d %-5p [%c{1}] - %m%n",fileName,true,"System.out",Level.INFO};
			Logger logger = loggerCreator.createLogger(cityid+LoggingConstant.SMS_CITY_LOG_ROOT_NAME, loggerParams);
			logger.setLevel(Level.INFO);
			// 设为false，使各地市的日志输出只输出到本地市的日志文件中，而不同时输出到根日志文件中
			logger.setAdditivity(false); 
			
			logger.warn("------"+cityid+":log file changed to " + logFilename + " ---------------");
			loggers.put(cityid+LoggingConstant.SMS_CITY_LOG_ROOT_NAME, logger);
		} else {
			loggers.put(cityid+LoggingConstant.SMS_CITY_LOG_ROOT_NAME, Logger.getLogger(this.getClass()));
		}
	}
	
	/**
	 * 创建监控日志Logger对象
	 * @param loggerCreator
	 * @param logFilename
	 * @throws Exception
	 */
	private void createMonitorDBLogger(LoggerCreator loggerCreator, String logFilename) throws Exception {
		//String fileName = MdbgBase.class.getResource("/").getPath()+"../" + logFilename + "." + (new SimpleDateFormat("yyMMdd")).format(new Date());
		//为方便维护人员修改日志生成目录，改为在SMSService.properties中读取绝对路径;by yedaoe
		String fileName = logFilename + "." + (new SimpleDateFormat("yyMMdd")).format(new Date());
		Object[] loggerParams = {"'.'yyyy-MM-dd","%d %-5p [%c{1}] - %m%n",fileName,true,"System.out",Level.INFO};
		Logger logger = loggerCreator.createLogger(LoggingConstant.MONITOR_DB_CONN_LOGNAME, loggerParams);
		logger.setLevel(Level.INFO);
		// 设为false，使监控日志输出只输出到监控日志文件中，而不同时输出到根日志文件中
		logger.setAdditivity(false);
		loggers.put(LoggingConstant.MONITOR_DB_CONN_LOGNAME, logger);
	}
	
	protected void registerAtomikosDataSourceBean(Properties hibernateProperties , String dsName) {
		
		DefaultListableBeanFactory beanFactory = SpringContextManager.getDefaultBeanFactory();
		PropertyValue pv1 = new PropertyValue("uniqueResourceName", SpringContextManager.HIBERNATE_SESSION_DATASOURCE + "_" + dsName);
		PropertyValue pv2 = new PropertyValue("url", hibernateProperties.get("url"));
		PropertyValue pv3 = new PropertyValue("user", hibernateProperties.get("user"));
		PropertyValue pv4 = new PropertyValue("password", hibernateProperties.get("password"));
		PropertyValue pv5 = new PropertyValue("driverClassName", "oracle.jdbc.driver.OracleDriver");
		String maxPoolSize = (String)hibernateProperties.get("poolSize");
		Integer minPoolSize = Integer.parseInt(maxPoolSize)/2;
		PropertyValue pv6 = new PropertyValue("minPoolSize", minPoolSize);
		PropertyValue pv7 = new PropertyValue("maxPoolSize",maxPoolSize);
		PropertyValue pv8 = new PropertyValue("borrowConnectionTimeout",30);
		
		MutablePropertyValues pvs = new MutablePropertyValues();
		pvs.addPropertyValue(pv1);
		pvs.addPropertyValue(pv2);
		pvs.addPropertyValue(pv3);
		pvs.addPropertyValue(pv4);
		pvs.addPropertyValue(pv5);
		pvs.addPropertyValue(pv6);
		pvs.addPropertyValue(pv7);
		pvs.addPropertyValue(pv8);

		RootBeanDefinition beanDefinition = new RootBeanDefinition();
		beanDefinition.setBeanClassName(AtomikosNonXADataSourceBean.class.getName());
		beanDefinition.setSingleton(true); // 默认为true, 需要增加可配置性
		beanDefinition.setInitMethodName("init");
		beanDefinition.setDestroyMethodName("close");
		beanDefinition.setPropertyValues(pvs);
		beanFactory.registerBeanDefinition(SpringContextManager.HIBERNATE_SESSION_DATASOURCE + "_" + dsName, beanDefinition);
		
	}
	
	/**
	 * 
	 * 初始化hibernate，并注册到spring容器里面
	 * 
	 */
	protected void registerSessionFactoryBean(Properties hibernateProperties , String dbName) {
		
		DefaultListableBeanFactory beanFactory = SpringContextManager.getDefaultBeanFactory();
		
		String customHibernateConfigPath = CoreConfigInfo.COMMON_DB_NAME
				.equals(dbName) ? hibernateCommonConfigPath
				: hibernateConfigPath;
		String configPath = customHibernateConfigPath.startsWith("classpath:") ? customHibernateConfigPath : "classpath:" + customHibernateConfigPath;
		PropertyValue pv1 = new PropertyValue("configLocations", configPath);
		PropertyValue pv2 = new PropertyValue("dataSource", SpringContextManager.getBean(SpringContextManager.HIBERNATE_SESSION_DATASOURCE + "_" + dbName));
		PropertyValue pv3 = new PropertyValue("jtaTransactionManager", SpringContextManager.getBean("atomikosTransactionManager"));
		
		MutablePropertyValues pvs = new MutablePropertyValues();
		pvs.addPropertyValue(pv1);
		pvs.addPropertyValue(pv2);
		pvs.addPropertyValue(pv3);

		RootBeanDefinition beanDefinition = new RootBeanDefinition();
		beanDefinition.setBeanClassName(LocalSessionFactoryBean.class.getName());
		beanDefinition.setSingleton(true); // 默认为true, 需要增加可配置性
		beanDefinition.setPropertyValues(pvs);
		beanFactory.registerBeanDefinition(SpringContextManager.HIBERNATE_SESSION_FACTORY_NAME + "_" + dbName, beanDefinition);
		
	}
}
