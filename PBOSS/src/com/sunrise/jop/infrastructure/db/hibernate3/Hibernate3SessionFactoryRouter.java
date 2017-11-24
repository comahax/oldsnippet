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
	
	private static SessionFactoryRouter sessionFactoryRouter ;  //����ĵ���
		
	private String sessionFactoryConfig;
	private boolean hasInit; 
	private String defaultDataSource = DB_FLAG_COMMON;
	private String multiDBMode = "COMMON_CITY_MODE";  //ȡֵ:����+���п�ģʽ COMMON_CITY_MODE�� ƽ�п�ģʽ:BROTHERS_MODE
	
	static Properties dbMap;

	public Hibernate3SessionFactoryRouter() {		
	}
	
	/**
	 * ��ȡ�����Ψһ����
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
	 * ��������
	 *
	 */
	private  void loadSessionFactoryConfig() {
//		��������
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
	
				if(log.isDebugEnabled()) log.debug("����SessionFactory ����: " + sessionFactoryConfig  +", Content:" + dbMap);
				
				//�������ã� ����Spring bean ��������sessionFactory
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
			beanDefinition.setSingleton( true ); //Ĭ��Ϊtrue, ��Ҫ���ӿ�������
			
			MutablePropertyValues propertyValues = new MutablePropertyValues();
			String configpath = configFile.startsWith("classpath:") ? configFile : "classpath:" + configFile;
			PropertyValue propertyValue1 = new PropertyValue("configLocations",configpath);	
			propertyValues.addPropertyValue(propertyValue1);
			
			beanDefinition.setPropertyValues(propertyValues);
			beanFactory.registerBeanDefinition( beanName , beanDefinition);
			
			if(log.isDebugEnabled()) log.debug("ע�� SessionFactory bean: " + beanName );
		}
	}
	
	/**
	 * ����voClass,����Դ��ʶ��ȡSessionManager
	 */
	public SessionManager getSessionManager(Class voClass,String dbFlag) {
		dbFlag = Hibernate3RouterMap.getCityRouter(dbFlag);//��һ��������cityid��װ��
		if(dbFlag == null){
			throw new IllegalArgumentException("dbFlag is missing when getSessionManager(Class voClass,String dbFlag). ");
		}
		if(voClass == null) {
			throw new IllegalArgumentException("voClass is missing when getSessionManager(Class voClass,String dbFlag). ");
		}
		//���δ����common����Դ������û�г�ʼ�����򰴶�����Դ�������� ������Դ���á�
		//���򣬰�������Դ����
		if(!hasInit && 
				!SpringContextManager.containsBean("sessionFactory_" + defaultDataSource)) {
			loadSessionFactoryConfig();		
			hasInit = true;
		}
		
		//�ж����ڵ�����Դ��ʶ
		String targetDBFlag = dbFlag;
		Hibernate3SessionManager sessionManager = new Hibernate3SessionManager();
		if( COMMON_CITY_MODE.equals( getMultiDBMode() )) {
			//����Ҫ��ԭ���ǵ��п��빫����Ŀ����������ͬ,�����Ե��п�ı�����Ϊ׼,��Ϊ�������׿�������
			//ԭ�����Ȳ���п�ı�,�Ե��п�Ϊ׼
			//���Ե�ʱ��ų���DB_COMMON���ֵ���ID,�Ժ�Ҫ��
			SessionFactory sessionFactory = (SessionFactory) SpringContextManager.getBean("sessionFactory_DB_" + targetDBFlag);
			if( sessionFactory.getClassMetadata(voClass)!=null && !targetDBFlag.equals("COMMON")){ 
				targetDBFlag = dbFlag; //voClass ���ڵ��п�
			}else{
				sessionFactory = (SessionFactory) SpringContextManager.getBean("sessionFactory_" + defaultDataSource);
				if(sessionFactory.getClassMetadata(voClass)!=null && Hibernate3RouterMap.containsCommonVO(voClass.getName())){
					//ֻ�й������ҵ��ñ�,������commonDBtable�����ò��Ͽ�
				}else{
					throw new JOPException("������δ�ҵ��ñ�["+voClass.getName()+"],������commonDBtable�����ò��Ͽ�,����ǵ��п������hibernate.cfg.xml����!");
				}
			}
			sessionManager.setSessionFactoryRouter(this);
			sessionManager.setSessionFactory(sessionFactory);
			return sessionManager;
		}else{
			//ƽ�����ݿ�ģʽ
			targetDBFlag = dbFlag;
			SessionFactory sessionFactory = (SessionFactory) SpringContextManager.getBean("sessionFactory_DB_" + targetDBFlag);
			sessionManager.setSessionFactoryRouter(this);
			sessionManager.setSessionFactory(sessionFactory);
			return sessionManager;
		}
	}
	
	/**
	 * ���ø÷���������Ա������ȷ֪��vo�ڶ�Ӧ���Ǹ�dbFlag����,����ᱨ��.
	 */
	public SessionManager getSessionManager(String dbFlag) {
		dbFlag = Hibernate3RouterMap.getCityRouter(dbFlag);//��һ��������cityid��װ��
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
	 * ��ȡȱʡ������Դ
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
	 * ֧������ģʽ��ȡֵ:����+���п�ģʽ COMMON_CITY_MODE�� ƽ�п�ģʽ:BROTHERS_MODE
	 */
	public String getMultiDBMode() {
		return multiDBMode;
	}
	
	/**
	 * ֧������ģʽ��ȡֵ:����+���п�ģʽ COMMON_CITY_MODE�� ƽ�п�ģʽ:BROTHERS_MODE
	 * @param multiDBMode
	 */
	public void setMultiDBMode(String multiDBMode) {
		this.multiDBMode = multiDBMode;
	}

}
