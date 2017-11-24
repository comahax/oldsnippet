package com.sunrise.jop.infrastructure.db;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;

import com.sunrise.jop.common.persistent.CommonDAO;
import com.sunrise.jop.common.spring.SpringContextManager;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.db.hibernate3.Hibernate3SessionManager;


/**
 * 
 * <p>
 * Title: DAOFactory
 * </p>
 * 
 * <p>
 * Description:DAO工厂, 构造委托的DAO实例.
 * 使用 build(Class daoClazz,User user) 构造的DAO实例, 将会对create,update,remove方法自动生成管理日志或操作日志.
 * <br> 其中, 对应VO必须实现 ManageLog 接口,或者 OperationLog 接口. 
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author J, He Kun 
 * @version 1.0
 * @version 1.1 He Kun 代码重构。用Spring容器构造DAO实例。
 */
public class DAOFactory {	
	/**
	 * 构造DAO实例
	 * @param daoClazz
	 * @param param
	 * @return
	 */
	public static BaseDAO build(Class daoClazz, DBAccessUser user) {
		return build(daoClazz, null, user);		
	}
	
	/**
	 * 构造 CommonDAO 的实例
	 * @param voClass
	 * @param user
	 * @return
	 */
	public static BaseDAO buildCommonDAO(Class voClass, DBAccessUser user) {
		return build(CommonDAO.class, voClass, user);
	}
	
	/**
	 * 采用Spring bean容器的方式构造到实例，以便为dao增加切面功能。具体配置在 applicationContext.xml中
	 * @param daoClazz
	 * @param user
	 * @return
	 */
	public static BaseDAO build(Class daoClazz, Class voClass, DBAccessUser user) {
		return build(daoClazz, voClass, user.getCityid());
	}	

	
	/**
	 * 构造dao实例。
	 * @param daoClazz
	 * @param dbFlag 数据源标识
	 * @return
	 */
	public static BaseDAO build(Class daoClazz, String dbFlag) {
		return build(daoClazz, null, dbFlag);
	}
	
	/**
	 * 构造 CommonDAO 的实例
	 * @param voClass
	 * @param dbFlag 数据源标识
	 * @return
	 */
	public static BaseDAO buildCommonDAO(Class voClass, String dbFlag) {
		return build(CommonDAO.class, voClass, dbFlag);
	}

	/**
	 * 采用Spring bean容器的方式构造到实例，以便为dao增加切面功能。具体配置在 applicationContext.xml中
	 * @param daoClazz
	 * @param voClass
	 * @param dbFlag
	 * @return
	 */
	public static BaseDAO build(Class daoClazz, Class voClass, String dbFlag) {
		AbstractDAO dao = null;
		try {
			SpringContextManager.registerBean(daoClazz.getName(), daoClazz);
			dao = (AbstractDAO)SpringContextManager.getBean(daoClazz.getName());
			
			Hibernate3SessionManager sessionManager = new Hibernate3SessionManager();
			
			if(dao.getVoClass()==null) {
				if(voClass==null)
					throw new IllegalArgumentException("voClass is empty when build DAO " + daoClazz.getName());
				else
					dao.setVoClass(voClass);
			}
			
			if( StringUtils.isBlank(dbFlag)) {
				throw new IllegalArgumentException("dbFlag( user.cityid ) is missing!" );
			}
			
			String dbName = dbFlag.startsWith("DB_")? dbFlag : "DB_" + dbFlag;
			SessionFactory sf ;
			if(SpringContextManager.containsBean(SpringContextManager.HIBERNATE_SESSION_FACTORY_NAME)){
				// 非短信营业厅用
				sf = (SessionFactory) SpringContextManager.getBean(SpringContextManager.HIBERNATE_SESSION_FACTORY_NAME );
			}else if(SpringContextManager.containsBean(SpringContextManager.HIBERNATE_SESSION_FACTORY_NAME + "_" + dbName)) {
				// 短信营业厅用
				sf = (SessionFactory) SpringContextManager.getBean(SpringContextManager.HIBERNATE_SESSION_FACTORY_NAME + "_" + dbName);
			}else {
				throw new JOPException("未配置地市["+dbFlag+"]"+"的数据库连接参数!");
			}
			
			if(sf.getClassMetadata(dao.getVoClass()) == null) {
				if(CoreConfigInfo.COMMON_DB_NAME.equals(dbFlag)) {
					throw new JOPException("公共库中未找到该表["+dao.getVoClass().getName()+"],请检查hibernate_comm.cfg.xml配置!");
				}else {
					sf = (SessionFactory) SpringContextManager.getBean(SpringContextManager.HIBERNATE_SESSION_FACTORY_NAME + "_" + CoreConfigInfo.COMMON_DB_NAME);
					if(sf.getClassMetadata(dao.getVoClass()) == null) {
						throw new JOPException("公共库和地市库都未找到该表["+dao.getVoClass().getName()+"],请检查hibernate_comm.cfg.xml与hibernate.cfg.xml配置!");
					}
				}
			}
			sessionManager.setSessionFactory(sf);
			BaseDAO delegateDAO = sessionManager.newDAO();
			//要先设置委托dao，再设置其他属性。
			
			dao.setDelegateDAO(delegateDAO);
			
			dao.setDbFlag(dbFlag); //设置user， 业务bean需要	
			if(dao.getVoClass()==null) {
				if(voClass == null) 
					throw new NullPointerException("voClass is required! But it's null! Perhaps you don't set voClass property to commonControl object!");
				else
					dao.setVoClass(voClass);
			}
		} catch (Exception e) {	
			throw new JOPException("Can't build dao of " + daoClazz.getName()+", cause:" + e.getMessage(),e);
		}
		return  dao;	
	}	
}
