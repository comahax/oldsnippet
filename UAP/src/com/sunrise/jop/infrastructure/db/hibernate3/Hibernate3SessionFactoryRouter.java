package com.sunrise.jop.infrastructure.db.hibernate3;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

import com.sunrise.jop.common.spring.SpringContextManager;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.infrastructure.db.SessionFactoryRouter;
import com.sunrise.jop.infrastructure.db.SessionManager;


public class Hibernate3SessionFactoryRouter implements SessionFactoryRouter {
	private static String HIBERNATE_CONFIG = "jop.hibernate.path";
	
	private static Logger log = LoggerFactory.getLogger(Hibernate3SessionFactoryRouter.class);
	
	private static SessionFactoryRouter sessionFactoryRouter ;  //本类的单例
		
	private String sessionFactoryConfig;
	private boolean hasInit; 
	private String defaultDataSource = DBConstant.DB_FLAG_COMMON;
	private String multiDBMode = "MULTI_CITY_MODE";  //取值:公共+地市库模式 MULTI_CITY_MODE， 平行库模式:BROTHERS_MODE
	
	static Properties dbMap;

	public Hibernate3SessionFactoryRouter() {		
	}
	
	/**
	 * 获取该类的唯一单例
	 * @return
	 */
	public static SessionFactoryRouter getInstance() {
		if( SpringContextManager.containsBean(SessionFactoryRouter.class.getName())) {
			sessionFactoryRouter = (SessionFactoryRouter)SpringContextManager.getBean(SessionFactoryRouter.class.getName());
		}else {
			if(log.isWarnEnabled()) log.warn("Bean can't be found! It must be required! Name: " + SessionFactoryRouter.class.getName());
			sessionFactoryRouter = new Hibernate3SessionFactoryRouter();
		}
			
		return sessionFactoryRouter;
	}
	
	public String getSessionFactoryConfig() {
		return sessionFactoryConfig;
	}

	public void setSessionFactoryConfig(String sessionFactoryConfig) {
		this.sessionFactoryConfig = sessionFactoryConfig;
	}
	
	/**
	 * 加载配置
	 *
	 */
	private  void loadSessionFactoryConfig() {
//		加载配置
		InputStream in = null;
		try {
			dbMap = new Properties();
			synchronized (dbMap) {
				 in = Hibernate3SessionFactoryRouter.class.getResourceAsStream("/" + sessionFactoryConfig);
				if(in == null) {
					if(log.isErrorEnabled())
						log.error("sessionFactoryConfig:" + sessionFactoryConfig + " not found!" );
					throw new JOPException("sessionFactoryConfig: " + sessionFactoryConfig + " not found!");
				}
					
				
				dbMap.load(in);
	
				if(log.isDebugEnabled()) log.debug("加载SessionFactory 配置: " + sessionFactoryConfig  +", Content:" + dbMap);
				
				//根据配置， 运用Spring bean 容器构造sessionFactory
				Iterator keys = dbMap.keySet().iterator();
				while(keys.hasNext()) {
					String dbName = (String)keys.next();
					String configFile = dbMap.getProperty(dbName);
					
					registerSessionFactoryBean(dbName, configFile);
				}
			}
			
		}catch(IOException e) {
			throw new JOPException("Can't load sessionFactoryConfig from location: " + sessionFactoryConfig);
		}finally {
			if(in!=null)
				try {	in.close();	} catch (IOException e) { }
		}
	}
	
	private void registerSessionFactoryBean(String dbName,String configFile) {
		DefaultListableBeanFactory beanFactory = SpringContextManager.getDefaultBeanFactory();
		String beanName =  "sessionFactory_" + dbName;
		if(!beanFactory.containsBean( beanName )){
			
			RootBeanDefinition beanDefinition = new RootBeanDefinition();
			
			beanDefinition.setBeanClassName( LocalSessionFactoryBean.class.getName());
			beanDefinition.setSingleton( true ); //默认为true, 需要增加可配置性
			
			MutablePropertyValues propertyValues = new MutablePropertyValues();
			
			String[] configpaths;
			if(configFile.indexOf(",")>0){
				configpaths = configFile.split(",");
			}else{
				configpaths = new String[]{configFile};
			}
			
			//2011-8-24 jinbo 允许由外部提供Hibernate配置文件所在路径
			String path = CoreConfigInfo.getRuntimeParam(HIBERNATE_CONFIG);
			if (path != null){
				for (int i=0; i<configpaths.length; i++){
					configpaths[i] = path + configpaths[i]; 
				}
			}
			//2011-8-24 jinbo 允许由外部提供Hibernate配置文件所在路径
			
			
//			String configpath = configFile.startsWith("classpath:") ? configFile : "classpath:" + configFile;
			PropertyValue propertyValue1 = new PropertyValue("configLocations",configpaths);	
			
			propertyValues.addPropertyValue(propertyValue1);
			
			beanDefinition.setPropertyValues(propertyValues);
			beanFactory.registerBeanDefinition( beanName , beanDefinition);
			
			if(log.isDebugEnabled()) log.debug("注册 SessionFactory bean: " + beanName );
		}
	}
	
