package com.sunrise.boss.common.base.db;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.boss.ui.commons.User;

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
 */
public class DAOFactory {
	
	private static final Log log = LogFactory.getLog(DAOFactory.class);
	
	private static final ThreadLocal threadUser = new ThreadLocal();
	
	/**
	 * 构造委托的DAO实例
	 * @param daoClazz
	 * @param dbFlag
	 * @return
	 */
	public static BaseDAO build(Class daoClazz, String dbFlag) {

		/**
		 * @todo 根据dbFlag来判断用哪个数据库
		 */
		return buildDAO(daoClazz, dbFlag);

	}
	
	/**
	 * 构造委托的DAO实例
	 * @param daoClazz
	 * @param user
	 * @return
	 */
	public static BaseDAO build(Class daoClazz,User user) {

		/**
		 * @todo 根据dbFlag来判断用哪个数据库
		 */
		return buildDAO(daoClazz, user);

	}	
	
	/**
	 * buildDAO
	 * @param daoClazz
	 * @param dbFlag
	 * @return
	 */
	private static BaseDAO buildDAO(Class daoClazz, String dbFlag) {
		try {
			Object dao = daoClazz.newInstance();
			if(dao instanceof BaseDAO) {
				BaseDAO logDAO = (BaseDAO)dao;
				logDAO.setDbFlag(dbFlag);
			}
			return (BaseDAO)dao;
			
		} catch (Exception e) {	
			if(log.isErrorEnabled()) log.error(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static BaseDAO buildDAO(Class daoClazz, User user) {
		
		try {
			Object dao = daoClazz.newInstance();
			if(dao instanceof BaseLogDAO) {
				BaseLogDAO logDAO = (BaseLogDAO)dao;
				logDAO.setUser(user);
			}else{
				((BaseDAO)dao).setDbFlag(user.getCityid());
			}
			return (BaseDAO)dao;
			
		} catch (Exception e) {	
			if(log.isErrorEnabled()) log.error(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static User getUser() {
		User user = (User)threadUser.get();
		if(log.isDebugEnabled()) log.debug("get dao user " + user );
		return user;
	}
}
