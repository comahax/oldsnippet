package com.gmcc.pboss.BgProcess.base;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.ByteConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

import com.atomikos.jdbc.nonxa.AtomikosNonXADataSourceBean;
import com.gmcc.pboss.BgProcess.base.convert.SqlDateConverter;
import com.gmcc.pboss.BgProcess.base.convert.SqlTimestampConverter;
import com.gmcc.pboss.BgProcess.base.convert.UtilDateConverter;
import com.sunrise.jop.common.spring.SpringContextManager;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.ui.User;

public class BgCommonBase {
	protected static final String mkey = "70469B26CBF1E575";

	protected String hibernateConfigPath = "/hibernate.cfg.xml"; // 建议不同的后台程序用不同的Hibernate配置文件，预防有冲突
	
	private String hibernateCommonConfigPath = "/hibernate_comm.cfg.xml";
	
	public String getHibernateCommonConfigPath() {
		return hibernateCommonConfigPath;
	}

	public void setHibernateCommonConfigPath(String hibernateCommonConfigPath) {
		this.hibernateCommonConfigPath = hibernateCommonConfigPath;
	}
	
	public static Properties dbMap;

	public String getHibernateConfigPath() {
		return hibernateConfigPath;
	}

	public void setHibernateConfigPath(String hibernateConfigPath) {
		this.hibernateConfigPath = hibernateConfigPath;
	}

	protected String myProfilePath; // 个性化properties配置文件

	public String getMyProfilePath() {
		return myProfilePath;
	}

	public void setMyProfilePath(String myProfilePath) {
		this.myProfilePath = myProfilePath;
	}

	protected Properties properties = new Properties(); // 将配置提取出来

	protected static Logger log;

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
		sb.append("[cityid]").append("\n");
		sb.append("e.g. [ZS]");
		return sb.toString();
	}

	/**
	 * 返回user
	 */
	protected User getUser(String cityid) {
		User user = new User();
		user.setCityid(cityid);
		user.setOpername("PBOSS-BG");
		user.setOprcode("PBOSS-BG");
		return user;
	}
	/**
	 * 读取Properties配置文件
	 * @throws Exception
	 */
	protected void initProperties() throws Exception {
		Properties baseConf = new Properties();
		// 加载基础连接
		InputStream baseIs = this.getClass().getResourceAsStream("/base.properties");
		baseConf.load(baseIs);
		baseIs.close();
		properties.putAll(baseConf);
		// 加载个性化配置
		if (myProfilePath != null) {
			InputStream is = this.getClass().getResourceAsStream(myProfilePath);
			properties.load(is);
			is.close();
		}
	}

	/**
	 * @throws Exception
	 * 
	 */
	protected void init(String[] args) throws Exception {

		String cityid = args[0];
		
		initProperties();
		// 初始化log
		String logFilename = properties.getProperty(cityid + "_log");

		BasicConfigurator.configure();
		if (logFilename != null) {
			Logger logger = Logger.getRootLogger();
			DailyRollingFileAppender appender = (DailyRollingFileAppender) logger.getAppender("FILE");
			Date today = new Date();
			// 日志文件生成在与classpath同级的目录下; by zhangsiwei
			appender.setFile(BgCommonBase.class.getResource("/").getPath()+"../"+(logFilename + "." + (new SimpleDateFormat("yyMMdd")).format(today)));
			appender.activateOptions();

			logger.info("------log file changed to " + logFilename + " ---------------");
			StringBuffer sb = new StringBuffer();
			for (String arg : args) {
				sb.append("[").append(arg).append("] ");
			}
			logger.info(sb);
			log = logger;
		} else {
			log = Logger.getLogger(this.getClass());
		}
		for(Iterator<String> ittCityid = CityMappingUtil.getMap().keySet().iterator(); ittCityid.hasNext();){
			cityid = ittCityid.next();
			
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
				continue;
			}else{
				
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
		SpringContextManager.init3(); // @todo 这里调用初始化有点丑陋，以后改进之
		registerTypeConvert();//注册类型转换器

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

	protected void registerTypeConvert() {
		// init commons BeanUtils
		ConvertUtils.register(new SqlTimestampConverter(null), java.sql.Timestamp.class);
		ConvertUtils.register(new UtilDateConverter(null), java.util.Date.class);
		ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);

		// don't convert null number to 0.
		ConvertUtils.register(new ByteConverter(null), Byte.class);
		ConvertUtils.register(new ShortConverter(null), Short.class);
		ConvertUtils.register(new IntegerConverter(null), Integer.class);
		ConvertUtils.register(new LongConverter(null), Long.class);
		ConvertUtils.register(new FloatConverter(null), Float.class);
		ConvertUtils.register(new DoubleConverter(null), Double.class);
	}

	/**
	 * 将异常堆栈中的信息输出到日志文件中
	 * 
	 * @param ex
	 * @return
	 */
	protected StringBuffer bgPrintStackTrace(Throwable ex) {
		StringBuffer sb = new StringBuffer("");
		String message = ex.getMessage();
		if (message != null) {
			sb.append("\n\tException Message: " + ex.getMessage());
		}
		StackTraceElement[] stElements = ex.getStackTrace();
		for (StackTraceElement stElement : stElements) {
			sb.append("\n\tat " + stElement);
		}
		return sb;
	}
}