	/**
	 * 根据voClass,数据源标识获取SessionManager
	 * @param voClass
	 * @param dbFlag GDIB/XXIB/XXBILL
	 */
	public SessionManager getSessionManager(Class voClass,String dbFlag) {
		
		if(dbFlag == null){
			throw new IllegalArgumentException("dbFlag is missing when getSessionManager(Class voClass,String dbFlag). ");
		}
		if(voClass == null) {
			throw new IllegalArgumentException("voClass is missing when getSessionManager(Class voClass,String dbFlag). ");
		}
		//如果未配置common数据源，并且没有初始化，则按多数据源处理，加载 多数据源配置。
		//否则，按单数据源处理
		if(!hasInit && !SpringContextManager.containsBean("sessionFactory_DB_" + defaultDataSource)) {
			loadSessionFactoryConfig();		
			hasInit = true;
		}
		
		dbFlag = Hibernate3RouterMap.checkIsCommonDB(voClass, dbFlag); //判断voClass是否对应COMMON库里面的库表
		
		if(log.isDebugEnabled()) log.debug("当前数据源：" + dbFlag );
		
		SessionFactory sessionFactory;
		if( DBConstant.MULTI_CITY_MODE.equals( getMultiDBMode() )) { //多数据库模式
				sessionFactory = (SessionFactory) SpringContextManager.getBean("sessionFactory_DB_" + dbFlag);

		}else{ //平行数据库模式, 2013-5-28 jinbo 重定义为单数据库模式
			sessionFactory = (SessionFactory) SpringContextManager.getBean("sessionFactory_DB_" + defaultDataSource);
		}
		
		Hibernate3SessionManager sessionManager = new Hibernate3SessionManager();
		sessionManager.setSessionFactoryRouter(this);
		sessionManager.setSessionFactory(sessionFactory);
		return sessionManager;
	}
	
	/**
	 * 调用该方法开发人员必须明确知道vo在对应的那个dbFlag里面,否则会报错.
	 */
	public SessionManager getSessionManager(String dbFlag) {
		
		if(dbFlag == null){
			throw new IllegalArgumentException("dbFlag is missing when getSessionManager(String dbFlag). ");
		}
		if(log.isDebugEnabled()) log.debug("当前数据源：" + dbFlag );
		
		Hibernate3SessionManager sessionManager = new Hibernate3SessionManager();
		SessionFactory sessionFactory = (SessionFactory) SpringContextManager.getBean("sessionFactory_DB_" + dbFlag);
		sessionManager.setSessionFactoryRouter(this);
		sessionManager.setSessionFactory(sessionFactory);
		return sessionManager;
	}

	/**
	 * 获取缺省的数据源
	 */
	public SessionManager getSessionManager() {	
		throw new  IllegalArgumentException("not supoort!");
	}


	public String getDefaultDataSource() {
		return defaultDataSource;
	}

	public void setDefaultDataSource(String defaultDataSource) {
		this.defaultDataSource = defaultDataSource;
	}
	
	/**
	 * 支持两种模式：取值:公共+地市库模式 COMMON_CITY_MODE， 平行库模式:BROTHERS_MODE
	 */
	public String getMultiDBMode() {
		return multiDBMode;
	}
	
	/**
	 * 支持两种模式：取值:公共+地市库模式 COMMON_CITY_MODE， 平行库模式:BROTHERS_MODE
	 * @param multiDBMode
	 */
	public void setMultiDBMode(String multiDBMode) {
		this.multiDBMode = multiDBMode;
	}

}
