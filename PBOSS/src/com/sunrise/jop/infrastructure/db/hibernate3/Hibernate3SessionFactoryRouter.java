package com.sunrise.jop.infrastructure.db.hibernate3;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.naming.*;

import org.apache.commons.logging.*;
import org.hibernate.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.support.*;
import org.springframework.orm.hibernate3.*;

import com.sunrise.jop.common.spring.*;
import com.sunrise.jop.exception.*;
import com.sunrise.jop.infrastructure.db.*;


public class Hibernate3SessionFactoryRouter implements SessionFactoryRouter {

	
	
	private static Log log = LogFactory.getLog(Hibernate3SessionFactoryRouter.class);
	
	private static SessionFactoryRouter sessionFactoryRouter ;  //本类的单例
		
	private String sessionFactoryConfig;
	private boolean hasInit; 
	private String defaultDataSource = DB_FLAG_COMMON;
	private String multiDBMode = "COMMON_CITY_MODE";  //取值:公共+地市库模式 COMMON_CITY_MODE， 平行库模式:BROTHERS_MODE
	
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
			String configpath = configFile.startsWith("classpath:") ? configFile : "classpath:" + configFile;
			PropertyValue propertyValue1 = new PropertyValue("configLocations",configpath);	
			propertyValues.addPropertyValue(propertyValue1);
			
			beanDefinition.setPropertyValues(propertyValues);
			beanFactory.registerBeanDefinition( beanName , beanDefinition);
			
			if(log.isDebugEnabled()) log.debug("注册 SessionFactory bean: " + beanName );
		}
	}
	
	/**
	 * 根据voClass,数据源标识获取SessionManager
	 */
	public SessionManager getSessionManager(Class voClass,String dbFlag) {
		dbFlag = Hibernate3RouterMap.getCityRouter(dbFlag);//做一层名字与cityid的装换
		if(dbFlag == null){
			throw new IllegalArgumentException("dbFlag is missing when getSessionManager(Class voClass,String dbFlag). ");
		}
		if(voClass == null) {
			throw new IllegalArgumentException("voClass is missing when getSessionManager(Class voClass,String dbFlag). ");
		}
		//如果未配置common数据源，并且没有初始化，则按多数据源处理，加载 多数据源配置。
		//否则，按单数据源处理
		if(!hasInit && 
				!SpringContextManager.containsBean("sessionFactory_" + defaultDataSource)) {
			loadSessionFactoryConfig();		
			hasInit = true;
		}
		
		//判断所在地数据源标识
		String targetDBFlag = dbFlag;
		Hibernate3SessionManager sessionManager = new Hibernate3SessionManager();
		if( COMMON_CITY_MODE.equals( getMultiDBMode() )) {
			//最主要的原则是地市库与公共库的库表名不能相同,否则以地市库的表内容为准,因为这样容易看出问题
			//原则上先查地市库的表,以地市库为准
			//测试的时候才出现DB_COMMON这种地市ID,以后要改
			SessionFactory sessionFactory = (SessionFactory) SpringContextManager.getBean("sessionFactory_DB_" + targetDBFlag);
			if( sessionFactory.getClassMetadata(voClass)!=null && !targetDBFlag.equals("COMMON")){ 
				targetDBFlag = dbFlag; //voClass 属于地市库
			}else{
				sessionFactory = (SessionFactory) SpringContextManager.getBean("sessionFactory_" + defaultDataSource);
				if(sessionFactory.getClassMetadata(voClass)!=null && Hibernate3RouterMap.containsCommonVO(voClass.getName())){
					//只有公共库找到该表,并且在commonDBtable有配置才认可
				}else{
					throw new JOPException("公共库未找到该表["+voClass.getName()+"],并且在commonDBtable有配置才认可,如果是地市库表则在hibernate.cfg.xml配置!");
				}
			}
			sessionManager.setSessionFactoryRouter(this);
			sessionManager.setSessionFactory(sessionFactory);
			return sessionManager;
		}else{
			//平行数据库模式
			targetDBFlag = dbFlag;
			SessionFactory sessionFactory = (SessionFactory) SpringContextManager.getBean("sessionFactory_DB_" + targetDBFlag);
			sessionManager.setSessionFactoryRouter(this);
			sessionManager.setSessionFactory(sessionFactory);
			return sessionManager;
		}
	}
	
	/**
	 * 调用该方法开发人员必须明确知道vo在对应的那个dbFlag里面,否则会报错.
	 */
	public SessionManager getSessionManager(String dbFlag) {
		dbFlag = Hibernate3RouterMap.getCityRouter(dbFlag);//做一层名字与cityid的装换
		if(dbFlag == null){
			throw new IllegalArgumentException("dbFlag is missing when getSessionManager(String dbFlag). ");
		}
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
